package random;

import java.util.Scanner;

public class CustomerDetails {
    private String customerId;
    private String customerName;
    private long phoneNumber;
    private String city;
    private double unitsConsumed;
    private double costPerUnit;

    // Parametrized constructor to initialize the values for the CustomerDetails object
    public CustomerDetails(String customerId, String customerName, long phoneNumber, String city, double unitsConsumed, double costPerUnit) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.unitsConsumed = unitsConsumed;
        this.costPerUnit = costPerUnit;
    }

    // Getters and Setters for all attributes
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(double unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    // Calculate the electricity bill based on units consumed and cost per unit
    public double calculateElectricityBill() {
        double amount = unitsConsumed * costPerUnit;
        return amount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Customer Id");
        String customerId = scanner.nextLine();

        System.out.println("Enter Customer Name");
        String customerName = scanner.nextLine();

        System.out.println("Enter Phone Number");
        long phoneNumber = scanner.nextLong();

        scanner.nextLine(); // Clear the newline character from the buffer

        System.out.println("Enter City");
        String city = scanner.nextLine();

        System.out.println("Enter Units Consumed");
        double unitsConsumed = scanner.nextDouble();

        System.out.println("Enter Cost per Unit");
        double costPerUnit = scanner.nextDouble();

        CustomerDetails customer = new CustomerDetails(customerId, customerName, phoneNumber, city, unitsConsumed, costPerUnit);
        double electricityBill = customer.calculateElectricityBill();

        System.out.printf("Amount to be paid is Rs.%.2f%n", electricityBill);

        scanner.close();
    }
}
