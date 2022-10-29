package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.repositories.interfaces.GalleryRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeGalleryRepository implements GalleryRepository {

    private final List<Gallery> galleries;

    @Inject
    public FakeGalleryRepository() {
        galleries = new ArrayList<>();
    }

    @Override
    public List<Gallery> getLoggedInUserGalleries() {
        return galleries;
    }

    private List<Gallery> getMockGalleries() {
        List<Gallery> galleries = new ArrayList<>();

        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "", 1));
        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "",  1));
        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "",  1));

        return galleries;
    }
}
