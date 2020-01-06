package order.tracking;

import java.util.Date;

public class SpecialOrder extends Order {

	public SpecialOrder(int orderId, String orderItem, Date date, int quantity) {
		super(orderId, orderItem, date, quantity);
	}

	@Override
	public void dispatch() {
		System.out.println("Special order dispatched!");	
	}
}
