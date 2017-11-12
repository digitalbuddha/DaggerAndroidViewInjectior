package nyc.friendlyrobot.dagger.di.view

import dagger.Module
import dagger.Provides
import nyc.friendlyrobot.dagger.di.activity.ViewScoped
import nyc.friendlyrobot.dagger.ui.NestedDaggerView

@Module
abstract class NestedModule {
//    @Binds abstract fun nestedView(view: View): NestedView

    @Module
    companion object {
        @Provides
        @JvmStatic
        @ViewScoped
        internal fun provideViewName(view: NestedDaggerView): String = view.javaClass.name
    }
}