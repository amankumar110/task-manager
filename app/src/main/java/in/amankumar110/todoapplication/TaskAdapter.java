package in.amankumar110.todoapplication;

import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import in.amankumar110.todoapplication.databinding.TaskListItemLayoutBinding;
public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_TASK = 0;

    private static final List<String> hexColors = Arrays.asList("#f5cc00","#c77dff","#b8d0eb","#ffc2d1","#90e0ef");
    private static final int VIEW_TYPE_EMPTY = 1;

    private List<Task> tasks;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_TASK) {
            TaskListItemLayoutBinding binding = DataBindingUtil.inflate(inflater,
                    R.layout.task_list_item_layout, parent, false);

            return new TaskHolder(binding);
        } else {
            View emptyView = inflater.inflate(R.layout.empty_list_layout, parent, false);
            return new EmptyViewHolder(emptyView);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder  instanceof TaskHolder) {

            TaskHolder taskHolder = (TaskHolder) holder;

            String randomColor = hexColors.get(position % hexColors.size());

            Log.v("val",randomColor);

            View constraintLayout = taskHolder.binding.getRoot().getRootView();

            constraintLayout.setBackgroundColor(Color.parseColor(randomColor));


            taskHolder.binding.setTask(tasks.get(position));
        }
        // No binding required for empty view
    }

    @Override
    public int getItemCount() {
        return tasks.isEmpty() ? 1 : tasks.size();
    }

    @Override
    public int getItemViewType(int position) {
        return tasks.isEmpty() ? VIEW_TYPE_EMPTY : VIEW_TYPE_TASK;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {

        if(tasks.isEmpty()) {
            LinearLayoutManager manager = new LinearLayoutManager(recyclerView.getContext());
            recyclerView.setLayoutManager(manager);
        } else {
            GridLayoutManager manager = new GridLayoutManager(recyclerView.getContext(),2);
            recyclerView.setLayoutManager(manager);
        }
    }

    public static class TaskHolder extends RecyclerView.ViewHolder {

        TaskListItemLayoutBinding binding;

        public TaskHolder(TaskListItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}