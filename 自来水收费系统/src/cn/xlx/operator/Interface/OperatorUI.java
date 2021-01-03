package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.xlx.operator.entity.Operators;


public class OperatorUI {
	// 管理员主界面
	public static void getOperatorUI(Operators operators) {
		JFrame ojframe = new JFrame("管理员界面"); // 创建窗体对象并赋标题参数
		ojframe.setSize(740, 700); // 设置窗体大小
		ojframe.setBackground(Color.WHITE); // 设置背景颜色
		ojframe.setLocation(300, 200); // 设置窗体显示位置
		ojframe.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("您好，" + operators.getName());
		jLabel.setBounds(250, 30, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(Color.black); // 设置字体颜色

		JButton JCPassword = new JButton("修改个人密码"); // 创建"修改个人密码"按钮
		JCPassword.setBounds(60, 200, 600, 50); // 按钮大小和位置
		JCPassword.setFont(new Font("宋体", 1, 22)); // 设置字体
		JCPassword.setForeground(Color.RED); // 设置字体颜色

		JButton JOwnerManagement = new JButton("业务工作"); // 创建"业务工作"按钮
		JOwnerManagement.setBounds(60, 300, 600, 50); // 按钮大小和位置
		JOwnerManagement.setFont(new Font("宋体", 1, 22)); // 设置字体
		JOwnerManagement.setForeground(Color.magenta); // 设置字体颜色
		
		JButton JBusinessWork = new JButton("查看所有业主"); // 创建"查看所有业主"按钮
		JBusinessWork.setBounds(60, 400, 600, 50); // 按钮大小和位置
		JBusinessWork.setFont(new Font("宋体", 1, 22)); // 设置字体
		JBusinessWork.setForeground(Color.blue); // 设置字体颜色


		ojframe.add(jLabel); // 标签加入到界面
		ojframe.add(JCPassword); // 按钮加入到界面
		ojframe.add(JOwnerManagement); // 按钮加入到界面
		ojframe.add(JBusinessWork); // 按钮加入到界面
		ojframe.setVisible(true); // 显示窗体

		// 为"修改个人密码"按钮设置点击事件
		JCPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OCPasswordUI.getOCPasswordUI(operators);
				ojframe.setVisible(false); // 关闭窗体
			}
		});

		// 为"业务工作"按钮设置点击事件
		JOwnerManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OManageUI.getOMangeUI(operators);//打开"业务工作"窗体		
				ojframe.setVisible(false); // 关闭原窗体
			}
		});
		
		// 为"查看所有业主"按钮设置点击事件
		JBusinessWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllOwnersUI.getViewAllOwnersUI(operators);
				ojframe.setVisible(false); // 关闭窗体
			}
		});
	}
}
