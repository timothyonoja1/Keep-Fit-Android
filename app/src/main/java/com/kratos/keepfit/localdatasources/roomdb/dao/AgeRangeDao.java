package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.AgeRange;
import java.util.Date;
import java.util.List;

@Dao
public interface AgeRangeDao {

    @Query("SELECT * FROM ageRange")
    List<AgeRange> getAllAgeRanges();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAgeRanges(List<AgeRange> ageRanges);

    @Query("DELETE FROM ageRange")
    void deleteAllAgeRanges();

    @Query("SELECT dateSavedToLocalDatabase FROM ageRange LIMIT 1")
    Date getDateOfLastUpdate();

}