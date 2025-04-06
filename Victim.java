import java.io.Serializable;

class Victim implements Serializable {
    private String address;
    private String victimId;
    protected String name;
    protected int age;
    protected String contact;

    public Victim(String name, int age, String contact, String address, String victimId) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
        this.victimId = victimId;
    }

    
    public void displayInfo() {
        System.out.println("Victim ID: " + victimId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact: " + contact);
        System.out.println("Address: " + address);
    }
    public int svictimid(String id){
        if (id.equals(victimId)) {
            return 1;  
        }
        else return 0;
        
        
    }

    public String getVictimId() {
        return victimId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}