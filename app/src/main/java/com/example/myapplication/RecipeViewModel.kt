import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecipeViewModel : ViewModel() {
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    private var nextId = 1

    fun addRecipe(title: String, ingredients: String, steps: String): Recipe {
        val newRecipe = Recipe(nextId++, title, ingredients, steps)
        _recipes.value = _recipes.value + newRecipe
        return newRecipe   // ✅ 必须返回新建的 Recipe
    }
    fun getRecipeById(id: Int): Recipe? {
        return _recipes.value.find { it.id == id }
    }
}
