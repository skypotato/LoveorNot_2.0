package org.skypotato.love_or_not;

import android.os.SystemClock;
import android.view.View;

/**
 * Created by hunso on 2018-01-03.
 * 중복방지 OnClickListener()
 */

public abstract class OnSingleClickListener implements View.OnClickListener {
    private static final long MIN_CLICK_INTERVAL=600;

    private long mLastClickTime;

    public abstract void onSingleClick(View v);

    @Override
    public void onClick(View view) {
        long currentClickTime= SystemClock.uptimeMillis();
        long elapsedTime=currentClickTime-mLastClickTime;
        mLastClickTime=currentClickTime;

        if(elapsedTime<=MIN_CLICK_INTERVAL){
            return;
        }

        onSingleClick(view);
    }
}
