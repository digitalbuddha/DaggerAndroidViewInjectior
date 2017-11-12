package nyc.friendlyrobot.dagger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import nyc.friendlyrobot.dagger.ui.MainActivity

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class,MainViewInjectorModule::class))
    @ActivityScoped
    internal abstract fun mainActivity(): MainActivity

}
