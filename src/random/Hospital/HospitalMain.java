package random.Hospital;

import java.util.Scanner;

public class HospitalMain {
    public static Doctor createDoctorDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Hospital Name");
        String hospitalName = scanner.nextLine();

        System.out.println("Enter Contact Number");
        long contactNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter City");
        String city = scanner.nextLine();

        System.out.println("Enter Doctor Id");
        String doctorId = scanner.nextLine();

        System.out.println("Enter Doctor Name");
        String doctorName = scanner.nextLine();

        System.out.println("Enter Specialization");
        String specialization = scanner.nextLine();

        scanner.close();

        Hospital hospital = new Hospital(hospitalName, contactNumber, city);
        return new Doctor(doctorId, doctorName, specialization, hospital);
    }

    public static void main(String[] args) {
        Doctor doctor = createDoctorDetails();

        System.out.println("Doctor id: " + doctor.getDoctorId());
        System.out.println("Doctor name: " + doctor.getDoctorName());
        System.out.println("Specialization: " + doctor.getSpecialization());
        System.out.println("Hospital Name: " + doctor.getHospital().getHospitalName());
        System.out.println("Contact Number: " + doctor.getHospital().getContactNumber());
        System.out.println("City: " + doctor.getHospital().getCity());
    }
}
