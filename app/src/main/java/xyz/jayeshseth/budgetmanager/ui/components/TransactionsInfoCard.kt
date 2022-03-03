package xyz.jayeshseth.budgetmanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.jayeshseth.budgetmanager.ui.theme.BudgetManagerTheme

@ExperimentalMaterialApi
@Composable
fun TransactionsInfoCard(
    title: String,
    totalExpenses: String,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 2.dp,
        onClick = onClick
    ) {
        Row {
            if (expanded) {
                Column() {
                    TransactionCardRowExpanded(title = title)
                    TransactionInfo()

                }
            } else {
                TransactionCardRow(
                    title = title,
                    totalExpenses = totalExpenses)
            }
        }
    }
}

@Composable
fun TransactionCardRow(
    title: String,
    totalExpenses: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
    ) {
        Icon(
            imageVector = Icons.Rounded.KeyboardArrowDown,
            contentDescription = "contentDescription",
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(4.dp)
                .align(CenterVertically)
                .weight(1f))
        Text(
            text = totalExpenses,
            modifier = Modifier.padding(4.dp))
    }
}

@Composable
fun TransactionCardRowExpanded(
    title: String,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
       Icon(
           imageVector = Icons.Rounded.KeyboardArrowUp,
           contentDescription = "contentDescription",
           modifier = Modifier.padding(4.dp)
       )

        Text(
            text = title,
            modifier = Modifier
                .padding(4.dp)
                .align(CenterVertically)
                .weight(1f))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.Edit,
                contentDescription = "Edit icon"
            )
        }
    }
}

@Composable
fun TransactionInfo() {
    Column(Modifier.padding(4.dp)) {
        Row {
            Expenses()
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            color = MaterialTheme.colors.onSurface,
            thickness = 4.dp,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
        )
        Text(text = "$ 500",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )
    }

}

@Composable
fun Expenses() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically,
    ) {
        Text("House Expenses",
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp))
        Text("$ 500",
            modifier = Modifier.padding(start = 4.dp))
    }
}

@ExperimentalMaterialApi
@Preview(showBackground =  true)
@Composable
fun PreviewTransactionInfoCard() {
    BudgetManagerTheme() {
        TransactionsInfoCard(
            title = "Title",
            totalExpenses = "$ 500",
            expanded = true,
            onClick = {}
        )
    }
}

@Preview(showBackground =  true)
@Composable
fun PreviewTransactionCardRow() {
    BudgetManagerTheme() {
        Surface() {
            TransactionCardRow(
                title = "Title",
                totalExpenses = "$ 500"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTransactionCardRowExpanded() {
    BudgetManagerTheme() {
        Surface() {
            TransactionCardRowExpanded(
                title = "Title"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTransactionInfo() {
    BudgetManagerTheme {
        Surface() {
            TransactionInfo()
        }
    }
}