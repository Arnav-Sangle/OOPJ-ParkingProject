import java.util.*;

class UserDetails {
    String name;
    String license_no;
    int security_key;
    String vehicle_type;
    int parking_no;
    String category;
    
    public void get_user_details() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name: ");
        this.name = sc.next();
        
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
    
    public void check() {
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
    }
}

class Bike extends Facilities {
    
    void setchoice(int c) {
        choice=c;
    }
    
    public void check() {
        
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
    }
    
}



class Grid extends UserDetails {
    
    public static int[][] parking_area = new int[4][3];
    HashMap<String, Integer> map = new HashMap<String, Integer>();
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

    public void book(int r, int c) {
        if (parking_area[r][c] == 1) {
            System.out.println("This Parking is already booked!! Please Choose different slot\n");
        } 
        else {
            parking_area[r][c] = 1;
            this.parking_no = (r * 3) + (c + 1);
            System.out.println("We have successfully booked your parking\nYour Parking No. is " + this.parking_no);
            map.put(this.name, this.parking_no);
        }
    }

    public void display() {
        System.out.println("-----Current Parking Status-----");
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    public void deleteParkSpace() {
        int t = map.get(this.name);
        int r = t / 3;
        int c = t % 3;
        parking_area[r][c] = 0;
        map.remove(this.name);
        System.out.println("----Thank You!! Visit Again----");
    }
}



class Exit extends Facilities{
    public int exitParking(UserDetails obj) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter security key: ");
        int usrKey = sc.nextInt();
        if (usrKey == obj.getSecurityKey()) {
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
        System.out.println("\n-----PARKIN PARADISE-----\n");
        System.out.println("Name: " + this.name);
        System.out.println("License No.: " + this.license_no);
        System.out.println("Parking No.: " + this.parking_no);
        
        if (this.vehicle_type.equals("car")) {
            System.out.println("Vehicle Type: " + this.vehicle_type);
            System.out.println("Category: " + this.category);
            System.out.println("Expense: " + costC);
        }
        else {
            System.out.println("Vehicle Type: " + this.vehicle_type);
            System.out.println("Category: " + this.category);
            System.out.println("Expense: " + costB);
        }
        
        System.out.println("Thank you!! Visit Again");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cat = 0;
        UserDetails usr = new UserDetails();
        Grid g = new Grid();
        Exit e = new Exit();
        
        usr.get_user_details();     //inputing user details during entry
        g.initialize();
        
        System.out.println("*****Welcome to PARKIN PARADISE!*****");
        
        int ch=0;
        do {
            System.out.println("Select Class\n1. General\n2. Premium");
            System.out.print("Your choice: ");
            cat = sc.nextInt();
            
            if(cat==1) {
                usr.setCategory("General");
            }
            else {
                usr.setCategory("Premium");
            }
            
            if (usr.vehicle_type.equals("bike") && cat == 1) {
            // System.out.println(g.bikegeneral()+"bike general");
                if (g.bikegeneral() == true) {
                    g.showgrid();
                    System.out.println("");
                    System.out.print("Enter row and column(Choose where 0 is there):\n" +
                        "---GuideLines to Choose Row and Column---\n" +
                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                        "You can choose Columns between 0 to 2\n"
                    );
                    System.out.print("Your choice: ");    
                    
                    int r = 0;
                    int c = sc.nextInt();
                    g.book(r, c);
                    
                    g.showgrid();   //status after booking
                    System.out.println("");
                } 
                else {
                    System.out.println("Try in Premium Section!!");
                    continue;
                }
            } 
            else if (usr.vehicle_type.equals("bike") && cat == 2) {
                // System.out.println(g.bikepremium()+"bike premium");
                if (g.bikepremium() == true) {
                    g.showgrid();
                    System.out.println("");
                    System.out.print("Enter row and column(Choose where 0 is there):\n" +
                        "---GuideLines to Choose Row and Column---\n" +
                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                        "You can choose Columns between 0 to 2\n"
                    );
                    System.out.print("Your choice: ");  
                    
                    int r = 1;
                    int c = sc.nextInt();
                    g.book(r, c);
                    
                    g.showgrid();   //status after booking
                    System.out.println("");
                } 
                else {
                    System.out.println("Try in General Section!!");
                    continue;
                }
            } 
            else if (usr.vehicle_type.equals("car") && cat == 1) {
                // System.out.println(g.cargeneral()+"car general");
                if (g.cargeneral() == true) {
                    g.showgrid();
                    System.out.println("");
                    System.out.print("Enter row and column(Choose where 0 is there):\n" +
                        "---GuideLines to Choose Row and Column---\n" +
                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                        "You can choose Columns between 0 to 2\n"
                    );
                    System.out.print("Your choice: "); 
                    
                    int r = 2;
                    int c = sc.nextInt();
                    g.book(r, c);
                    
                    g.showgrid();   //status after booking
                    System.out.println("");
                }
                else {
                    System.out.println("Try in Premium Section!!");
                    continue;
                }
            } 
            else {
                // System.out.println(g.carpremium()+"car premium");
                if (g.carpremium() == true) {
                    g.showgrid();
                    System.out.print("");
                    System.out.print("Enter row and column(Choose where 0 is there):\n" +
                        "---GuideLines to Choose Row and Column---\n" +
                        " Row 0- Bike General\n Row 1- Bike Premium\n Row 2- Car General\n Row 3- Car Premium\n" +
                        "You can choose Columns between 0 to 2\n"
                    );
                    System.out.print("Your choice: ");
                    
                    int r = 3;
                    int c = sc.nextInt();
                    g.book(r, c);
                    
                    g.showgrid();   //status after booking
                    System.out.println("");
                } 
                else {
                    System.out.println("Try in General Section!!");
                    continue;
                }
            }
            
            System.out.println("Do you want to continue(0/1)");
            ch = sc.nextInt();
        }while(ch!=0);
        
        System.out.println("Your Parking Ticket Details: ");
        usr.generateSecurityKey();
        System.out.println("\tParking number: "+g.getParkingNo());
        System.out.println("\tCategory: "+usr.getCategory());
        System.out.println("\tGenerated Security key: "+usr.getSecurityKey()+"\n\tPlease keep it private to you\n");
        
        Bike B = new Bike();
        Car C = new Car();
        
        System.out.println("---Facilities---");
        if (usr.vehicle_type.equals("bike")) {
            B.setchoice(cat);
            B.PUC();
            B.check();
        } 
        else {
            C.setchoice(cat);
            C.PUC();
            C.check();
        }
        
        int s;
        do{
            s = e.exitParking(usr);
        }while(s==1);
        
        e.receipt_generation();
        g.deleteParkSpace();
        
    }
}
