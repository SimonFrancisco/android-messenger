package francisco.simon.core.essentials.exceptions.base

import francisco.simon.core.essentials.resources.CoreStringProvider
import francisco.simon.core.essentials.resources.StringProviderStore

abstract class CoreAppException(
    message: String,
    cause: Throwable? = null
) : AppException(message, cause), WithLocalizedMessage {

    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<CoreStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String
}