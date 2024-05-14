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

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { currentState ->
                currentState.copy(
                    types = listOf(
                        "Электротранспорт",
                        "Маневровый электровоз",
                        "Альтернативная энергетика(домашняя)",
                        "Геостационарная орбита",
                        "Солнечно-стационарная орбита",
                        "Импульсная характеристика разряда"
                    ),
                    selectedType = "Электротранспорт",
                    selectedIndex = 0
                )
            }
        }
    }

    fun onEnergyInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        energy = newValue,
                        energyError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        energy = newValue,
                        energyError = "Необходимо ввести число"
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

    fun onSelectedChange(newValue: String, index: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { currentState ->
                currentState.copy(
                    selectedType = newValue,
                    selectedIndex = index
                )
            }
        }
    }
}