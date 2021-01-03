package cn.xlx.loginUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.xlx.operator.Interface.OperatorUI;
import cn.xlx.operator.dao.OperatorsDao;

public class OperatorLoginUI {
	// 获取收费员登录界面
		public static void getOperatorLogin() {
			JFrame mjframe = new JFrame("收费员登录界面"); // 创建窗体对象并赋标题参数
			mjframe.setSize(740, 700); // 设置窗体大小
			mjframe.setBackground(Color.WHITE); // 设置背景颜色
			mjframe.setLocation(300, 200); // 设置窗体显示位置
			mjframe.setLayout(null); // 无布局

			JLabel jLabel = new JLabel("收费员登录中心");
			jLabel.setBounds(260, 30, 300, 200); // 标签大小和位置
			jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
			jLabel.setForeground(Color.MAGENTA); // 设置字体颜色

			// 定义账号和密码标签
			JLabel jlmname = new JLabel("账号id:");
			JLabel jlmpassword = new JLabel("密  码:");
			
			//定义账号和密码输入框
			JTextField jtmname = new JTextField();
			JPasswordField jtmpassword = new JPasswordField();
			
			//定义登录按钮
			JButton jButton = new JButton("登录");
			
			// 设置账号密码标签的样式
			jlmname.setBounds(60, 240, 100, 40); // 标签大小和位置
			jlmname.setFont(new Font("宋体", 1, 22)); // 设置字体
			jlmname.setForeground(Color.black); // 设置字体颜色
			
			jlmpassword.setBounds(60, 290, 100, 40); // 标签大小和位置
			jlmpassword.setFont(new Font("宋体", 1, 22)); // 设置字体
			jlmpassword.setForeground(Color.black); // 设置字体颜色
			// 设置账号密码输入框的样式
			jtmname.setBounds(200, 240, 400, 40); // 标签大小和位置
			jtmname.setFont(new Font("宋体", 1, 22)); // 设置字体
			jtmname.setForeground(Color.black); // 设置字体颜色
			
			jtmpassword.setBounds(200, 290, 400, 40); // 标签大小和位置
			jtmpassword.setFont(new Font("宋体", 1, 22)); // 设置字体
			jtmpassword.setForeground(Color.black); // 设置字体颜色
			// 设置登录按钮的样式
			jButton.setBounds(240, 450, 260, 50); // 标签大小和位置
			jButton.setFont(new Font("宋体", 1, 22)); // 设置字体
			jButton.setForeground(Color.black); // 设置字体颜色
			
			// 所有标签，输入框，按钮加入到界面
			mjframe.add(jLabel); 
			mjframe.add(jlmname);
			mjframe.add(jlmpassword);
			mjframe.add(jtmname);
			mjframe.add(jtmpassword);
			mjframe.add(jButton);
			
			mjframe.setVisible(true); // 显示窗体
			
			//为"登录"按钮设置点击事件
			jButton.addActionListener(new ActionListener() {			
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					//如果账号密码正确
					if(OperatorsDao.checkLogin(Long.valueOf(jtmname.getText()), jtmpassword.getText())){				
						//显示出界面
						OperatorUI.getOperatorUI(OperatorsDao.find(Long.valueOf(jtmname.getText())));
						mjframe.setVisible(false); //关闭登录窗口
					}
					else{
						LoginErrorUI.getLoginErrorUI();
						jtmname.setText("");
						jtmpassword.setText("");
					}
				}
			});

		}
}
