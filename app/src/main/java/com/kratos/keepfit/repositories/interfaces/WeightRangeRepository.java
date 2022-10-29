package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.WeightRange;

import java.util.List;

public interface WeightRangeRepository {

    boolean saveWeightSelectedByUser(int weight);

    int getWeightSelectedByUser();

    int getWeightRangeIDSelectedBUser();

    List<WeightRange> getAllWeightRanges();

    boolean deleteWeightSelectedByUser();

}
