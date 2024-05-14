package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.PopupProperties

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Select(
    selected: String,
    values: List<String>,
    onSelectedChange: (option: String, index: Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: String? = null,
    expanded: MutableState<Boolean> = remember { mutableStateOf(false) },
) {
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded.value,
        onExpandedChange = { expanded.value = !expanded.value }
    ) {
        Input(
            modifier = Modifier
                .fillMaxWidth(),
            value = selected,
            placeholder = placeholder,
            onValueChange = {},
            readOnly = true,
            enabled = enabled,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded.value
                )
            }
        )
        DropdownMenu(
            modifier = Modifier
                .exposedDropdownSize()
                .background(Color.White, MaterialTheme.shapes.large),
            expanded = expanded.value,
            properties = PopupProperties(clippingEnabled = false),
            onDismissRequest = { expanded.value = false }
        ) {
            values.forEachIndexed { index, item ->
                DropdownMenuItem(
                    onClick = {
                        onSelectedChange(item, index)
                        expanded.value = !expanded.value
                    }
                ) {
                    Text(text = item)
                }
            }
        }
    }
}