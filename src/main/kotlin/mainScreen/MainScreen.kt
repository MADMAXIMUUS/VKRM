package mainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.Button
import components.Input
import components.Select

@Composable
fun MainRoute(
    mainViewModel: MainViewModel
) {
    val state by mainViewModel.state.collectAsState()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MainScreen(
                state = state,
                onEnergyInput = mainViewModel::onEnergyInput,
                onPowerInput = mainViewModel::onPowerInput,
                onCostInput = mainViewModel::onCostInput,
                onMassInput = mainViewModel::onMassInput,
                onVolumeInput = mainViewModel::onVolumeInput,
                onSelectedChange = mainViewModel::onSelectedChange,
                onButtonClick = mainViewModel::check
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    state: MainScreenState,
    onEnergyInput: (String) -> Unit,
    onPowerInput: (String) -> Unit,
    onCostInput: (String) -> Unit,
    onMassInput: (String) -> Unit,
    onVolumeInput: (String) -> Unit,
    onSelectedChange: (String, Int) -> Unit,
    onButtonClick: ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(
                modifier = Modifier.width(200.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Энергоемкость, Втч",
                    style = MaterialTheme.typography.caption
                )
                Input(
                    value = state.energy,
                    onValueChange = onEnergyInput,
                    placeholder = "00.00000"
                )
                if (state.energyError != null)
                    Text(
                        text = state.energyError,
                        style = MaterialTheme.typography.caption,
                        color = Color.Red
                    )
            }
            Column(
                modifier = Modifier.width(200.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Мощность, Вт",
                    style = MaterialTheme.typography.caption
                )
                Input(
                    value = state.power,
                    onValueChange = onPowerInput,
                    placeholder = "00.00000"
                )
                if (state.powerError != null)
                    Text(
                        text = state.powerError,
                        style = MaterialTheme.typography.caption,
                        color = Color.Red
                    )
            }
            Column(
                modifier = Modifier.width(200.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Цена, Руб",
                    style = MaterialTheme.typography.caption
                )
                Input(
                    value = state.cost,
                    onValueChange = onCostInput,
                    placeholder = "00.00000"
                )
                if (state.costError != null)
                    Text(
                        text = state.costError,
                        style = MaterialTheme.typography.caption,
                        color = Color.Red
                    )
            }
            Column(
                modifier = Modifier.width(200.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Масса, Кг",
                    style = MaterialTheme.typography.caption
                )
                Input(
                    value = state.mass,
                    onValueChange = onMassInput,
                    placeholder = "00.00000"
                )
                if (state.massError != null)
                    Text(
                        text = state.massError,
                        style = MaterialTheme.typography.caption,
                        color = Color.Red
                    )
            }
            Column(
                modifier = Modifier.width(200.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Объем, дм3",
                    style = MaterialTheme.typography.caption
                )
                Input(
                    value = state.volume,
                    onValueChange = onVolumeInput,
                    placeholder = "00.00000"
                )
                if (state.volumeError != null)
                    Text(
                        text = state.volumeError,
                        style = MaterialTheme.typography.caption,
                        color = Color.Red
                    )
            }
        }
        Column(
            modifier = Modifier.width(412.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Выберите область применения",
                style = MaterialTheme.typography.caption
            )
            Select(
                selected = state.selectedType,
                values = state.types,
                onSelectedChange = onSelectedChange
            )
        }
        Button(
            title = "Расчитать",
            onClick = onButtonClick
        )
        Text(
            text = state.result,
            style = MaterialTheme.typography.h1
        )
    }
}