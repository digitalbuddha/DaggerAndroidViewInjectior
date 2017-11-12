package nyc.friendlyrobot.dagger.di

import android.view.View
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds

@Module
abstract class AndroidViewInjectionModule {
    @Multibinds
    abstract fun viewInjectorFactories(): @JvmSuppressWildcards Map<Class<out View>, @JvmSuppressWildcards AndroidInjector.Factory<out View>>
}