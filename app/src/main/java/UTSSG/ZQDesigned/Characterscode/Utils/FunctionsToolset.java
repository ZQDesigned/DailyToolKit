package UTSSG.ZQDesigned.Characterscode.Utils;

import android.app.Activity;
import android.content.pm.PackageManager;

public class FunctionsToolset {



    /**
     * 申请权限
     *
     * @param permissionName
     * @param requestCode
     */
    public static void requestPermission(Activity activity,String permissionName, int requestCode) {
        if (activity.checkSelfPermission(permissionName) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{permissionName}, requestCode);
        }
    }

    /**
     * 判断是否有某个权限
     *
     * @param permissionName
     * @param activity
     * @return
     */
    public static boolean checkPermission(Activity activity, String permissionName) {
        int check = activity.getApplicationContext().checkCallingOrSelfPermission(permissionName);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * 判断是否安装了某个应用
     *
     * @param packageName
     * @return
     */
    public static boolean isInstalled(Activity activity,String packageName) {
        FunctionsToolset functionsToolset = new FunctionsToolset();
        try {
            functionsToolset.pm(activity,packageName);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

    }

    void pm(Activity activity,String packageName) throws PackageManager.NameNotFoundException {
        activity.getPackageManager().getPackageInfo(packageName, 0);
    }

    /**
     * 设置状态栏颜色
     *
     * @param activity
     * @param color
     */
    public static void setStatusBarColor(Activity activity,int color) {
        activity.getWindow().setStatusBarColor(color);
    }
}


