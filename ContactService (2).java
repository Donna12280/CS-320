import java.util.HashMap;
import java.util.Map;


public class ContactService {

    // In-memory data structure to store contacts using contactId as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact to the service
    // Throws an exception if a contact with the same ID already exists
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Deletes a contact by contact ID
    // Throws an exception if the contact ID is not found
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    // Updates the first name for a contact by ID
    // Throws an exception if the contact ID is not found
    public void updateFirstName(String contactId, String firstName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.get(contactId).setFirstName(firstName);
    }

    // Updates the last name for a contact by ID
    // Throws an exception if the contact ID is not found
    public void updateLastName(String contactId, String lastName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.get(contactId).setLastName(lastName);
    }

    // Updates the phone number for a contact by ID
    // Throws an exception if the contact ID is not found
    public void updatePhone(String contactId, String phone) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.get(contactId).setPhone(phone);
    }

    // Updates the address for a contact by ID
    // Throws an exception if the contact ID is not found
    public void updateAddress(String contactId, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.get(contactId).setAddress(address);
    }

    // Retrieves a contact by contact ID
    // Returns null if the contact is not found
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}