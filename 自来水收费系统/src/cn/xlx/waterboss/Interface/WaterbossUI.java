package cn.xlx.waterboss.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.xlx.waterboss.entity.Owners;

public class WaterbossUI {
	public static void getWaterbossUI(Owners owners) {
		JFrame wjframe = new JFrame("业主界面"); // 创建窗体对象并赋标题参数
		wjframe.setSize(740, 700); // 设置窗体大小
		wjframe.setBackground(Color.WHITE); // 设置背景颜色
		wjframe.setLocation(300, 200); // 设置窗体显示位置
		wjframe.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("您好，" + owners.getName());
		jLabel.setBounds(250, 30, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(Color.blue); // 设置字体颜色

		JButton jpersonal = new JButton("个人中心"); // 创建"个人中心"按钮
		jpersonal.setBounds(60, 250, 600, 70); // 按钮大小和位置
		jpersonal.setFont(new Font("宋体", 1, 22)); // 设置字体
		jpersonal.setForeground(Color.RED); // 设置字体颜色

		JButton jbill = new JButton("查询账单"); // 创建"查询账单"按钮
		jbill.setBounds(60, 400, 600, 70); // 按钮大小和位置
		jbill.setFont(new Font("宋体", 1, 22)); // 设置字体
		jbill.setForeground(Color.magenta); // 设置字体颜色

		wjframe.add(jLabel); // 标签加入到界面
		wjframe.add(jpersonal); // 按钮加入到界面
		wjframe.add(jbill); // 按钮加入到界面
		wjframe.setVisible(true); // 显示窗体

		// 为"个人中心"按钮设置点击事件
		jpersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WPersonalUI.getWPersonalUI(owners);
				wjframe.setVisible(false); // 关闭窗体
			}
		});

		// 为"查询账单"按钮设置点击事件
		jbill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WBillUI.getBillUI(owners);
				wjframe.setVisible(false); // 关闭窗体
			}
		});

	}

}
