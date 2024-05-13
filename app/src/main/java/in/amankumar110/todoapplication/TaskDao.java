package in.amankumar110.todoapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    public void addTask(Task t);

    @Delete
    public void deleteTask(Task t);

    @Query("SELECT * FROM task_table")
    public LiveData<List<Task>> getAllTasks();

}
