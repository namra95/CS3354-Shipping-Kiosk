import java.util.Map;
import java.util.Set;

public class ShippingLabel {
    private String name;
    private String address;
    private String aptSuite;
    private String city;
    private String state;

    //In order for the name to be valid, it cannot be empty
    public static boolean isNameValid(String name) {
        return name != null && !name.trim().isEmpty();
    }

    //In order for the address to be valid, it cannot be empty and can only contain numbers and letters
    public static boolean isAddressValid(String address) {
        return address != null && address.matches("^[0-9]+\\s+[a-zA-Z\\s]+$");
    }

    // Apt/Suite is valid if it's null, empty after trimming, or contains only numbers and letters
    public static boolean isAptSuiteValid(String aptSuite) {
        return aptSuite == null || aptSuite.trim().isEmpty() || aptSuite.trim().matches("[a-zA-Z0-9\\s]+");
    }


    //In order for the city to be valid, it cannot be empty and can only contain letters
    public static boolean isCityValid(String city) {
        return city != null && city.matches("^[a-zA-Z\\s]+$");
    }

    //In order for the state to be valid, it cannot be empty and can only be one of the documented state codes
    public static boolean isStateCodeValid(String state) {
        Set<String> stateCodes = Set.of("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY");
        return stateCodes.contains(state);
    }

    // Validates a standard 5-digit or 9-digit zip code format ex. "12345" or "12345-6789"
    public static boolean isZipCodeValid(String zipCode) {
        return zipCode != null && zipCode.matches("\\d{5}(-\\d{4})?");
    }

    // Combined validation for the entire address
    public static boolean isCompleteAddressValid(String name, String address, String aptSuite, String city, String state, String zipCode) {
        return isNameValid(name) &&
                isAddressValid(address) &&
                isAptSuiteValid(aptSuite) &&
                isCityValid(city) &&
                isStateCodeValid(state) &&
                isZipCodeValid(zipCode);
    }
}
