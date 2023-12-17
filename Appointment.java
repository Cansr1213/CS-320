import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    Appointment(String aid, Date d, String descript) {
        Date today = new Date();

        if (aid == null || aid.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment date-null or length > 10");
        }
        if (d == null) {
            throw new IllegalArgumentException("Invalid appointment date-null");
        } else if (d.before(today)) {
            throw new IllegalArgumentException("Invalid appointment date-past date");
        }
        if (descript == null || descript.length() > 50) {
            throw new IllegalArgumentException("Invalid description - null or length > 50");
        }
        this.appointmentId = aid;
        this.appointmentDate = d;
        this.description = descript;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

}
