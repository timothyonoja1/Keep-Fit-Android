package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.Gallery;

import java.util.List;

public interface GalleryRemoteDataSource {

    List<Gallery> getGalleries(int userProfileID);

}
