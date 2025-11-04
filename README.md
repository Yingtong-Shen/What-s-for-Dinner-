# How I Used Artificial Intelligence in This Project

## 1. Project Planning and Function Design
I used AI (ChatGPT) to help me organize and list all necessary composable functions for this app. Each function’s responsibilities were clearly outlined by AI before I started coding.

## 2. Navigation Implementation Guidance
I wasn’t familiar with how to use NavHostController, NavHost, and the sealed class Routes structure in Compose navigation.
AI provided me with example code and explanations for how to Pass arguments using navigate(route + "/{id}")

## 3. Debugging and UI Refinement
After implementing the main logic, I used AI to help debug errors (for example, unresolved references and incorrect route setups).
I also asked for design advice — AI suggested improvements such as: Using Card and LazyColumn for better layout；Adjusting typography with MaterialTheme.typography；Adding consistent padding and Spacer() for spacing；

---

# Where AI Misunderstood Navigation Behavior

## 1. Incorrect parameter usage
AI initially suggested calling routes like Routes.Detail(id = recipe.id), but in Kotlin, you can’t use named parameters with custom functions like createRoute(id: Int); the correct call is Routes.Detail.createRoute(recipe.id).

## 2. Multiple ViewModel instances
Early AI examples placed viewModel() inside each screen, which caused state not to persist between pages. I later corrected this by declaring a shared RecipeViewModel in MainActivity and passing it to all composables.
