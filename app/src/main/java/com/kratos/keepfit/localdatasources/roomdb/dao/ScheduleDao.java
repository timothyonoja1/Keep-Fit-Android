package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.Schedule;
import java.util.Date;
import java.util.List;

@Dao
public interface ScheduleDao {

    @Query("SELECT * FROM schedule")
    List<Schedule> getAllSchedules();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSchedules(List<Schedule> Schedules);

    @Query("DELETE FROM schedule")
    void deleteAllScheduleAs();

    @Query("SELECT dateSavedToLocalDatabase FROM schedule LIMIT 1")
    Date getDateOfLastUpdate();

}
