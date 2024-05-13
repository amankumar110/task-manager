package in.amankumar110.todoapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import in.amankumar110.todoapplication.helpers.Validator;

public class TaskViewModel extends AndroidViewModel {

    private Repository repository;

    public TaskViewModel(@NonNull Application application) {

        super(application);
        repository = new Repository(application.getApplicationContext());
    }

    public void addTask(Task task) {

        if (!Validator.isTaskNameEmpty(task.getTaskName())) {
            throw new RuntimeException("Enter Task Name Please!");
        } else if(!Validator.isTaskDescriptionEmpty(task.getTaskDescription())) {
            throw new RuntimeException("Enter task Description Please!");
        } else {
            repository.addTask(task);
        }
    }


    public void deleteTask(Task task) { repository.deleteTask(task); }

    public LiveData<List<Task>> getAllTasks() { return repository.getAllTasks();};

}
