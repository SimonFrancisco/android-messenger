package francisco.simon.core.common.android

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import francisco.simon.core.essentials.resources.CoreStringProvider
import javax.inject.Inject

class CoreStringProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : CoreStringProvider {

    override val connectionErrorMessage: String =
        context.getString(R.string.connection_error_message)

    override val unknownErrorMessage: String = context.getString(R.string.unknown_error_message)

    override fun backendErrorMessage(
        code: Int,
        backendMessage: String
    ): String = context.getString(R.string.backend_error_message, code, backendMessage)

}