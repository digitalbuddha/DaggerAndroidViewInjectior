package nyc.friendlyrobot.dagger

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import nyc.friendlyrobot.dagger.di.DaggerAppComponent

class MyDaggerApplication : DaggerApplication() {
    override fun applicationInjector(): @JvmSuppressWildcards AndroidInjector<out DaggerApplication> =
       DaggerAppComponent.builder().application(this).build()
}