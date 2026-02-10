package francisco.simon.core.essentials.exceptions

import francisco.simon.core.essentials.exceptions.base.CoreAppException
import francisco.simon.core.essentials.resources.CoreStringProvider

class BackendException(
    val httpCode: Int = 400,
    val backendMessage: String = "Unknown backend error",
    cause: Throwable? = null
) : CoreAppException("Server error", cause) {
    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.backendErrorMessage(
            code = httpCode,
            backendMessage = backendMessage
        )
    }
}