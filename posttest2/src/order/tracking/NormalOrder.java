package order.tracking;

import java.util.Date;

public class NormalOrder extends Order {

	public NormalOrder(int orderId, String orderItem, Date date, int quantity) {
		super(orderId, orderItem, date, quantity);
	}

	@Override
	public void dispatch() {
		System.out.println("Special order dispatched!");
	}
	
	public void receive() {
		System.out.println("Special order received!");
	}
}
