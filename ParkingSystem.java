import java.util.*;

class UserDetails {
  String name;
  String liscence_no;
  int security_key;
  String vehicle_type;
  String parking_no;

  public void get_user_details() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Name: ");
    this.name = sc.next(); 
    
    System.out.print("Enter Liscence number: ");
    this.liscence_no = sc.next();
    
    this.security_key = generateSecurityKey();
    
    System.out.print("Enter Vehicle type: ");
    this.vehicle_type = sc.next();
    
    this.parking_no = generateParkingNo();
    
  }
  
  public int generateSecurityKey() {
    Random rand = new Random();
    int key = random.nextInt(10000);
    return key;
  }

  public int generateParkingNo() {
    Random rand = new Random();
    int parkNo = random.nextInt(10000);
    parkNo = Integer.toHexString(parkNo);
    return key;
  }
  
  public void show_availability(UserDetails obj) {
    System.out.print("Checking availability...\n");
    System.out.print("Type of vehicle: "+obj.vehicleType+"\n");
  }

  public void reciept_generation() {
    
  }
  
}



class facilities{
  int choice,costC=0,costB=0,ch;
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
      cosc+=150;
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

class ParkingSystem {
  public static void main(String[] args) {
    
    System.out.println("Hello world!");

    UserDetails na
    
    
  }
}