package xyz.jayeshseth.budgetmanager

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import xyz.jayeshseth.budgetmanager.ui.navComponents.AppDrawer
import xyz.jayeshseth.budgetmanager.ui.navComponents.BudgetManagerNavGraph
import xyz.jayeshseth.budgetmanager.ui.navComponents.MainDestinations
import xyz.jayeshseth.budgetmanager.ui.theme.BudgetManagerTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun BudgetManagerApp() {
    BudgetManagerTheme {
        ProvideWindowInsets {
//            val darkTheme = isSystemInDarkTheme()
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
            }

            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()
            /** This Scaffold Contains the app drawer,
             * which needs to accessible form multiple screens
             * An event is passed to open the Drawer each time
             * the screen needs it
             */
            val scaffoldState = rememberScaffoldState()

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_ROUTE
            Scaffold(
                scaffoldState = scaffoldState,
                drawerContent = {
                    AppDrawer(
                        currentRoute = currentRoute,
                        navigateToAdd = {
                            navController.navigate(MainDestinations.ADD_BUDGET)
                        },
                        closeDrawer = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    )
                }
            ) {
                BudgetManagerNavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}

//systemUiController.setNavigationBarColor(
//color = if (darkTheme) {
//    DarkGrey700
//} else {
//    DarkBlue500
//}
//)