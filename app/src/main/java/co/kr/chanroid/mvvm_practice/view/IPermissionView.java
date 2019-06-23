package co.kr.chanroid.mvvm_practice.view;

public interface IPermissionView {
    void permissionRequest(int requestCode, String[] permissions);
    void permissionExplain(String[] permissions);
}
