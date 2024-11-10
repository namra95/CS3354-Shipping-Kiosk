import static org.junit.Assert.*;
import org.junit.Test;  // You need to import the @Test annotation

public class ShippingLabelTest {
    @Test
    public void isNameValidTest() {
        // Valid cases
        assertEquals(true, ShippingLabel.isNameValid("Nivedha Sreenivasan"));
        assertEquals(true, ShippingLabel.isNameValid("John Doe"));

        // Invalid cases
        assertEquals(false, ShippingLabel.isNameValid("   "));
        assertEquals(false, ShippingLabel.isNameValid(""));
        assertEquals(false, ShippingLabel.isNameValid(null));
    }

    @Test
    public void isAddressValidTest() {
        // Valid cases
        assertEquals(true, ShippingLabel.isAddressValid("123 Main St"));
        assertEquals(true, ShippingLabel.isAddressValid("456 Elm Avenue"));

        // Invalid cases
        assertEquals(false, ShippingLabel.isAddressValid("Main St"));
        assertEquals(false, ShippingLabel.isAddressValid("123"));
        assertEquals(false, ShippingLabel.isAddressValid(""));
    }

    @Test
    public void isAptSuiteValidTest() {
        // Valid cases
        assertEquals(true, ShippingLabel.isAptSuiteValid(""));
        assertEquals(true, ShippingLabel.isAptSuiteValid("101"));
        assertEquals(true, ShippingLabel.isAptSuiteValid("Apt 4B"));
        assertEquals(true, ShippingLabel.isAptSuiteValid("Suite 101"));

        // Invalid cases
        assertEquals(false, ShippingLabel.isAptSuiteValid("Apt#5"));
        assertEquals(false, ShippingLabel.isAptSuiteValid("4B!"));
    }

    @Test
    public void isCityValidTest() {
        // Valid cases
        assertEquals(true, ShippingLabel.isCityValid("Dallas"));
        assertEquals(true, ShippingLabel.isCityValid("San Francisco"));
        assertEquals(true, ShippingLabel.isCityValid("New York"));
        assertEquals(true, ShippingLabel.isCityValid("Los Angeles"));

        // Invalid cases
        assertEquals(false, ShippingLabel.isCityValid("Dallas123"));
        assertEquals(false, ShippingLabel.isCityValid("New-York"));
        assertEquals(false, ShippingLabel.isCityValid("San@Francisco"));
        assertEquals(false, ShippingLabel.isCityValid(""));
        assertEquals(false, ShippingLabel.isCityValid("12345"));
    }

    @Test
    public void isStateCodeValidTest() {
        // Valid cases (assuming valid U.S. state codes)
        assertEquals(true, ShippingLabel.isStateCodeValid("TX"));
        assertEquals(true, ShippingLabel.isStateCodeValid("CA"));
        assertEquals(true, ShippingLabel.isStateCodeValid("NY"));
        assertEquals(true, ShippingLabel.isStateCodeValid("FL"));

        // Invalid cases
        assertEquals(false, ShippingLabel.isStateCodeValid("XX"));
        assertEquals(false, ShippingLabel.isStateCodeValid("abc"));
        assertEquals(false, ShippingLabel.isStateCodeValid("123"));
        assertEquals(false, ShippingLabel.isStateCodeValid(""));
    }

    @Test
    public void isZipCodeValidTest() {
        // Valid cases (5-digit and 9-digit formats)
        assertEquals(true, ShippingLabel.isZipCodeValid("12345"));
        assertEquals(true, ShippingLabel.isZipCodeValid("12345-6789"));

        // Invalid cases
        assertEquals(false, ShippingLabel.isZipCodeValid("1234"));
        assertEquals(false, ShippingLabel.isZipCodeValid("123456"));
        assertEquals(false, ShippingLabel.isZipCodeValid("12345-678"));
        assertEquals(false, ShippingLabel.isZipCodeValid(""));
        assertEquals(false, ShippingLabel.isZipCodeValid("ABCDE"));
    }

    @Test
    public void isCompleteAddressValidTest() {
        // Valid complete address
        assertEquals(true, ShippingLabel.isCompleteAddressValid(
                        "John Doe", "123 Main St", "Apt 4B", "Dallas", "TX", "12345"));
        // Invalid cases
        assertEquals(false, ShippingLabel.isCompleteAddressValid(
                        "  ", "123 Main St", "Apt 4B", "Dallas", "TX", "12345"));
        assertEquals(false, ShippingLabel.isCompleteAddressValid(
                        "John Doe", "Main St", "Apt 4B", "Dallas", "TX", "12345"));
        assertEquals(false, ShippingLabel.isCompleteAddressValid(
                        "John Doe", "123 Main St", "Apt 4B", "Dallas123", "TX", "12345"));
        assertEquals(false, ShippingLabel.isCompleteAddressValid(
                        "John Doe", "123 Main St", "Apt 4B", "Dallas", "XX", "12345"));
        assertEquals(false, ShippingLabel.isCompleteAddressValid(
                        "John Doe", "123 Main St", "Apt 4B", "Dallas", "TX", "1234"));
    }
}


