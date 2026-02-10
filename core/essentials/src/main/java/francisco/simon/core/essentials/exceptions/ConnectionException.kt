package francisco.simon.core.essentials.exceptions

import francisco.simon.core.essentials.exceptions.base.CoreAppException
import francisco.simon.core.essentials.resources.CoreStringProvider

class ConnectionException(
    cause: Throwable? = null
) : CoreAppException("Network error", cause) {
    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.connectionErrorMessage
    }
}