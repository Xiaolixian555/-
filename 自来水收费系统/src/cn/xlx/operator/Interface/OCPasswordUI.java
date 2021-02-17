package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.TextBorderUtlis;
import cn.xlx.waterboss.Interface.PromptUI;


public class OCPasswordUI {
	public static void getOCPasswordUI(Operators operators) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame cjframe = new JFrame("修改个人密码"); // 创建窗体对象并赋标题参数
		cjframe.setSize(740, 700); // 设置窗体大小
		cjframe.setBackground(Color.WHITE); // 设置背景颜色
		cjframe.setLocationRelativeTo(null);
		cjframe.setCursor(cursor);  //设置鼠标样式
		cjframe.setLayout(null); // 无布局

		//创建一个JLayeredPane用于分层的。
		JLayeredPane layeredPane = new JLayeredPane();
		//创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
		JPanel jpanel = new JPanel();
		//创建背景图片对象
		ImageIcon image = new ImageIcon("src/images/operatorlogin.jpeg");
		ImageIcon icon = new ImageIcon("src/images/button4.jpg");
		//创建背景的那些东西
		jpanel.setBounds(0, 10, 745, 700);
		JLabel  jlabel = new JLabel(image);  //创建一个标签，里面存放image
		jpanel.add(jlabel);  //将标签加进面板容器jpanel中
		//定义各种标签及其样式
		JLabel jLabel = new JLabel("修改个人密码");
		jLabel.setBounds(254, 10, 300, 160); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 35)); // 设置字体
		jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色
		
		JLabel jloldpw = new JLabel("旧密码：");
		jloldpw.setBounds(60, 180, 200, 50); // 标签大小和位置
		jloldpw.setFont(new Font("宋体", 1, 22)); // 设置字体
		jloldpw.setForeground(new Color(0x566347)); // 设置字体颜色
		
		JLabel jlnewpw1 = new JLabel("新密码：");
		jlnewpw1.setBounds(60, 250, 200, 50); // 标签大小和位置
		jlnewpw1.setFont(new Font("宋体", 1, 22)); // 设置字体
		jlnewpw1.setForeground(new Color(0x566347)); // 设置字体颜色
		
		JLabel jlnewpw2 = new JLabel("确认密码：");
		jlnewpw2.setBounds(60, 320, 200, 50); // 标签大小和位置
		jlnewpw2.setFont(new Font("宋体", 1, 22)); // 设置字体
		jlnewpw2.setForeground(new Color(0x566347)); // 设置字体颜色
		
		//定义各种文本框及其样式
		JPasswordField jpold = new JPasswordField();
		jpold.setBounds(240, 180, 300, 50); // 标签大小和位置
		jpold.setFont(new Font("宋体", 1, 22)); // 设置字体
		jpold.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jpold.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));
	
		JPasswordField jpnew1 = new JPasswordField();
		jpnew1.setBounds(240, 250, 300, 50); // 标签大小和位置
		jpnew1.setFont(new Font("宋体", 1, 22)); // 设置字体
		jpnew1.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jpnew1.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));
		
		JPasswordField jpnew2 = new JPasswordField();
		jpnew2.setBounds(240, 320, 300, 50); // 标签大小和位置
		jpnew2.setFont(new Font("宋体", 1, 22)); // 设置字体
		jpnew2.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jpnew2.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));
		
		//定义按钮及其样式
		ImageIcon icon3 = new ImageIcon("src/images/button4.jpg");
		JButton jButton = new JButton("修改",icon3);
		jButton.setBounds(240, 440, 250, 60); // 标签大小和位置
		jButton.setFont(new Font("楷体", 1, 25)); // 设置字体
		jButton.setForeground(new Color(0x566347)); // 设置字体颜色
		jButton.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jButton.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jButton.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jButton.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		ImageIcon icon4 = new ImageIcon("src/images/button4.jpeg");
		JButton jBack = new JButton("返回",icon4);
		jBack.setBounds(240, 530, 250, 60); // 标签大小和位置
		jBack.setFont(new Font("楷体", 1, 25)); // 设置字体
		jBack.setForeground(new Color(0x566347)); // 设置字体颜色
		jBack.setHorizontalTextPosition(SwingConstants.CENTER);
		jBack.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jBack.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jBack.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jBack.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		
		cjframe.add(jLabel);
		cjframe.add(jloldpw);
		cjframe.add(jlnewpw1);
		cjframe.add(jlnewpw2);
		cjframe.add(jpold);
		cjframe.add(jpnew1);
		cjframe.add(jpnew2);
		cjframe.add(jButton);
		cjframe.add(jBack);
		//设置各组件的层级
		cjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);         //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);                   //将jLabel放在该层级面板的高层
		layeredPane.add(jloldpw,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlnewpw1,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlnewpw2,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jpold,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jpnew1,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jpnew2,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jButton,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jBack,JLayeredPane.MODAL_LAYER);
		cjframe.setResizable(false);//不允许调整窗体大小
		cjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
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

		//鼠标移入移出按钮事件
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				cjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				cjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jBack.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				cjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jBack.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				cjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
	}
}
