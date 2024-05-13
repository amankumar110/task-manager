package in.amankumar110.todoapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity(tableName = "task_table")
public class Task {

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String taskName;

    @ColumnInfo
    private String taskDescription;

    @ColumnInfo
    private String taskPostedTime;

    public Task( String taskName, String taskDescription, String taskPostedTime) {

        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPostedTime = taskPostedTime;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskPostedTime() {
        return taskPostedTime;
    }

    public void setTaskPostedTime(String taskPostedTime) {
        this.taskPostedTime = taskPostedTime;
    }
}
