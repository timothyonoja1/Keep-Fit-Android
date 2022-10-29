package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.FitnessProgramme;
import java.util.Date;
import java.util.List;

public interface FitnessProgrammeDao {

    @Query("SELECT * FROM ageRange")
    List<FitnessProgramme> getAllFitnessProgramme();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFitnessProgrammes(List<FitnessProgramme> fitnessProgrammes);

    @Query("DELETE FROM fitnessProgramme")
    void deleteAllFitnessProgrammes();

    @Query("SELECT dateSavedToLocalDatabase FROM fitnessProgramme LIMIT 1")
    Date getDateOfLastUpdate();

}
