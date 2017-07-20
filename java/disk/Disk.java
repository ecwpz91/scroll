/**
 * The Disk class simulates a hard disk (hard drive).
 * @author mike surbey
 *
 */
public class Disk
{
   private int sectorCount;  //sectors on the disk
   private int sectorSize;  //characters in a sector
   private char[][] store;  //where disk data is stored
   
	/**
	 * Constructs an empty Disk object that initializes the instance 
	 * variable store (2-D array) with a default a sector count of 
	 * 10,000 and sector size of 512.
	 */
   public Disk() {
	   sectorCount = 10000; //default sector count
	   sectorSize = 512; //default sector size
	   store = new char[sectorCount][sectorSize]; //default size of disk
   }
   
   /**
    * Constructs a Disk object that initializes the instance variable 
    * store (2-D array) with a user specified sector count and sector size.
    * @param sectorCount of this Disk's store array
    * @param sectorSize of this Disk's store array
    */
   public Disk(int inSectorCount, int inSectorSize) {
	   if (inSectorCount <= 0 || inSectorSize <= 0)  //checks that sector count or
		   //size is greater than zero
		   throw new IllegalArgumentException("Sector count or size is less than zero.");
	   sectorCount = inSectorCount;
	   sectorSize = inSectorSize;
	   store = new char[sectorCount][sectorSize];
   }
   
   /**
    * Copies the contents of a sector to the buffer object.
    * @param sectorNumber copying the contents from
    * @param buffer object copying contents to
    */
   public void readSector(int sectorNumber, char[] buffer) {
       if (buffer.length == getSectorSize()) {  //check that buffer is of same length
    	   for (int i=0; i<store[sectorNumber].length; i++)
    		   buffer[i] = store[sectorNumber][i];  //store the contents of the sector into
    	   //the buffer array
       }else
    	   throw new ArrayIndexOutOfBoundsException("Buffer size must be the same as sector size.");
   }
   
   /**
    * Copies and overwrites the contents of as sector with the buffer object.
    * @param sectorNumber copying contents to
    * @param buffer object copying contents from
    */
   public void writeSector(int sectorNumber, char[] buffer) {
	   if (buffer.length == getSectorSize()) {  //check that buffer is of same length
		   for (int i=0; i<store[sectorNumber].length; i++)
			   store[sectorNumber][i] = buffer[i];  //store the contents of the buffer into
		   //the sector array
	   }else 
		   throw new ArrayIndexOutOfBoundsException("Buffer size must be the same as sector size.");
   }                                                   
   
   /**
    * Returns the number of sectors inside of this Disk.
    * @return sectorCount of this Disk
    */
   public int getSectorCount() {
      return sectorCount;  //number of sectors inside of this Disk
   }
   
   /**
    * Returns the size of each sector of this Disk.
    * @return sectorSize of this Disk
    */
   public int getSectorSize() {
      return sectorSize;  //the size of each size of this Disk
   }
}