package nyc.friendlyrobot.dagger.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import nyc.friendlyrobot.dagger.R
import nyc.friendlyrobot.dagger.di.view.ViewInjectorModule
import javax.inject.Inject


interface HasViewInjector {
    fun viewInjector(): DispatchingAndroidInjector<View>
    fun viewInjectorBuilder(): ViewInjectorModule.ViewSubcomponent.Builder
}

class MainActivity : DaggerAppCompatActivity(), HasViewInjector {
    @Inject lateinit var viewInjector: DispatchingAndroidInjector<View>

    @Inject lateinit var viewInjectorBuilder: ViewInjectorModule.ViewSubcomponent.Builder

    @Inject lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assert(context != null)
    }

    override fun viewInjectorBuilder(): ViewInjectorModule.ViewSubcomponent.Builder = viewInjectorBuilder
    override fun viewInjector(): DispatchingAndroidInjector<View> =viewInjector

}
