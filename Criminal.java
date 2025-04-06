import java.io.Serializable;

class Criminal implements Serializable {
    private String crimeType;
    private String criminalId;
    protected String name;
    protected int age;
    protected String contact;

    Criminal(String name, int age, String contact, String crimeType, String criminalId) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.crimeType = crimeType;
        this.criminalId = criminalId;
    }

    
    public void displayInfo() {
        System.out.println("Criminal ID: " + criminalId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact: " + contact);
        System.out.println("Crime Type: " + crimeType);
    }

    public String getCriminalId() {
        return criminalId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
