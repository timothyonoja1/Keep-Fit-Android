package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.Gallery;
import java.util.List;

public interface GalleryRepository {

    List<Gallery> getLoggedInUserGalleries();

}
