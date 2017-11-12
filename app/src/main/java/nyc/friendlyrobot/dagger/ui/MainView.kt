package nyc.friendlyrobot.dagger.ui

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import javax.inject.Inject

class MainView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    @Inject lateinit var myContext:Context

    override fun onFinishInflate() {
        super.onFinishInflate()
        AndroidViewInjection.inject(this)
        assert(myContext!=null)
    }
}