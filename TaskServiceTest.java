import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    @Test
    @DisplayName("Test to Update Task Name Successfully")
    @Order(1)
    void testUpdateTaskNameSuccess() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        service.updateTaskName("Updated Task Name", "0");
        assertEquals("Updated Task Name", service.getTask("0").getTaskName(), "Task name was not updated successfully.");
    }

    @Test
    @DisplayName("Test to Update Task Description Successfully")
    @Order(2)
    void testUpdateTaskDescSuccess() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        service.updateTaskDesc("Updated Description", "0");
        assertEquals("Updated Description", service.getTask("0").getTaskDesc(), "Task description was not updated successfully.");
    }

    @Test
    @DisplayName("Test to Ensure Service Correctly Deletes Task")
    @Order(3)
    void testDeleteTaskSuccess() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        String taskID = service.getTaskList().get(0).getTaskID();
        service.deleteTask(taskID);
        ArrayList<Task> taskListEmpty = new ArrayList<>();
        assertEquals(taskListEmpty, service.getTaskList(), "The task was not deleted successfully.");
    }

    @Test
    @DisplayName("Test to Ensure Service Can Add a Task")
    @Order(4)
    void testAddTaskSuccess() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        assertNotNull(service.getTask("0"), "Task was not added successfully.");
    }

    @Test
    @DisplayName("Test to Update Task Name With Invalid TaskID")
    @Order(5)
    void testUpdateTaskNameInvalidID() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("Updated Task Name", "1"); // Invalid TaskID
        });
    }
}
