package mainScreen

data class MainScreenState(
    val selectedType: String = "",
    val selectedIndex: Int = 0,
    val types: List<String> = emptyList(),
    val energy: String = "",
    val energyError: String? = null,
    val power: String = "",
    val powerError: String? = null,
    val cost: String = "",
    val costError: String? = null,
    val mass: String = "",
    val massError: String? = null,
    val volume: String = "",
    val volumeError: String? = null,
    val strength: String = "",
    val strengthError: String? = null,
    val voltage: String = "",
    val voltageError: String? = null,
    val result: String = ""
)
