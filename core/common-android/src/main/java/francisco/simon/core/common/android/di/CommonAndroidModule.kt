package francisco.simon.core.common.android.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import francisco.simon.core.common.android.AndroidLogger
import francisco.simon.core.essentials.logger.Logger

@Module
@InstallIn(SingletonComponent::class)
interface CommonAndroidModule {

    @Binds
    fun bingLogger(logger: AndroidLogger): Logger
}