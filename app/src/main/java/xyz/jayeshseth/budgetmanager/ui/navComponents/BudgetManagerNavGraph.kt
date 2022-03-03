package xyz.jayeshseth.budgetmanager.ui.navComponents

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.jayeshseth.budgetmanager.screens.AddBudget
import xyz.jayeshseth.budgetmanager.screens.HomeScreen
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun BudgetManagerNavGraph(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String = MainDestinations.HOME_ROUTE
) {
    val actions = remember(navController) {
        MainActions(navController)
    }
    val coroutineScope = rememberCoroutineScope()
    val openDrawer: () -> Unit = {
        coroutineScope.launch {
            scaffoldState.drawerState.open()
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            HomeScreen(
                openDrawer = openDrawer,
                scaffoldState = scaffoldState,
                navigateToAddBudget = actions.navigateToAddBudget
            )
        }
        composable(MainDestinations.ADD_BUDGET) {
            AddBudget(
                onBack = actions.upPress
            )
        }
    }

}

class MainActions(navController: NavHostController) {
    val navigateToAddBudget: () -> Unit = {
        navController.navigate(MainDestinations.ADD_BUDGET)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}