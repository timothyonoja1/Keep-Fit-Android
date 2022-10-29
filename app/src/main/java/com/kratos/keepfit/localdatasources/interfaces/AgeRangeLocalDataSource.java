package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.AgeRange;
import java.util.List;

public interface AgeRangeLocalDataSource {

    boolean isOutdated();

    boolean saveAgeRanges(List<AgeRange> ageRanges);

    List<AgeRange> getAllAgeRanges();

}
