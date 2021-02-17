package cn.xlx.loginUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import cn.xlx.operator.Interface.OperatorUI;
import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;

public class OperatorLoginUI {
		// 获取收费员登录界面
		public static void getOperatorLogin() {
			//鼠标样式定义
			Toolkit tk = Toolkit.getDefaultToolkit();
			Image img = new ImageIcon("src/images/cursor2.png").getImage();
			Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
			JFrame mjframe = new JFrame("收费员登录界面"); // 创建窗体对象并赋标题参数
			mjframe.setSize(740, 700); // 设置窗体大小
			mjframe.setBackground(Color.WHITE); // 设置背景颜色
			mjframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
			mjframe.setLayout(null); // 无布局
			mjframe.setCursor(cursor);  //设置鼠标样式
			//创建一个JLayeredPane用于分层的。
			JLayeredPane layeredPane = new JLayeredPane();
			//创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
			JPanel jpanel = new JPanel();
			//创建背景图片对象
			ImageIcon image = new ImageIcon("src/images/operatorlogin.jpeg");
			//创建背景的那些东西
			jpanel.setBounds(0, 10, 745, 700);
			JLabel  jlabel = new JLabel(image);  //创建一个标签，里面存放image
			jpanel.add(jlabel);  //将标签加进面板容器jpanel中

			JLabel jLabel = new JLabel("收费员登录中心");
			jLabel.setBounds(260, 30, 300, 200); // 标签大小和位置
			jLabel.setFont(new Font("楷体", 1, 35)); // 设置字体
			jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色

			// 定义账号和密码标签
			JLabel jlmname = new JLabel("账号id:");
			JLabel jlmpassword = new JLabel("密  码:");
			
			//定义账号和密码输入框
			JTextField jtmname = new JTextField();
			JPasswordField jtmpassword = new JPasswordField();
			
			//定义登录按钮
			ImageIcon icon = new ImageIcon("src/images/button4.jpg");
			JButton jButton = new JButton("登录",icon);
			
			// 设置账号密码标签的样式
			jlmname.setBounds(60, 240, 100, 40); // 标签大小和位置
			jlmname.setFont(new Font("宋体", 1, 22)); // 设置字体
			jlmname.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			
			jlmpassword.setBounds(60, 290, 100, 40); // 标签大小和位置
			jlmpassword.setFont(new Font("宋体", 1, 22)); // 设置字体
			jlmpassword.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			// 设置账号密码输入框的样式
			jtmname.setBounds(200, 240, 400, 40); // 标签大小和位置
			jtmname.setFont(new Font("宋体", 1, 22)); // 设置字体
			jtmname.setForeground(new Color(0x2C711C)); // 设置字体颜色
			jtmname.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));
			
			jtmpassword.setBounds(200, 290, 400, 40); // 标签大小和位置
			jtmpassword.setFont(new Font("宋体", 1, 22)); // 设置字体
			jtmpassword.setForeground(new Color(0x2C711C)); // 设置字体颜色
			jtmpassword.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));
			// 设置登录按钮的样式
			jButton.setBounds(240, 450, 260, 50); // 标签大小和位置
			jButton.setFont(new Font("楷体", 1, 25)); // 设置字体
			jButton.setForeground(new Color(0x566347)); // 设置字体颜色
			jButton.setHorizontalTextPosition(SwingConstants.CENTER);
			jButton.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
			jButton.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
			jButton.setContentAreaFilled(false);//设置图片填满按钮所在的区域
			jButton.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
			// 所有标签，输入框，按钮加入到界面
			mjframe.add(jLabel); 
			mjframe.add(jlmname);
			mjframe.add(jlmpassword);
			mjframe.add(jtmname);
			mjframe.add(jtmpassword);
			mjframe.add(jButton);
			//设置各组件的层级
			mjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
			layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
			layeredPane.add(jlmname,JLayeredPane.MODAL_LAYER);    //将jloname放在该层级面板的高层
			layeredPane.add(jlmpassword,JLayeredPane.MODAL_LAYER);    //将jlopassword放在该层级面板的高层
			layeredPane.add(jtmname,JLayeredPane.MODAL_LAYER);    //将jtoname放在该层级面板的高层
			layeredPane.add(jtmpassword,JLayeredPane.MODAL_LAYER);    //将jtopassword放在该层级面板的高层
			layeredPane.add(jButton,JLayeredPane.MODAL_LAYER);    //将jButton放在该层级面板的高层
			mjframe.setResizable(false);//不允许调整窗体大小
			mjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
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
						PromptTool.getPromptTool("账号或密码输入不正确，请重新输入！");
						jtmname.setText("");
						jtmpassword.setText("");
					}
				}
			});

			//鼠标移入移出按钮事件
			jButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					jButton.setFont(new Font("楷体", 1, 28)); // 设置字体
					Toolkit tk = Toolkit.getDefaultToolkit();
					Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
					Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
					mjframe.setCursor(cursor);  //设置鼠标样式
				}

				@Override
				public void mouseExited(MouseEvent e) {
					jButton.setFont(new Font("楷体", 1, 25)); // 设置字体
					Toolkit tk = Toolkit.getDefaultToolkit();
					Image img = new ImageIcon("src/images/cursor2.png").getImage();
					Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
					mjframe.setCursor(cursor);  //设置鼠标样式
				}
			});
			//设置回车键盘事件
			jtmpassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(e.getKeyChar()=='\n'){
						jButton.doClick();
					}
				}
			});
		}
}
