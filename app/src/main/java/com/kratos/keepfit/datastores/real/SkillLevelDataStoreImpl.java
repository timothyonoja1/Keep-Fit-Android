package com.kratos.keepfit.datastores.real;

import android.content.Context;
import android.content.SharedPreferences;
import com.kratos.keepfit.datastores.interfaces.SkillLevelDataStore;
import com.kratos.keepfit.entities.SkillLevel;
import javax.inject.Inject;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;

public class SkillLevelDataStoreImpl implements SkillLevelDataStore {

    private final Context context;

    @Inject
    public SkillLevelDataStoreImpl(@ApplicationContext Context context) {
        this.context = context;
    }

    @Override
    public boolean saveSkillLevelSelectedByUser(SkillLevel skillLevel) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("skillLevelID", skillLevel.getSkillLevelID());
        editor.putString("name", skillLevel.getName());
        editor.apply();

        return true;
    }

    @Override
    public SkillLevel getSkillLevelSelectedByUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        int skillLevelID = sharedPref.getInt("skillLevelID", 0);
        String name = sharedPref.getString("name", "");

        return new SkillLevel(skillLevelID, name);
    }

    @Override
    public boolean deleteSkillLevelSelectedByUser() {
        saveSkillLevelSelectedByUser(new SkillLevel(0, ""));
        return true;
    }
}
