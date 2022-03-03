package xyz.jayeshseth.budgetmanager.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.budgetmanager.R
import com.example.budgetmanager.ui.components.InsetAwareTopBar
import com.example.budgetmanager.ui.components.UserInfoCard
import com.example.budgetmanager.ui.theme.BudgetManagerTheme
import com.google.accompanist.insets.navigationBarsPadding
import kotlinx.coroutines.launch

/**
 * A Stateful HomeScreen Which manages state using [produceUiState]
 */
//@Composable
//fun HomeScreenState(
//    openDrawer: () -> Unit,
//) {
//
//}

@ExperimentalAnimationApi
@Composable
fun HomeScreen(
    openDrawer: () -> Unit,
    navigateToAddBudget: () -> Unit,
    scaffoldState: ScaffoldState
) {
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,

        // Replace it with InsetAwareTopBar // replace done :)
        topBar = {
            InsetAwareTopBar(
                title = {
                    Text(modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                        text = stringResource(R.string.app_name),
                        textAlign = TextAlign.Center,
                    )
                },
                navIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            openDrawer()
                        }
                    }) {
                        Icon(painter = painterResource(R.drawable.ic_wallet),
                            contentDescription = "nav menu icon",
                            Modifier.padding(8.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(R.drawable.ic_sort),
                            contentDescription = "sort icon",
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            AddFloatingActionButton(
                extended = true,
                modifier = Modifier
                    .navigationBarsPadding(bottom = true),
                onClick = navigateToAddBudget
            )
        }
    ) {
        UserInfoCard(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
        )
    }
}

@ExperimentalAnimationApi
@Composable
private fun AddFloatingActionButton(
    extended: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(painter = painterResource(R.drawable.ic_add_icon),
                contentDescription = "add icon",
                modifier = Modifier
                    .size(30.dp)
            )
            AnimatedVisibility(visible = extended) {
                Text(
                    text = "Add",
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showSystemUi = false)
@Composable
fun PreviewHome() {
    BudgetManagerTheme() {
        HomeScreen(
            openDrawer = {},
            navigateToAddBudget = {},
            scaffoldState = rememberScaffoldState()
        )
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun PreviewAddFab() {
    BudgetManagerTheme() {
        AddFloatingActionButton(extended = true,
        onClick = {},
        modifier = Modifier
            .navigationBarsPadding(bottom = true))
    }
}