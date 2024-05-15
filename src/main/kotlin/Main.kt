import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import mainScreen.MainRoute
import mainScreen.MainScreen
import mainScreen.MainScreenState
import mainScreen.MainViewModel

@Composable
@Preview
fun MainScreenPreview() {
    MainScreen(
        state = MainScreenState(),
        onEnergyInput = {},
        onPowerInput = {},
        onCostInput = {},
        onMassInput = {},
        onVolumeInput = {},
        onSelectedChange = { _, _-> },
        onButtonClick = {}
    )
}

@Composable
fun App() {
    MainRoute(mainViewModel = MainViewModel())
}

fun main() = application {
    Window(
        state = WindowState(),
        title = "Подбор аккумулятора",
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
