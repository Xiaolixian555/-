package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.xlx.operator.entity.Operators;

public class OwnerAddTypeUI {
	// 选择增加业主的方式界面
	public static void getOwnerAddTypeUI(Operators operators) {
		JFrame jfOAT = new JFrame("添加业主方式");
		jfOAT.setSize(740, 570); // 设置窗体大小
		jfOAT.setBackground(Color.WHITE); // 设置背景颜色
		jfOAT.setLocation(300, 200); // 设置窗体显示位置
		jfOAT.setLayout(null); // 无布局
		
		JLabel jltitle = new JLabel("添加业主方式");
		jltitle.setBounds(260, 20, 300, 100); // 标签大小和位置
		jltitle.setFont(new Font("楷体", 1, 32)); // 设置字体
		jltitle.setForeground(Color.black); // 设置字体颜色
		
		JButton jbsingle = new JButton("单个添加");
		jbsingle.setBounds(210, 160, 300, 50); // 标签大小和位置
		jbsingle.setFont(new Font("宋体", 1, 24)); // 设置字体
		jbsingle.setForeground(Color.blue); // 设置字体颜色

		JButton jbgroup = new JButton("批量添加");
		jbgroup.setBounds(210, 270, 300, 50); // 标签大小和位置
		jbgroup.setFont(new Font("宋体", 1, 24)); // 设置字体
		jbgroup.setForeground(Color.blue); // 设置字体颜色
		
		JButton jback = new JButton("返回上一层");
		jback.setBounds(210, 380, 300, 50); // 标签大小和位置
		jback.setFont(new Font("宋体", 1, 24)); // 设置字体
		jback.setForeground(Color.black); // 设置字体颜色

		//加载所有组件
		jfOAT.add(jltitle);
		jfOAT.add(jbsingle);
		jfOAT.add(jbgroup);
		jfOAT.add(jback);
		
		//为"单个添加"按钮添加点击事件
		jbsingle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				AddSingleUI.getOwnerAddUI(operators);
				jfOAT.setVisible(false);
			}
		});
		//为"批量添加"按钮添加点击事件
		jbgroup.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddGroupUI.getAddGroupUI(operators);
				jfOAT.setVisible(false);
			}
		});
		
		//为"返回上一层"按钮添加点击事件
		jback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OManageUI.getOMangeUI(operators);
				jfOAT.setVisible(false);		
			}
		});
		
		
		jfOAT.setVisible(true);
	}
}
