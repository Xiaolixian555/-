package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddSuccessPrompt {
	public static void getAddSuccessPrompt() {
		JFrame addpjframe = new JFrame("结果提示");    //创建窗体对象并赋标题参数
		addpjframe.setSize(520,290);    //设置窗体大小
		addpjframe.setBackground(Color.WHITE);    //设置背景颜色
		addpjframe.setLocation(350,400);    //设置窗体显示位置
		addpjframe.setLayout(null); //无布局
		
		JLabel jLabel = new JLabel("添加成功！");
		jLabel.setBounds(200, 18, 340, 80);  //标签大小和位置
		jLabel.setFont(new Font("宋体", 1, 20));  //设置字体
		jLabel.setForeground(Color.blue);  //设置字体颜色
		
		JButton jButton = new JButton("确定"); //创建"确定"按钮
		jButton.setBounds(210, 150, 80, 40);  //按钮大小和位置
		jButton.setFont(new Font("宋体", 1, 18));  //设置字体
		jButton.setForeground(Color.black);  //设置字体颜色
		
		addpjframe.add(jLabel);  //标签加入到界面
		addpjframe.add(jButton);  //按钮加入界面
		addpjframe.setVisible(true); //窗体显示
		
		//为确定按钮添加点击事件
		jButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				addpjframe.setVisible(false); //窗体关闭
			}
		});
	}
}
