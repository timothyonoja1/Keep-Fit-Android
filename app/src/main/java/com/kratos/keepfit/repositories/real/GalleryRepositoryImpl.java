package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.localdatasources.interfaces.GalleryLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.GalleryRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.GalleryRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class GalleryRepositoryImpl implements GalleryRepository {

    private final UserDataStore userDataStore;
    private final GalleryLocalDataSource galleryLocalDataSource;
    private final GalleryRemoteDataSource galleryRemoteDataSource;

    @Inject
    public GalleryRepositoryImpl(UserDataStore userDataStore,
                                 GalleryLocalDataSource galleryLocalDataSource,
                                 GalleryRemoteDataSource galleryRemoteDataSource) {
        this.userDataStore = userDataStore;
        this.galleryLocalDataSource = galleryLocalDataSource;
        this.galleryRemoteDataSource = galleryRemoteDataSource;
    }

    @Override
    public List<Gallery> getLoggedInUserGalleries() {
        if (galleryLocalDataSource.iOutdated()) {
            refresh();
        }
        return galleryLocalDataSource.getAllLoggedInUserGalleries();
    }

    private void refresh() {
        int userProfileID = userDataStore.getLoggedInUserProfile().getUserProfileID();
        List<Gallery> result = galleryRemoteDataSource.getGalleries(userProfileID);
        Date currentDate = new Date();
        for (Gallery gallery : result) {
            gallery.setDateSavedToLocalDatabase(currentDate);
        }
        galleryLocalDataSource.saveGalleries(result);
    }

}