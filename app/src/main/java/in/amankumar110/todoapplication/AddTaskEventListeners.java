package in.amankumar110.todoapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.adapters.TextViewBindingAdapter;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.xml.validation.Validator;

import in.amankumar110.todoapplication.databinding.ActivityAddTaskBinding;

public class AddTaskEventListeners {

    private Context context;
    private Task task;
    private ActivityAddTaskBinding binding;
    private TaskViewModel viewModel;

    public AddTaskEventListeners(Context context, Task task,ActivityAddTaskBinding binding,TaskViewModel viewModel) {

        this.task = task;
        this.binding = binding;
        this.viewModel =viewModel;
        this.context =context;
    }

    public void onTaskNameDataChanged(Editable editable) {

        binding.taskNameText.setText(editable.toString());
    }

    public void onTaskDescriptionDataChanged(Editable editable) {

        binding.taskDescriptionText.setText(editable.toString());
    }

    public void submitButtonClickListener(View v) {

        String currentTime = Calendar.getInstance().getTime().toString();
        task.setTaskPostedTime(currentTime);

        try {
            viewModel.addTask(this.task);
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } catch (RuntimeException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
