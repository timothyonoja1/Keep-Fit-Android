package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.AgeRange;
import java.util.List;

public interface AgeRangeRepository {

    boolean saveAgeSelectedByUser(int age);

    boolean deleteAgeSelectedByUser();

    int getAgeSelectedByUser();

    int getAgeRangeIDSelectedByUser();

    List<AgeRange> getAllAgeRanges();

}