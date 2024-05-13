package in.amankumar110.todoapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.amankumar110.todoapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private TaskViewModel viewModel;

   private Database database;

   private ActivityMainBinding binding;

   private List<Task> tasks;

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        database = Database.getInstance(this.getApplication());
        viewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        tasks = new ArrayList<>();

        viewModel.getAllTasks().observe(this,(tasks)->{

            this.tasks.clear();
            this.tasks.addAll(tasks);
            binding.taskList.swapAdapter(new TaskAdapter(this.tasks),true);
        });

       binding.taskList.setAdapter(new TaskAdapter(tasks));

       MainActivityClickListener listeners = new MainActivityClickListener(tasks,viewModel,binding,this);
       binding.setListeners(listeners);

       listeners.setItemSwipedListener();

    }


}