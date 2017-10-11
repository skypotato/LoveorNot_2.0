package org.skypotato.love_or_not;

import com.tsengvn.typekit.Typekit;

/**
 * Created by hunso on 2017-10-09.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Application에 폰트 적용
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/bmjua.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/bmjua.ttf"));
    }
}
