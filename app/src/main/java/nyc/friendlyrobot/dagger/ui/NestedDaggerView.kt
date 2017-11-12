package nyc.friendlyrobot.dagger.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import javax.inject.Inject

class NestedDaggerView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    @Inject lateinit var name: String

    override fun onFinishInflate() {
        super.onFinishInflate()
        AndroidViewInjection.inject(this)
        assert(name.isNotEmpty())
    }
}