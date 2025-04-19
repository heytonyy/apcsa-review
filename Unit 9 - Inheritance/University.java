// University subclass
public class University extends EducationalEntity {
    private boolean isResearch;
    private int numberOfFaculty;
    private int numberOfPrograms;
    private double endowmentMillions;
    
    // Constructor
    public University(String name, String location, int studentCount, 
                     boolean isResearch, int numberOfFaculty, 
                     int numberOfPrograms, double endowmentMillions) {
        super(name, location, studentCount);
        this.isResearch = isResearch;
        this.numberOfFaculty = numberOfFaculty;
        this.numberOfPrograms = numberOfPrograms;
        this.endowmentMillions = endowmentMillions;
    }
    
    // Getters
    public boolean isResearch() {
        return isResearch;
    }
    
    public int getNumberOfFaculty() {
        return numberOfFaculty;
    }
    
    public int getNumberOfPrograms() {
        return numberOfPrograms;
    }
    
    public double getEndowment() {
        return endowmentMillions;
    }
    
    // Override funding calculation
    public double calculateAnnualFunding() {
        double baseFunding = super.calculateAnnualFunding() * 1.5; // Universities get 50% more base funding
        
        // Research universities get additional funding
        if (isResearch) {
            baseFunding *= 1.5;
        }
        
        // Additional funding from endowment (5% of endowment)
        baseFunding += (endowmentMillions * 1000000 * 0.05);
        
        return baseFunding;
    }
    
    // University-specific method
    public double calculateFacultyRatio() {
        return (double) getStudentCount() / numberOfFaculty;
    }
    
    // Override display to include university-specific info
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + (isResearch ? "Research" : "Teaching") + " University");
        System.out.println("Number of Faculty: " + numberOfFaculty);
        System.out.println("Number of Programs: " + numberOfPrograms);
        System.out.println("Endowment: $" + endowmentMillions + " million");
        System.out.println("Student-Faculty Ratio: " + calculateFacultyRatio());
    }
}