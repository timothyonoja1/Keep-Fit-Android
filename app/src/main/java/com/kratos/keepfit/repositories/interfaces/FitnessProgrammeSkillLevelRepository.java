package com.kratos.keepfit.repositories.interfaces;

import java.util.List;

public interface FitnessProgrammeSkillLevelRepository {

    List<Integer> getFitnessProgrammeIDs(List<Integer> skillLevelIDs);

}
