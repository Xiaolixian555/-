package cn.xlx.main;

import cn.xlx.loginUI.OperatorLoginUI;
import cn.xlx.loginUI.OwnerLoginUI;


public class Main {
    // 测试专用
    public static void main(String[] args) {
//        OwnerLoginUI.getOwnerUI(); //业主端（前台）
        OperatorLoginUI.getOperatorLogin();  //管理员端（后端）
    }

}
