package francisco.simon.features.init.domain.usecase

import com.elveum.container.Container
import com.elveum.container.subject.ContainerConfiguration
import com.elveum.container.subject.LazyFlowSubject
import francisco.simon.features.init.domain.entities.KeyFeature
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetKeyFeatureUseCase @Inject constructor() {

    operator fun invoke(): Flow<Container<KeyFeature>> {
        return LazyFlowSubject.create {
            delay(2000)
            //throw ConnectionException()
            emit(KeyFeature(1L, "Test", "Testing"))
        }.listen(ContainerConfiguration(emitReloadFunction = true))
    }
}