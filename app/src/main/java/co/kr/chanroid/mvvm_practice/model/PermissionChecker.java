package co.kr.chanroid.mvvm_practice.model;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PermissionChecker {
    public static boolean request(Activity activity, int requestCode, String[] permissions) {
        ArrayList<String> requestList = new ArrayList<>();
        for (String permission : permissions) {
            int permissionCheck = ContextCompat.checkSelfPermission(activity, permission);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    // 이전에 요청된 적이 있으나 거부
                } else {
                    // 이전에 요청된 적이 없음
                    // 이전에 요청된 적이 있으나 다시 보지 않음을 선택하고 거부 (요청해도 화면에 표시되지 않음)
                }
                requestList.add(permission);
            }
        }

        if (requestList.size() > 0) {
            String[] requestPermissions = requestList.toArray(new String[0]);
            ActivityCompat.requestPermissions(activity, requestPermissions, requestCode);
            return true;
        } else {
            return false;
        }
    }

    public static String[] result(Activity activity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        ArrayList<String> explainList = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            String permission = permissions[i];
            int grantResult = grantResults[i];
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    // 권한이 필요한 이유에 대한 설명 필요
                } else {
                    // 다시 보지 않음을 선택
                }
                explainList.add(permission);
            }
        }

        return explainList.toArray(new String[0]);
    }
}
