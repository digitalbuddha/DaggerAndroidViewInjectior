package nyc.friendlyrobot.dagger.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import nyc.friendlyrobot.dagger.BuildConfig
import nyc.friendlyrobot.dagger.MyDaggerApplication
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    internal abstract fun bindContext(context: MyDaggerApplication): Context

    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        internal fun provideVersionCode(): Int = BuildConfig.VERSION_CODE
    }
}