package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.FitnessCategory;
import java.util.Date;
import java.util.List;

@Dao
public interface FitnessCategoryDao {

    @Query("SELECT * FROM fitnesscategory")
    List<FitnessCategory> getAllFitnessCategories();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFitnessCategories(List<FitnessCategory> fitnessCategories);

    @Query("DELETE FROM fitnessCategory")
    void deleteAllFitnessCategories();

    @Query("SELECT dateSavedToLocalDatabase FROM fitnesscategory LIMIT 1")
    Date getDateOfLastUpdate();
}
