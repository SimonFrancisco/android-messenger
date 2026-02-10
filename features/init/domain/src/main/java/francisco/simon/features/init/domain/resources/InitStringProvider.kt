package francisco.simon.features.init.domain.resources

import francisco.simon.core.essentials.resources.StringProvider

interface InitStringProvider : StringProvider {
    val deviceIsRootedErrorMessage: String
}