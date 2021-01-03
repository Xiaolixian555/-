package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import cn.xlx.operator.entity.Operators;
import cn.xlx.waterboss.dao.OwnersDao;
import cn.xlx.waterboss.entity.Owners;

public class BusinessTypeUI {
	public static Boolean getBusinessTypeUI(Operators operators, Long id) {
		JFrame bpjframe = new JFrame("业务类型选择"); // 创建窗体对象并赋标题参数
		bpjframe.setSize(710, 540); // 设置窗体大小
		bpjframe.setBackground(Color.WHITE); // 设置背景颜色
		bpjframe.setLocation(300, 200); // 设置窗体显示位置
		bpjframe.setLayout(null); // 无布局

		Owners owners = new Owners();
		owners = OwnersDao.find(id);
		if (owners == null) {
			return false;
		}

		JLabel jLabel = new JLabel("您正在修改的是 " + owners.getName() + " 业主");
		jLabel.setBounds(140, 0, 410, 150); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 28)); // 设置字体
		jLabel.setForeground(Color.black); // 设置字体颜色

		JButton jbmessage = new JButton("修改业主信息");
		jbmessage.setBounds(190, 180, 300, 50); // 标签大小和位置
		jbmessage.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbmessage.setForeground(Color.red); // 设置字体颜色

		JButton jbbill = new JButton("修改业主账务");
		jbbill.setBounds(190, 260, 300, 50); // 标签大小和位置
		jbbill.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbbill.setForeground(Color.MAGENTA); // 设置字体颜色

		JButton jbback = new JButton("返回上一层");
		jbback.setBounds(190, 340, 300, 50); // 标签大小和位置
		jbback.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbback.setForeground(Color.blue); // 设置字体颜色

		bpjframe.add(jLabel);
		bpjframe.add(jbmessage);
		bpjframe.add(jbbill);
		bpjframe.add(jbback);

		bpjframe.setVisible(true);

		// 为所有按钮分别添加点击事件
		jbmessage.addActionListener(new ActionListener() {
			// 选择修改业主信息
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifyMessageUI.getModifyMessageUI(operators, OwnersDao.find(id));
				bpjframe.setVisible(false);
			}
		});

		jbbill.addActionListener(new ActionListener() {
			// 选择修改业主账务
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateBillsUI.getUpdateBillsUI(operators,id);
				bpjframe.setVisible(false);
			}
		});

		jbback.addActionListener(new ActionListener() {
			// 返回上一层
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessProcessingUI.getBusinessProcessingUI(operators);
				bpjframe.setVisible(false);
			}
		});

		return true;
	}

}
