package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.TextBorderUtlis;

public class OwnerAddTypeUI {
	// 选择增加业主的方式界面
	public static void getOwnerAddTypeUI(Operators operators) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame jfOAT = new JFrame("添加业主方式");
		jfOAT.setSize(740, 570); // 设置窗体大小
		jfOAT.setBackground(Color.WHITE); // 设置背景颜色
		jfOAT.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		jfOAT.setCursor(cursor);  //设置鼠标样式
		jfOAT.setLayout(null); // 无布局

		//创建一个JLayeredPane用于分层的。
		JLayeredPane layeredPane = new JLayeredPane();
		//创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
		JPanel jpanel = new JPanel();
		//创建背景图片对象
		ImageIcon image = new ImageIcon("src/images/operatorlogin.jpeg");
		ImageIcon icon1 = new ImageIcon("src/images/button4.jpg");
		ImageIcon icon2 = new ImageIcon("src/images/button4.jpeg");
		//创建背景的那些东西
		jpanel.setBounds(0, 10, 745, 700);
		JLabel  jlabel = new JLabel(image);  //创建一个标签，里面存放image
		jpanel.add(jlabel);  //将标签加进面板容器jpanel中

		JLabel jltitle = new JLabel("添加业主方式");
		jltitle.setBounds(256, 20, 300, 100); // 标签大小和位置
		jltitle.setFont(new Font("楷体", 1, 34)); // 设置字体
		jltitle.setForeground(new Color(0x166F0C)); // 设置字体颜色
		
		JButton jbsingle = new JButton("单个添加",icon1);
		jbsingle.setBounds(210, 160, 300, 50); // 标签大小和位置
		jbsingle.setFont(new Font("楷体", 1, 25)); // 设置字体
		jbsingle.setForeground(new Color(0x566347)); // 设置字体颜色
		jbsingle.setHorizontalTextPosition(SwingConstants.CENTER);
		jbsingle.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbsingle.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbsingle.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbsingle.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		JButton jbgroup = new JButton("批量添加",icon1);
		jbgroup.setBounds(210, 270, 300, 50); // 标签大小和位置
		jbgroup.setFont(new Font("楷体", 1, 25)); // 设置字体
		jbgroup.setForeground(new Color(0x566347)); // 设置字体颜色
		jbgroup.setHorizontalTextPosition(SwingConstants.CENTER);
		jbgroup.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbgroup.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbgroup.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbgroup.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		
		JButton jback = new JButton("返回上一层",icon2);
		jback.setBounds(210, 380, 300, 50); // 标签大小和位置
		jback.setFont(new Font("楷体", 1, 25)); // 设置字体
		jback.setForeground(new Color(0x566347)); // 设置字体颜色
		jback.setHorizontalTextPosition(SwingConstants.CENTER);
		jback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		//加载所有组件
		jfOAT.add(jltitle);
		jfOAT.add(jbsingle);
		jfOAT.add(jbgroup);
		jfOAT.add(jback);
		jfOAT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);         //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jltitle,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbsingle,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbgroup,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jback,JLayeredPane.MODAL_LAYER);
		
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

		// 为按钮设置鼠标移出移入事件
		jbsingle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbsingle.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfOAT.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbsingle.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfOAT.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbgroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbgroup.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfOAT.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbgroup.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfOAT.setCursor(cursor);  //设置鼠标样式
			}
		});
		jback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfOAT.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfOAT.setCursor(cursor);  //设置鼠标样式
			}
		});
		jfOAT.setResizable(false);//不允许调整窗体大小
		jfOAT.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		jfOAT.setVisible(true);
	}
}
