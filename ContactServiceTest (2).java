import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Unit tests for ContactService class (with strict delete)
public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("001", "John", "Doe", "1234567890", "123 Main Street");
    }

    @Test
    public void testAddContact() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("001"); // first deletion should succeed

        // Second deletion should throw an exception because it no longer exists
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("001"));
    }

    @Test
    public void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("001", "Jane");
        assertEquals("Jane", contact.getFirstName());
    }


    @Test
    public void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("001", "Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        service.addContact(contact);
        service.updatePhone("001", "0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("001", "456 Elm Street");
        assertEquals("456 Elm Street", contact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Jane"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("999", "Smith"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("999", "0987654321"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("999", "456 Elm Street"));
    }
}