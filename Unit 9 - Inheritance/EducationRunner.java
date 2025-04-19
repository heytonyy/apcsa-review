// Test class demonstrating polymorphism
public class EducationRunner {
    public static void main(String[] args) {
        // Create objects of different types
        EducationalEntity genericEntity = new EducationalEntity("Learning Center", "Chicago", 500);
        School highSchool = new School("Lincoln High", "Portland", 1200, true, 80, 2);
        University stateUniv = new University("State University", "Boston", 15000, true, 900, 120, 500.0);
        
        // Store in an array of superclass type
        EducationalEntity[] entities = new EducationalEntity[3];
        entities[0] = genericEntity;
        entities[1] = highSchool;
        entities[2] = stateUniv;
        
        // Display information polymorphically
        System.out.println("EDUCATIONAL ENTITIES INFORMATION:");
        System.out.println("================================");
        
        for (EducationalEntity entity : entities) {
            entity.displayInfo();
            System.out.println("--------------------------------");
        }
        
        // Calculate total funding across all entities
        double totalFunding = 0;
        for (EducationalEntity entity : entities) {
            totalFunding += entity.calculateAnnualFunding();
        }
        
        System.out.println("Total funding across all entities: $" + totalFunding);
        
        // Demonstrate downcasting
        System.out.println("\nSPECIFIC ENTITY OPERATIONS:");
        System.out.println("================================");
        
        if (entities[1] instanceof School) {
            School school = (School) entities[1];
            System.out.println(school.getName() + " teacher workload: " + 
                               school.calculateTeacherWorkload() + " students per teacher");
        }
        
        if (entities[2] instanceof University) {
            University univ = (University) entities[2];
            System.out.println(univ.getName() + " faculty ratio: " + 
                               univ.calculateFacultyRatio() + " students per faculty");
        }
    }
}