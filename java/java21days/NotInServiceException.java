@SuppressWarnings("serial")
class NotInServiceException extends Exception {
	
	public NotInServiceException() {}
	
	public NotInServiceException (String msg) {
		super(msg);
	}
	
	public static void main(String[] args) throws NotInServiceException {
		NotInServiceException nise = new NotInServiceException("Exception: Database " +
				"Not in Service.");
		throw nise;
	}
}