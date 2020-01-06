package order.tracking;

import java.util.Date;

public abstract class Order {

	int orderId;
	String orderItem;
	Date date;
	int quantity;
	
	public Order(int orderId, String orderItem, Date date, int quantity) {
		this.orderId = orderId;
		this.orderItem = orderItem;
		this.date = date;
		this.quantity = quantity;
	}

	public void confirm() {
		System.out.println("Order confirmed!");	
	}
	
	public void close() {
		System.out.println("Order closed!");
	}
	
	public abstract void dispatch();
	
	@Override
	public String toString() {
		return "# Order ID: " + this.orderId
				+ "\nOrder Item: " + this.orderItem
				+ "\nDate: " + this.date
				+ "\nQuantity: " + this.quantity;
	}
}
