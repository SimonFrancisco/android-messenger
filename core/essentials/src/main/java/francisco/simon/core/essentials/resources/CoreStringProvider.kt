package francisco.simon.core.essentials.resources

interface CoreStringProvider : StringProvider {
    val connectionErrorMessage: String
    val unknownErrorMessage: String
    fun backendErrorMessage(code: Int, backendMessage: String): String
}