package francisco.simon.features.init.domain

import francisco.simon.core.essentials.exceptions.AppException
import francisco.simon.core.essentials.exceptions.WithLocalizedMessage
import francisco.simon.core.essentials.resources.StringProviderStore

abstract class InitAppException(
    message: String,
    cause: Throwable? = null
) : AppException(message, cause), WithLocalizedMessage {

    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<InitStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String
}

class DeviceIsRootedException : InitAppException("Device is rooted"){

    override fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String {
        return stringProvider.deviceIsRootedErrorMessage
    }
}