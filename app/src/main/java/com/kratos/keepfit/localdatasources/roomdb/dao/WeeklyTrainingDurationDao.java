package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.WeeklyTrainingDuration;
import java.util.Date;
import java.util.List;

@Dao
public interface WeeklyTrainingDurationDao {

    @Query("SELECT * FROM weeklyTrainingDuration")
    List<WeeklyTrainingDuration> getAllWeeklyTrainingDurations();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWeeklyTrainingDurations(List<WeeklyTrainingDuration> weeklyTrainingDuration);

    @Query("DELETE FROM weeklyTrainingDuration")
    void deleteAllWeeklyTrainingDurations();

    @Query("SELECT dateSavedToLocalDatabase FROM weeklyTrainingDuration LIMIT 1")
    Date getDateOfLastUpdate();

}