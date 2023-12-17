public class Contact {
    private final String id;
    private String firstName;
    private final String lastName;
    private final String number;
    private final String address;

    public Contact(String id, String firstName, String lastName, String number, String address) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid firstName");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid lastName");
        }
        if (number == null || number.length() > 10) {
            throw new IllegalArgumentException("Invalid phoneNumber");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNumber() {
        return this.number;
    }

    public String getAddress() {
        return this.address;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Contact [" + "id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", Number = " + number + ", address = " + address + ']';
    }
}
