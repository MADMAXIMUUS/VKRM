import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.textFiled.Button
import components.textFiled.Input

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val viewModel = remember { MainViewModel() }
    val state by viewModel.state.collectAsState()
    Input(
        modifier = Modifier.padding(100.dp),
        value = "",
        placeholder = "Enter value",
        onValueChange = {}
    )
    MaterialTheme {
        Button(
            modifier = Modifier.padding(10.dp),
            title = text,
            onClick = {
                text = "Hello, Desktop!"
            }
        )
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
