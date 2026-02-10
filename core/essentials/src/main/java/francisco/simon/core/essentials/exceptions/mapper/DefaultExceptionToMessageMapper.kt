package francisco.simon.core.essentials.exceptions.mapper

import francisco.simon.core.essentials.exceptions.base.WithLocalizedMessage
import francisco.simon.core.essentials.resources.CoreStringProvider
import francisco.simon.core.essentials.resources.StringProviderStore
import javax.inject.Inject

class DefaultExceptionToMessageMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore
) : ExceptionToMessageMapper {

    override fun getLocalizedMessage(exception: Exception): String {
        return if (exception is WithLocalizedMessage) {
            exception.getLocalizedErrorMessage(stringProviderStore)
        } else {
            stringProviderStore<CoreStringProvider>().unknownErrorMessage
        }
    }

}