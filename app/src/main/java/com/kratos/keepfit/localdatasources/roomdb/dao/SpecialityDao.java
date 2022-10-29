package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.Speciality;
import java.util.Date;
import java.util.List;

@Dao
public interface SpecialityDao {

    @Query("SELECT * FROM speciality")
    List<Speciality> getAllSpecialities();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpecialities(List<Speciality> specialities);

    @Query("DELETE FROM speciality")
    void deleteAllSpecialities();

    @Query("SELECT dateSavedToLocalDatabase FROM speciality LIMIT 1")
    Date getDateOfLastUpdate();

}