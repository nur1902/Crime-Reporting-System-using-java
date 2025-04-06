import java.io.Serializable;

class Police implements Serializable {
    private String name;
    private String rank;
    private String username;
    private String password;

    public Police(String name, String rank, String username, String password) {
        this.name = name;
        this.rank = rank;
        this.username = username;
        this.password = password;
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void displayInfo() {
        System.out.println("Police Name: " + name);
        System.out.println("Rank: " + rank);
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }
}