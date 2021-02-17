package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.TextBorderUtlis;


public class OperatorUI {
	// 管理员主界面
	public static void getOperatorUI(Operators operators) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame ojframe = new JFrame("管理员界面"); // 创建窗体对象并赋标题参数
		ojframe.setCursor(cursor);  //设置鼠标样式
		ojframe.setSize(740, 700); // 设置窗体大小
		ojframe.setBackground(Color.WHITE); // 设置背景颜色
		ojframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		ojframe.setLayout(null); // 无布局

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

		JLabel jLabel = new JLabel("您好，" + operators.getName());
		jLabel.setBounds(250, 30, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色


		JButton JCPassword = new JButton("修改个人密码",icon); // 创建"修改个人密码"按钮
		JCPassword.setBounds(120, 210, 500, 70); // 按钮大小和位置
		JCPassword.setFont(new Font("楷体", 1, 26)); // 设置字体
		JCPassword.setForeground(new Color(0x566347)); // 设置字体颜色
		JCPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		JCPassword.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		JCPassword.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		JCPassword.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		JCPassword.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		JButton JOwnerManagement = new JButton("业务工作",icon); // 创建"业务工作"按钮
		JOwnerManagement.setBounds(120, 330, 500, 70); // 按钮大小和位置
		JOwnerManagement.setFont(new Font("楷体", 1, 26)); // 设置字体
		JOwnerManagement.setForeground(new Color(0x566347)); // 设置字体颜色
		JOwnerManagement.setHorizontalTextPosition(SwingConstants.CENTER);
		JOwnerManagement.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		JOwnerManagement.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		JOwnerManagement.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		JOwnerManagement.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		
		JButton JBusinessWork = new JButton("查看所有业主",icon); // 创建"查看所有业主"按钮
		JBusinessWork.setBounds(120, 450, 500, 70); // 按钮大小和位置
		JBusinessWork.setFont(new Font("楷体", 1, 26)); // 设置字体
		JBusinessWork.setForeground(new Color(0x566347)); // 设置字体颜色
		JBusinessWork.setHorizontalTextPosition(SwingConstants.CENTER);
		JBusinessWork.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		JBusinessWork.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		JBusinessWork.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		JBusinessWork.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离


		ojframe.add(jLabel); // 标签加入到界面
		ojframe.add(JCPassword); // 按钮加入到界面
		ojframe.add(JOwnerManagement); // 按钮加入到界面
		ojframe.add(JBusinessWork); // 按钮加入到界面

		//设置各组件的层级
		ojframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);         //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);                   //将jLabel放在该层级面板的高层
		layeredPane.add(JCPassword,JLayeredPane.MODAL_LAYER);
		layeredPane.add(JOwnerManagement,JLayeredPane.MODAL_LAYER);
		layeredPane.add(JBusinessWork,JLayeredPane.MODAL_LAYER);
		ojframe.setResizable(false);//不允许调整窗体大小
		ojframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		ojframe.setVisible(true); // 显示窗体

		// 为"修改个人密码"按钮设置点击事件
		JCPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OCPasswordUI.getOCPasswordUI(operators);
				ojframe.setVisible(false); // 关闭窗体
			}
		});

		// 为"业务工作"按钮设置点击事件
		JOwnerManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OManageUI.getOMangeUI(operators);//打开"业务工作"窗体		
				ojframe.setVisible(false); // 关闭原窗体
			}
		});
		
		// 为"查看所有业主"按钮设置点击事件
		JBusinessWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllOwnersUI.getViewAllOwnersUI(operators);
				ojframe.setVisible(false); // 关闭窗体
			}
		});

		// 为"修改个人密码"按钮设置鼠标移出移入事件
		JCPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JCPassword.setFont(new Font("楷体", 1, 28)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				ojframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JCPassword.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				ojframe.setCursor(cursor);  //设置鼠标样式
			}
		});

		// 为"业务工作"按钮设置鼠标移出移入事件
		JOwnerManagement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOwnerManagement.setFont(new Font("楷体", 1, 28)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				ojframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JOwnerManagement.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				ojframe.setCursor(cursor);  //设置鼠标样式
			}
		});

		// 为"查看所有业主"按钮设置鼠标移出移入事件
		JBusinessWork.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JBusinessWork.setFont(new Font("楷体", 1, 28)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				ojframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JBusinessWork.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				ojframe.setCursor(cursor);  //设置鼠标样式
			}
		});
	}
}
