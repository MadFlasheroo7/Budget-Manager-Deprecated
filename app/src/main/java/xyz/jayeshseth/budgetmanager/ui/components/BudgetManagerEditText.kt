package xyz.jayeshseth.budgetmanager.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.jayeshseth.budgetmanager.ui.theme.BudgetManagerTheme

/** Custom made Material TextField
 *
 * similar to Material TextField but themed according to app's theme
 */
@Composable
fun BudgetManagerEditText(
    shape: Shape,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    var value by remember {
        mutableStateOf("")
    }
    TextField(
        value = value,
        onValueChange = { newString ->
            value = newString
        },
        label = label,
        shape = shape,
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,

        /** Other optional methods include
         * enabled // When false TextField will not be editable nor be focusable
         * maxLines // Maximum amount of line allowed
         * interactionSource //
         * keyboardActions //
         * keyboardOptions //
         * leadingIcon //
         * trailingIcon //
         * placeholder // Text shown when text field is empty and in focus
         * readOnly // When true user can focus and copy text but not edit it
         * textStyle // Styling Text
         * visualTransformation // Visual Filter for password
         */
    )
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewBMEditText() {
    BudgetManagerTheme() {
        BudgetManagerEditText(
            label = {
                Text(text = "Text")
            },
            modifier = Modifier.padding(18.dp),
            shape = MaterialTheme.shapes.medium
        )
    }
}

