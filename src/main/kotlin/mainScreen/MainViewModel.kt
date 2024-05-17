package mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import battery.BatteryManager
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

    fun onStrengthInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        strength = newValue,
                        strengthError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        strength = newValue,
                        strengthError = "Необходимо ввести число"
                    )
                }
            }
        }
    }

    fun onVoltageInput(newValue: String) {
        try {
            if (newValue.isNotEmpty()) newValue.toDouble()
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        voltage = newValue,
                        voltageError = null
                    )
                }
            }
        } catch (e: NumberFormatException) {
            viewModelScope.launch(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(
                        voltage = newValue,
                        voltageError = "Необходимо ввести число"
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

    fun check() {
        val batteryManager = BatteryManager()
        viewModelScope.launch(Dispatchers.IO) {
            val isInputsValid = state.value.energyError == null &&
                    state.value.powerError == null &&
                    state.value.costError == null &&
                    state.value.massError == null &&
                    state.value.volumeError == null &&
                    state.value.strengthError == null &&
                    state.value.voltageError == null

            if (isInputsValid) {
                val battery = batteryManager.getBestBattery(
                    state.value.energy.toDouble(),
                    state.value.power.toDouble(),
                    state.value.cost.toDouble(),
                    state.value.mass.toDouble(),
                    state.value.volume.toDouble(),
                    state.value.strength.toDouble(),
                    state.value.voltage.toDouble(),
                    state.value.selectedIndex
                )
                val result = "Подходящий аккумулятор:\n" +
                        "Название: ${battery.name}\n" +
                        "C-ratio: ${battery.cRatio.start} - ${battery.cRatio.endInclusive}\n" +
                        "Удельная энергоемкость, M: ${battery.cEnergyM.start} - ${battery.cEnergyM.endInclusive} Втч/кг\n" +
                        "Удельная энергоемкость, V: ${battery.cEnergyV.start} - ${battery.cEnergyV.endInclusive} Втч/дм3\n" +
                        "Удельная стоимость, E: ${battery.cEnergyCost.start} - ${battery.cEnergyCost.endInclusive} Втч/руб" +
                        "Удельная мощность, M: ${battery.cPowerM.start} - ${battery.cPowerM.endInclusive} Вт/кг\n" +
                        "Уельная мощность, V: ${battery.cPowerV.start} - ${battery.cPowerV.endInclusive} Вт/дм3\n" +
                        "Удельная стоимость, P: ${battery.cPowerCost.start} - ${battery.cPowerCost.endInclusive} Вт/руб\n"
                _state.update { currentState ->
                    currentState.copy(
                        result = result
                    )
                }
            } else {
                _state.update { currentState ->
                    currentState.copy(
                        result = "Введите корректные данные"
                    )
                }
            }
        }
    }
}