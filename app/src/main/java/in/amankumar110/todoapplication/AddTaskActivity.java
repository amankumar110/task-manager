package in.amankumar110.todoapplication;

import static androidx.core.view.ViewCompat.setBackgroundTintList;

import android.os.Bundle;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import in.amankumar110.todoapplication.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

        Task task = new Task();

        TaskViewModel viewModel = new TaskViewModel(getApplication());

        ActivityAddTaskBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_add_task);

        AddTaskEventListeners listeners = new AddTaskEventListeners(this,task,binding,viewModel);

        binding.setTask(task);
        binding.setListeners(listeners);


        binding.submitButton.setBackgroundTintList(null);




    }
}