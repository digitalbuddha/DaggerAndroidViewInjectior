package nyc.friendlyrobot.dagger.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import nyc.friendlyrobot.dagger.MyDaggerApplication
import javax.inject.Singleton

/**
 * This is a Dagger component. Refer to [MyDaggerApplication] for the list of Dagger components
 * used in this application.
 *
 *
 * Even though Dagger allows annotating a [Component] as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in [ ].
 * //[AndroidSupportInjectionModule]
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */
@Singleton
@Component(modules =

[(AppModule::class),
(ActivityBindingModule::class),
(AndroidSupportInjectionModule::class),
(AndroidViewInjectionModule::class)])
interface AppComponent : AndroidInjector<MyDaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyDaggerApplication>()
}

