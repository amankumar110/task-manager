package in.amankumar110.todoapplication;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private TaskDao taskDao;
    private Context context;

    ExecutorService executor;

    Repository(Context context) {
        this.context = context;
        Database database = Database.getInstance(context);
        taskDao = database.getTaskDao();
        this.executor = Executors.newSingleThreadExecutor();

    }

    public void addTask(Task task){

       executor.execute(()-> taskDao.addTask(task));
    }

    public void deleteTask(Task task) {


        executor.execute(()-> taskDao.deleteTask(task));
    }


    public LiveData<List<Task>> getAllTasks() {

         return taskDao.getAllTasks();
    }

}
