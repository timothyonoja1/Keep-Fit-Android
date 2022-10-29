package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.remotedatasources.interfaces.GalleryRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeGalleryRemoteDataSource implements GalleryRemoteDataSource {

    private final List<Gallery> galleries;

    @Inject
    public FakeGalleryRemoteDataSource() {
        galleries = new ArrayList<>();
    }

    @Override
    public List<Gallery> getGalleries(int userProfileID) {
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
