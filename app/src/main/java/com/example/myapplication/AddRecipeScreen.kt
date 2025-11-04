import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRecipeScreen(navController: NavHostController, viewModel: RecipeViewModel) {

    // Use remember to save the form state entered by the user.
    var title by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("") }
    var steps by remember { mutableStateOf("") }

    // Scaffold provides the overall structure
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                title = { Text("Add New Recipe") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->

        // Use a column layout to place input forms and buttons
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            // Recipe title input box
            OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
            Spacer(modifier = Modifier.height(8.dp))
            // Ingredient input box
            OutlinedTextField(value = ingredients, onValueChange = { ingredients = it }, label = { Text("Ingredients") })
            Spacer(modifier = Modifier.height(8.dp))
            // Step input box
            OutlinedTextField(value = steps, onValueChange = { steps = it }, label = { Text("Steps") })
            Spacer(modifier = Modifier.height(16.dp))

            // Save button: Clicking this will create a new recipe and take you to the details page.
            Button(
                onClick = {
                    if (title.isNotBlank()) {
                        val newRecipe = viewModel.addRecipe(title, ingredients, steps)
                        navController.navigate(Routes.Detail.createRoute(newRecipe.id)) {
                            popUpTo(Routes.Home.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save & View Recipe")
            }

        }
    }
}
