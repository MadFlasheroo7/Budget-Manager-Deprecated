package xyz.jayeshseth.budgetmanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserInfoCard(modifier: Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(IntrinsicSize.Min)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Text(text = "Your Income")
            Text(text = "$ 500")
        }
        RoundedDivider(Modifier.align(Alignment.CenterVertically))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 8.dp, start = 8.dp)
        ) {
            Text(text = "Your Expensus")
            Text(text = "$ 500")
        }
        RoundedDivider(Modifier.align(Alignment.CenterVertically))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 8.dp, start = 8.dp)
        ) {
            Text(text = "Balance")
            Text(text = "$ 0")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserInfoCard() {
    UserInfoCard(
        modifier = Modifier.padding(16.dp)
    )
}
