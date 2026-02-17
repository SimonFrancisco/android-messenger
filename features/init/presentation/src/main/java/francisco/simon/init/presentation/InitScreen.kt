package francisco.simon.init.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.elveum.container.Container
import francisco.simon.core.theme.Dimens
import francisco.simon.core.theme.MediumVerticalSpace
import francisco.simon.core.theme.components.ContainerView
import francisco.simon.core.theme.components.ProgressButton
import francisco.simon.features.init.domain.entities.KeyFeature
import francisco.simon.init.presentation.InitViewModel.State

@Composable
fun InitScreen() {
    val viewModel: InitViewModel = hiltViewModel()
    val container: Container<State> by viewModel.stateFlow.collectAsStateWithLifecycle()

    ContainerView(
        container = container,
        modifier = Modifier.fillMaxSize()
    ) { state ->
        InitContent(state = state,
            onLetsGoAction = viewModel::letsGo)
    }
}

@Composable
fun InitContent(
    state: State,
    onLetsGoAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val keyFeature = state.keyFeature
        Text(
            text = keyFeature.title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        MediumVerticalSpace()
        Text(
            text = keyFeature.description,
            textAlign = TextAlign.Center
        )
        MediumVerticalSpace()
        ProgressButton(
            isInProgress = state.isCheckedAuthInProgress,
            text = stringResource(R.string.let_s_go),
            onClick = onLetsGoAction
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InitContentPreview() {
    InitContent(
        State(
            KeyFeature(
                0L,
                LoremIpsum(5).values.joinToString(),
                description = LoremIpsum(30).values.joinToString()
            ),
            isCheckedAuthInProgress = false
        ),
        onLetsGoAction = {}
    )
}