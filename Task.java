
public class Task {
    private final String taskID;
    private String taskName;
    private String taskDesc;

    public Task(String taskName, String taskDesc) {
        if (taskName == null || taskName.isEmpty() || taskDesc == null || taskDesc.isEmpty()) {
            throw new IllegalArgumentException("Invalid taskName or taskDesc");
        }
        this.taskID = null;  // Setting taskID to null, not generating an ID
        setTaskName(taskName);
        setTaskDesc(taskDesc);
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid taskName");
        }
        this.taskName = taskName;
    }

    public void setTaskDesc(String taskDesc) {
        if (taskDesc == null || taskDesc.length() > 50) {
            throw new IllegalArgumentException("Invalid taskDesc");
        }
        this.taskDesc = taskDesc;
    }
}
