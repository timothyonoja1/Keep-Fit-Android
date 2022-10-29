package com.kratos.keepfit.managers.fakes;

import com.kratos.keepfit.entities.Allergy;
import com.kratos.keepfit.managers.interfaces.AllergyManager;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeAllergyManager implements AllergyManager {

    private final List<Allergy> allergies;

    @Inject
    public FakeAllergyManager() {
        allergies = getMockAllergies();
    }

    @Override
    public List<Allergy> getAllAllergies() {
        return allergies;
    }

    @Override
    public boolean saveUserAllergies(List<Allergy> allergies) {
        return true;
    }

    private List<Allergy> getMockAllergies() {
        List<Allergy> allergies = new ArrayList<>();
        allergies.add(new Allergy(1, "ShellFish"));
        allergies.add(new Allergy(2, "Gluten"));
        allergies.add(new Allergy(3, "Diary"));
        allergies.add(new Allergy(4, "Peanut"));
        allergies.add(new Allergy(5, "Tree Nut"));
        allergies.add(new Allergy(6, "Soy"));
        allergies.add(new Allergy(7, "Egg"));
        allergies.add(new Allergy(8, "Sesame"));
        allergies.add(new Allergy(9, "Mustard"));
        allergies.add(new Allergy(10, "Sulfite"));
        allergies.add(new Allergy(11, "Nightshade"));

        return allergies;
    }
}