package exceptions;

public class OrderingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OrderingException() {}
	
    public OrderingException (String message) {
        super (message);
    }

    public OrderingException (Throwable cause) {
        super (cause);
    }

    public OrderingException (String message, Throwable cause) {
        super (message, cause);
    }
}
