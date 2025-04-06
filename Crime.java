import java.io.Serializable;

class Crime implements Serializable {
    private String description;
    private String location;
    private Victim victim;
    private Criminal criminal;
    private Police officer;

    public Crime(String description, String location, Victim victim, Criminal criminal, Police officer) {
        this.description = description;
        this.location = location;
        this.victim = victim;
        this.criminal = criminal;
        this.officer = officer;
    }

    public void displayCrimeDetails() {

        System.out.println("It comes in display fuckers");
        System.out.println("\n--- Crime Details ---");
        System.out.println("Description: " + description);
        System.out.println("Location: " + location);
        System.out.println("\n--- Victim Info ---");
        victim.displayInfo();
        System.out.println("\n--- Criminal Info ---");
        criminal.displayInfo();
        System.out.println("\n--- Investigating Officer ---");
        officer.displayInfo();
        System.out.println("-----------------------------");
    }

    public void matchesVictimId(String id) {
        if (victim.svictimid(id)==1) {
            displayCrimeDetails();

           
            
        }
        
    }

    public boolean matchesCriminalId(String id) {
        return criminal.getCriminalId().equalsIgnoreCase(id);
    }

    public boolean matchesKeyword(String keyword) {
        keyword = keyword.toLowerCase();
        return description.toLowerCase().contains(keyword)
                || location.toLowerCase().contains(keyword)
                || victim.getName().toLowerCase().contains(keyword)
                || criminal.getName().toLowerCase().contains(keyword);
    }
}
