import android.view.View
import nyc.friendlyrobot.dagger.ui.HasViewInjector

class AndroidViewInjection {

    companion object {
        fun inject(view: View) {
            val hasViewInjector = findHasViewInjector(view)
            val viewInjector = hasViewInjector.viewInjector()
            viewInjector.inject(view)
        }

        private fun findHasViewInjector(view: View): HasViewInjector {
            val context = view.context

            if (context is HasViewInjector) {
                return context
            }

            context.applicationContext.let {
                if (it is HasViewInjector) {
                    return it
                }
            }
            throw IllegalAccessException("No injector was found for $view")
        }
    }
}