package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.HeightRange;
import com.kratos.keepfit.repositories.interfaces.HeightRangeRepository;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeHeightRangeRepository implements HeightRangeRepository {

    private int selectedHeight;

    @Inject
    public FakeHeightRangeRepository() {

    }

    @Override
    public boolean saveHeightSelectedByUser(int height) {
        selectedHeight = height;
        return true;
    }

    @Override
    public int getHeightSelectedByUser() {
        return selectedHeight;
    }

    @Override
    public int getHeightRangeIDSelectedBUser() {
        return 0;
    }

    @Override
    public List<HeightRange> getAllHeightRanges() {
        return new ArrayList<>();
    }

    @Override
    public boolean deleteHeightSelectedByUser() {
        selectedHeight = 0;
        return true;
    }
}
