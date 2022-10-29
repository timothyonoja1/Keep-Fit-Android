package com.kratos.keepfit.managers.interfaces;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.FitnessProgramme;
import java.util.List;

public interface FitnessProgrammeManager {

    void getFitnessProgrammes(int fitnessCategoryID, ResultCallback<List<FitnessProgramme>> callback);

    List<FitnessProgramme> getFitnessProgrammesSync(int fitnessCategoryID);

    int getNumberOfFitnessProgrammesSync(List<Integer> fitnessCategoryIDs);

    int getNumberOfFitnessProgrammesSync(int fitnessCategoryID);

}