package cn.xlx.loginUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginErrorUI {
	public static void getLoginErrorUI() {
		JFrame ejframe = new JFrame("错误提示");    //创建窗体对象并赋标题参数
		ejframe.setSize(540,300);    //设置窗体大小
		ejframe.setBackground(Color.WHITE);    //设置背景颜色
		ejframe.setLocation(350,400);    //设置窗体显示位置
		ejframe.setLayout(null); //无布局
		
		JLabel jLabel = new JLabel("您输入的账号或密码有误，请重新输入！");
		jLabel.setBounds(90, 10, 540, 100);  //标签大小和位置
		jLabel.setFont(new Font("宋体", 1, 20));  //设置字体
		jLabel.setForeground(Color.red);  //设置字体颜色
		
		JButton jButton = new JButton("确定"); //创建"确定"按钮
		jButton.setBounds(210, 150, 80, 40);  //按钮大小和位置
		jButton.setFont(new Font("宋体", 1, 18));  //设置字体
		jButton.setForeground(Color.black);  //设置字体颜色
		
		ejframe.add(jLabel);  //标签加入到界面
		ejframe.add(jButton);  //按钮加入界面
		ejframe.setVisible(true); //窗体显示
		
		//为确定按钮添加点击事件
		jButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				ejframe.setVisible(false); //窗体关闭
			}
		});
	}
}
