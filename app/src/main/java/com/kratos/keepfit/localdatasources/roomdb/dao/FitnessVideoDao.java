package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.FitnessVideo;
import java.util.Date;
import java.util.List;

@Dao
public interface FitnessVideoDao {

    @Query("SELECT * FROM fitnessVideo")
    List<FitnessVideo> getAllFitnessVideos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFitnessVideos(List<FitnessVideo> fitnessVideos);

    @Query("DELETE FROM fitnessVideo")
    void deleteAllFitnessVideos();

    @Query("SELECT dateSavedToLocalDatabase FROM fitnessVideo LIMIT 1")
    Date getDateOfLastUpdate();

}