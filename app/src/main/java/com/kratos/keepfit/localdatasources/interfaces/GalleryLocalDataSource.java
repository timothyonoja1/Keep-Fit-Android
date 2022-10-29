package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.Gallery;
import java.util.List;

public interface GalleryLocalDataSource {

    boolean iOutdated();

    boolean saveGalleries(List<Gallery> galleries);

    List<Gallery> getAllLoggedInUserGalleries();

    boolean deleteAllGalleries();

}
