package nyc.friendlyrobot.dagger.di.view

import android.view.View
import dagger.Module
import dagger.Provides
import nyc.friendlyrobot.dagger.di.activity.ViewScoped

@Module
abstract class BundleModule {
//    @Binds abstract fun nestedView(view: View): NestedView

    @Module
    companion object {
        @Provides
        @JvmStatic
        @ViewScoped
        internal fun provideViewName(view: View): String = "hello"
    }
}

