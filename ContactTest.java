import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Contact contact = new Contact("1", "Johnny", "Appleseed", "123456789", "123 Lyon Ln. 123456789");

    @Test
    void testGetId() {
        assertEquals("1", contact.getId());
    }

    @Test
    void testGetFirstName() {
        assertEquals("Johnny", contact.getFirstName());
    }

    @Test
    void testGetNumber() {
        assertEquals("123456789", contact.getNumber());
    }

    @Test
    void testGetAddress() {
        assertEquals("123 Lyon Ln. 123456789", contact.getAddress());
    }

    @Test
    void testToString() {
        assertEquals("Contact [id = 1, firstName = Johnny, lastName = Appleseed, Number = 123456789, address = 123 Lyon Ln. 123456789]", contact.toString());
    }

    @Test
    void testCreateContactWithInvalidId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Jaime", "Pineapple", "12345678789", "123 85th"));
    }

    @Test
    void testCreateContactWithValidData() {
        Contact contact = new Contact("2", "Jaime", "Pineapple", "123456789", "123 Bailey Ave");
        assertNotNull(contact);
        assertEquals("2", contact.getId());
        assertEquals("Jaime", contact.getFirstName());
        assertEquals("Pineapple", contact.getLastName());
        assertEquals("123456789", contact.getNumber());
        assertEquals("123 Bailey Ave", contact.getAddress());
    }

    @Test
    void testCreateContactWithInvalidData() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Contact("3", "Invalid", "Data", "InvalidNumber", "InvalidAddress"));
    }

    @Test
    void testCreateContactWithInvalidFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Jaimmmmmeeeee", "Pineapple", "123456789", "123 Bailey Ave"));
    }

    @Test
    void testCreateContactWithInvalidLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Jaime", "Apple", "123456789", "123 Bailey Ave"));
    }

    @Test
    void testCreateContactWithInvalidNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Jaime", "Pineapple", "23131343245432", "123 Baily Ave"));
    }

    @Test
    void testCreateContactWithInvalidAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Jaime", "Pineapple", "123456789", "321 JasonSt"));
    }

    @Test
    void testCreateContactWithTooLongNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Jaime", "Pineapple", "12345678901", "123 Bailey Ave"));
    }

    @Test
    void testCreateContactWithShortNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Jaime", "Pineapple", "12", "123 Bailey Ave"));
    }
}


