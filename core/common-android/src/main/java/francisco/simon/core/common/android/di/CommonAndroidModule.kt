package francisco.simon.core.common.android.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import francisco.simon.core.common.android.AndroidLogger
import francisco.simon.core.common.android.CoreStringProviderImpl
import francisco.simon.core.essentials.exceptions.mapper.DefaultExceptionToMessageMapper
import francisco.simon.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import francisco.simon.core.essentials.logger.Logger
import francisco.simon.core.essentials.resources.CoreStringProvider
import francisco.simon.core.essentials.resources.StringProvider

@Module
@InstallIn(SingletonComponent::class)
interface CommonAndroidModule {

    @Binds
    fun bindLogger(logger: AndroidLogger): Logger

    @Binds
    @IntoMap
    @ClassKey(CoreStringProvider::class)
    fun bindCoreStringProvider(
        impl: CoreStringProviderImpl
    ): StringProvider

    @Binds
    fun bindExceptionToMessageMapper(
        impl: DefaultExceptionToMessageMapper
    ):ExceptionToMessageMapper
}
