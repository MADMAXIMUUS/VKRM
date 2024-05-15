package battery

data class Battery(
    val name: String,
    val cRatio: ClosedRange<Double>,
    val cEnergyM: ClosedRange<Double>,
    val cEnergyV: ClosedRange<Double>,
    val cEnergyCost: ClosedRange<Double>,
    val cPowerM: ClosedRange<Double>,
    val cPowerV: ClosedRange<Double>,
    val cPowerCost: ClosedRange<Double>
)