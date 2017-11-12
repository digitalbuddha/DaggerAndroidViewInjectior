package nyc.friendlyrobot.dagger.di.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nyc.friendlyrobot.dagger.di.view.ViewInjectorModule
import nyc.friendlyrobot.dagger.ui.MainActivity

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class, ViewInjectorModule::class))
    @ActivityScoped
    internal abstract fun mainActivity(): MainActivity

}
