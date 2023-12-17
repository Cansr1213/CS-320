import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("1", "Johnny", "Appleseed", "123456789", "123 Avenue");
        Contact contact2 = new Contact("2", "Jaime", "Pineapple", "987654321", "456 Street");

        assertTrue(contactService.addContact(contact1));
        assertTrue(contactService.addContact(contact2));
        assertFalse(contactService.addContact(contact1)); // Adding the same contact again should fail
    }

    @Test
    void testRemoveContactById() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "Johnny", "Appleseed", "123456789", "123 Avenue");

        contactService.addContact(contact);
        assertTrue(contactService.removeContactById("1"));
        assertFalse(contactService.removeContactById("1")); // Removing the same contact again should fail
    }

    @Test
    void testUpdateContactFirstName() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "Johnny", "Appleseed", "123456789", "123 Avenue");

        contactService.addContact(contact);
        assertTrue(contactService.updateContactFirstName("1", "Jane"));
        assertFalse(contactService.updateContactFirstName("2", "Jane")); // Updating non-existing contact should fail
    }

    @Test
    void testUpdateContactLastName() {
        // Similar to testUpdateContactFirstName, create test cases for updating last names
    }

    @Test
    void testUpdateContactPhone() {
        // Similar to testUpdateContactFirstName, create test cases for updating phone numbers
    }

    @Test
    void testUpdateContactAddress() {
        // Similar to testUpdateContactFirstName, create test cases for updating addresses
    }
}
