import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class AppointmentTest {

    @Test
    void testValidAppointmentCreation() {
        // Appointment date in the future
        Date currentDate = new Date(System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 10);

        // Valid appointment creation
        Appointment appointment = new Appointment("12345", afterToday, "Description");

        // Assertions
        assertEquals(afterToday, appointment.getAppointmentDate());
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals("Description", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentCreationPastDate() {
        // Appointment date in the past
        Date currentDate = new Date(System.currentTimeMillis());
        Date beforeToday = new Date(currentDate.getTime() - 10);

        // Invalid appointment creation - appointment date in the past
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", beforeToday, "Description"));
    }

    @Test
    void testInvalidAppointmentCreationNullId() {
        // Invalid appointment creation - null appointment ID
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Description"));
    }

    @Test
    void testInvalidAppointmentCreationLongId() {
        // Invalid appointment creation - appointment ID length > 10
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(), "Description"));
    }

    @Test
    void testInvalidAppointmentCreationNullDescription() {
        // Invalid appointment creation - null description
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", new Date(), null));
    }

    @Test
    void testInvalidAppointmentCreationLongDescription() {
        // Invalid appointment creation - description length > 50
        String longDescription = "This is a very long description to test the validation of the description length.";
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", new Date(), longDescription));
    }
}
