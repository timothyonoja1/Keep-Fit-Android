package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.LiveFitness;
import com.kratos.keepfit.entities.LiveFitnessDetail;
import com.kratos.keepfit.states.LiveFitnessListUiState;
import com.kratos.keepfit.states.LiveFitnessItemUiState;
import com.kratos.keepfit.viewmodels.interfaces.LiveFitnessViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeLiveFitnessViewModel extends ViewModel implements LiveFitnessViewModel {

    private LiveFitness selectedLiveFitness;

    /** Constructs a new instance. */
    @Inject
    public FakeLiveFitnessViewModel(){

    }

    @Override
    public MutableLiveData<LiveFitnessListUiState> getLiveFitnessListUiState() {
        MutableLiveData<LiveFitnessListUiState> liveFitnessListUiState = new MutableLiveData<>();

        List<LiveFitness> liveFitnessList = getMockLiveFitnessList();

        liveFitnessListUiState.setValue(new LiveFitnessListUiState(false, liveFitnessList));
        return liveFitnessListUiState;
    }

    @Override
    public MutableLiveData<LiveFitnessItemUiState> getLiveFitnessItemUiState() {
        MutableLiveData<LiveFitnessItemUiState> liveFitnessUiState = new MutableLiveData<>();
        liveFitnessUiState.setValue(new LiveFitnessItemUiState(selectedLiveFitness));
        return liveFitnessUiState;
    }

    @Override
    public void setSelectedLiveFitness(LiveFitness liveFitness) {
        selectedLiveFitness = liveFitness;
    }

    private List<LiveFitness> getMockLiveFitnessList() {
        List<String> uris = new ArrayList<>();
        uris.add("@drawable/quick_core_crush");
        uris.add("@drawable/pregnant_mums");
        uris.add("@drawable/south_paw_training");

        List<String> names = new ArrayList<>();
        names.add("Quick Core Crush");
        names.add("Pregnant mums");
        names.add("Southpaw Training");

        List<LiveFitness> liveFitnessList = new ArrayList<>();
        LiveFitness liveFitness;
        LiveFitnessDetail liveFitnessDetail = null;
        int i = 0;
        while (i < 3){
            if (i == 0) {
                liveFitnessDetail = new LiveFitnessDetail(
                        "@drawable/tania_dp", "@drawable/quick_core_crush_background",
                        "Tania Hardy", "Quick Core Crush",
                        "This one will challenge your core from all sides, if you feel a" +
                                "a strain in your neck, take a quick break, then jump back in when you're ready.",
                        "drawable/tania_dp", "drawable/tania_dp", "1,892");
            }
            liveFitness = new LiveFitness(1, names.get(i), "500",
                    uris.get(i), liveFitnessDetail);
            liveFitnessList.add(liveFitness);
            ++i;
            liveFitnessDetail = null;
        }

        return liveFitnessList;
    }
}