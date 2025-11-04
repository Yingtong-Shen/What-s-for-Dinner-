import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, viewModel: RecipeViewModel, id: Int) {
    // Retrieve the corresponding recipe from the ViewModel based on the passed-in id
    val recipe = viewModel.getRecipeById(id)

    // Scaffold provides the overall structure, including a top bar and a bottom navigation bar.
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                title = { Text("Recipe Details") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
        }
    ) { padding ->
        if (recipe != null) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                // Title (Bold and Large)
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Ingredients
                Text(
                    text = "Ingredients:",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = recipe.ingredients,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Step
                Text(
                    text = "Steps:",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = recipe.steps,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
