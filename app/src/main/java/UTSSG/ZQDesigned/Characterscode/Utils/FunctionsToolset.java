package UTSSG.ZQDesigned.Characterscode.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageManager;

public class FunctionsToolset {


    /**
     * 申请权限
     *
     * @param permissionName 权限名称
     * @param requestCode 请求码
     */
    public static void requestPermission(Activity activity, String permissionName, int requestCode) {
        if (activity.checkSelfPermission(permissionName) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{permissionName}, requestCode);
        }
    }

    /**
     * 判断是否有某个权限
     *
     * @param permissionName 权限名称
     * @param activity 当前活动
     * @return true 有权限，false 没有权限
     */
    public static boolean checkPermission(Activity activity, String permissionName) {
        int check = activity.getApplicationContext().checkCallingOrSelfPermission(permissionName);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * 判断是否安装了某个应用
     *
     * @param packageName 应用包名
     * @return true 安装了，false 没有安装
     */
    public static boolean isInstalled(Activity activity, String packageName) {
        FunctionsToolset functionsToolset = new FunctionsToolset();
        try {
            functionsToolset.pm(activity, packageName);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

    }

    void pm(Activity activity, String packageName) throws PackageManager.NameNotFoundException {
        activity.getPackageManager().getPackageInfo(packageName, 0);
    }

    /**
     * 设置状态栏颜色
     *
     * @param activity 当前活动
     * @param color 颜色值
     */
    public static void setStatusBarColor(Activity activity, int color) {
        activity.getWindow().setStatusBarColor(color);
    }

    /**
     * 弹出对话框
     *
     * @param activity 当前活动
     * @param title 标题
     * @param message 内容
     * @param positiveButton 按钮文字
     * @param icon 图标
     * @param cancelable 是否可以取消
     */
    public static void showDialog(Activity activity, String title, String message, String positiveButton,int icon,boolean cancelable) {
        new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButton, null)
                .setIcon(icon)
                .setCancelable(cancelable)
                .show();
    }
}


