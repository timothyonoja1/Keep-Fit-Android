package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.FitnessGoal;
import java.util.Date;
import java.util.List;

@Dao
public interface FitnessGoalDao {

    @Query("SELECT * FROM fitnessGoal")
    List<FitnessGoal> getAllFitnessGoals();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFitnessGoals(List<FitnessGoal> fitnessGoals);

    @Query("DELETE FROM fitnessGoal")
    void deleteAllFitnessGoals();

    @Query("SELECT dateSavedToLocalDatabase FROM fitnessGoal LIMIT 1")
    Date getDateOfLastUpdate();


}
