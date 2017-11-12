package nyc.friendlyrobot.dagger.di

import android.app.Application
import android.view.View
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import nyc.friendlyrobot.dagger.ui.MainView
import nyc.friendlyrobot.dagger.ui.NestedView

@Module(subcomponents = arrayOf(MainViewInjectorModule.MainViewSubcomponent::class))
abstract class MainViewInjectorModule {

//    @Binds
//    @IntoMap
//    @ViewKey(MainView::class)
//    internal abstract fun bindAndroidInjectorFactory(builder: MainViewSubcomponent.Builder)
//            : AndroidInjector.Factory<out View>

    @Subcomponent
    abstract class MainViewSubcomponent : AndroidInjector<View> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<View>(){
            override fun seedInstance(instance: View?) {
                TODO("implement module") //To change body of created functions use File | Settings | File Templates.
            }
        }

        override fun inject(view: View?) {
            when (view) {
                is MainView -> inject(view)
                is NestedView -> inject(view)
                else -> throw IllegalArgumentException()
            }
        }

        abstract fun inject(red: MainView)
        abstract fun inject(blue: NestedView)
    }
}