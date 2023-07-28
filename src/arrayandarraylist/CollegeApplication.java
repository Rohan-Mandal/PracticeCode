package arrayandarraylist;

import java.util.Scanner;

public class CollegeApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Applicant name");
        String name = sc.nextLine();
        System.out.println("Marks obtained in HSC");
        double HSCMarks = sc.nextDouble();
        System.out.println("Total possible marks in HSC");
        double totalHSC = sc.nextDouble();
        System.out.println("Engineering cutoff mark");
        double cutoffMark = sc.nextDouble();
        System.out.println("Marks obtained in SSLC");
        double SSLCMarks = sc.nextDouble();
        System.out.println("Total possible marks in SSLC");
        double totalSSLC = sc.nextDouble();
        System.out.println("Gender");
        String gender = sc.next();
        sc.close();

        System.out.println("Your Application has been Submitted Successfully");
        System.out.println("The name of the applicant: " +name);
        System.out.println("Enginnering Cutoff: " + cutoffMark);
        System.out.println("Applicant gender: " +gender);
        System.out.println("All the best for your Career");

    }
}
