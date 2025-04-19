// Base class
public class EducationalEntity {
    private String name;
    private String location;
    private int studentCount;
    
    // Constructor
    public EducationalEntity(String name, String location, int studentCount) {
        this.name = name;
        this.location = location;
        this.studentCount = studentCount;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public int getStudentCount() {
        return studentCount;
    }
    
    // Method for funding calculation (can be overridden)
    public double calculateAnnualFunding() {
        // Base calculation: $1000 per student
        return studentCount * 1000.0;
    }
    
    // Common method for displaying information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Student Count: " + studentCount);
        System.out.println("Annual Funding: $" + calculateAnnualFunding());
    }
}