package random;

import java.util.Scanner;

public class PlantOxygen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double floorArea1, floorArea2, plantArea;
        System.out.println("Enter the floor area of the room(m*m)");
        floorArea1 = sc.nextInt();
        floorArea2 = sc.nextInt();
        System.out.println("Enter the plant area of a single plant(in cm2");
        plantArea = sc.nextInt() ;

        int totalPlants = calculateTotalPlants(floorArea1, floorArea2, plantArea);
        double oxygenProduction = calculateOxygenProduced(totalPlants);

        System.out.printf("Total plants placed on floor area %.2f*%.2f is %d plants produces %.2f litres of oxygen in a day%n",
                floorArea1, floorArea2, totalPlants, oxygenProduction);

        sc.close();
    }
    public static int calculateTotalPlants(double floorArea1, double floorArea2, double plantArea){
        double Area = floorArea1 * floorArea2;
        int totalPlants = (int) Math.floor((Area / plantArea * 100 * 100));
        int roundedPlants = totalPlants / 10 * 10;
        return roundedPlants;
    }
    public static double calculateOxygenProduced(int totalPlants){
        return totalPlants * 0.9;
    }
}
