package nyc.friendlyrobot.dagger.di.view

import android.view.View
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import nyc.friendlyrobot.dagger.di.activity.ViewKey
import nyc.friendlyrobot.dagger.di.activity.ViewScoped
import nyc.friendlyrobot.dagger.ui.MainView
import nyc.friendlyrobot.dagger.ui.NestedView
import nyc.friendlyrobot.dagger.ui.NestedDaggerView


@Module(subcomponents = arrayOf(ViewInjectorModule.ViewSubcomponent::class,ViewInjectorModule.NestedViewInjectonViewComponent::class))
abstract class ViewInjectorModule {

     //creates a new subcomponent for each view
    @Binds
    @IntoMap
    @ViewKey(NestedDaggerView::class)
    internal abstract fun bindAndroidInjectorFactory(builder: NestedViewInjectonViewComponent.Builder)
            : AndroidInjector.Factory<out View>

    @Subcomponent(modules = arrayOf(NestedModule::class))
    @ViewScoped
    interface NestedViewInjectonViewComponent : AndroidInjector<NestedDaggerView> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<NestedDaggerView>()
    }
    
    //each view below will share same subcomponent 
    @ViewScoped
    @Subcomponent(modules =
    [(BundleModule::class)])
    abstract class ViewSubcomponent : AndroidInjector<View> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<View>()

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
