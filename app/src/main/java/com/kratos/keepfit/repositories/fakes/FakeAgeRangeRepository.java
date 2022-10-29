package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.AgeRange;
import com.kratos.keepfit.repositories.interfaces.AgeRangeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeAgeRangeRepository implements AgeRangeRepository {

    private int selectedAge;

    @Inject
    public FakeAgeRangeRepository() {

    }

    @Override
    public boolean saveAgeSelectedByUser(int age) {
        selectedAge = age;
        return true;
    }

    @Override
    public boolean deleteAgeSelectedByUser() {
        selectedAge = 0;
        return true;
    }

    @Override
    public int getAgeSelectedByUser() {
        return selectedAge;
    }

    @Override
    public int getAgeRangeIDSelectedByUser() {
        return 0;
    }

    @Override
    public List<AgeRange> getAllAgeRanges() {
        return new ArrayList<>();
    }

}
