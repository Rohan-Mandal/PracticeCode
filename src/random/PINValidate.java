package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PINValidate {
    private List<String> pinNumbers;

    public PINValidate() {
        pinNumbers = new ArrayList<>();
    }

    public void inputPINNumbers(int totalNumbers) {
        if (totalNumbers <= 0) {
            System.out.println(totalNumbers + " is an invalid number");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the PIN numbers");
        for (int i = 0; i < totalNumbers; i++) {
            String pin = scanner.nextLine().trim();
            if (isValidPIN(pin)) {
                pinNumbers.add(pin);
            } else {
                System.out.println(pin + " is an invalid PIN number");
            }
        }
    }

    private boolean isValidPIN(String pin) {
        if (pin.length() != 4) {
            return false;
        }

        int first = Integer.parseInt(pin.charAt(0) + "");
        int second = Integer.parseInt(pin.charAt(1) + "");
        int third = Integer.parseInt(pin.charAt(2) + "");
        int last = Integer.parseInt(pin.charAt(3) + "");

        if (first % 2 != 1 || second % 2 != 0 && isPrime(third) && isComposite(last)) {
            return true;
        }

        return false;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isComposite(int num) {
        return num > 1 && !isPrime(num);
    }

    public void printValidPINNumbers() {
        if (pinNumbers.isEmpty()) {
            System.out.println("All these " + pinNumbers.size() + " numbers are not a valid PIN number");
        } else {
            System.out.println("Valid PIN numbers are");
            for (String pin : pinNumbers) {
                System.out.println(pin);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total number of PIN numbers");
        int totalNumbers = scanner.nextInt();

        PINValidate pinValidator = new PINValidate();
        pinValidator.inputPINNumbers(totalNumbers);
        pinValidator.printValidPINNumbers();
    }
}
