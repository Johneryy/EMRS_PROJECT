import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Hospital hospital;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("WELCOME TO SEMICOLON HEALTH MANAGEMENT SYSTEM");
        try {
            visitHospital();
            autoEmployDoctorsAndCreateTests();
            int i = 0;
            while (i != -1) {
                System.out.println("""
                        1. Admin
                        2. Patient
                        0. Exit
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
            main(args);
        }
    }

    private static void autoEmployDoctorsAndCreateTests() {
        String[] defaultFirstNames = {"Mike","John","Grace","Mofe","Wale","Abigail"};

        String[] defaultLastNames = {"Boyo","Ery","Royal","Eyi","Saheed","Chibob",};
        Gender[] gender = {Gender.MALE,Gender.FEMALE,Gender.NON_BINARY};
        String[] tests= {"HIV", "MALARIA", "GONORRHEA","DIABETES","COVID-19","STD"};
        Random random = new Random();
        for (int i = 0; i <5 ; i++) {
            MedicalTest test = new MedicalTest(tests[i]);
            Doctor doctor = new Doctor(defaultFirstNames[i],defaultLastNames[i], gender[random.nextInt(gender.length-1)],i+27);
            hospital.addDoctor(doctor);
            hospital.addTest(test);
        }

    }

    private static void patient() {
        int i = 0;
        while (i != -1) {
            System.out.println("""
                    1. Register
                    2. Sign In
                    0. homepage
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> patientReg();
                case 2 -> patientSignIn();
                default -> i = -1;
            }
        }
    }

    private static void patientSignIn() {
        System.out.println("Enter your email");
        String email = scanner.next();
        System.out.println("Enter your password");
        String password = scanner.next();
        User user = hospital.getAUser(email, password);
        System.out.println("Welcome "+user.getFirstName());
        int sent  =0;
        while (sent != -1) {
            System.out.println("""
                1. Take Test
                2. View Records
                0. Exit
                """);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> takeTest(user);
                case 2 -> viewRecords(user);
                default ->sent = -1;
            }
        }


    }

    private static void viewRecords(User user) {
        System.out.println("Enter password");
        String password = scanner.next();

        List<Record> records = user.getRecords(password);
        System.out.println(user.getFirstName()+"'s Medical Record");
        Record recordUSe = null;
        for(Record record : records) {
            if(record != null){
                recordUSe = record;
            }
        }
        assert recordUSe != null;
        System.out.printf("""
                Hospital: %s
                Doctor: %s %s
                Genotype: %s
                BloodGroup: %s
                """,recordUSe.getHospital().getName(), recordUSe.getDoctor().getFirstName(),
                recordUSe.getDoctor().getFirstName(), recordUSe.getGenotype(),recordUSe.getBloodGroup());
        System.out.println("Tests taken");
        System.out.println("=".repeat(10));
        for(Record record : records) {
            List<MedicalTest> tests = record.getTests();
            for(MedicalTest test : tests) {
                System.out.println(test);
                System.out.println("Doctor's Comment: "+test.getComment());
                System.out.println();
            }
        }
        System.out.println("=".repeat(10));


    }

    private static void takeTest(User user) {
        Genotype[] genotypes = {Genotype.AA, Genotype.AC, Genotype.AS, Genotype.SC, Genotype.SS};
        BloodGroup[] bloodGroups = { BloodGroup.A_Positive, BloodGroup.A_Negative,BloodGroup.B_Positive,
                BloodGroup.B_Negative, BloodGroup.AB_Positive, BloodGroup.AB_Negative, BloodGroup.O_Positive, BloodGroup.O_Negative};

        System.out.println("Select your genotype");
        for (int i = 0; i < genotypes.length ; i++) {
            System.out.println(i+1+". "+genotypes[i]);
        }
        Genotype genotype;
        int user_input = scanner.nextInt();
        switch (user_input){
            case 2 -> genotype = Genotype.AC;
            case 3 -> genotype = Genotype.AS;
            case 4 -> genotype = Genotype.SC;
            case 5 -> genotype = Genotype.SS;
            default -> genotype = Genotype.AA;
        }
        System.out.println("Select your blood Group");
        for (int i = 0; i < bloodGroups.length ; i++) {
            System.out.println(i+1+". "+ bloodGroups[i]);
        }
        BloodGroup bloodGroup;
        int user_inputs = scanner.nextInt();
        switch (user_inputs){
            case 1 -> bloodGroup = BloodGroup.A_Positive;
            case 2 -> bloodGroup = BloodGroup.A_Negative;
            case 3 -> bloodGroup = BloodGroup.B_Positive;
            case 4 -> bloodGroup = BloodGroup.B_Negative;
            case 5 -> bloodGroup = BloodGroup.AB_Positive;
            case 6 -> bloodGroup = BloodGroup.AB_Negative;
            case 7 -> bloodGroup = BloodGroup.O_Positive;
            default -> bloodGroup = BloodGroup.O_Negative;
        }
        Random random = new Random();
        int sent = 0;
        while (sent != -1) {
            List<MedicalTest> tests = hospital.getTest();
            for (MedicalTest test : tests) {
                System.out.println(test);
            }
            System.out.println("Enter test Id to take test");
            int testId = scanner.nextInt();
            MedicalTest test = hospital.getATest(testId);
            System.out.print("Taking blood samples");
            slow();
            System.out.print("Performing tests.");
            slow();
            System.out.print("Gathering results.");
            slow();
            int doctorsSize = hospital.getDoctors().size();
            Doctor doctor = hospital.getDoctors().get(random.nextInt(doctorsSize));
            String[] comments = {"You have ", "You don't have "};
            test.addComment(comments[random.nextInt(2)] + test.getTestName());
            Record record = new Record(hospital, doctor);
            record.addTests(test);
            record.setGenotype(genotype);
            record.setBloodGroup(bloodGroup);
            user.addRecord(record);
            System.out.println(test.getComment());

            System.out.println("Enter 1 to take another test or 0 to end");
            int input = scanner.nextInt();
            if (input != 1) {
                sent = -1;
            }
        }


    }

    private static void patientReg() {
        System.out.println("Enter your First Name");
        String firstname = scanner.next();
        System.out.println("Enter your Last Name");
        String lastname = scanner.next();
        System.out.println("Enter your e-mail");
        String email = scanner.next();
        System.out.println("Create your password ->");
        String password = scanner.next();
        User user = new User(firstname, lastname, email, password);
        hospital.addUser(user);
        System.out.println("Registered successfully");
    }

    private static void admin() {
        int i = 0;
        while (i != -1) {
            System.out.println("""
                    1. View all patients
                    2. View all Doctors
                    3. Employ Doctor
                    4. Create new test
                    5. View all available tests
                    0. Homepage
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> viewAllPatients();
                case 2 -> viewAllDoctors();
                case 3 -> employDoctor();
                case 4 -> createTest();
                case 5 -> viewTests();
                default -> i = -1;
            }
        }
    }

    private static void viewTests() {
        List<MedicalTest> tests = hospital.getTest();
        for (MedicalTest test : tests) {
            System.out.println(test);
        }
    }

    private static void createTest() {
        int sent = 0;
        while (sent != -1) {
            System.out.println("Enter test name");
            String name = scanner.next();
            MedicalTest test = new MedicalTest(name);
            hospital.addTest(test);
            System.out.println("Press 1 to add another test or 0 to end");
            int input = scanner.nextInt();
            if (input != 1) {
                sent = -1;
            }
        }
    }

    private static void employDoctor() {
        int sent = 0;
        while (sent != -1) {
            System.out.println("Enter firstName");
            String firstName = scanner.next();

            firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
            System.out.println("Enter last name");
            String lastName = scanner.next();
            lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
            System.out.println("""
                Select gender
                1. Male
                2. Female
                3. Others
                """);
            Gender gender;
            int input = scanner.nextInt();
            switch (input){
                case 2 -> gender = Gender.FEMALE;
                case 3 -> gender = Gender.NON_BINARY;
                default -> gender = Gender.MALE;
            }
            System.out.println("Enter age");
            int age = scanner.nextInt();
            Doctor doctor = new Doctor(firstName,lastName,gender,age);
            hospital.addDoctor(doctor);
            System.out.println("Press 1 to add another doctor or 0 to end");
            int user = scanner.nextInt();
            if (user != 1) {
                sent = -1;
            }
        }

    }

    private static void viewAllDoctors() {
        List<Doctor> doctors = hospital.getDoctors();
        for (Doctor doctor :doctors){
            System.out.println(doctor);
        }
    }

    private static void viewAllPatients() {
        List<User> users = hospital.getUsers();
        for (User user :users){
            System.out.println(user);
        }
    }

    private static void visitHospital() {
        System.out.println("Enter your location");
        String location = scanner.next();

        location = location.substring(0,1).toUpperCase() + location.substring(1);
        System.out.print("Fetching hospital data in " + location);
        slow();
        System.out.println("Available hospitals in " + location);
        String[] names = {"Divine Health", "Graceful Health", "Forever Health", "Good Life", "St' Nicolas"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + 1 + ". " + names[i]);
        }
        System.out.println("Choose hospital by entering id");
        int id = scanner.nextInt();
        hospital = new Hospital(names[id - 1], location);
        System.out.println("Welcome to " + hospital.getName() + " Hospital, " + hospital.getLocation());
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
