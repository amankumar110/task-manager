package in.amankumar110.todoapplication.helpers;

import in.amankumar110.todoapplication.Task;

public  class Validator {


    public static boolean isTaskNameEmpty(String taskName) {


        return taskName != null && !taskName.isEmpty();
    };

    public static boolean isTaskDescriptionEmpty(String taskDescription) {

        return taskDescription != null && !taskDescription.isEmpty();
    };
}
