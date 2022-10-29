package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessProgrammeLocalDataSource implements FitnessProgrammeLocalDataSource {

    private final List<FitnessProgramme> fitnessProgrammes = new ArrayList<>();

    @Inject
    public FakeFitnessProgrammeLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveFitnessProgrammes(List<FitnessProgramme> fitnessProgrammes) {
        this.fitnessProgrammes.clear();
        this.fitnessProgrammes.addAll(fitnessProgrammes);
        return true;
    }

    @Override
    public List<FitnessProgramme> getFitnessProgrammes(List<Integer> fitnessProgrammeIDs) {
        List<FitnessProgramme> result = new ArrayList<>();
        for (int fitnessProgrammeID : fitnessProgrammeIDs) {
            FitnessProgramme fitnessProgramme = getFitnessProgramme(fitnessProgrammeID);
            if (fitnessProgramme != null) {
                result.add(fitnessProgramme);
            }
        }
        return result;
    }

    private FitnessProgramme getFitnessProgramme(int fitnessProgrammeID) {
        for (FitnessProgramme fitnessProgramme : fitnessProgrammes) {
            if (fitnessProgramme.getFitnessProgrammeID() == fitnessProgrammeID) {
                return fitnessProgramme;
            }
        }
        return null;
    }
}
