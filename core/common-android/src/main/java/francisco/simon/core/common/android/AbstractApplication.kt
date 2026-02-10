package francisco.simon.core.common.android

import android.app.Application
import francisco.simon.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import francisco.simon.core.essentials.logger.Logger
import timber.log.Timber
import javax.inject.Inject

abstract class AbstractApplication: Application() {

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var exceptionToMessageMapper: ExceptionToMessageMapper

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Logger.set(logger)
        ExceptionToMessageMapper.set(exceptionToMessageMapper)
    }
}