package xyz.jayeshseth.budgetmanager.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgetmanager.ui.components.BudgetManagerEditText
import com.example.budgetmanager.ui.components.InsetAwareTopBar
import com.example.budgetmanager.ui.theme.BudgetManagerTheme
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun AddBudget(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxHeight()
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
            },
        ) {
            Column(Modifier
                .padding(16.dp)) {
                BudgetManagerEditText(
                    shape = MaterialTheme.shapes.small,
                    label = {
                        Text(
                            text = "Title")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Column(modifier = Modifier.weight(1f)) {
                    
                }
                Column() {
                    Divider(
                        color = MaterialTheme.colors.onSurface,
                        thickness = 3.dp,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = "$ 500",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        textAlign = TextAlign.End
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .navigationBarsPadding(bottom = true)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(20.dp))
//                            .padding(bottom = 8.dp),
                            ,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.secondary
                        )
                    ) {
                        Text(
                            text = "Done",
                            Modifier.padding(8.dp)
                        )
                    }
                }
            }
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