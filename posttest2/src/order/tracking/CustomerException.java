package order.tracking;

public class CustomerException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomerException() {
		super();
	}

	public CustomerException(String customMessage) {
		super(customMessage);
	}
}
