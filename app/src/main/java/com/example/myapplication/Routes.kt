sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Add : Routes("add")
    object Detail : Routes("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
    object Settings : Routes("settings")
}
