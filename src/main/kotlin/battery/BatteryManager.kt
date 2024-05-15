package battery

import util.intersect

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
                    cRatio = 0.1..0.3,
                    cEnergyM = 30.0..50.0,
                    cEnergyV = 50.0..90.0,
                    cEnergyCost = 100.0..200.0,
                    cPowerM = 150.0..300.0,
                    cPowerV = 200.0..400.0,
                    cPowerCost = 50.0..100.0
                ),
                Battery(
                    name = "Никель-металлгидридный",
                    cRatio = 0.2..0.5,
                    cEnergyM = 60.0..120.0,
                    cEnergyV = 140.0..300.0,
                    cEnergyCost = 200.0..300.0,
                    cPowerM = 250.0..1000.0,
                    cPowerV = 400.0..1500.0,
                    cPowerCost = 100.0..200.0
                ),
                Battery(
                    name = "Никель-водородный",
                    cRatio = 0.2..0.5,
                    cEnergyM = 60.0..80.0,
                    cEnergyV = 140.0..250.0,
                    cEnergyCost = 300.0..500.0,
                    cPowerM = 200.0..400.0,
                    cPowerV = 300.0..600.0,
                    cPowerCost = 150.0..300.0
                ),
                Battery(
                    name = "Литий-ионный",
                    cRatio = 0.5..2.0,
                    cEnergyM = 150.0..250.0,
                    cEnergyV = 250.0..620.0,
                    cEnergyCost = 150.0..250.0,
                    cPowerM = 300.0..1500.0,
                    cPowerV = 600.0..3000.0,
                    cPowerCost = 75.0..125.0
                ),
                Battery(
                    name = "Литий-железо-фосфатный",
                    cRatio = 0.5..2.0,
                    cEnergyM = 90.0..120.0,
                    cEnergyV = 200.0..330.0,
                    cEnergyCost = 150.0..200.0,
                    cPowerM = 200.0..1000.0,
                    cPowerV = 400.0..2000.0,
                    cPowerCost = 75.0..100.0
                ),
                Battery(
                    name = "Литий-титанатный",
                    cRatio = 1.0..10.0,
                    cEnergyM = 70.0..90.0,
                    cEnergyV = 150.0..240.0,
                    cEnergyCost = 200.0..300.0,
                    cPowerM = 2000.0..6000.0,
                    cPowerV = 3000.0..10000.0,
                    cPowerCost = 100.0..150.0
                ),
                Battery(
                    name = "Суперконденсатор",
                    cRatio = 10.0..100.0,
                    cEnergyM = 5.0..10.0,
                    cEnergyV = 5.0..10.0,
                    cEnergyCost = 500.0..1000.0,
                    cPowerM = 5000.0..10000.0,
                    cPowerV = 10000.0..20000.0,
                    cPowerCost = 200.0..400.0
                )
            )
        )
        _applies.addAll(
            listOf(
                Battery(
                    name = "Электромобили",
                    cRatio = 1.0..5.0,
                    cEnergyM = 150.0..250.0,
                    cEnergyV = 250.0..620.0,
                    cEnergyCost = 150.0..250.0,
                    cPowerM = 300.0..1500.0,
                    cPowerV = 600.0..3000.0,
                    cPowerCost = 75.0..125.0
                ),
                Battery(
                    name = "Маневровый электровоз",
                    cRatio = 3.0..5.0,
                    cEnergyM = 150.0..1000.0,
                    cEnergyV = 250.0..1000.0,
                    cEnergyCost = 0.0..0.2,
                    cPowerM = 300.0..1000.0,
                    cPowerV = 600.0..1000.0,
                    cPowerCost = 0.0..0.1
                ),
                Battery(
                    name = "Альтернативная энергетика",
                    cRatio = 0.1..1.0,
                    cEnergyM = 100.0..1000.0,
                    cEnergyV = 200.0..1000.0,
                    cEnergyCost = 0.0..0.2,
                    cPowerM = 300.0..1000.0,
                    cPowerV = 600.0..1000.0,
                    cPowerCost = 0.0..0.3
                ),
                Battery(
                    name = "Геостационарная орбита",
                    cRatio = 0.1..0.5,
                    cEnergyM = 100.0..1000.0,
                    cEnergyV = 200.0..1000.0,
                    cEnergyCost = 0.0..500.0,
                    cPowerM = 200.0..1000.0,
                    cPowerV = 400.0..1000.0,
                    cPowerCost = 0.0..1000.0
                ),
                Battery(
                    name = "солнечно стационарная орбита",
                    cRatio = 0.1..0.5,
                    cEnergyM = 100.0..250.0,
                    cEnergyV = 200.0..600.0,
                    cEnergyCost = 10.0..50.0,
                    cPowerM = 100.0..500.0,
                    cPowerV = 200.0..1000.0,
                    cPowerCost = 10.0..50.0
                ),
                Battery(
                    name = "Импульсный характер разряда",
                    cRatio = 1.0..5.0,
                    cEnergyM = 30.0..250.0,
                    cEnergyV = 50.0..700.0,
                    cEnergyCost = 0.0..100.0,
                    cPowerM = 100.0..10000.0,
                    cPowerV = 200.0..20000.0,
                    cPowerCost = 0.0..100.0
                )
            )
        )
    }

    fun getBestBattery(
        energy: Double,
        power: Double,
        cost: Double,
        mass: Double,
        volume: Double,
        strength: Double,
        voltage: Double,
        application: Int
    ): Battery {
        val applicationBattery: Battery = applies[application]

        val cRatio = (strength * voltage) / energy

        val cEnergyM = energy / mass
        val cEnergyV = energy / volume
        val cEnergyCost = energy / cost

        val cPowerM = power / mass
        val cPowerV = power / volume
        val cPowerCost = power / cost

        val bestBattery =
            findBestBattery(applicationBattery, cRatio, cEnergyM, cEnergyV, cEnergyCost, cPowerM, cPowerV, cPowerCost)

        return bestBattery ?: batteries[0]
    }

    private fun findBestBattery(
        application: Battery,
        cRatio: Double,
        cEnergyM: Double,
        cEnergyV: Double,
        cEnergyCost: Double,
        cPowerM: Double,
        cPowerV: Double,
        cPowerCost: Double
    ): Battery? {
        if (batteries.isEmpty()) return null

        var bestBattery = batteries[0]
        var bestScore =
            calculateScore(
                bestBattery,
                application,
                cRatio,
                cEnergyM,
                cEnergyV,
                cEnergyCost,
                cPowerM,
                cPowerV,
                cPowerCost
            )

        for (battery in batteries) {
            val score =
                calculateScore(
                    battery,
                    application,
                    cRatio,
                    cEnergyM,
                    cEnergyV,
                    cEnergyCost,
                    cPowerM,
                    cPowerV,
                    cPowerCost
                )
            if (score > bestScore) {
                bestScore = score
                bestBattery = battery
            }
        }

        return bestBattery
    }

    private fun calculateScore(
        battery: Battery,
        application: Battery,
        cRatio: Double,
        cEnergyM: Double,
        cEnergyV: Double,
        cEnergyCost: Double,
        cPowerM: Double,
        cPowerV: Double,
        cPowerCost: Double
    ): Double {
        val cRatioScore =
            if (battery.cRatio.intersect(application.cRatio)?.contains(cRatio) == true) 1.0 else 0.0
        val energyMScore =
            if (battery.cEnergyM.intersect(application.cEnergyM)?.contains(cEnergyM) == true) 1.0 else 0.0
        val energyVScore =
            if (battery.cEnergyV.intersect(application.cEnergyV)?.contains(cEnergyV) == true) 1.0 else 0.0
        val energyCostScore =
            if (battery.cEnergyCost.intersect(application.cEnergyCost)?.contains(cEnergyCost) == true) 1.0 else 0.0
        val powerMScore = if (battery.cPowerM.intersect(application.cPowerM)?.contains(cPowerM) == true) 1.0 else 0.0
        val powerVScore = if (battery.cPowerV.intersect(application.cPowerV)?.contains(cPowerV) == true) 1.0 else 0.0
        val powerCostScore =
            if (battery.cPowerCost.intersect(application.cPowerCost)?.contains(cPowerCost) == true) 1.0 else 0.0

        return cRatioScore + energyMScore + energyVScore + energyCostScore + powerMScore + powerVScore + powerCostScore
    }
}