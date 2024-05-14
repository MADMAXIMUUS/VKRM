package mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState> = _state

    fun onEnerInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        ener = newValue,
                        enerError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        ener = newValue,
                        enerError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun onPowerInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        power = newValue,
                        powerError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        power = newValue,
                        powerError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun onCostInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        cost = newValue,
                        costError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        cost = newValue,
                        costError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun onMassInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        mass = newValue,
                        massError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        mass = newValue,
                        massError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun onVolumeInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        volume = newValue,
                        volumeError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        volume = newValue,
                        volumeError = "Необходимо ввести число"
                    )
                }
            }
        }
    }
}