package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.Allergy;
import java.util.Date;
import java.util.List;

@Dao
public interface AllergyDao {

    @Query("SELECT * FROM allergy")
    List<Allergy> getAllAllergiess();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllergies(List<Allergy> allergies);

    @Query("DELETE FROM allergy")
    void deleteAllAllergies();

    @Query("SELECT dateSavedToLocalDatabase FROM allergy LIMIT 1")
    Date getDateOfLastUpdate();

}
