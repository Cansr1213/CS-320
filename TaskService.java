import java.util.ArrayList;

public class TaskService {
    private final ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(String taskName, String taskDesc) {
        if (taskName == null || taskName.isEmpty() || taskDesc == null || taskDesc.isEmpty()) {
            throw new IllegalArgumentException("Invalid taskName or taskDesc");
        }
        Task task = new Task(taskName, taskDesc);
        taskList.add(task);
    }

    public Task getTask(String taskID) {
        for (Task task : taskList) {
            if (task.getTaskID().equals(taskID)) {
                return task;
            }
        }
        return null; // Task not found
    }

    public void deleteTask(String taskID) {
        for (int counter = 0; counter < taskList.size(); counter++) {
            if (taskList.get(counter).getTaskID().equals(taskID)) {
                taskList.remove(counter);
                return; // Task found and deleted
            }
        }
        throw new IllegalArgumentException("Task ID: " + taskID + " not found.");
    }

    public void updateTaskName(String updatedString, String taskID) {
        for (Task task : taskList) {
            if (task.getTaskID().equals(taskID)) {
                task.setTaskName(updatedString);
                return; // Task found and name updated
            }
        }
        throw new IllegalArgumentException("Task ID: " + taskID + " not found.");
    }

    public void updateTaskDesc(String updatedString, String taskID) {
        for (Task task : taskList) {
            if (task.getTaskID().equals(taskID)) {
                task.setTaskDesc(updatedString);
                return; // Task found and description updated
            }
        }
        throw new IllegalArgumentException("Task ID: " + taskID + " not found.");
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}
