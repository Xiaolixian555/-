package cn.xlx.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PromptTool {
	public static void getPromptTool(String s) {
		JFrame pjframe = new JFrame("提示信息");    //创建窗体对象并赋标题参数
		pjframe.setSize(520,290);    //设置窗体大小
		pjframe.setBackground(Color.WHITE);    //设置背景颜色
		pjframe.setLocation(380,390);    //设置窗体显示位置
		pjframe.setLayout(null); //无布局
		
		JLabel jLabel = new JLabel(s);
		jLabel.setBounds(170, 18, 340, 80);  //标签大小和位置
		jLabel.setFont(new Font("宋体", 1, 20));  //设置字体
		jLabel.setForeground(Color.red);  //设置字体颜色
		
		JButton jButton = new JButton("确定"); //创建"确定"按钮
		jButton.setBounds(210, 150, 80, 40);  //按钮大小和位置
		jButton.setFont(new Font("宋体", 1, 18));  //设置字体
		jButton.setForeground(Color.black);  //设置字体颜色
		
		pjframe.add(jLabel);  //标签加入到界面
		pjframe.add(jButton);  //按钮加入界面
		pjframe.setVisible(true); //窗体显示
		
		//为确定按钮添加点击事件
		jButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				pjframe.setVisible(false); //窗体关闭
			}
		});
	}
}
