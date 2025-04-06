//Project code

import java.io.*;
import java.util.*;
public class nothing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        // Predefined police (Can be made dynamic too)
        Police registeredPolice = new Police("Mr. X", "Inspector", "mrx", "1234");

        System.out.println("=== Police Login Portal ===");
        System.out.print("Enter Username: ");
        String inputUser = sc.nextLine();
        System.out.print("Enter Password: ");
        String inputPass = sc.nextLine();

        if (!registeredPolice.login(inputUser, inputPass)) {
            System.out.println("Unauthorized Access! Login Failed.");
            return;
        }

        System.out.println("\nLogin Successful! Welcome " + registeredPolice.getName() + " (" + registeredPolice.getRank() + ")\n");
        RecordManager manager=new RecordManager();
        manager.loadData();

        while (true) {
            System.out.println("=== Crime Records Management System ===");
            System.out.println("1. Add Crime Record");
            System.out.println("2. Show All Crime Records");
            System.out.println("3. Search Crime by Keyword");
            System.out.println("4. Search by Victim ID");
            System.out.println("5. Search by Criminal ID");
            System.out.println("6. Delete Crime Record");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }
            
                
                if (choice==1) {
                    
                
                    System.out.print("Victim Name: ");
                    String vName = sc.nextLine();
                    System.out.print("Victim Age: ");
                    int vAge = Integer.parseInt(sc.nextLine());
                    System.out.print("Victim Contact: ");
                    String vContact = sc.nextLine();
                    System.out.print("Victim Address: ");
                    String vAddress = sc.nextLine();
                    System.out.print("Victim ID: ");
                    String vId = sc.nextLine();

                    System.out.print("Criminal Name: ");
                    String cName = sc.nextLine();
                    System.out.print("Criminal Age: ");
                    int cAge = Integer.parseInt(sc.nextLine());
                    System.out.print("Criminal Contact: ");
                    String cContact = sc.nextLine();
                    System.out.print("Crime Type: ");
                    String cType = sc.nextLine();
                    System.out.print("Criminal ID: ");
                    String cId = sc.nextLine();

                    System.out.print("Crime Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Crime Location: ");
                    String location = sc.nextLine();

                    Victim victim = new Victim(vName, vAge, vContact, vAddress, vId);
                    Criminal criminal = new Criminal(cName, cAge, cContact, cType, cId);
                    
                    manager.addCrime(new Crime(desc, location, victim, criminal, registeredPolice));
                }

                else if (choice==2) {
                    
                
                    manager.showAllCrimes();
                    
                }
                    

               else if (choice==3) {
                    
                
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    manager.searchCrime(keyword);
                }

                else if (choice==4) {
                    
                
                    System.out.print("Enter Victim ID: ");
                    String searchVid = sc.nextLine();
                    manager.searchByVictimId(searchVid);
                }

                else if (choice==5) {
                    
                
                    System.out.print("Enter Criminal ID: ");
                    String searchCid = sc.nextLine();
                    manager.searchByCriminalId(searchCid);
                }

                else if (choice==6) {
                    
                
                    manager.showAllCrimes();
                    System.out.print("Enter record number to delete: ");
                    int delIndex = Integer.parseInt(sc.nextLine()) - 1;
                    manager.deleteCrime(delIndex);
                }

                else if (choice==7) {
                    
                
                    System.out.println("Exiting system. Goodbye.");
                    break;
                }

                else
                    System.out.println("Invalid choice!");
            
        }
    }
}


