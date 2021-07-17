package com.example.budgetmanager.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgetmanager.R
import com.example.budgetmanager.ui.components.BudgetManagerEditText
import com.example.budgetmanager.ui.components.InsetAwareTopBar
import com.example.budgetmanager.ui.theme.BudgetManagerTheme

@Composable
fun AddBudget(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            InsetAwareTopBar(
                title = {
                    Text(
                        text = "Add Budget",
                        modifier = Modifier
                            .fillMaxWidth(0.56f),
                        textAlign = TextAlign.Right,
                    )
                },
                navIcon = {
                    IconButton(onClick = onBack ) {
                        Icon(imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "navigate back icon"
                        )
                    }
                }
            )
        }
    ) {
        Column() {
            BudgetManagerEditText(
                shape = MaterialTheme.shapes.small,
                label = {
                    Text(
                        text = "Title")
                },
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAddBudget() {
    BudgetManagerTheme {
        AddBudget(
            onBack = {}
        )
    }
}