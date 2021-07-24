import java.util.Scanner;

public class PlayProject {
    private static double salary;

    public static void main(String[] args) {
        getOutput();

    }


    public static void getOutput() {
        Scanner scan = new Scanner(System.in);
        double salary;
        double fedTax;
        double provTax;
        double totalTax;
        double finalSalary;
        boolean restart = false;

        salary = getInput("What is your yearly salary?");
        System.out.println(salary);

        fedTax = getFederalRate(salary);
        provTax = getOntarioRate(salary);

        totalTax = provTax + fedTax;
        finalSalary = salary - totalTax;

        System.out.printf("Your federal tax will be $%.2f , and your provincial tax will be $%.2f %n", fedTax, provTax);
        System.out.printf("Your total tax is $%.2f, and after tax you will be left with $%.2f %n", totalTax, finalSalary);

        System.out.printf("Would you like to enter another salary ? %n 1: True 2: False %n");
        restart = getBoolean();
        if (restart)
            getOutput();
        else System.exit(1);


    }



    public static double getInput(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        while (!scan.hasNextDouble()) {
            scan.next();
            System.out.println("That is invalid, numbers only");
        }
        return scan.nextDouble();


    }

    public static boolean getBoolean() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextBoolean()) {
            scan.next();
            System.out.println("Invalid input, type true or false");

        }
        return scan.nextBoolean();
    }

    public static double getFederalRate(double salary) {
        double fedTax = 0;
        //0-$49,020
        double tier1 = 0.15;
        //$49,020-$98,040
        double tier2 = 0.205;
        //$98,040-$151,978
        double tier3 = 0.26;
        //51,978 up to $216,511
        double tier4 = 0.29;
        //over $216,511
        double tier5 = 0.33;

        if (salary <= 49020)
            fedTax = salary * tier1;
        else if (salary <= 98040)
            fedTax = (salary - 49020) * tier2 + (49020 * tier1);
        else if (salary <= 151978)
        fedTax = (49020 * tier1) + (49020 * tier2) + (salary - 98040) * tier3;
            else if (salary <= 216511)
            fedTax = (49020 * tier1) + (49020 * tier2) + (98040 * tier3) + (salary - 151978) * tier4;
        else if (salary > 216511)
            fedTax = (49020 * tier1) + (49020 * tier2) + (98040 * tier3) + (64533 * tier4) + (salary - 216511) * tier5;


        return fedTax;

    }

    public static double getOntarioRate(double salary) {
        double provTax = 0;
        //0-$45,152
        double provTier1 = 0.0505;
        // $45,142 up to $90,287
        double provTier2 = 0.0915;
        //$90,287 up to $150,000
        double provTier3 = 0.1116;
        //$150,000 up to $220,000
        double provTier4 = 0.1216;
        //over $220,000
        double proveTier5 = 0.1316;


        if (salary <= 45142)
            provTax = (salary * provTier1);
        else if (salary <= 90287)
            provTax = (45142 * provTier1) + (salary - 45142) * provTier2;
        else if (salary <= 150000)
            provTax = (45142 * provTier1) + (45142 * provTier2) + (salary - 98287) * provTier3;
        else if (salary <= 220000)
            provTax = (45142 * provTier1) + (45142 * provTier2) + (59713 * provTier3) + (salary - 150000) * provTier4;
        else if (salary > 220000)
            provTax = (45142 * provTier1) + (45142 * provTier2) + (59713 * provTier3) + (70000 * provTier4) + (salary - 220000) * proveTier5;


        return provTax;
    }

}



