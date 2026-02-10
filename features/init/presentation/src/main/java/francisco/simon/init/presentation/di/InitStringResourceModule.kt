package francisco.simon.init.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import francisco.simon.core.essentials.resources.StringProvider
import francisco.simon.features.init.domain.InitStringProvider
import francisco.simon.init.presentation.InitStringProviderImpl

@Module
@InstallIn(SingletonComponent::class)
interface InitStringResourceModule {

    @Binds
    @IntoMap
    @ClassKey(InitStringProvider::class)
    fun bindInitStringProvider(
        impl: InitStringProviderImpl
    ): StringProvider

}