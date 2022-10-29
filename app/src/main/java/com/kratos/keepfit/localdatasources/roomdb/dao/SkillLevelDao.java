package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.SkillLevel;
import java.util.Date;
import java.util.List;

@Dao
public interface SkillLevelDao {

    @Query("SELECT * FROM skillLevel")
    List<SkillLevel> getAllSkillLevels();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSkillLevels(List<SkillLevel> skillLevels);

    @Query("DELETE FROM skilllevel")
    void deleteAllSkillLevels();

    @Query("SELECT dateSavedToLocalDatabase FROM skillLevel LIMIT 1")
    Date getDateOfLastUpdate();
}
