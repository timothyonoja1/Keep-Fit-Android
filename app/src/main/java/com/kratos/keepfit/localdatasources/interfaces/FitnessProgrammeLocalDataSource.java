package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessProgramme;
import java.util.List;

public interface FitnessProgrammeLocalDataSource {

    boolean isOutdated();

    boolean saveFitnessProgrammes(List<FitnessProgramme> fitnessProgrammes);

    List<FitnessProgramme> getFitnessProgrammes(List<Integer> fitnessProgrammeIDs);

}
