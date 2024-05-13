package in.amankumar110.todoapplication;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Task.class},version = 1)
public abstract class Database extends RoomDatabase {

    public abstract TaskDao getTaskDao();

    private static Database dbInstance;
    public static Database getInstance(Context context) {

        if(dbInstance == null) {
            dbInstance = Room.databaseBuilder(context.getApplicationContext(),Database.class,"task_db").fallbackToDestructiveMigration().build();
        }
        return dbInstance;
    };
}
