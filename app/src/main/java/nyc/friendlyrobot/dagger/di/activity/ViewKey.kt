package nyc.friendlyrobot.dagger.di.activity

import android.view.View
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewKey(
        val value: KClass<out View>
)
