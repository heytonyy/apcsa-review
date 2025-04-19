public class RainfallRunner {
    public static void main(String[] args) {
        int[] rainfall = {0, 5, 2, 0, 0, 0, 8, 3, 0, 2};
        
        RainfallAnalyzer analyzer = new RainfallAnalyzer(rainfall);
        
        System.out.println("Average rainfall: " + analyzer.getAverageRainfall() + " mm");
        System.out.println("Number of dry days: " + analyzer.countDryDays());
        System.out.println("Maximum rainfall: " + analyzer.getMaxRainfall() + " mm");
        
        int[] wetDays = analyzer.getWetDaysOnly();
        System.out.print("Wet day measurements: ");
        for (int amount : wetDays) {
            System.out.print(amount + " ");
        }
        System.out.println();
        
        System.out.println("Has 3+ consecutive dry days: " + analyzer.hasThreeConsecutiveDryDays());
    }
}