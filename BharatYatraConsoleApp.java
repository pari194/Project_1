import java.util.*;

public class BharatYatraConsoleApp {
    
    // Data model class
    static class SearchResult {
        private String city;
        private String title;
        private String kind;
        private String price;
        
        public SearchResult(String city, String title, String kind, String price) {
            this.city = city;
            this.title = title;
            this.kind = kind;
            this.price = price;
        }
        
        public String getCity() { return city; }
        public String getTitle() { return title; }
        public String getKind() { return kind; }
        public String getPrice() { return price; }
        
        @Override
        public String toString() {
            return String.format("%s (%s) - %s - %s", title, city, kind, price);
        }
    }
    
    // Create sample data
    private static List<SearchResult> createSampleData() {
        List<SearchResult> data = new ArrayList<>();
        
        // Delhi entries
        data.add(new SearchResult("delhi", "Taj Palace", "hotel", "Rs. 5,200/night"));
        data.add(new SearchResult("delhi", "The Leela Palace", "hotel", "Rs. 6,800/night"));
        data.add(new SearchResult("delhi", "ITC Maurya", "hotel", "Rs. 5,500/night"));
        data.add(new SearchResult("delhi", "Delhi Metro Tourist Pass", "transport", "Rs. 300/day"));
        data.add(new SearchResult("delhi", "Auto Rickshaw Rental", "transport", "Rs. 1,500/day"));
        
        // Mumbai entries
        data.add(new SearchResult("mumbai", "Taj Mahal Palace", "hotel", "Rs. 8,500/night"));
        data.add(new SearchResult("mumbai", "The Oberoi", "hotel", "Rs. 7,200/night"));
        data.add(new SearchResult("mumbai", "Trident Nariman Point", "hotel", "Rs. 6,500/night"));
        data.add(new SearchResult("mumbai", "Mumbai Local Train Pass", "transport", "Rs. 200/day"));
        data.add(new SearchResult("mumbai", "Cab Service", "transport", "Rs. 2,000/day"));
        
        // Bangalore entries
        data.add(new SearchResult("bangalore", "The Ritz-Carlton", "hotel", "Rs. 7,800/night"));
        data.add(new SearchResult("bangalore", "Taj West End", "hotel", "Rs. 6,200/night"));
        data.add(new SearchResult("bangalore", "ITC Gardenia", "hotel", "Rs. 6,500/night"));
        data.add(new SearchResult("bangalore", "BIKE Rental", "transport", "Rs. 800/day"));
        data.add(new SearchResult("bangalore", "Car with Driver", "transport", "Rs. 2,500/day"));
        
        // Jaipur entries
        data.add(new SearchResult("jaipur", "Rambagh Palace", "hotel", "Rs. 9,000/night"));
        data.add(new SearchResult("jaipur", "Jai Mahal Palace", "hotel", "Rs. 5,800/night"));
        data.add(new SearchResult("jaipur", "Fairmont Jaipur", "hotel", "Rs. 6,500/night"));
        data.add(new SearchResult("jaipur", "Heritage Car Tour", "transport", "Rs. 3,500/day"));
        data.add(new SearchResult("jaipur", "Camel Safari", "transport", "Rs. 1,200/half-day"));
        
        // Goa entries
        data.add(new SearchResult("goa", "Park Hyatt Goa", "hotel", "Rs. 7,500/night"));
        data.add(new SearchResult("goa", "Taj Fort Aguada", "hotel", "Rs. 8,200/night"));
        data.add(new SearchResult("goa", "Leela Palace Goa", "hotel", "Rs. 9,500/night"));
        data.add(new SearchResult("goa", "Scooter Rental", "transport", "Rs. 400/day"));
        data.add(new SearchResult("goa", "Yacht Rental", "transport", "Rs. 15,000/day"));
        
        // Varanasi entries
        data.add(new SearchResult("varanasi", "Taj Ganges Varanasi", "hotel", "Rs. 5,500/night"));
        data.add(new SearchResult("varanasi", "BrijRama Palace", "hotel", "Rs. 6,800/night"));
        data.add(new SearchResult("varanasi", "Suryauday Haveli", "hotel", "Rs. 3,200/night"));
        data.add(new SearchResult("varanasi", "Boat Ride on Ganges", "transport", "Rs. 600/hour"));
        data.add(new SearchResult("varanasi", "Cycle Rickshaw Tour", "transport", "Rs. 300/hour"));
        
        return data;
    }
    
    // Helper method to get city from input
    private static String getCityFromInput(String input) {
        input = input.toLowerCase().trim();
        
        // Check for number inputs
        if (input.equals("1") || input.equals("delhi")) return "delhi";
        if (input.equals("2") || input.equals("mumbai")) return "mumbai";
        if (input.equals("3") || input.equals("bangalore")) return "bangalore";
        if (input.equals("4") || input.equals("jaipur")) return "jaipur";
        if (input.equals("5") || input.equals("goa")) return "goa";
        if (input.equals("6") || input.equals("varanasi")) return "varanasi";
        if (input.equals("7") || input.equals("exit")) return "exit";
        
        return ""; // Invalid input
    }
    
    // Helper method to get service type from input
    private static String getServiceFromInput(String input) {
        input = input.toLowerCase().trim();
        
        if (input.equals("1") || input.equals("hotel") || input.equals("hotels")) return "hotel";
        if (input.equals("2") || input.equals("transport")) return "transport";
        if (input.equals("3") || input.equals("both")) return "";
        
        return ""; // Default to both
    }
    
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<SearchResult> sampleData = createSampleData();
        
        System.out.println("Welcome to Bharat Yatra - Indian Travel Planner!");
        System.out.println("================================================");
        
        boolean running = true;
        while (running) {
            System.out.println("\nChoose a city to search:");
            System.out.println("1. Delhi (or type 'delhi')");
            System.out.println("2. Mumbai (or type 'mumbai')");
            System.out.println("3. Bangalore (or type 'bangalore')");
            System.out.println("4. Jaipur (or type 'jaipur')");
            System.out.println("5. Goa (or type 'goa')");
            System.out.println("6. Varanasi (or type 'varanasi')");
            System.out.println("7. Exit (or type 'exit')");
            System.out.print("Enter your choice: ");
            
            String input = scanner.nextLine();
            String city = getCityFromInput(input);
            
            if (city.equals("exit")) {
                System.out.println("Thank you for using Bharat Yatra!");
                running = false;
                continue;
            }
            
            if (city.isEmpty()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            
            System.out.println("\nChoose service type:");
            System.out.println("1. Hotels (or type 'hotel')");
            System.out.println("2. Transport (or type 'transport')");
            System.out.println("3. Both (or type 'both')");
            System.out.print("Enter your choice: ");
            
            String serviceInput = scanner.nextLine();
            String kind = getServiceFromInput(serviceInput);
            
            // Display results
            System.out.println("\nSearch Results for " + city.toUpperCase() + ":");
            System.out.println("=================================");
            
            int count = 0;
            for(SearchResult item : sampleData) {
                if(item.getCity().equals(city) && 
                   (kind.isEmpty() || item.getKind().equals(kind))) {
                    String symbol = item.getKind().equals("hotel") ? "HOTEL" : "CAR";
                    System.out.println(symbol + " " + item.getTitle() + " - " + item.getPrice());
                    count++;
                }
            }
            
            if(count == 0) {
                System.out.println("No results found for your search criteria.");
            } else {
                System.out.println("=================================");
                System.out.println("Found " + count + " result(s)");
            }
            
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }
        
        scanner.close();
    }
}