import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

class RecordManager {
    private List<Crime> crimeList;
    protected String FileName="Data_ser.ser";
    public void saveData(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FileName));
            oos.writeObject(crimeList);
            System.out.println("Data Saved successfully!");
        }  catch (IOException e) {
            System.out.println("Something went wrong!"+e.getMessage());
        }
    }

    public RecordManager() {
        crimeList = new ArrayList<>();
    }

    public void addCrime(Crime crime) {
        crimeList.add(crime);
        saveData();

        
    }

    public void showAllCrimes() {
        System.out.println("hehhe");
        int i=0;
        
            for(Crime crm: crimeList){
                System.out.println("Crime Number: "+(i+1));
                crm.displayCrimeDetails();
                i++;

            }
        
    }

    public void searchCrime(String keyword) {
        boolean found = false;
        for (Crime c : crimeList) {
            if (c.matchesKeyword(keyword)) {
                c.displayCrimeDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching record found.");
        }
    }

    public void searchByVictimId(String id) {
       // boolean found = false;
        for (Crime c : crimeList) {
           // System.out.println("geya");
            
            c.matchesVictimId(id);
        }
       // if (!found) {
         //   System.out.println("No victim found with ID: " + id);
        //}
    }

    public void searchByCriminalId(String id) {
        boolean found = false;
        for (Crime c : crimeList) {
            if (c.matchesCriminalId(id)) {
                c.displayCrimeDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No criminal found with ID: " + id);
        }
    }

    public void deleteCrime(int index) {
        if (index >= 0 && index < crimeList.size()) {
            crimeList.remove(index);
            System.out.println("Crime record deleted successfully!");
        } else {
            System.out.println("Invalid index. Deletion failed.");
        }
    }
    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FileName))) {
            crimeList = (List<Crime>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }
}

// Main Class
