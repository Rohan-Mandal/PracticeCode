package random.IncredibleDiscount;
import java.util.*;
public class ToyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Customer Id");
        String customerId = scanner.nextLine();

        System.out.println("Enter Customer Name");
        String customerName = scanner.nextLine();

        System.out.println("Enter Phone Number");
        long phoneNumber = Long.parseLong(scanner.nextLine());

        System.out.println("Enter Email Id");
        String emailId = scanner.nextLine();

        System.out.println("Enter type");
        String toyType = scanner.nextLine();

        System.out.println("Enter Price");
        double price = Double.parseDouble(scanner.nextLine());

        CustomerDetails customer = new CustomerDetails(customerId, customerName, phoneNumber, emailId, toyType, price);

        if (customer.validateCustomerId()) {
            double amountToBePaid = customer.calculateDiscount();
            System.out.printf("Amount to be paid by the Customer %.2f%n", amountToBePaid);
        } else {
            System.out.println("Provide a proper Customer Id");
        }
    }
}
