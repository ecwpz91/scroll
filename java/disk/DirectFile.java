/**
 * The DirectFile class hashes the contents of record, writing and reading them to and 
 * from a Disk object.
 * @author mike surbey
 *
 */

public class DirectFile {
   private Disk disk;             //disk on which the file will be written
   private char[] buffer;         //disk buffer
   private int recordSize;        //in characters
   private int keySize;           //in characters
   private int recordsPerSector;
   private int firstAllocated;    //sector number 1024
   private int bucketsAllocated;  //buckets originally allocated  
   private int firstOverflow;     //sector number
   private int overflowBuckets;   //count of overflow buckets in use
   
   /**
    * Constructs a DirectFile object that inserts and finds records for the parameterized Disk object.
    * @param disk object on which the file will be written
    * @param recordSize of each character record written
    * @param keySize of each character record written
    * @param firstAllocated starting sector
    * @param bucketsAllocated before overflow occurs
    */
   public DirectFile(Disk inDisk, int inRecordSize, int inKeySize,
                     int inFirstAllocated, int inBucketsAllocated) {
	   disk = inDisk;
	   buffer = new char[disk.getSectorSize()]; //sets buffer size to the size of a Disk sector
	   //size
	   recordSize = inRecordSize; //size of each record being inserted
	   //or searched for corresponding to the disk
	   keySize = inKeySize; //length of a records key (stating from index 0)
	   firstAllocated = inFirstAllocated; //the starting sector for for reading and writing from
	   bucketsAllocated = inBucketsAllocated; //number of available buckets (sectors) on the Disk object
	   if (recordSize <= 0) //checks for divide by zero
		   throw new ArithmeticException();
	   recordsPerSector = disk.getSectorSize() / recordSize; //records per sector
	   overflowBuckets = 0; //number of overflow buckets in use
	   firstOverflow = (firstAllocated + bucketsAllocated) + 1; //beginning overflow sector
   }
   
   /**
    * Uses the hash method to determine an inserting sector, then reads the sector 
    * from disk, and writes the record into the first available position. If the 
    * sector is full, the record is placed in the first overflow sector which is not full.
    * If a record already exists in the file with the given key no insertion will 
    * be done and insertRecord will return false. If an insertion is done true will
    * be returned. 
    * @param record being inserted into a sector
    * @return boolean true if the record was inserted into a sector
    */
   public boolean insertRecord(char[] record) {	   
	   int hashKey =  hash(findKey(record)); //find the hashKey for the record
	   disk.readSector(hashKey, buffer); //read the sectors contents and store in buffers
	   
	   if(checkContents(record)) //check for duplicates
		   return false;
	   
	   while (!checkVacancy()) {
		   hashKey = firstOverflow+overflowBuckets; //reset hashKey value to overflow
		   disk.readSector(hashKey, buffer); //read overflow
		   
		   if(checkContents(record)) //check for duplicates
			   return false;

		   if (!checkVacancy()) //increment overflow if not enough space
			   overflowBuckets++;
	   }
	   
	   int start = findStart(); //determine starting index of buffer
	   for (int i=0; i<record.length; i++) {
		   buffer[start] = record[i];
		   start++;
	   }
	   
	   disk.writeSector(hashKey, buffer); //overwrite contents of buffer with additional record
	   
	   return true;
   }   
   
   /**
    * Using a records hash the key, reads the corresponding sector, and then copies
    * the record from its place in the disk buffer into the (char[]) parameter 
    * of findRecord and true is returned. If the record is not found in this sector, 
    * but the sector is not full, the record is not in the table and false is returned. 
    * If the record is not found in this sector and the sector is 
    * full you must search the overflow sectors.
    * @param record being searched for
    * @return boolean true if the record was found in a sector
    */
   public boolean findRecord(char[] record) {
	   int hashKey =  hash(findKey(record)); //find the hashKey for the record
	   disk.readSector(hashKey, buffer); //read the sectors contents and store in buffer
	   
	   if (!checkContents(record)) {
		   hashKey = firstOverflow; //change the to firstOverflow
		   for (int i=0; i<=overflowBuckets; i++) {
			   disk.readSector(hashKey, buffer); //read the new sectors contents
			   if (!checkContents(record)) //check if the record exists in the buffers
				   hashKey++;
		   }
	   }
	   
	   if (!checkContents(record)) //checks if the record exists in the last overflow / current
		   return false;
	   
	   String bufferStr = new String(buffer);
	   int index = 0;
	   for (int i=0; i<bufferStr.length(); i+=recordSize)
		   if (i+recordSize < bufferStr.length())
			   //checks if the record at this current position in the buffer is the record being
			   //search for and then takes the buffer contents and copies them by reference to the
			   //record
			   if (bufferStr.substring(i, i+recordSize).toLowerCase().contains(new String(record)
			   .substring(0, keySize).toLowerCase()))
				   index = i;
	   			   for (int j=0; j<record.length; j++) {
	   				   record[j] = buffer[index];
	   				   index++;
	   			   }

	   return true;
   }   
   
   /**
    * Takes a key for its parameter and returns a 
    * hash value in the range 0 ... (bucketsAllocated - 1).
    * @param character array containing a records unique key
    * @return int hash value of the key from range 0 ... (bucketsAllocated - 1) 
    */
   private int hash(char[] key) {
	   int hashValue = 0; //initial hash value
	   
	   for (char c : key)
		   hashValue += Character.getNumericValue(c); //increment character numerical value to hash value
	  
	   return firstAllocated + (Math.abs(hashValue) % bucketsAllocated); //return hash value in
	   //range of 0... (bucketsAllocated -1)
   }
   
   /**
    * Finds the corresponding key to a record.
    * @param record being inserted or searched for
    * @return character array containing a records unique key
    */
   private char[] findKey(char[] inRecord) {
	   
	   return new String(inRecord).substring(0, keySize).toCharArray(); //returns the character represenation
	   //of the in coming record
   }
   
   /**
    * Determines if a record is already contained in the corresponding
    * buffer object.
    * @param record being inserted or searched for
    * @return boolean true if the record already exists in the buffer object
    */
   private boolean checkContents(char[] inRecord) {
	   String bufferStr = new String(buffer).toLowerCase();
	   String recordStr = new String(inRecord).substring(0, keySize).toLowerCase();
	   
	   if (bufferStr.contains(recordStr)) //checks to see if the incoming record
		   //is contained within the current buffer object
		   return true;
		   
	   return false;
   }
   
   /**
    * Returns whether or not there is space to insert a record into
    * the corresponding buffer object.
    * @return boolean true if there is space in the buffer object
    */
   private boolean checkVacancy() { 
	   int numRecords = 0;
	   
	   for (int i=0; i<buffer.length; i+=recordSize)
		   if (buffer[i] != '\000') //checks if there is a record already at that recordSize index
			   numRecords++;
		   
	   if (numRecords >= recordsPerSector)
		   return false;
	   
	   return true;
   }
   
   /**
    * Returns the starting index of the corresponding buffer object.
    * @return int stating index of the corresponding buffer object
    */
   private int findStart() {
	   int start = 0;
	   boolean escape = false;
	   
	   for (int i=0; i<buffer.length; i+=recordSize)
		   if (buffer[i] == '\000' && !escape) {
			   start = i; //sets the starting integer to the record position that is empty within
			   //the buffer object of the disk class
			   escape = true;
		   }

	   return start;
   }
}