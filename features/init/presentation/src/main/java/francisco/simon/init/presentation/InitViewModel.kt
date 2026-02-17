package francisco.simon.init.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elveum.container.Container
import com.elveum.container.map
import dagger.hilt.android.lifecycle.HiltViewModel
import francisco.simon.core.essentials.exceptions.handler.ExceptionHandler
import francisco.simon.features.init.domain.entities.KeyFeature
import francisco.simon.features.init.domain.usecase.GetKeyFeatureUseCase
import francisco.simon.features.init.domain.usecase.IsAuthorizedUseCase
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(
    getKeyFeatureUseCase: GetKeyFeatureUseCase,
    private val isAuthorizedUseCase: IsAuthorizedUseCase,
    private val exceptionHandler: ExceptionHandler
) : ViewModel() {

    private val vmStateFlow = MutableStateFlow(ViewModelState())

    val stateFlow: StateFlow<Container<State>> = combine(
        getKeyFeatureUseCase(),
        vmStateFlow
    ) { container, vmState ->
        container.map { keyFeature ->
            State(keyFeature, vmState.isCheckedAuthInProgress)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(1000L),
        initialValue = Container.Pending
    )


    fun letsGo() {
        viewModelScope.launch {
            try {
                showProgress()
                val isAuthorized = isAuthorizedUseCase()
                if (isAuthorized) {
                    // main flow
                } else {
                    // sign in flow
                }
            } catch (e: Exception) {
                ensureActive()
                hideProgress()
                exceptionHandler.handleException(e)
            }
        }
    }

    private fun hideProgress() {
        vmStateFlow.update {
            it.copy(isCheckedAuthInProgress = false)
        }
    }

    private fun showProgress() {
        vmStateFlow.update {
            it.copy(isCheckedAuthInProgress = true)
        }
    }

    data class State(
        val keyFeature: KeyFeature,
        val isCheckedAuthInProgress: Boolean
    )

    private data class ViewModelState(
        val isCheckedAuthInProgress: Boolean = false
    )

}