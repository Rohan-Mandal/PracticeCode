package random;

import java.util.*;



public class IncomeTax {



    public static double taxSlab(double income){
        double tax;
        if(income==0 && income<=250000){
            tax=0;
        }
        else if (income>=250001 && income<=500000) {
            tax=0.05*income;
            income=income-tax;
        }
        else if (income>=500001 && income<=750000) {
            tax=0.1*income;
            income=income-tax;
        }
        else if (income>=750001 && income<=1000000) {
            tax=0.15*income;
            income=income-tax;
        }
        else if (income>=1000001 && income<=1250000) {
            tax=0.20*income;
            income=income-tax;
        }
        else if (income>=1250001 && income<=1500000) {
            tax=0.25*income;
            income=income-tax;
        }
        else {
            tax=0.30*income;
            income=income-tax;
        }
        return income;
    }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double income=sc.nextDouble();

        double pay= taxSlab(income);

        double sur;
    }

}
