import java.io.*;
import java.util.Scanner;

class BloodBank {
    static int[] bloodGroup = new int[8];
}

class Admin {
    void display() {
        System.out.printf("%-15s%-15s\n", "Blood Group", "Packets Available");

        String[] bloodGroups = {"A +ve", "O +ve", "B +ve", "AB +ve", "A -ve", "O -ve", "B -ve", "AB -ve"};

        for (int i = 0; i < 8; ++i) {
            System.out.printf("%-15s%-15d\n", bloodGroups[i], BloodBank.bloodGroup[i]);
        }
    }

    Admin() {
        Scanner scanner = new Scanner(System.in);
        String password = "saurabh";

        System.out.print("Enter password: ");
        String str = scanner.next();

        if (password.equals(str)) {
            System.out.println("WELCOME ADMIN");
            display();
        } else {
            System.out.println("Error please contact rabh");
        }
    }
}

class Recipient {
    String name;
    String bloodGroup;

    void save() {
        Scanner scanner = new Scanner(System.in);
        int c;

        System.out.print("Enter your Name: ");
        name = scanner.next();

        System.out.println("Enter type of blood group you are looking for:");
        System.out.println("0 = A positive\n1 = O positive\n2 = B positive\n3 = AB positive\n4 = A negative\n5 = O negative\n6 = B negative\n7 = AB negative");
        c = scanner.nextInt();

        System.out.println("You will be donated with 1 blood packet");
        show(c);
    }

    void show(int c) {
        if (c >= 0 && c < 8) {
            String[] bloodGroups = {"A +ve", "O +ve", "B +ve", "AB +ve", "A -ve", "O -ve", "B -ve", "AB -ve"};

            System.out.printf("%-15s%-15s\n", "Blood Group", "Packets Available");
            System.out.printf("%-15s%-15d\n", bloodGroups[c], BloodBank.bloodGroup[c]);

            if (BloodBank.bloodGroup[c] > 0) {
                BloodBank.bloodGroup[c]--;
            } else {
                System.out.println("Blood group not available");
            }
        } else {
            System.out.println("Invalid blood group selection.");
        }
    }
}

class Donor {
    String name;

    void addDonor() throws IOException {
        BufferedWriter file = new BufferedWriter(new FileWriter("donor.txt", true));
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = scanner.next();

        System.out.println("Enter type of blood group you are donating:");
        System.out.println("0 = A positive\n1 = O positive\n2 = B positive\n3 = AB positive\n4 = A negative\n5 = O negative\n6 = B negative\n7 = AB negative");
        int c = scanner.nextInt();

        System.out.print("Number of packets of blood you donate: ");
        int x = scanner.nextInt();

        if (x > 2) {
            System.out.println("You can donate only 2 packets of blood.");
            x = 2;
        }

        file.write("\tDONOR DETAILS\t\n");
        file.write("Donor Name : " + name + "\n");
        file.write("Blood Group : " + c + "\n");
        file.write("Number Of Packets : " + x + "\n");
        file.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        BloodBank.bloodGroup[c] += x;

        System.out.print("Do you want your information to be displayed (Y/N)?");
        char ch = scanner.next().charAt(0);

        if (ch == 'Y' || ch == 'y') {
            display();
        }

        file.close();
    }

    void display() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("donor.txt"));

        String line;
        System.out.printf("%-15s%-15s%-15s\n", "Name", "Blood Group", "Packets Donated");

        String[] bloodGroups = {"A +ve", "O +ve", "B +ve", "AB +ve", "A -ve", "O -ve", "B -ve", "AB -ve"};

        while ((line = f.readLine()) != null) {
            String[] data = line.split(" ");
            if (data.length >= 3) {
                System.out.printf("%-15s%-15s%-15s\n", data[3], bloodGroups[Integer.parseInt(data[5])], data[7]);
            }
        }

        f.close();
    }
}

public class BloodBankMangementSystem {
    public static void main(String[] args) throws IOException {
        Donor[] donors = new Donor[100];
        Recipient[] recipients = new Recipient[50];

        int c = 0;
        Scanner scanner = new Scanner(System.in);

        while (c != 4) {
            System.out.println("*********************************************** WELCOME TO BLOOD BANK ************************************************");
            System.out.println("*");
            System.out.println("**********************************************************************************************************************");
            System.out.println("Enter 1 if you are the admin:");
            System.out.println("Enter 2 if you are a donor:");
            System.out.println("Enter 3 if you are a recipient:");
            System.out.println("Enter 4 if you want to exit:");
            System.out.print("Enter: ");
            c = scanner.nextInt();

            switch (c) {
                case 4:
                    break;
                case 1:
                    Admin admin = new Admin();
                    break;
                case 2:
                    System.out.println("**********************************************************************************************************************");
                    System.out.println("*\n* WELCOME DONOR *\n*");
                    System.out.println("**********************************************************************************************************************");
                    System.out.print("Enter 1 to enter your information: ");
                    int k = scanner.nextInt();
                    if (k == 1) {
                        donors[Donor.i++].addDonor();
                    } else if (k == 2) {
                        donors[Donor.i].display();
                    }
                    break;
                case 3:
                    System.out.println("WELCOME RECIPIENT : ");
                    recipients[Recipient.i++].save();
                    break;
            }
        }
    }
}
