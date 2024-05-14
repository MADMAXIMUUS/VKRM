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
import components.Input

@Composable
fun MainRoute(
    mainViewModel: MainViewModel
) {
    val state by mainViewModel.state.collectAsState()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MainScreen(
                state = state,
                onEnerInput = mainViewModel::onEnerInput,
                onPowerInput = mainViewModel::onPowerInput,
                onCostInput = mainViewModel::onCostInput,
                onMassInput = mainViewModel::onMassInput,
                onVolumeInput = mainViewModel::onVolumeInput
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    state: MainScreenState,
    onEnerInput: (String) -> Unit,
    onPowerInput: (String) -> Unit,
    onCostInput: (String) -> Unit,
    onMassInput: (String) -> Unit,
    onVolumeInput: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
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
                    text = "Энергоемкость",
                    style = MaterialTheme.typography.overline
                )
                Input(
                    value = state.ener,
                    onValueChange = onEnerInput,
                    placeholder = "00.00000"
                )
                if (state.enerError != null)
                    Text(
                        text = state.enerError,
                        style = MaterialTheme.typography.caption,
                        color = Color.Red
                    )
            }
            Column(
                modifier = Modifier.width(200.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Мощность",
                    style = MaterialTheme.typography.overline
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
                    text = "Цена",
                    style = MaterialTheme.typography.overline
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
                    text = "Масса",
                    style = MaterialTheme.typography.overline
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
                    text = "Объем",
                    style = MaterialTheme.typography.overline
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
    }
}