package order.tracking;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OrderTrackingApp {

	static Set<Customer> customerDetails = new HashSet<>(); 
	
	public static void main(String[] args) {
		try {
			// Add two customers and orders
			Order o1 = new NormalOrder(101, "Pizza", new Date(), 100);
			Customer c1 = new Customer(1, "Abhijit", "Hyderabad", o1);
			addCustomer(c1);
			Order o2 = new SpecialOrder(102, "Bread Sticks", new Date(), 50);
			Customer c2 = new Customer(2, "Chitta", "Hyderabad", o2);
			addCustomer(c2);
			
			// Find customer by customerId
			System.out.println("Find customer by customerId 1");
			System.out.println(findCustomer(1));
			
			// Delete customer
			System.out.println("\n*************");
			System.out.println("Delete customer with customerId 2");
			deleteCustomer(2);
			//System.out.println(findCustomer(2));
			
			// Update customer
			System.out.println("\n*************");
			System.out.println("Update customer with customerId 1");
			Order o3 = new SpecialOrder(103, "Pepsi", new Date(), 75);
			c1 = new Customer(3, "Sandeep", "Bhubaneswar", o3);
			updateCustomer(1, c1);
			System.out.println(findCustomer(3));
			
			// Search by order id
			System.out.println("\n*************");
			System.out.println("Search by order id 103");
			System.out.println(findOrder(103));
			
			
		} catch (CustomerException | OrderException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Adds a customer to the list. Throws an exception if a customer with the
	 * same customerId already exists.
	 */
	public static void addCustomer(Customer customer) {
		if (findCustomer(customer.customerId) != null) {
			throw new CustomerException("Customer already exists!");
		}

		customerDetails.add(customer);
	}
	
	/**
	 * Finds and returns a customer with given customerId. Returns null if customer
	 * doesn't exist.
	 */
	public static Customer findCustomer(int customerId) {
		for (Customer customer : customerDetails) {
			if (customer.customerId == customerId) {
				return customer;
			}
		}

		return null;
	}
	
	/**
	 * Deletes customer with the given customerId. Throws an exception if the specified
	 * customer doesn't exist.
	 */
	public static void deleteCustomer(int customerId) {
		Iterator<Customer> iterator = customerDetails.iterator();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			if (customer.customerId == customerId) {
				iterator.remove();
				return;
			}
		}
		
		throw new CustomerException("Customer not found!");
	}
	
	/**
	 * Updates customer details with the given customerId. Throws an exception if the
	 * specified customer doesn't exist.
	 */
	public static void updateCustomer(int customerId, Customer customer) {
		if (findCustomer(customer.customerId) != null) {
			throw new CustomerException("Customer not found!");
		}
		
		deleteCustomer(customerId);
		addCustomer(customer);
	}
	
	/**
	 * Searches for an order within the list of customers for the given orderId.
	 * Throws exception if the order is not found.
	 */
	public static Customer findOrder(int orderId) {
		for (Customer customer : customerDetails) {
			if (customer.order.orderId == orderId) {
				return customer;
			}
		}
		
		throw new CustomerException("Order not found!");
	}
}
