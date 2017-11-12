package nyc.friendlyrobot.dagger.ui

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

interface ViewWithActivity {
    // Using android-gradle-plugin 3.0, which has the desugar step for default methods on interfaces
    // https://android.googlesource.com/platform/frameworks/support/+/03e0f3daf3c97ee95cd78b2f07bc9c1be05d43db/v7/mediarouter/src/android/support/v7/app/MediaRouteButton.java#276

}


fun View.activity(): Activity? {
    var viewContext = context
    while (viewContext is ContextWrapper) {
        if (viewContext is Activity) {
            return viewContext
        }
        viewContext = (context as ContextWrapper).baseContext
    }
    throw IllegalStateException("Context does not stem from an activity: " + java.security.AccessController.getContext())

}