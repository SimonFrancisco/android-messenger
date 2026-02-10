package francisco.simon.init.presentation

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import francisco.simon.features.init.domain.InitStringProvider
import javax.inject.Inject

class InitStringProviderImpl @Inject constructor(
    @ApplicationContext context: Context
) : InitStringProvider {

    override val deviceIsRootedErrorMessage: String = context.getString(R.string.rooted_device_error)
}