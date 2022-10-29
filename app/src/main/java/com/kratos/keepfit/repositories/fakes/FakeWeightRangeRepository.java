package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.WeightRange;
import com.kratos.keepfit.repositories.interfaces.WeightRangeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeWeightRangeRepository implements WeightRangeRepository {

    private int selectedWeight;

    @Inject
    public FakeWeightRangeRepository() {

    }

    @Override
    public boolean saveWeightSelectedByUser(int weight) {
        selectedWeight = weight;
        return true;
    }

    @Override
    public int getWeightSelectedByUser() {
        return selectedWeight;
    }

    @Override
    public int getWeightRangeIDSelectedBUser() {
        return 0;
    }

    @Override
    public List<WeightRange> getAllWeightRanges() {
        return new ArrayList<>();
    }

    @Override
    public boolean deleteWeightSelectedByUser() {
        selectedWeight = 0;
        return true;
    }
}