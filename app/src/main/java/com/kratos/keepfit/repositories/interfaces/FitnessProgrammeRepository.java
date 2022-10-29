package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.FitnessProgramme;
import java.util.List;

public interface FitnessProgrammeRepository {

    List<FitnessProgramme> getFitnessProgrammes(List<Integer> fitnessProgrammeIDs);

}
