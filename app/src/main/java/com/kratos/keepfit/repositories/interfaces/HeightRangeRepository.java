package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.HeightRange;
import java.util.List;

public interface HeightRangeRepository {

    boolean saveHeightSelectedByUser(int height);

    int getHeightSelectedByUser();

    int getHeightRangeIDSelectedBUser();

    List<HeightRange> getAllHeightRanges();

    boolean deleteHeightSelectedByUser();

}
