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
import cn.xlx.waterboss.Interface.WaterbossUI;
import cn.xlx.waterboss.dao.OwnersDao;


public class OwnerLoginUI {
	// 获取业主登录界面
	public static void getOwnerUI() {
		JFrame ojframe = new JFrame("业主登录界面"); // 创建窗体对象并赋标题参数
		ojframe.setSize(740, 700); // 设置窗体大小
		ojframe.setBackground(Color.WHITE); // 设置背景颜色
		ojframe.setLocation(300, 200); // 设置窗体显示位置
		ojframe.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("业主登录中心");
		jLabel.setBounds(260, 30, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(Color.blue); // 设置字体颜色

		// 定义账号和密码标签
		JLabel jloname = new JLabel("账号id:");
		JLabel jlopassword = new JLabel("密  码:");
		
		//定义账号和密码输入框
		JTextField jtoname = new JTextField();
		JPasswordField jtopassword = new JPasswordField();
		
		//定义登录按钮
		JButton jButton = new JButton("登录");
		
		// 设置账号密码标签的样式
		jloname.setBounds(60, 240, 100, 40); // 标签大小和位置
		jloname.setFont(new Font("宋体", 1, 22)); // 设置字体
		jloname.setForeground(Color.black); // 设置字体颜色
		
		jlopassword.setBounds(60, 290, 100, 40); // 标签大小和位置
		jlopassword.setFont(new Font("宋体", 1, 22)); // 设置字体
		jlopassword.setForeground(Color.black); // 设置字体颜色
		// 设置账号密码输入框的样式
		jtoname.setBounds(200, 240, 400, 40); // 标签大小和位置
		jtoname.setFont(new Font("宋体", 1, 22)); // 设置字体
		jtoname.setForeground(Color.black); // 设置字体颜色
		
		jtopassword.setBounds(200, 290, 400, 40); // 标签大小和位置
		jtopassword.setFont(new Font("宋体", 1, 22)); // 设置字体
		jtopassword.setForeground(Color.black); // 设置字体颜色
		// 设置登录按钮的样式
		jButton.setBounds(240, 450, 260, 50); // 标签大小和位置
		jButton.setFont(new Font("宋体", 1, 22)); // 设置字体
		jButton.setForeground(Color.black); // 设置字体颜色
		
		// 所有标签，输入框，按钮加入到界面
		ojframe.add(jLabel); 
		ojframe.add(jloname);
		ojframe.add(jlopassword);
		ojframe.add(jtoname);
		ojframe.add(jtopassword);
		ojframe.add(jButton);		

		ojframe.setVisible(true); // 显示窗体
		
		//为"登录"按钮设置点击事件
		jButton.addActionListener(new ActionListener() {			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//如果账号密码正确
				if(OwnersDao.checkLogin(Long.valueOf(jtoname.getText()), jtopassword.getText())){				
					//显示出界面
					WaterbossUI.getWaterbossUI(OwnersDao.find(Long.valueOf(jtoname.getText())));
					ojframe.setVisible(false); //关闭登录窗口
				}
				else{
					LoginErrorUI.getLoginErrorUI();
					jtoname.setText("");
					jtopassword.setText("");
				}
			}
		});

	}
}
