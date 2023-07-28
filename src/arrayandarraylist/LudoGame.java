package arrayandarraylist;

import java.util.Scanner;
//
//class LudoGame {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int alexPoints, nikilPoints, samPoints;
//
//        System.out.println("Enter Alex points");
//        alexPoints = scanner.nextInt();
//        if (checkPoints(alexPoints)) {
//            System.out.println("Enter Nikil points");
//            nikilPoints = scanner.nextInt();
//            if (checkPoints(nikilPoints)) {
//                System.out.println("Enter Sam points");
//                samPoints = scanner.nextInt();
//                if (checkPoints(samPoints)) {
//                    findWinner("Alex", alexPoints, "Nikil", nikilPoints, "Sam", samPoints);
//                } else {
//                    System.out.println(samPoints + " is an invalid number.");
//                }
//            } else {
//                System.out.println(nikilPoints + " is an invalid number.");
//            }
//        } else {
//            System.out.println(alexPoints + " is an invalid number.");
//        }
//
//        scanner.close();
//    }
//
//    public static boolean checkPoints(int points) {
//        return points >= 0 && points <= 50;
//    }
//
//    public static void findWinner(String name1, int points1, String name2, int points2, String name3, int points3) {
//        int maxPoints = Math.max(points1, Math.max(points2, points3));
//
//        if (maxPoints == points1) {
//            System.out.println(name1 + " scored " + points1 + " points and won the game");
//        } else if (maxPoints == points2) {
//            System.out.println(name2 + " scored " + points2 + " points and won the game");
//        } else {
//            System.out.println(name3 + " scored " + points3 + " points and won the game");
//        }
//    }
//}

import java.util.Scanner;

class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}

public class LudoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player alex = new Player("Alex");
        Player nikil = new Player("Nikil");
        Player sam = new Player("Sam");

        int alexPoints, nikilPoints, samPoints;

        System.out.println("Enter Alex points");
        alexPoints = scanner.nextInt();
        if (isValidPoints(alexPoints)) {
            alex.setPoints(alexPoints);
        } else {
            System.out.println(alexPoints + " is an invalid number.");
            return;
        }

        System.out.println("Enter Nikil points");
        nikilPoints = scanner.nextInt();
        if (isValidPoints(nikilPoints)) {
            nikil.setPoints(nikilPoints);
        } else {
            System.out.println(nikilPoints + " is an invalid number.");
            return;
        }

        System.out.println("Enter Sam points");
        samPoints = scanner.nextInt();
        if (isValidPoints(samPoints)) {
            sam.setPoints(samPoints);
        } else {
            System.out.println(samPoints + " is an invalid number.");
            return;
        }

        findWinner(alex, nikil, sam);
    }

    public static boolean isValidPoints(int points) {
        return points >= 0 && points <= 50;
    }

    public static void findWinner(Player player1, Player player2, Player player3) {
        Player winner = player1;
        if (player2.getPoints() > winner.getPoints()) {
            winner = player2;
        }
        if (player3.getPoints() > winner.getPoints()) {
            winner = player3;
        }

        System.out.println(winner.getName() + " scored " + winner.getPoints() + " points and won the game");
    }
}
