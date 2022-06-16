import java.util.Scanner;

public class Main {
    static Hospital hospital;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            visitHospital();
            int i = 0;
            while (i != -1) {
                System.out.println("""
                        1. Admin
                        2. Patient
                        """);
                int input = scanner.nextInt();

                switch (input) {
                    case 1 -> admin();
                    case 2 -> patient();
                    case 0 -> i = -1;
                    default -> main(args);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void patient() {
    }

    private static void admin() {
        int i = 0;
        while (i != -1) {
            System.out.println("""
                    1. View all patient
                    2. View all Doctors
                    3. employ Doctor
                    4. create new test
                    0. homepage
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> viewAllPatients();
                case 2 -> viewAllDoctors();
                case 3 -> employDoctor();
                case 4 -> createTest();
                default -> i = -1;
            }
        }
    }

    private static void createTest() {
    }

    private static void employDoctor() {
    }

    private static void viewAllDoctors() {
    }

    private static void viewAllPatients() {
    }

    private static void visitHospital() {
        System.out.println("enter your location");
        String location = scanner.next();
        System.out.print("fetching hospital data in " + location);
        slow();

        System.out.println("available hospitals in " + location);
        String[] names = {"Divine Health", "Graceful Health", "Forever Health", "Good Life"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + 1 + ". " + names[i]);
        }
        System.out.println("choose hospital by entering id");
        int id = scanner.nextInt();
        hospital = new Hospital(names[id - 1], location);
        System.out.println("Welcome to " + hospital.getName() + "," + hospital.getLocation());
    }

    private static void goToHospitals() {

    }

    private static void slow() {
        for (int i = 0; i < 8; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
        System.out.println();
    }
}
