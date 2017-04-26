package xu.qiwei.com.todomvvmtest.blueprint.interfaces;

import java.util.List;

import xu.qiwei.com.todomvvmtest.blueprint.models.BlueDivice;

/**
 * Created by xuqiwei on 17-4-26.
 */

public interface BlueToothListener {
    public void devicesListCallBack(List<BlueDivice> blueDivices);
}
