package francisco.simon.features.init.domain.usecase

import francisco.simon.core.essentials.exceptions.ConnectionException
import kotlinx.coroutines.delay
import javax.inject.Inject

// todo!
class IsAuthorizedUseCase @Inject constructor() {

    suspend operator fun invoke(): Boolean{
        delay(2000)
        throw ConnectionException()
    }
}