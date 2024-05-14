package mainScreen

data class MainScreenState(
    val selectedType: String = "",
    val types: List<String> = emptyList(),
    val ener: String = "",
    val enerError: String? = null,
    val power: String = "",
    val powerError: String? = null,
    val cost: String = "",
    val costError: String? = null,
    val mass: String = "",
    val massError: String? = null,
    val volume: String = "",
    val volumeError: String? = null,
    val result: String = ""
)
