package order.tracking;

public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderException() {
		super();
	}

	public OrderException(String customMessage) {
		super(customMessage);
	}
}
