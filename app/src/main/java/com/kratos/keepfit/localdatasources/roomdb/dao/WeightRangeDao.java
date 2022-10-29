package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.WeightRange;
import java.util.Date;
import java.util.List;

@Dao
public interface WeightRangeDao {

    @Query("SELECT * FROM ageRange")
    List<WeightRange> getAllWeightRanges();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWeightRanges(List<WeightRange> weightRanges);

    @Query("DELETE FROM weightRange")
    void deleteAllWeightRanges();

    @Query("SELECT dateSavedToLocalDatabase FROM weightRange LIMIT 1")
    Date getDateOfLastUpdate();

}
