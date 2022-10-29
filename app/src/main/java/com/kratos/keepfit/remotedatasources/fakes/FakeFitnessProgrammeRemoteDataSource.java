package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessProgramme;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeRemoteDataSource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FakeFitnessProgrammeRemoteDataSource implements FitnessProgrammeRemoteDataSource {

    @Inject
    public FakeFitnessProgrammeRemoteDataSource() {

    }

    @Override
    public List<FitnessProgramme> getAllFitnessProgrammes() {
        return getMockFitnessProgrammeList();
    }

    private List<FitnessProgramme> getMockFitnessProgrammeList() {
        List<FitnessProgramme> fitnessProgrammeList = new ArrayList<>();

        fitnessProgrammeList.add(new FitnessProgramme(1, "Circuit Training Fundamentals",
                "Completed by Dwayne Johnson", "23 July, at 10:00 AM",
                "12", "4", "Requires a mat & exercise band",
                "@drawable/circuit_training", 1));

        fitnessProgrammeList.add(new FitnessProgramme(2, "Cardio Hybrid",
                "Completed by Chris Bab", "15 August, at 12:00 PM",
                "12", "4", "Requires a mat & skipping rope",
                "@drawable/cardio_hybrid", 1));


        fitnessProgrammeList.add(new FitnessProgramme(3, "Muscular Circuit",
                "Completed by Tania Hardy", "19 August, at 12:00 PM",
                "12", "4", "Requires a mat or clean floor",
                "@drawable/muscular_circuit", 1));

        return fitnessProgrammeList;
    }
}
