package francisco.simon.features.init.domain

import francisco.simon.core.essentials.resources.StringProvider

interface InitStringProvider : StringProvider {
    val deviceIsRootedErrorMessage: String
}