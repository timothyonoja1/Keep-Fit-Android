package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.states.AccountUiState;

public interface AccountViewModel {

    MutableLiveData<AccountUiState> getAccountUiState();

}
