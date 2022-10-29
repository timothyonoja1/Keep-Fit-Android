package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.localdatasources.interfaces.GalleryLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeGalleryLocalDataSource implements GalleryLocalDataSource {

    private final List<Gallery> galleries = new ArrayList<>();

    @Inject
    public FakeGalleryLocalDataSource() {

    }

    @Override
    public boolean iOutdated() {
        return true;
    }

    @Override
    public boolean saveGalleries(List<Gallery> galleries) {
        this.galleries.clear();
        this.galleries.addAll(galleries);
        return true;
    }

    @Override
    public List<Gallery> getAllLoggedInUserGalleries() {
        return galleries;
    }

    @Override
    public boolean deleteAllGalleries() {
        galleries.clear();
        return true;
    }
}