// School subclass
public class School extends EducationalEntity {
    private boolean isPublic;
    private int numberOfTeachers;
    private int gradeLevel; // 0 for elementary, 1 for middle, 2 for high
    
    // Constructor
    public School(String name, String location, int studentCount, 
                 boolean isPublic, int numberOfTeachers, int gradeLevel) {
        super(name, location, studentCount);
        this.isPublic = isPublic;
        this.numberOfTeachers = numberOfTeachers;
        this.gradeLevel = gradeLevel;
    }
    
    // Getters
    public boolean isPublic() {
        return isPublic;
    }
    
    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }
    
    public String getGradeLevelName() {
        if (gradeLevel == 0) {
            return "Elementary School";
        } else if (gradeLevel == 1) {
            return "Middle School";
        } else if (gradeLevel == 2) {
            return "High School";
        } else {
            return "Unknown";
        }
    }
    
    // Override funding calculation
    public double calculateAnnualFunding() {
        double baseFunding = super.calculateAnnualFunding();
        
        // Public schools get 30% more funding
        if (isPublic) {
            baseFunding *= 1.3;
        }
        
        // Additional funding based on grade level
        if (gradeLevel == 0) {
            return baseFunding * 1.1; // Elementary: +10%
        } else if (gradeLevel == 1) {
            return baseFunding * 1.2; // Middle: +20%
        } else if (gradeLevel == 2) {
            return baseFunding * 1.3; // High: +30%
        } else {
            return baseFunding;
        }
    }
    
    // School-specific method
    public double calculateTeacherWorkload() {
        return (double) getStudentCount() / numberOfTeachers;
    }
    
    // Override display to include school-specific info
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + (isPublic ? "Public" : "Private") + " " + getGradeLevelName());
        System.out.println("Number of Teachers: " + numberOfTeachers);
        System.out.println("Student-Teacher Ratio: " + calculateTeacherWorkload());
    }
}