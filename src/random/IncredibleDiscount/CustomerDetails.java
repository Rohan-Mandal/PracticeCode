package random.IncredibleDiscount;

public class CustomerDetails {
    private String customerId;
    private String customerName;
    private long phoneNumber;
    private String emailId;
    private String toyType;
    private double price;

    public CustomerDetails(String customerId, String customerName, long phoneNumber, String emailId, String toyType, double price) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.toyType = toyType;
        this.price = price;
    }

    // Method to validate customerId
    public boolean validateCustomerId() {
        // Regular expression pattern to validate the customerId
        String regex = "Incredible/\\d{3}/\\d{4}";
        return customerId.matches(regex);
    }

    // Method to calculate discount based on toyType
    public double calculateDiscount() {
        String toyTypeLowerCase = toyType.toLowerCase();

        double discountPercentage;
        switch (toyTypeLowerCase) {
            case "softtoys":
                discountPercentage = 0.05;
                break;
            case "fidgettoys":
                discountPercentage = 0.1;
                break;
            case "sensorytoys":
                discountPercentage = 0.15;
                break;
            case "puzzles":
                discountPercentage = 0.20;
                break;
            default:
                // If toyType is not recognized, no discount is applied
                discountPercentage = 0.0;
        }
        return price - (price * discountPercentage);
    }
}
