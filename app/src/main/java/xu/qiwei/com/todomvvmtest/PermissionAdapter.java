package xu.qiwei.com.todomvvmtest;

/**
 * LuoZheng on 2017/1/19 11:13<br />
 * Email : zheng.l@medicalsystem.cn <br />
 */

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

/**
 * Created by LuoZheng on 2016/8/23.
 */
public class PermissionAdapter {

    private static final int REQ_PERMISSION_CALENDAR = 0x1;
    private static final int REQ_PERMISSION_CAMERA = 0x2;
    private static final int REQ_PERMISSION_CONTACTS = 0x3;
    private static final int REQ_PERMISSION_LOCATION = 0x4;
    private static final int REQ_PERMISSION_MICROPHONE = 0x5;
    private static final int REQ_PERMISSION_PHONE = 0x6;
    private static final int REQ_PERMISSION_SENSORS = 0x7;
    private static final int REQ_PERMISSION_SMS = 0x8;
    private static final int REQ_PERMISSION_STORAGE = 0x9;

    private static PermissionAdapter instance;
    private PermissionVerifyCallBack permissionCallback;

    public static PermissionAdapter getInstance() {
        if (instance == null) {
            synchronized (PermissionAdapter.class) {
                instance = new PermissionAdapter();
            }
        }
        return instance;
    }

    private PermissionAdapter() {

    }

    /**
     * MICROPHONE
     *
     * @param activity
     * @param callback
     */
    public void microphone(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;
        String[] permissions = new String[]{Manifest.permission.RECORD_AUDIO};
        if (hasPermission(activity, permissions, REQ_PERMISSION_MICROPHONE)) {
            callback.onGet();
        }
    }

    /**
     * CAMERA
     *
     * @param activity
     * @param callback
     */
    public void camera(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;
        String[] permissions = new String[]{Manifest.permission.CAMERA};
        if (hasPermission(activity, permissions, REQ_PERMISSION_CAMERA)) {
            callback.onGet();
        }
    }

    /**
     * CONTACTS
     *
     * @param activity
     * @param callback
     */
    public void contacts(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;
        String[] permissions = new String[]{Manifest.permission.GET_ACCOUNTS, //
                Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS};
        if (hasPermission(activity, permissions, REQ_PERMISSION_CONTACTS)) {
            callback.onGet();
        }
    }

    /**
     * LOCATION
     *
     * @param activity
     * @param callback
     */
    public void location(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;
        String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        if (hasPermission(activity, permissions, REQ_PERMISSION_LOCATION)) {
            callback.onGet();
        }
    }

    /**
     * PHONE
     *
     * @param activity
     * @param callback
     */
    public void phone(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;

        String[] permissions = new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG,
                Manifest.permission.ADD_VOICEMAIL, Manifest.permission.USE_SIP,
                Manifest.permission.PROCESS_OUTGOING_CALLS};
        if (hasPermission(activity, permissions, REQ_PERMISSION_PHONE)) {
            callback.onGet();
        }

    }

    /**
     * STORAGE
     *
     * @param activity
     * @param callback
     */
    public void storage(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;

        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};
        if (hasPermission(activity, permissions, REQ_PERMISSION_STORAGE)) {
            callback.onGet();
        }
    }

    /**
     * SMS
     *
     * @param activity
     * @param callback
     */
    public void sms(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;
        String[] permissions = new String[]{Manifest.permission.SEND_SMS,
                Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS};
        if (hasPermission(activity, permissions, REQ_PERMISSION_SMS)) {
            callback.onGet();
        }
    }

    /**
     * CALENDAR
     *
     * @param activity
     * @param callback
     */
    public void calendar(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;
        String[] permissions = new String[]{Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR};
        if (hasPermission(activity, permissions, REQ_PERMISSION_CALENDAR)) {
            callback.onGet();
        }
    }

    /**
     * SENSORS
     *
     * @param activity
     * @param callback
     */
    public void sensors(Activity activity, PermissionVerifyCallBack callback) {
        this.permissionCallback = callback;
        String[] permissions = new String[]{Manifest.permission.BODY_SENSORS};
        if (hasPermission(activity, permissions, REQ_PERMISSION_SENSORS)) {
            callback.onGet();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQ_PERMISSION_SMS:
            case REQ_PERMISSION_STORAGE:
            case REQ_PERMISSION_PHONE:
            case REQ_PERMISSION_LOCATION:
            case REQ_PERMISSION_CONTACTS:
            case REQ_PERMISSION_CAMERA:
            case REQ_PERMISSION_MICROPHONE:
            case REQ_PERMISSION_CALENDAR:
            case REQ_PERMISSION_SENSORS:
                if (permissionCallback != null) {
                    if (verifyPermissions(grantResults)) {
                        permissionCallback.onGet();
                    } else {
                        permissionCallback.onLost();
                    }
                    permissionCallback = null;
                }
                break;
        }
    }

    /**
     * 对用户是否授权进行处理
     *
     * @param grantResults
     * @return
     */
    private boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if (grantResults.length < 1) {
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用来判断是否具有某些权限
     *
     * @param activity
     * @param permissions
     * @return
     */
    private boolean hasPermission(Activity activity, String[] permissions, int requestCode) {
        boolean hasPermisson = true;
//        for (String permission : permissions) {
//            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(activity, permissions, requestCode);
//                hasPermisson = false;
//                break;
//            }
//        }
        return hasPermisson;
    }
}
