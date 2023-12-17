import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentServiceTest {

    @Test
    void testAddAndDeleteAppointment() {
        // Create an appointment service
        AppointmentService appointmentService = new AppointmentService();

        // Appointment date in the future
        Date currentDate = new Date(System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 10);

        // Create a valid appointment
        Appointment appointment = new Appointment("12345", afterToday, "Description");

        // Add the appointment to the service
        appointmentService.addAppointment(appointment);

        // Check if the appointment was added successfully
        assertEquals(1, appointmentService.getAllAppointments().size());

        // Delete the added appointment
        appointmentService.deleteAppointment("12345");

        // Check if the appointment was deleted successfully
        assertEquals(0, appointmentService.getAllAppointments().size());
    }

    @Test
    void testAddDuplicateAppointment() {
        // Create an appointment service
        AppointmentService appointmentService = new AppointmentService();

        // Appointment date in the future
        Date currentDate = new Date(System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 10);

        // Create a valid appointment
        Appointment appointment = new Appointment("12345", afterToday, "Description");

        // Add the appointment to the service
        appointmentService.addAppointment(appointment);

        // Try to add an appointment with the same ID (should throw an exception)
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment));
    }

    @Test
    void testDeleteNonexistentAppointment() {
        // Create an appointment service
        AppointmentService appointmentService = new AppointmentService();

        // Try to delete a nonexistent appointment (should throw an exception)
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("nonexistentId"));
    }

    @Test
    void testGetAllAppointments() {
        // Create an appointment service
        AppointmentService appointmentService = new AppointmentService();

        // Appointment date in the future
        Date currentDate = new Date(System.currentTimeMillis());
        Date afterToday = new Date(currentDate.getTime() + 10);

        // Add two appointments
        appointmentService.addAppointment(new Appointment("12345", afterToday, "Description1"));
        appointmentService.addAppointment(new Appointment("67890", afterToday, "Description2"));

        // Check if getAllAppointments returns the correct number of appointments
        assertEquals(2, appointmentService.getAllAppointments().size());
    }
}
