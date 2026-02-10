package francisco.simon.features.init.domain.exception

import francisco.simon.features.init.domain.resources.InitStringProvider
import francisco.simon.features.init.domain.exception.base.InitAppException

class DeviceIsRootedException : InitAppException("Device is rooted"){

    override fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String {
        return stringProvider.deviceIsRootedErrorMessage
    }
}