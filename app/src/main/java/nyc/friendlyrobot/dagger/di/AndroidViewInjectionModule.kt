package nyc.friendlyrobot.dagger.di

import android.view.View
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds

@Module
abstract class AndroidViewInjectionModule {

    @Multibinds
    abstract fun viewInjectorFactories(): Map<Class<out View>, AndroidInjector.Factory<out View>>
}
