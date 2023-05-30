import java.util.*;

class UserDetails {
    String name;
    String license_no;
    int security_key;
    String vehicle_type;
    int parking_no;
    String category;
    int costc, costb;

    public void get_user_details() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        this.name = sc.next();
        this.name=this.name.toLowerCase();
        System.out.print("Enter License number: ");
        this.license_no = sc.next();

        System.out.print("Enter Vehicle type: ");
        this.vehicle_type = sc.next();
    }

    public void generateSecurityKey() {
        Random rand = new Random();
        int key = rand.nextInt(10000);
        this.security_key = key;
    }

    public int getSecurityKey() {
        return this.security_key;
    }

    public String getVehicleType() {
        return this.vehicle_type;
    }

    public int getParkingNo() {
        return this.parking_no;
    }

    public void setParkingNo(int x) {
        this.parking_no = x;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String x) {
        this.category = x;
    }
    public void setcostc(int x)
    {
        this.costc=x;
    }
    public void setcostb(int y)
    {
        this.costb=y;
    }
}

class Facilities extends UserDetails{

    protected int choice;
    protected int costC = 0;
    protected int costB = 0;
    protected int ch;

    Scanner sc = new Scanner(System.in);

    public void PUC() {
        System.out.println("Do you have PUC (0/1):");
        ch = sc.nextInt();
    }

}

class Car extends Facilities {

    void setchoice(int c) {
        choice=c;
    }

    public void check(UserDetails usr) {
        int y;

        if (choice == 1) {
            costC += 150;
        }
        else if (choice == 2) {
            costC += 250;
        }

        if (ch == 1) {
            System.out.println("Good to go....");
        }
        else {
            System.out.println("Warning: Traffic Police ahead PUC Fine Rs.500");
            System.out.println("Want to create PUC\n1. yes\n2. No");
            y = sc.nextInt();

            if (y == 1) {
                System.out.println("We are giving free Air Check");
                costC += 100;
            }
            else {
                System.out.println("Thank You ");
            }
        }
        // System.out.println(costC);
        usr.setcostc(costC);
    }
}

class Bike extends Facilities {

    void setchoice(int c) {
        choice=c;
    }

    public void check(UserDetails usr) {

        int y;
        if (choice == 1) {
            costB += 100;
        }
        else if (choice == 2) {
            costB += 150;
        }

        if (ch == 1) {
            System.out.println("Good to go....");
        }
        else {
            System.out.println("Warning: Traffic Police ahead PUC Fine Rs.500");
            System.out.println("Want to create PUC\n1. yes\n2. No");
            y = sc.nextInt();

            if (y == 1) {
                System.out.println("We are giving free Air Check");
                costB += 50;
            }
            else {
                System.out.println("Thank You ");
            }
        }
        // this.costB=costB;
        // System.out.println(costB);
        usr.setcostb(costB);
    }

}


class Grid extends UserDetails {
    public static int[][] parking_area = new int[4][3];
    HashMap<String, Integer> map = new HashMap<>();
    int i, j;

    public void initialize() {
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 3; j++) {
                parking_area[i][j] = 0;
            }
        }
    }

    public void showgrid() {
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(parking_area[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public boolean bikegeneral() {
        for (i = 0; i < 3; i++) {
            if (parking_area[0][i] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean bikepremium() {
        for (i = 0; i < 3; i++) {
            if (parking_area[1][i] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean cargeneral() {
        for (i = 0; i < 3; i++) {
            if (parking_area[2][i] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean carpremium() {
        for (i = 0; i < 3; i++) {
            if (parking_area[3][i] == 0) {
                return true;
            }
        }
        return false;
    }

    public void book(UserDetails usr,int r, int c) {
        if (parking_area[r][c] == 1) {
            System.out.println("This Parking is already booked!! Please choose a different slot.\n");
        } else {
            parking_area[r][c] = 1;
            usr.setParkingNo((r * 3) + (c + 1)); // Set parking_no of UserDetails object
            System.out.println("We have successfully booked your parking.\nYour Parking No. is " + usr.getParkingNo());
            map.put(usr.name, usr.getParkingNo());
        }
    }

    public void display() {
        System.out.println("-----Current Parking Status-----");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void deleteParkSpace(UserDetails usr,String n) {
        Integer parkingNo = map.get(n);
        System.out.println(parkingNo);
        if (parkingNo != null) {
            int r = (parkingNo - 1) / 3;
            int c = (parkingNo - 1) % 3;
            parking_area[r][c] = 0;
            map.remove(n);
//            usr.setParkingNo(0); // Set parking_no of UserDetails object to 0
            System.out.println("----Thank You!! Visit Again----");
        } else {
            System.out.println("No parking space found for " + n);
        }
    }

}


class Exit extends Facilities{
    public int exitParking(UserDetails obj) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter security key: ");
        int usrKey = sc.nextInt();
        if (usrKey == obj.security_key) {
            // parkNo delete from hashmap    // grid
            System.out.print("Exited from Parking area successfully!");
            return 0;
        }
        else {
            System.out.print("Wrong Securiy key");
            return 1;
        }
    }

    public void receipt_generation(UserDetails usr) {
        try {
            System.out.print("Generating Receipt ");
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.println();
        }
        catch (Exception e) {

            // catching the exception
            System.out.println(e);
        }
        System.out.println("-----PARKIN PARADISE-----");
        System.out.println("Name: " + usr.name);
        System.out.println("License No.: " + usr.license_no);
        System.out.println("Parking No.: " + usr.parking_no);

        if (usr.vehicle_type.equals("car")) {
            System.out.println("Vehicle Type: " + usr.vehicle_type);
            System.out.println("Category: " + usr.category);
            System.out.println("Expense: " + usr.costc);
        }
        else {
            System.out.println("Vehicle Type: " + usr.vehicle_type);
            System.out.println("Category: " + usr.category);
            System.out.println("Expense: " + usr.costb);
        }

        System.out.println("Thank you!! Visit Again");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cat = 0,choice;
        UserDetails[] usr = new UserDetails[50];
        Grid g = new Grid();
        Exit e = new Exit();

//        usr.get_user_details();     //inputing user details during entry
        g.initialize();
        int o=-1;
        System.out.println("*****Welcome to PARKIN PARADISE!*****");
        do {

            System.out.println("\n-------- MENU --------");
            System.out.println("1. Book Parking");
            System.out.println("2. Check Facilities");
            System.out.println("3. Exit Parking");
            System.out.println("4. Display Parking Status");
            System.out.println("5. Delete Parking Space");
            System.out.println("6. Generate Receipt");
            System.out.println("7. Show Parking Area");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    o++;
                    usr[o]=new UserDetails();
                    System.out.println("\n-----Book Parking-----");
                    usr[o].get_user_details();
                    int i = 4;
                    while (i != 0) {
                        System.out.println("Select Class\n1. General\n2. Premium");
                        System.out.print("Your choice: ");
                        cat = sc.nextInt();

                        if (cat == 1) {
                            usr[o].setCategory("General");
                        } else {
                            usr[o].setCategory("Premium");
                        }

                        if (usr[o].vehicle_type.equals("bike") && cat == 1) {

                            if (g.bikegeneral() == true) {
                                g.showgrid();
                                System.out.println("");
                                System.out.print("Enter row and column(Choose where 0 is there):\n" +
                                        "---GuideLines to Choose Row and Column---\n" +
                                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                                        "You can choose Columns between 0 to 2\n");
                                System.out.print("Your choice: ");

                                int r = 0;
                                int c = sc.nextInt();
                                g.book(usr[o], r, c);

//                                g.showgrid();   //status after booking
                                System.out.println("");
                            } else {
                                System.out.println("Try in Premium Section!!");
                                continue;
                            }
                        } else if (usr[o].vehicle_type.equals("bike") && cat == 2) {
                            if (g.bikepremium() == true) {
                                g.showgrid();
                                System.out.println("");
                                System.out.print("Enter row and column(Choose where 0 is there):\n" +
                                        "---GuideLines to Choose Row and Column---\n" +
                                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                                        "You can choose Columns between 0 to 2\n");
                                System.out.print("Your choice: ");

                                int r = 1;
                                int c = sc.nextInt();
                                g.book(usr[o], r, c);

//                                g.showgrid();   //status after booking
                                System.out.println("");
                            } else {
                                System.out.println("Try in General Section!!");
                                continue;
                            }
                        } else if (usr[o].vehicle_type.equals("car") && cat == 1) {
                            if (g.cargeneral() == true) {
                                g.showgrid();
                                System.out.println("");
                                System.out.print("Enter row and column(Choose where 0 is there):\n" +
                                        "---GuideLines to Choose Row and Column---\n" +
                                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                                        "You can choose Columns between 0 to 2\n");
                                System.out.print("Your choice: ");

                                int r = 2;
                                int c = sc.nextInt();
                                g.book(usr[o], r, c);

//                                g.showgrid();   //status after booking
                                System.out.println("");
                            } else {
                                System.out.println("Try in Premium Section!!");
                                continue;
                            }
                        } else {
                            if (g.carpremium() == true) {
                                g.showgrid();
                                System.out.print("");
                                System.out.print("Enter row and column(Choose where 0 is there):\n" +
                                        "---GuideLines to Choose Row and Column---\n" +
                                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                                        "You can choose Columns between 0 to 2\n");
                                System.out.print("Your choice: ");

                                int r = 3;
                                int c = sc.nextInt();
                                g.book(usr[o], r, c);

//                                g.showgrid();   //status after booking
                                System.out.println("");
                            } else {
                                System.out.println("Try in General Section!!");
                                continue;
                            }
                        }

                        System.out.println("Do you want to continue(0/1)");
                        int y = sc.nextInt();
                        if (y == 0) {
                            break;
                        }
                        i--;
                    }
                    System.out.println("You have Successfully Parked your Vehicle");
                    System.out.println("Your Parking Ticket Details: ");
                    usr[o].generateSecurityKey();
                    System.out.println("\tParking number: " + usr[o].getParkingNo());
                    System.out.println("\tCategory: " + usr[o].getCategory());
                    System.out.println("\tGenerated Security key: " + usr[o].getSecurityKey() + "\n\tPlease keep it private to you\n");
                    break;
                case 2:
                    Bike B = new Bike();
                    Car C = new Car();
                    System.out.println("---Facilities---");
                    if (usr[o].vehicle_type.equals("bike")) {
                        B.setchoice(cat);
                        B.PUC();
                        B.check(usr[o]);
                    } else {
                        C.setchoice(cat);
                        C.PUC();
                        C.check(usr[o]);
                    }
                    break;
                case 3:
                    int s;
                    do {
                        s = e.exitParking(usr[o]);
                    } while (s == 1);
                    break;
                case 4:
                    g.display();
                    break;
                case 5:
                    System.out.println("Enter name customer you want to delete: ");
                    String nm=sc.next();
                    nm=nm.toLowerCase();
                    g.deleteParkSpace(usr[o],nm);
                    break;
                case 6:
                    e.receipt_generation(usr[o]);
                    break;
                case 7:
                    g.showgrid();
                    break;
            }
        }while(choice!=0);


    }
}
