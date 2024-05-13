package in.amankumar110.todoapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.amankumar110.todoapplication.databinding.ActivityMainBinding;

public class MainActivityClickListener {


    private List<Task> tasks;
    private TaskViewModel viewModel;
    ActivityMainBinding binding;
    Context context;

    public MainActivityClickListener(List<Task> tasks, TaskViewModel viewModel, ActivityMainBinding binding, Context context) {
        this.tasks = tasks;
        this.viewModel = viewModel;
        this.binding = binding;
        this.context =context;
    }

    public void setItemSwipedListener() {

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                if(direction == ItemTouchHelper.LEFT) {
                    Task task = tasks.get(viewHolder.getAdapterPosition());
                    viewModel.deleteTask(task);
                }
            }
        }).attachToRecyclerView(binding.taskList);
    }

    public void onAddButtonClicked(View v) {
        Intent intent = new Intent(context, AddTaskActivity.class);
        context.startActivity(intent);
    }
}
