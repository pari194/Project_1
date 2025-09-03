import java.util.*;

public class BharatYatraConsoleApp {
    
    // Data model class
    static class SearchResult {
        private String city;
        private String title;
        private String kind;
        private String price;
        private String details;
        
        public SearchResult(String city, String title, String kind, String price, String details) {
            this.city = city;
            this.title = title;
            this.kind = kind;
            this.price = price;
            this.details = details;
        }
        
        public String getCity() { return city; }
        public String getTitle() { return title; }
        public String getKind() { return kind; }
        public String getPrice() { return price; }
        public String getDetails() { return details; }
    }
    
    // Create sample data with car rentals
    private static List<SearchResult> createSampleData() {
        List<SearchResult> data = new ArrayList<>();
        
        // Delhi entries
        data.add(new SearchResult("delhi", "Taj Palace", "hotel", "Rs. 5,200/night", "5-star luxury hotel with spa"));
        data.add(new SearchResult("delhi", "The Leela Palace", "hotel", "Rs. 6,800/night", "Palace-style luxury accommodation"));
        data.add(new SearchResult("delhi", "ITC Maurya", "hotel", "Rs. 5,500/night", "Business hotel with fine dining"));
        data.add(new SearchResult("delhi", "Delhi Metro Tourist Pass", "transport", "Rs. 300/day", "Unlimited travel on Delhi Metro"));
        data.add(new SearchResult("delhi", "Auto Rickshaw Rental", "transport", "Rs. 1,500/day", "Self-drive auto rickshaw"));
        data.add(new SearchResult("delhi", "Zoomcar Sedan", "car-rental", "Rs. 2,500/day", "Honda City or similar, unlimited km"));
        data.add(new SearchResult("delhi", "Myles SUV", "car-rental", "Rs. 3,800/day", "Hyundai Creta, 100 km free"));
        
        // Mumbai entries
        data.add(new SearchResult("mumbai", "Taj Mahal Palace", "hotel", "Rs. 8,500/night", "Iconic 5-star hotel overlooking Gateway of India"));
        data.add(new SearchResult("mumbai", "The Oberoi", "hotel", "Rs. 7,200/night", "Luxury hotel with marine drive view"));
        data.add(new SearchResult("mumbai", "Trident Nariman Point", "hotel", "Rs. 6,500/night", "Business hotel with sea view"));
        data.add(new SearchResult("mumbai", "Mumbai Local Train Pass", "transport", "Rs. 200/day", "First class unlimited travel"));
        data.add(new SearchResult("mumbai", "Cab Service", "transport", "Rs. 2,000/day", "8 hours with driver"));
        data.add(new SearchResult("mumbai", "Revv Hatchback", "car-rental", "Rs. 2,200/day", "Maruti Baleno, self-drive"));
        data.add(new SearchResult("mumbai", "Avis Luxury Car", "car-rental", "Rs. 6,500/day", "BMW 3 Series with driver"));
        
        // Bangalore entries
        data.add(new SearchResult("bangalore", "The Ritz-Carlton", "hotel", "Rs. 7,800/night", "5-star luxury in city center"));
        data.add(new SearchResult("bangalore", "Taj West End", "hotel", "Rs. 6,200/night", "Heritage property with garden"));
        data.add(new SearchResult("bangalore", "ITC Gardenia", "hotel", "Rs. 6,500/night", "Eco-friendly luxury hotel"));
        data.add(new SearchResult("bangalore", "BIKE Rental", "transport", "Rs. 800/day", "Royal Enfield 350cc"));
        data.add(new SearchResult("bangalore", "Car with Driver", "transport", "Rs. 2,500/day", "8 hours, 80 km included"));
        data.add(new SearchResult("bangalore", "Zoomcar Electric", "car-rental", "Rs. 3,000/day", "Tata Nexon EV, free charging"));
        data.add(new SearchResult("bangalore", "Myles Premium", "car-rental", "Rs. 4,500/day", "Toyota Innova, with driver optional"));
        
        // Jaipur entries
        data.add(new SearchResult("jaipur", "Rambagh Palace", "hotel", "Rs. 9,000/night", "Former royal residence, now Taj hotel"));
        data.add(new SearchResult("jaipur", "Jai Mahal Palace", "hotel", "Rs. 5,800/night", "Heritage property with gardens"));
        data.add(new SearchResult("jaipur", "Fairmont Jaipur", "hotel", "Rs. 6,500/night", "Luxury resort-style hotel"));
        data.add(new SearchResult("jaipur", "Heritage Car Tour", "transport", "Rs. 3,500/day", "Vintage car with guide"));
        data.add(new SearchResult("jaipur", "Camel Safari", "transport", "Rs. 1,200/half-day", "Desert experience with lunch"));
        data.add(new SearchResult("jaipur", "Self-Drive Car", "car-rental", "Rs. 2,800/day", "Swift Dzire, unlimited km"));
        data.add(new SearchResult("jaipur", "Luxury Car with Driver", "car-rental", "Rs. 5,000/day", "Mercedes E-Class, 100 km free"));
        
        // Goa entries
        data.add(new SearchResult("goa", "Park Hyatt Goa", "hotel", "Rs. 7,500/night", "Beach resort with pool villas"));
        data.add(new SearchResult("goa", "Taj Fort Aguada", "hotel", "Rs. 8,200/night", "Fort converted to luxury resort"));
        data.add(new SearchResult("goa", "Leela Palace Goa", "hotel", "Rs. 9,500/night", "5-star beachfront property"));
        data.add(new SearchResult("goa", "Scooter Rental", "transport", "Rs. 400/day", "Activa or similar, helmet included"));
        data.add(new SearchResult("goa", "Yacht Rental", "transport", "Rs. 15,000/day", "Private yacht for 10 people"));
        data.add(new SearchResult("goa", "Convertible Car", "car-rental", "Rs. 4,500/day", "Mini Cooper Convertible, perfect for beaches"));
        data.add(new SearchResult("goa", "SUV Rental", "car-rental", "Rs. 3,200/day", "Ford Endeavour, for family trips"));
        
        // Varanasi entries
        data.add(new SearchResult("varanasi", "Taj Ganges Varanasi", "hotel", "Rs. 5,500/night", "5-star with Ganges view"));
        data.add(new SearchResult("varanasi", "BrijRama Palace", "hotel", "Rs. 6,800/night", "Heritage palace on riverbank"));
        data.add(new SearchResult("varanasi", "Suryauday Haveli", "hotel", "Rs. 3,200/night", "Boutique heritage property"));
        data.add(new SearchResult("varanasi", "Boat Ride on Ganges", "transport", "Rs. 600/hour", "Traditional boat with guide"));
        data.add(new SearchResult("varanasi", "Cycle Rickshaw Tour", "transport", "Rs. 300/hour", "Heritage city tour"));
        data.add(new SearchResult("varanasi", "Economy Car Rental", "car-rental", "Rs. 2,000/day", "Alto or similar, self-drive"));
        data.add(new SearchResult("varanasi", "Premium Car with Driver", "car-rental", "Rs. 4,000/day", "Toyota Fortuner, for city tours"));
        
        return data;
    }
    
    // Helper method to draw a line
    private static void drawLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    
    // Helper method to display a boxed title
    private static void displayTitle(String title) {
        int length = title.length() + 4;
        drawLine(length);
        System.out.println("| " + title + " |");
        drawLine(length);
    }
    
    // Helper method to get city from input
    private static String getCityFromInput(String input) {
        input = input.toLowerCase().trim();
        
        if (input.equals("1") || input.equals("delhi")) return "delhi";
        if (input.equals("2") || input.equals("mumbai")) return "mumbai";
        if (input.equals("3") || input.equals("bangalore")) return "bangalore";
        if (input.equals("4") || input.equals("jaipur")) return "jaipur";
        if (input.equals("5") || input.equals("goa")) return "goa";
        if (input.equals("6") || input.equals("varanasi")) return "varanasi";
        if (input.equals("7") || input.equals("exit")) return "exit";
        
        return "";
    }
    
    // Helper method to get service type from input
    private static String getServiceFromInput(String input) {
        input = input.toLowerCase().trim();
        
        if (input.equals("1") || input.equals("hotel") || input.equals("hotels")) return "hotel";
        if (input.equals("2") || input.equals("transport")) return "transport";
        if (input.equals("3") || input.equals("car") || input.equals("car-rental")) return "car-rental";
        if (input.equals("4") || input.equals("all")) return "";
        
        return "";
    }
    
    // Method to display main menu
    private static void displayMainMenu() {
        System.out.println();
        displayTitle("BHARAT YATRA TRAVEL PLANNER");
        System.out.println();
        
        System.out.println("Choose a city to search:");
        System.out.println("1. Delhi");
        System.out.println("2. Mumbai");
        System.out.println("3. Bangalore");
        System.out.println("4. Jaipur");
        System.out.println("5. Goa");
        System.out.println("6. Varanasi");
        System.out.println("7. Exit");
        System.out.print("Enter your choice (1-7): ");
    }
    
    // Method to display service menu
    private static void displayServiceMenu() {
        System.out.println();
        System.out.println("Choose service type:");
        System.out.println("1. Hotels");
        System.out.println("2. Transport");
        System.out.println("3. Car Rental");
        System.out.println("4. All Services");
        System.out.print("Enter your choice (1-4): ");
    }
    
    // Method to display search results in a formatted way
    private static void displayResults(List<SearchResult> results, String city) {
        System.out.println();
        displayTitle("SEARCH RESULTS FOR " + city.toUpperCase());
        System.out.println();
        
        if (results.isEmpty()) {
            System.out.println("No results found for your search criteria.");
            return;
        }
        
        // Group by service type
        Map<String, List<SearchResult>> groupedResults = new LinkedHashMap<>();
        groupedResults.put("hotel", new ArrayList<>());
        groupedResults.put("transport", new ArrayList<>());
        groupedResults.put("car-rental", new ArrayList<>());
        
        for (SearchResult result : results) {
            groupedResults.get(result.getKind()).add(result);
        }
        
        // Display hotels
        if (!groupedResults.get("hotel").isEmpty()) {
            System.out.println("HOTELS:");
            drawLine(50);
            for (SearchResult hotel : groupedResults.get("hotel")) {
                System.out.println("• " + hotel.getTitle());
                System.out.println("  Price: " + hotel.getPrice());
                System.out.println("  Details: " + hotel.getDetails());
                System.out.println();
            }
        }
        
        // Display car rentals
        if (!groupedResults.get("car-rental").isEmpty()) {
            System.out.println("CAR RENTALS:");
            drawLine(50);
            for (SearchResult car : groupedResults.get("car-rental")) {
                System.out.println("• " + car.getTitle());
                System.out.println("  Price: " + car.getPrice());
                System.out.println("  Details: " + car.getDetails());
                System.out.println();
            }
        }
        
        // Display transport
        if (!groupedResults.get("transport").isEmpty()) {
            System.out.println("TRANSPORT:");
            drawLine(50);
            for (SearchResult transport : groupedResults.get("transport")) {
                System.out.println("• " + transport.getTitle());
                System.out.println("  Price: " + transport.getPrice());
                System.out.println("  Details: " + transport.getDetails());
                System.out.println();
            }
        }
        
        System.out.println("Total results found: " + results.size());
        drawLine(50);
    }
    
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<SearchResult> sampleData = createSampleData();
        
        System.out.println();
        displayTitle("WELCOME TO BHARAT YATRA");
        System.out.println("India's Premier Travel Planning Console App");
        System.out.println();
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            String input = scanner.nextLine();
            String city = getCityFromInput(input);
            
            if (city.equals("exit")) {
                System.out.println();
                displayTitle("THANK YOU FOR USING BHARAT YATRA!");
                System.out.println("Happy travels! Visit again soon.");
                running = false;
                continue;
            }
            
            if (city.isEmpty()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            
            displayServiceMenu();
            String serviceInput = scanner.nextLine();
            String kind = getServiceFromInput(serviceInput);
            
            // Filter results based on selection
            List<SearchResult> filteredResults = new ArrayList<>();
            for (SearchResult item : sampleData) {
                if (item.getCity().equals(city) && (kind.isEmpty() || item.getKind().equals(kind))) {
                    filteredResults.add(item);
                }
            }
            
            displayResults(filteredResults, city);
            
            System.out.print("Press Enter to continue or type 'exit' to quit: ");
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("exit")) {
                System.out.println();
                displayTitle("THANK YOU FOR USING BHARAT YATRA!");
                running = false;
            }
        }
        
        scanner.close();
    }
}
