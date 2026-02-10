package francisco.simon.features.init.domain.exception.base

import francisco.simon.core.essentials.exceptions.base.AppException
import francisco.simon.core.essentials.exceptions.base.WithLocalizedMessage
import francisco.simon.core.essentials.resources.StringProviderStore
import francisco.simon.features.init.domain.resources.InitStringProvider

abstract class InitAppException(
    message: String,
    cause: Throwable? = null
) : AppException(message, cause), WithLocalizedMessage {

    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<InitStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String
}