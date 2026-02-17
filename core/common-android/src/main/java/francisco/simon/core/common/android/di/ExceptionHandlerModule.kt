package francisco.simon.core.common.android.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import francisco.simon.core.common.android.AndroidExceptionHandler
import francisco.simon.core.essentials.exceptions.handler.ExceptionHandler

@Module
@InstallIn(ActivityRetainedComponent::class)
interface ExceptionHandlerModule {

    @Binds
    fun bindExceptionHandler(
        impl: AndroidExceptionHandler
    ): ExceptionHandler
}