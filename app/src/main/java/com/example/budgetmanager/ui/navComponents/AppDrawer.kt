package com.example.budgetmanager.ui.navComponents

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgetmanager.R
import com.example.budgetmanager.ui.theme.BudgetManagerTheme

@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToAdd: () -> Unit,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(35.dp))
        BudgetManagerLogo(modifier = Modifier.padding(start = 16.dp))
        Divider(
            color = MaterialTheme.colors.onSurface.copy(0.5f),
            modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))
        )
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "home",
            isSelected = currentRoute == MainDestinations.HOME_ROUTE, // gib currentRoute == destination.route
            action = {
                closeDrawer()
            }
        )
        DrawerButton(
            icon = Icons.Rounded.Settings,
            label = "settings",
            isSelected = currentRoute == MainDestinations.ADD_BUDGET, // gib currentRoute == destination.route
            action = {
                navigateToAdd()
                closeDrawer()
            }
        )
    }
}

@Composable
fun BudgetManagerLogo(
    modifier: Modifier
) {
    Row(modifier = modifier) {
        Icon(
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = "App Logo",
            tint = MaterialTheme.colors.onSurface
        )
        Spacer(Modifier.width(8.dp))
        Box(modifier = Modifier.align(CenterVertically)) {
            Text(text = "Budget Manager",
                textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun DrawerButton(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colors

    val imageAlpha = if (isSelected) {
        1f
    } else {
        0.6f
    }

    val textIconColor = if (isSelected) {
        colors.onSurface
    } else {
        colors.onSurface.copy(0.6f)
    }

    val backgroundColor = if (isSelected) {
        colors.primary.copy(0.6f)
    } else {
        Color.Transparent
    }

    val surfaceModifier = modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
        .fillMaxWidth()

    Surface(
        modifier = surfaceModifier,
        color = backgroundColor,
        shape = MaterialTheme.shapes.small
    ) {
        TextButton(
            onClick = action,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = icon, // icon
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(textIconColor),
                    alpha = imageAlpha
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.body2,
                    color = textIconColor)
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppDrawer() {
    BudgetManagerTheme() {
        Surface() {
            AppDrawer(
                currentRoute = "",
                closeDrawer = {  },
                navigateToAdd = {}
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBudgetManagerLogo() {
    BudgetManagerLogo(
        modifier = Modifier.padding(start = 16.dp)
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDrawerButton() {
    BudgetManagerTheme() {
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "Home",
            isSelected = true,
            action = {}
        )
    }
}