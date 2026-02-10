package francisco.simon.core.essentials.exceptions

import francisco.simon.core.essentials.resources.CoreStringProvider
import francisco.simon.core.essentials.resources.StringProviderStore

abstract class AppException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)


class UnknownException : AppException("Unknown exception")

abstract class CoreAppException(
    message: String,
    cause: Throwable? = null
) : AppException(message, cause), WithLocalizedMessage {

    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<CoreStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String
}

class ConnectionException(
    cause: Throwable? = null
) : CoreAppException("Network error", cause) {
    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.connectionErrorMessage
    }

}

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