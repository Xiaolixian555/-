package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.TextBorderUtlis;

public class OManageUI {
	// 业主管理界面
	public static void getOMangeUI(Operators operators) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame omjframe = new JFrame("业主管理界面"); // 创建窗体对象并赋标题参数
		omjframe.setSize(740, 700); // 设置窗体大小
		omjframe.setBackground(Color.WHITE); // 设置背景颜色
		omjframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		omjframe.setCursor(cursor);  //设置鼠标样式
		omjframe.setLayout(null); // 无布局

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

		JLabel jLabel = new JLabel("业主管理界面");
		jLabel.setBounds(260, 22, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 37)); // 设置字体
		jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色

		JButton JbAddO = new JButton("增加业主",icon1); // 创建"增加业主"按钮
		JbAddO.setBounds(125, 210, 500, 60); // 按钮大小和位置
		JbAddO.setFont(new Font("楷体", 1, 25)); // 设置字体
		JbAddO.setForeground(new Color(0x566347)); // 设置字体颜色
		JbAddO.setHorizontalTextPosition(SwingConstants.CENTER);
		JbAddO.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		JbAddO.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		JbAddO.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		JbAddO.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		JButton JbDeleteO = new JButton("删除业主",icon1); // 创建"删除业主"按钮
		JbDeleteO.setBounds(125, 310, 500, 60); // 按钮大小和位置
		JbDeleteO.setFont(new Font("楷体", 1, 25)); // 设置字体
		JbDeleteO.setForeground(new Color(0x566347)); // 设置字体颜色
		JbDeleteO.setHorizontalTextPosition(SwingConstants.CENTER);
		JbDeleteO.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		JbDeleteO.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		JbDeleteO.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		JbDeleteO.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		
		JButton JbUpdate = new JButton("修改业主及其账务",icon1); // 创建"修改业主及其账务"按钮
		JbUpdate.setBounds(125, 410, 500, 60); // 按钮大小和位置
		JbUpdate.setFont(new Font("楷体", 1, 25)); // 设置字体
		JbUpdate.setForeground(new Color(0x566347)); // 设置字体颜色
		JbUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		JbUpdate.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		JbUpdate.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		JbUpdate.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		JbUpdate.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		JButton Jbback = new JButton("返回上一层",icon2); // 创建"返回上一层"按钮
		Jbback.setBounds(125, 510, 500, 60); // 按钮大小和位置
		Jbback.setFont(new Font("楷体", 1, 25)); // 设置字体
		Jbback.setForeground(new Color(0x566347)); // 设置字体颜色
		Jbback.setHorizontalTextPosition(SwingConstants.CENTER);
		Jbback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		Jbback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		Jbback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		Jbback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		omjframe.add(jLabel); // 标签加入到界面
		omjframe.add(JbAddO); // 按钮加入到界面
		omjframe.add(JbDeleteO); // 按钮加入到界面
		omjframe.add(JbUpdate); // 按钮加入到界面
		omjframe.add(Jbback); // 按钮加入到界面
		//设置各组件的层级
		omjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);         //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);                   //将jLabel放在该层级面板的高层
		layeredPane.add(JbAddO,JLayeredPane.MODAL_LAYER);
		layeredPane.add(JbDeleteO,JLayeredPane.MODAL_LAYER);
		layeredPane.add(JbUpdate,JLayeredPane.MODAL_LAYER);
		layeredPane.add(Jbback,JLayeredPane.MODAL_LAYER);
		omjframe.setResizable(false);//不允许调整窗体大小
		omjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		omjframe.setVisible(true); // 显示窗体

		// 为"增加业主"按钮设置点击事件
		JbAddO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerAddTypeUI.getOwnerAddTypeUI(operators);
				omjframe.setVisible(false); // 关闭窗体
			}
		});
		// 为"删除业主"按钮设置点击事件
		JbDeleteO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteOwnerUI.getDeleteOwnerUI(operators);
				omjframe.setVisible(false); // 关闭窗体
			}
		});
		//为"修改业主"按钮设置点击事件
		JbUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessProcessingUI.getBusinessProcessingUI(operators);
				omjframe.setVisible(false); // 关闭窗体
			}
		});
		//为"返回上一层"按钮设置点击事件
		Jbback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorUI.getOperatorUI(operators);
				omjframe.setVisible(false); // 关闭窗体				
			}
		});

		// 为按钮设置鼠标移出移入事件
		JbAddO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JbAddO.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JbAddO.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		JbDeleteO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JbDeleteO.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JbDeleteO.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		JbUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JbUpdate.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JbUpdate.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		Jbback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jbback.setFont(new Font("楷体", 1, 27)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Jbback.setFont(new Font("楷体", 1, 25)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				omjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
	}
}
