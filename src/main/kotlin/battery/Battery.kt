package battery

data class Battery(
    val name: String,
    val cRatio: Double,
    val cEnergyM: Double,
    val cEnergyV: Double,
    val cEnergyCost: Double,
    val cPowerM: Double,
    val cPowerV: Double,
    val cPowerCost: Double
)