package francisco.simon.core.common.android

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import francisco.simon.core.essentials.exceptions.handler.ExceptionHandler
import francisco.simon.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import javax.inject.Inject

@ActivityRetainedScoped
class AndroidExceptionHandler @Inject constructor(
    private val exceptionToMessageMapper: ExceptionToMessageMapper
) : ExceptionHandler {

    private val errorMessageState = mutableStateOf<String?>(null)

    override fun handleException(exception: Exception) {
        val message = exceptionToMessageMapper.getLocalizedMessage(exception)
        errorMessageState.value = message
    }

    @Composable
    fun ErrorDialog() {
        errorMessageState.value?.let { message ->
            AlertDialog(
                onDismissRequest = { errorMessageState.value = null },
                confirmButton = {
                    TextButton(onClick = {
                        errorMessageState.value = null
                    }) {
                        Text(stringResource(R.string.ok))
                    }
                },
                title = {
                    Text(stringResource(R.string.error))
                },
                text = {
                    Text(message)
                }
            )
        }
    }

}