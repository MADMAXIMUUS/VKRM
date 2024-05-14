package battery

class BatteryManager {

    private val _batteries: MutableList<Battery> = mutableListOf()
    val batteries get() = _batteries

    private val _applies: MutableList<Battery> = mutableListOf()
    val applies get() = _applies

    init {
        _batteries.addAll(
            listOf(
                Battery(
                    name = "Свинцово-кислотный",
                    cRatio = 0.2,
                    cEnergyM = 40.0,
                    cEnergyV = 70.0,
                    cEnergyCost = 150.0,
                    cPowerM = 200.0,
                    cPowerV = 300.0,
                    cPowerCost = 75.0
                ),
                Battery(
                    name = "Никель-металлгидридный",
                    cRatio = 0.4,
                    cEnergyM = 80.0,
                    cEnergyV = 220.0,
                    cEnergyCost = 250.0,
                    cPowerM = 800.0,
                    cPowerV = 1000.0,
                    cPowerCost = 150.0
                ),
                Battery(
                    name = "Никель-водородный",
                    cRatio = 0.4,
                    cEnergyM = 70.0,
                    cEnergyV = 180.0,
                    cEnergyCost = 400.0,
                    cPowerM = 300.0,
                    cPowerV = 450.0,
                    cPowerCost = 230.0
                ),
                Battery(
                    name = "Литий-ионный",
                    cRatio = 0.7,
                    cEnergyM = 200.0,
                    cEnergyV = 450.0,
                    cEnergyCost = 200.0,
                    cPowerM = 1000.0,
                    cPowerV = 2000.0,
                    cPowerCost = 100.0
                    ),
                Battery(
                    name = "Литий-железо-фосфатный",
                    cRatio = 1.4,
                    cEnergyM = 100.0,
                    cEnergyV = 250.0,
                    cEnergyCost = 180.0,
                    cPowerM = 700.0,
                    cPowerV = 1500.0,
                    cPowerCost = 85.0
                ),
                Battery(
                    name = "Литий-титанатный",
                    cRatio = 5.0,
                    cEnergyM = 80.0,
                    cEnergyV = 200.0,
                    cEnergyCost = 250.0,
                    cPowerM = 4000.0,
                    cPowerV = 6000.0,
                    cPowerCost = 125.0
                ),
                Battery(
                    name = "Суперконденсатор",
                    cRatio = 50.0,
                    cEnergyM = 7.0,
                    cEnergyV = 7.0,
                    cEnergyCost = 800.0,
                    cPowerM = 7000.0,
                    cPowerV = 15000.0,
                    cPowerCost = 300.0
                )
            )
        )
        _applies.addAll(
            listOf(
                Battery(
                    name = "Электромобили",
                    cRatio = 3.0,
                    cEnergyM = 200.0,
                    cEnergyV = 400.0,
                    cEnergyCost = 200.0,
                    cPowerM = 1000.0,
                    cPowerV = 2000.0,
                    cPowerCost = 100.0
                ),
                Battery(
                    name = "Маневровый электровоз",
                    cRatio = 4.0,
                    cEnergyM = 150.0,
                    cEnergyV = 250.0,
                    cEnergyCost = 0.2,
                    cPowerM = 300.0,
                    cPowerV = 600.0,
                    cPowerCost = 0.1
                ),
                Battery(
                    name = "Альтернативная энергетика",
                    cRatio = 0.5,
                    cEnergyM = 100.0,
                    cEnergyV = 200.0,
                    cEnergyCost = 0.2,
                    cPowerM = 300.0,
                    cPowerV = 600.0,
                    cPowerCost = 0.3
                ),
                Battery(
                    name = "Геостационарная орбита",
                    cRatio = 0.3,
                    cEnergyM = 100.0,
                    cEnergyV = 200.0,
                    cEnergyCost = 500.0,
                    cPowerM = 200.0,
                    cPowerV = 400.0,
                    cPowerCost = 1000.0
                ),
                Battery(
                    name = "солнечно стационарная орбита",
                    cRatio = 0.3,
                    cEnergyM = 150.0,
                    cEnergyV = 400.0,
                    cEnergyCost = 30.0,
                    cPowerM = 250.0,
                    cPowerV = 600.0,
                    cPowerCost = 30.0
                ),
                Battery(
                    name = "Импульсный характер разряда",
                    cRatio = 1.0,
                    cEnergyM = 180.0,
                    cEnergyV = 500.0,
                    cEnergyCost = 100.0,
                    cPowerM = 6000.0,
                    cPowerV = 15000.0,
                    cPowerCost = 100.0
                )
            )
        )
    }
}