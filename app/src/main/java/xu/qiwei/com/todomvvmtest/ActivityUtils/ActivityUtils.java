package xu.qiwei.com.todomvvmtest.ActivityUtils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by xuqiwei on 17-2-9.
 */

public class ActivityUtils {
    public static final void addFragmentToActivity(FragmentManager fragmentManager, int layoutID, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(layoutID, fragment);
        fragmentTransaction.commit();
    }

    public static final void addFragmentToActivity(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, String tag )
    {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment,tag);
        fragmentTransaction.commit();
    }
}
