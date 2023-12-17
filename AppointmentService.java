import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private final List<Appointment> listOfAppointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        // Check if appointmentId is unique
        for (Appointment existingAppointment : listOfAppointments) {
            if (existingAppointment.getAppointmentId().equals(appointment.getAppointmentId())) {
                throw new IllegalArgumentException("Appointment ID must be unique");
            }
        }

        // Add the appointment
        listOfAppointments.add(appointment);
    }

    public void deleteAppointment(String appointmentId) {
        // Find and remove the appointment by ID
        for (Appointment appointment : listOfAppointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                listOfAppointments.remove(appointment);
                return; // Exit the loop once found and removed
            }
        }

        // If the loop completes without finding the appointment, throw an exception
        throw new IllegalArgumentException("Appointment not found for ID: " + appointmentId);
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(listOfAppointments);
    }
}
