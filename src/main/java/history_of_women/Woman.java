package history_of_women;

public class Woman {
    private int id;
    private String name;
    private int birthYear;
    private String country;
    private String contribution;

    public Woman(String name, int birthYear, String country, String contribution) {
        this.name = name;
        this.birthYear = birthYear;
        this.country = country;
        this.contribution = contribution;
    }

    public Woman(int id, String name, int birthYear, String country, String contribution) {
        this(name, birthYear, country, contribution);
        this.id = id;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getBirthYear() { return birthYear; }
    public String getCountry() { return country; }
    public String getContribution() { return contribution; }
}
