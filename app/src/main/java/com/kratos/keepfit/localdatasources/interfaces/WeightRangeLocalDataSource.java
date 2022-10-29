package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.WeightRange;
import java.util.List;

public interface WeightRangeLocalDataSource {

    boolean isOutdated();

    boolean saveWeightRanges(List<WeightRange> weightRanges);

    List<WeightRange> getAllWeightRanges();
}
