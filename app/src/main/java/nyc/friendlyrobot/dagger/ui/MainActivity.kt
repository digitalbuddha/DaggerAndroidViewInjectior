package nyc.friendlyrobot.dagger.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import nyc.friendlyrobot.dagger.R
import javax.inject.Inject


internal interface HasViewInjector {
    fun viewInjector(): AndroidInjector<View>
}

class MainActivity : DaggerAppCompatActivity(), HasViewInjector {
    @Inject lateinit var viewInjector: DispatchingAndroidInjector<View>

    @Inject lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        assert(context != null)
    }

    override fun viewInjector(): AndroidInjector<View> = viewInjector
}
