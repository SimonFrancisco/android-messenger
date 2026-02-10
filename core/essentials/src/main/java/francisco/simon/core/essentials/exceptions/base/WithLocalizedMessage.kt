package francisco.simon.core.essentials.exceptions.base

import francisco.simon.core.essentials.resources.StringProviderStore

interface WithLocalizedMessage{
    fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String
}