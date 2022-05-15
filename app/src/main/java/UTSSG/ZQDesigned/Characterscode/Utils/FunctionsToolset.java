package UTSSG.ZQDesigned.Characterscode.Utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class FunctionsToolset extends Activity {



    /**
     * 申请权限
     *
     * @param permissionName
     * @param requestCode
     */
    public void requestPermission(String permissionName, int requestCode) {
        if (this.checkSelfPermission(permissionName) != PackageManager.PERMISSION_GRANTED) {
            this.requestPermissions(new String[]{permissionName}, requestCode);
        }
    }

    /**
     * 判断是否有某个权限
     *
     * @param permission
     * @param activity
     * @return
     */
    public static boolean checkPermission(String permission, Activity activity) {
        int check = activity.getApplicationContext().checkCallingOrSelfPermission(permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * 判断是否安装了某个应用
     *
     * @param packageName
     * @return
     */
    public static boolean isInstalled(String packageName) {
        FunctionsToolset functionsToolset = new FunctionsToolset();
        try {
            functionsToolset.pm(packageName);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

    }

    void pm(String packageName) throws PackageManager.NameNotFoundException {
        getPackageManager().getPackageInfo(packageName, 0);
    }
}


