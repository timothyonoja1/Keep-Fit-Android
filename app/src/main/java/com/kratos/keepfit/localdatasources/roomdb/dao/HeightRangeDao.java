package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.HeightRange;
import java.util.Date;
import java.util.List;

@Dao
public interface HeightRangeDao {

    @Query("SELECT * FROM ageRange")
    List<HeightRange> getAllHeightRanges();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHeightRanges(List<HeightRange> heightRanges);

    @Query("DELETE FROM heightrange")
    void deleteAllHeightRanges();

    @Query("SELECT dateSavedToLocalDatabase FROM heightRange LIMIT 1")
    Date getDateOfLastUpdate();

}