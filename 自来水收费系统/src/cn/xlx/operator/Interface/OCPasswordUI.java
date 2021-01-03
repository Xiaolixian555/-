package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.waterboss.Interface.PromptUI;


public class OCPasswordUI {
	public static void getOCPasswordUI(Operators operators) {
		JFrame cjframe = new JFrame("修改个人密码"); // 创建窗体对象并赋标题参数
		cjframe.setSize(740, 700); // 设置窗体大小
		cjframe.setBackground(Color.WHITE); // 设置背景颜色
		cjframe.setLocation(300, 200); // 设置窗体显示位置
		cjframe.setLayout(null); // 无布局
		
		//定义各种标签及其样式
		JLabel jLabel = new JLabel("修改个人密码");
		jLabel.setBounds(240, 10, 300, 160); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(Color.blue); // 设置字体颜色
		
		JLabel jloldpw = new JLabel("旧密码：");
		jloldpw.setBounds(60, 180, 200, 50); // 标签大小和位置
		jloldpw.setFont(new Font("宋体", 1, 22)); // 设置字体
		jloldpw.setForeground(Color.black); // 设置字体颜色
		
		JLabel jlnewpw1 = new JLabel("新密码：");
		jlnewpw1.setBounds(60, 250, 200, 50); // 标签大小和位置
		jlnewpw1.setFont(new Font("宋体", 1, 22)); // 设置字体
		jlnewpw1.setForeground(Color.black); // 设置字体颜色
		
		JLabel jlnewpw2 = new JLabel("确认密码：");
		jlnewpw2.setBounds(60, 320, 200, 50); // 标签大小和位置
		jlnewpw2.setFont(new Font("宋体", 1, 22)); // 设置字体
		jlnewpw2.setForeground(Color.black); // 设置字体颜色
		
		//定义各种文本框及其样式
		JPasswordField jpold = new JPasswordField();
		jpold.setBounds(240, 180, 300, 50); // 标签大小和位置
		jpold.setFont(new Font("宋体", 1, 22)); // 设置字体
		jpold.setForeground(Color.black); // 设置字体颜色
	
		JPasswordField jpnew1 = new JPasswordField();
		jpnew1.setBounds(240, 250, 300, 50); // 标签大小和位置
		jpnew1.setFont(new Font("宋体", 1, 22)); // 设置字体
		jpnew1.setForeground(Color.black); // 设置字体颜色
		
		JPasswordField jpnew2 = new JPasswordField();
		jpnew2.setBounds(240, 320, 300, 50); // 标签大小和位置
		jpnew2.setFont(new Font("宋体", 1, 22)); // 设置字体
		jpnew2.setForeground(Color.black); // 设置字体颜色
		
		//定义按钮及其样式
		JButton jButton = new JButton("修改");
		jButton.setBounds(240, 440, 250, 60); // 标签大小和位置
		jButton.setFont(new Font("宋体", 1, 22)); // 设置字体
		jButton.setForeground(Color.red); // 设置字体颜色
		
		JButton jBack = new JButton("返回");
		jBack.setBounds(240, 530, 250, 60); // 标签大小和位置
		jBack.setFont(new Font("宋体", 1, 22)); // 设置字体
		jBack.setForeground(Color.blue); // 设置字体颜色
		
		cjframe.add(jLabel);
		cjframe.add(jloldpw);
		cjframe.add(jlnewpw1);
		cjframe.add(jlnewpw2);
		cjframe.add(jpold);
		cjframe.add(jpnew1);
		cjframe.add(jpnew2);
		cjframe.add(jButton);
		cjframe.add(jBack);
		cjframe.setVisible(true); // 显示窗体
		 
		//为修改按钮添加点击事件
		jButton.addActionListener(new ActionListener() {	
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				//如果旧密码是正确的
				if(OperatorsDao.isOld(operators.getId(), jpold.getText())){
					//如果两次密码输入相同
					if(jpnew1.getText().equals(jpnew2.getText())){
						OperatorsDao.changePassword(operators.getId(), jpnew2.getText());
						cjframe.setVisible(false); //关闭本窗体
						OperatorUI.getOperatorUI(operators);
						PromptUI.getPromptUI();
					}
					//否则显示窗口："两次密码输入不一致"
					else{
						ChangePwErrorUI.getChangePwErrorUI(2);
					}
				}
				//否则显示窗口："旧密码错误"
				else{
					ChangePwErrorUI.getChangePwErrorUI(1);
				}
				
			}
		});
		
		// 为返回按钮添加点击事件
		jBack.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				cjframe.setVisible(false); //关闭本窗体
				OperatorUI.getOperatorUI(operators);
			}
		});
	}
}
