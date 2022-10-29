package com.kratos.keepfit.localdatasources.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kratos.keepfit.entities.Gallery;
import java.util.Date;
import java.util.List;

@Dao
public interface GalleryDao {

    @Query("SELECT * FROM gallery")
    List<Gallery> getAllGalleries();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGalleries(List<Gallery> galleries);

    @Query("DELETE FROM gallery")
    void deleteAllGalleries();

    @Query("SELECT dateSavedToLocalDatabase FROM gallery LIMIT 1")
    Date getDateOfLastUpdate();

}
