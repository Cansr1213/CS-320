import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("ValidName", "ValidDescription");
        assertEquals("NULL", task.getTaskID());
        assertEquals("ValidName", task.getTaskName());
        assertEquals("ValidDescription", task.getTaskDesc());
    }

    @Test
    public void testInvalidTaskCreationNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "ValidDescription"));
    }

    @Test
    public void testInvalidTaskCreationEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("", "ValidDescription"));
    }

    @Test
    public void testInvalidTaskCreationLongName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("ThisNameIsTooLongAndShouldThrowAnException", "ValidDescription"));
    }

    @Test
    public void testInvalidTaskCreationNullDesc() {
        assertThrows(IllegalArgumentException.class, () -> new Task("ValidName", null));
    }

    @Test
    public void testInvalidTaskCreationEmptyDesc() {
        assertThrows(IllegalArgumentException.class, () -> new Task("ValidName", ""));
    }

    @Test
    public void testInvalidTaskCreationLongDesc() {
        assertThrows(IllegalArgumentException.class, () -> new Task("ValidName", "ThisDescriptionIsTooLongAndShouldThrowAnException"));
    }

    @Test
    public void testValidSetTaskName() {
        Task task = new Task("OldName", "ValidDescription");
        task.setTaskName("NewName");
        assertEquals("NewName", task.getTaskName());
    }

    @Test
    public void testInvalidSetTaskNameNull() {
        Task task = new Task("OldName", "ValidDescription");
        assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
    }

    @Test
    public void testInvalidSetTaskNameLong() {
        Task task = new Task("OldName", "ValidDescription");
        assertThrows(IllegalArgumentException.class, () -> task.setTaskName("ThisNameIsTooLongAndShouldThrowAnException"));
    }

    @Test
    public void testValidSetTaskDesc() {
        Task task = new Task("ValidName", "OldDescription");
        task.setTaskDesc("NewDescription");
        assertEquals("NewDescription", task.getTaskDesc());
    }

    @Test
    public void testInvalidSetTaskDescNull() {
        Task task = new Task("ValidName", "OldDescription");
        assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc(null));
    }

    @Test
    public void testInvalidSetTaskDescLong() {
        Task task = new Task("ValidName", "OldDescription");
        assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc("ThisDescriptionIsTooLongAndShouldThrowAnException"));
    }
}
