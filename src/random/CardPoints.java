package random;

import java.util.Scanner;

public class CardPoints {
    private int cardId;
    private String holderName;
    private int balancePoints;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getBalancePoints() {
        return balancePoints;
    }

    public void setBalancePoints(int balancePoints) {
        this.balancePoints = balancePoints;
    }

    public boolean withdrawPoints(int points) {
        if (balancePoints >= points) {
            balancePoints -= points;
            System.out.println("Balance points after used: " + balancePoints);
            return true;
        } else {
            System.out.println("Sorry!!! No enough points");
            return false;
        }
    }
}

class GameCardDetails {
    public CardPoints getCardDetails() {
        Scanner scanner = new Scanner(System.in);
        CardPoints cardPoints = new CardPoints();

        System.out.println("Enter card id");
        cardPoints.setCardId(scanner.nextInt());

        scanner.nextLine(); // Clear the newline character from the buffer

        System.out.println("Enter card holder name");
        cardPoints.setHolderName(scanner.nextLine());

        int balancePoints;
        do {
            System.out.println("Enter balance points");
            balancePoints = scanner.nextInt();
            if (balancePoints <= 0) {
                System.out.println("Balance points should be positive");
            }
        } while (balancePoints <= 0);

        cardPoints.setBalancePoints(balancePoints);

        return cardPoints;
    }

    public int getPointUsage() {
        Scanner scanner = new Scanner(System.in);

        int points;
        do {
            System.out.println("Enter points should be used");
            points = scanner.nextInt();
            if (points <= 0) {
                System.out.println("Points should be positive");
            }
        } while (points <= 0);

        return points;
    }

    public static void main(String[] args) {
        GameCardDetails gameCardDetails = new GameCardDetails();

        CardPoints cardPoints = gameCardDetails.getCardDetails();
        int pointsUsed = gameCardDetails.getPointUsage();

        cardPoints.withdrawPoints(pointsUsed);
    }
}

