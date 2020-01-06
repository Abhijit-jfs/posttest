package order.tracking;

public class Customer implements User {

	int customerId;
	String customerName;
	String location;
	Order order;

	public Customer(int customerId, String customerName, String location, Order order) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.location = location;
		this.order = order;
	}

	@Override
	public void sendOrder() {
		System.out.println("Order sent!");
	}

	@Override
	public void receiveOrder() {
		System.out.println("Order received!");	
	}
	
	@Override
	public String toString() {
		return "\n# Customer ID: " + this.customerId
				+ "\nCustomer Name: " + this.customerName
				+ "\nLocation: " + this.location
				+ "\n" + this.order;
	}
	
	@Override
	public int hashCode() {
		return this.customerId;
	}
}
