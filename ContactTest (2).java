import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreationValid() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "JohnathonSmith", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "12345", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "abcdefghij", "123 Elm St"));
    }
}
