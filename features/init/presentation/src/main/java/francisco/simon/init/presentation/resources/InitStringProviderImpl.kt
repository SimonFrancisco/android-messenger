package francisco.simon.init.presentation.resources

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import francisco.simon.features.init.domain.resources.InitStringProvider
import francisco.simon.init.presentation.R
import javax.inject.Inject

class InitStringProviderImpl @Inject constructor(
    @ApplicationContext context: Context
) : InitStringProvider {

    override val deviceIsRootedErrorMessage: String = context.getString(R.string.rooted_device_error)
}