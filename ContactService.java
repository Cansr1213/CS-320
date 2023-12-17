import java.util.ArrayList;

public class ContactService {
    private final ArrayList<Contact> contactList = new ArrayList<>();

    public boolean addContact(Contact contact) {
        if (contactList.isEmpty() || !hasContactWithId(contact.getId())) {
            contactList.add(contact);
            return true;
        }

        return false;
    }

    private boolean hasContactWithId(String id) {
        for (Contact existingContact : contactList) {
            if (existingContact.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeContactById(String id) {
        Contact contactToRemove = findContactById(id);
        return contactToRemove != null && contactList.remove(contactToRemove);
    }

    private Contact findContactById(String id) {
        for (Contact contact : contactList) {
            if (contact.getId().equalsIgnoreCase(id)) {
                return contact;
            }
        }
        return null;
    }

    public boolean updateContactFirstName(String contactId, String firstName) {
        Contact contactToUpdate = findContactById(contactId);
        if (contactToUpdate != null) {
            contactToUpdate.setFirstName(firstName);
            return true;
        }
        return false;
    }
}
