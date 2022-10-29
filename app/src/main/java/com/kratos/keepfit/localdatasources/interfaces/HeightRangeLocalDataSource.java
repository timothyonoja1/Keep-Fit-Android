package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.HeightRange;
import java.util.List;

public interface HeightRangeLocalDataSource {

    boolean isOutdated();

    boolean saveHeightRanges(List<HeightRange> heightRanges);

    List<HeightRange> getAllHeightRanges();

}