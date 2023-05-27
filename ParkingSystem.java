import java.util.*;

class UserDetails {
  String name;
  String liscence_no;
  int security_key;
  String vehicle_type;
  int parking_no;

  public void get_user_details() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Name: ");
    this.name = sc.next(); 
    
    System.out.print("Enter Liscence number: ");
    this.liscence_no = sc.next();
    
    this.security_key = generateSecurityKey();
    
    System.out.print("Enter Vehicle type: ");
    this.vehicle_type = toLowerCase(sc.next());
    
    // this.parking_no = generateParkingNo();
    
  }
  
  public int generateSecurityKey() {
    Random rand = new Random();
    int key = random.nextInt(10000);
    return key;
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

  public int setParkingNo(int x) {
    this.parking_no = x;
  }

  public int generateParkingNo() {
    Random rand = new Random();
    if(this.vehicle_type)
    return key;
  }
  
  public void show_availability() {
    System.out.print("Checking availability...\n");
    System.out.print("Type of vehicle: "+this.vehicleType+"\n");
  }

  public void reciept_generation() {
    System.out.println("-----PARADISE PARKING-----");
    System.out.println("Name: "+this.name);
    System.out.println("Liscence No.: "+this.liscence_no);
    System.out.println("Parking No.: "+this.parking_no);
    if(this.vehicle_type=="car")
    {
      System.out.println("Vehicle Type: "+this.vehicle_type);
      System.out.println("Class: "+Main.choice);
      Systetem.out.println("Expense: "+facilities.costC);
    }
    else
    {
      System.out.println("Vehicle Type: "+this.vehicle_type);
      System.out.println("Class: "+Main.choice);
      Systetem.out.println("Expense: "+facilities.costB);
      
    }
    System.out.println("Thank you!! Visit Again");
    
    
    
    
  }
  
}



class facilities{
  public int choice,costC=0,costB=0,ch;
  Scanner sc=new Scanner(System.in);
  void displayfacilities()
  {
    System.out.println("1. General \n2. Premium\n");
    choice=sc.nextInt();
  }
  void PUC()
  {
    System.out.println("Do you have PUC(0/1):") ;
    ch=sc.nextInt();
    
  }
  
  
}
class car extends facilities{
  void check()
  {
    int y;
    if(choice==1)
    { 
      costc+=150;
    }
    else if(choice==2)
    {
      costc+=250;
    } 
  }
  if(ch==1)
  {
      System.out.println("Good to go....")
  }
  else
  {
      Syetem.out.println("Warning: Traffic Police ahead PUC Fine Rs.500");
      System.out.println("Want to create PUC\n1. yes\n2. No");
      if(y==1)
      {
        System.out.println("We are giving free Air Check")
          costc+=100;
      }
    else
      {
        System.out.println("Thank You ")
      }
  }

  
}

class bike extends facilities{
  void check()
  {
    int y;
    if(choice==1)
    { 
      cosb+=100;
    }
    else if(choice==2)
    {
      costb+=150;
    } 
  }
  if(ch==1)
  {
      System.out.println("Good to go....")
  }
  else
  {
      Syetem.out.println("Warning: Traffic Police ahead PUC Fine Rs.500");
      System.out.println("Want to create PUC\n1. yes\n2. No");
      if(y==1)
      {
        System.out.println("We are giving free Air Check")
          costb+=50;
      }
      else
      {
        System.out.println("Thank You ")
      }
  }

  
}
class Grid extends Userdetails{
  public int[][] parking_area=new int[4][3];
  HashMap<String,Integer> map=new HashMap<String,Integer>();
  int i,j;
  public void initialize()
  {
    for(i=0;i<4;i++)
      {
        for(j=0;j<3;j++)
          {
            parking_area[i][j]=0;
          }
      }
  }
  public void showgrid()
  {
     for(i=0;i<4;i++)
      {
        for(j=0;j<3;j++)
          {
            System.out.println(parking_area[i][j]);
          }
      }
    
  }
  public boolean bikegeneral()
  {
    for(i=0;i<3;i++)
      {
        if(parking_area[0][i]==0)
        {
          return true;
        }
      }
    return false;
  }
  public boolean bikepremium()
  {
    for(i=0;i<3;i++)
      {
        if(parking_area[1][i]==0)
        {
          return true;
        }
      }
    return false;
  }
  public boolean cargeneral()
  {
    for(i=0;i<3;i++)
      {
        if(parking_area[2][i]==0)
        {
          return true;
        }
      }
    return false;
  }
  public boolean carpremium()
  {
    for(i=0;i<3;i++)
      {
        if(parking_area[3][i]==0)
        {
          return true;
        }
      }
    return false;
  }
  public void book(int r,int c)
  {
    parking_area[r][c]=1;
    int parkNo = (r*3)+(c+1);
    this.setParkingNo(parkNo);
    System.out.println("We have successfully booked your parking\nYour Parking No. is "+parkNo);
    map.put(this.name,parkNo);
  }
  public void display()
  {
    System.out.println("-----Current Parking Status-----")
    for(Map.Entry m : map.entrySet()){    
    System.out.println(m.getKey()+" "+m.getValue());    
  }
  
}

class Exit extends UserDetails {
  public void exitParking(UserDetails objUserDetails obj) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter security key: ");
    usrKey = sc.nextInt();
    if(usrKey == this.generateSecurityKey()) {
      parkNo = this.generateParkingNo();
      // parkNo delete from hashmap
      // grid
      System.out.print("Exited from Parking area successfully!");
    }
  }

  public void deleteParkSpace() {
    int t=map.get();
    r=t/3;
    c=t%3;
    parking_area[r][c]=0;
    map.remove(this.name);
    System.out.println("----Thank You!! Visit Again----")
    
  }
  
}
         
class Main {
  public static void main(String[] args) {
    UserDetails usr = new UserDetails();
    Grid token = new Grid
    
    String category;
    public int choice;
    
    System.out.print("Welcome to Automated Parking System\n");
    System.out.print("Please give your details: ");

    System.out.print("Select parking category: ");
    System.out.print("\t1. General \n\t2. Premium\n");
    choice = sc.nextInt();
    if(choice == 1) {
      category = "general";
    }
    else {
      category = "premium";
    }
    
    System.out.print("Checking availability in parking ");
    
    if(usr.getVehicleType() == "car") {
      if(category == "general") {
        if(usr.cargeneral()) {
          System.out.print("Parking is available");
          usr.display();
          System.out.print("Enter Row and Col: ");
          int row = sc.nextInt();
          int col = sc.nextInt();
          usr.book(row,col);
        }
        else() {
          System.out.print("Parking is full in general category, try in premium\n");
        }
      }
      else {  
        if(usr.carpremium()) {
          System.out.print("Parking is available\n");
          //allot parking space
        }
        else {
          System.out.print("Parking is full in premium category\n");
        }
      } 
    }
    else {     
      if(category == "general") {
        if(usr.bikegeneral()) {
          System.out.print("Parking is available");
          //allot parking space
        }
        else() {
          System.out.print("Parking is full in general category, try in premium\n");
        }
      }
      else {     
        if(usr.bikepremium()) {
          System.out.print("Parking is available\n");
          //allot parking space
        }
        else {
          System.out.print("Parking is full in premium category\n");
        }
      }
    }

    
    System.out.print("Vehicle has been parked: ");
     
    
    
  }
}
