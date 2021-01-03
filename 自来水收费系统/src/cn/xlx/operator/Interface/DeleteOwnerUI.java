package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.PromptTool;

public class DeleteOwnerUI {
	public static void getDeleteOwnerUI(Operators operators) {
		JFrame deljframe = new JFrame("删除业主界面"); // 创建窗体对象并赋标题参数
		deljframe.setSize(740, 700); // 设置窗体大小
		deljframe.setBackground(Color.WHITE); // 设置背景颜色
		deljframe.setLocation(300, 200); // 设置窗体显示位置
		deljframe.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("删除业主界面");
		jLabel.setBounds(250, 30, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(Color.black); // 设置字体颜色

		JLabel jlid = new JLabel("删除业主id：");
		jlid.setBounds(50, 220, 200, 50); // 标签大小和位置
		jlid.setFont(new Font("宋体", 1, 24)); // 设置字体
		jlid.setForeground(Color.black); // 设置字体颜色

		JTextField jtid = new JTextField();
		jtid.setBounds(200, 220, 400, 50); // 输入框大小和位置
		jtid.setFont(new Font("宋体", 1, 24)); // 设置字体
		jtid.setForeground(Color.black); // 设置字体颜色

		JButton jbdel = new JButton("删除");
		jbdel.setBounds(130, 480, 170, 50); // 标签大小和位置
		jbdel.setFont(new Font("宋体", 1, 24)); // 设置字体
		jbdel.setForeground(Color.red); // 设置字体颜色

		JButton jbback = new JButton("返回上一层");
		jbback.setBounds(380, 480, 170, 50); // 标签大小和位置
		jbback.setFont(new Font("宋体", 1, 24)); // 设置字体
		jbback.setForeground(Color.blue); // 设置字体颜色

		// 加载所有组件
		deljframe.add(jLabel);
		deljframe.add(jlid);
		deljframe.add(jtid);
		deljframe.add(jbdel);
		deljframe.add(jbback);

		// 显示本窗体
		deljframe.setVisible(true);

		// 为"删除"按钮添加点击事件
		jbdel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtid.getText().equals("")) {
					PromptTool.getPromptTool("id号不能为空！");					
				} else {
					DeletePromptUI.getDeletePromptUI(operators, Long.valueOf(jtid.getText())); // 调出是否删除界面					
				}
			}
		});
		// 为"返回上一层"按钮添加点击事件
		jbback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deljframe.setVisible(false); // 关闭当前窗体
				OManageUI.getOMangeUI(operators); // 打开上一层
			}
		});
	}
}
