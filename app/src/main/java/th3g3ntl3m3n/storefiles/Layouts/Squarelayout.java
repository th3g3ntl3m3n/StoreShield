package th3g3ntl3m3n.storefiles.Layouts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by th3g3ntl3m3n on 1/9/17.
 */

public class Squarelayout extends RelativeLayout {

    public Squarelayout(Context context) {
        super(context);
    }

    public Squarelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Squarelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Squarelayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Set a square layout.
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
    //https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/21107949_2396743220550344_8168901984514998272_n.jpg
}