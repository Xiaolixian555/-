package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.xlx.operator.entity.Operators;

public class OManageUI {
	// 业主管理界面
	public static void getOMangeUI(Operators operators) {
		JFrame omjframe = new JFrame("业主管理界面"); // 创建窗体对象并赋标题参数
		omjframe.setSize(740, 700); // 设置窗体大小
		omjframe.setBackground(Color.WHITE); // 设置背景颜色
		omjframe.setLocation(300, 200); // 设置窗体显示位置
		omjframe.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("业主管理界面");
		jLabel.setBounds(250, 30, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(Color.black); // 设置字体颜色

		JButton JbAddO = new JButton("增加业主"); // 创建"增加业主"按钮
		JbAddO.setBounds(60, 200, 600, 50); // 按钮大小和位置
		JbAddO.setFont(new Font("宋体", 1, 22)); // 设置字体
		JbAddO.setForeground(Color.RED); // 设置字体颜色

		JButton JbDeleteO = new JButton("删除业主"); // 创建"删除业主"按钮
		JbDeleteO.setBounds(60, 300, 600, 50); // 按钮大小和位置
		JbDeleteO.setFont(new Font("宋体", 1, 22)); // 设置字体
		JbDeleteO.setForeground(Color.magenta); // 设置字体颜色
		
		JButton JbUpdate = new JButton("修改业主及其账务"); // 创建"修改业主及其账务"按钮
		JbUpdate.setBounds(60, 400, 600, 50); // 按钮大小和位置
		JbUpdate.setFont(new Font("宋体", 1, 22)); // 设置字体
		JbUpdate.setForeground(Color.blue); // 设置字体颜色

		JButton Jbback = new JButton("返回上一层"); // 创建"返回上一层"按钮
		Jbback.setBounds(60, 500, 600, 50); // 按钮大小和位置
		Jbback.setFont(new Font("宋体", 1, 22)); // 设置字体
		Jbback.setForeground(Color.black); // 设置字体颜色

		omjframe.add(jLabel); // 标签加入到界面
		omjframe.add(JbAddO); // 按钮加入到界面
		omjframe.add(JbDeleteO); // 按钮加入到界面
		omjframe.add(JbUpdate); // 按钮加入到界面
		omjframe.add(Jbback); // 按钮加入到界面
		omjframe.setVisible(true); // 显示窗体

		// 为"增加业主"按钮设置点击事件
		JbAddO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerAddTypeUI.getOwnerAddTypeUI(operators);
				omjframe.setVisible(false); // 关闭窗体
			}
		});

		// 为"删除业主"按钮设置点击事件
		JbDeleteO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteOwnerUI.getDeleteOwnerUI(operators);
				omjframe.setVisible(false); // 关闭窗体
			}
		});
		
		//为"修改业主"按钮设置点击事件
		JbUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessProcessingUI.getBusinessProcessingUI(operators);
				omjframe.setVisible(false); // 关闭窗体
			}
		});
		
		//为"返回上一层"按钮设置点击事件
		Jbback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorUI.getOperatorUI(operators);
				omjframe.setVisible(false); // 关闭窗体				
			}
		});
	}
}
