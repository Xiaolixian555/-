package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.TextBorderUtlis;
import cn.xlx.waterboss.dao.OwnersDao;
import cn.xlx.waterboss.entity.Owners;

public class BusinessTypeUI {
	public static Boolean getBusinessTypeUI(Operators operators, Long id) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame bpjframe = new JFrame("业务类型选择"); // 创建窗体对象并赋标题参数
		bpjframe.setSize(710, 540); // 设置窗体大小
		bpjframe.setBackground(Color.WHITE); // 设置背景颜色
		bpjframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		bpjframe.setLayout(null); // 无布局
		bpjframe.setCursor(cursor);  //设置鼠标样式
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
		Owners owners = new Owners();
		owners = OwnersDao.find(id);
		if (owners == null) {
			return false;
		}

		JLabel jLabel = new JLabel("您正在修改的是 " + owners.getName() + " 业主",JLabel.CENTER);
		jLabel.setBounds(0, 0, 710, 150); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 28)); // 设置字体
		jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色
		ImageIcon icon1 = new ImageIcon("src/images/button4.jpg");
		JButton jbmessage = new JButton("修改业主信息",icon1);
		jbmessage.setBounds(190, 180, 300, 50); // 标签大小和位置
		jbmessage.setFont(new Font("楷体", 1, 23)); // 设置字体
		jbmessage.setForeground(new Color(0x566347)); // 设置字体颜色
		jbmessage.setHorizontalTextPosition(SwingConstants.CENTER);
		jbmessage.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbmessage.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbmessage.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbmessage.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		JButton jbbill = new JButton("修改业主账务",icon1);
		jbbill.setBounds(190, 260, 300, 50); // 标签大小和位置
		jbbill.setFont(new Font("楷体", 1, 23)); // 设置字体
		jbbill.setForeground(new Color(0x566347)); // 设置字体颜色
		jbbill.setHorizontalTextPosition(SwingConstants.CENTER);
		jbbill.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbbill.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbbill.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbbill.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		ImageIcon icon2 = new ImageIcon("src/images/button3.jpeg");
		JButton jbback = new JButton("返回上一层",icon2);
		jbback.setBounds(190, 340, 300, 50); // 标签大小和位置
		jbback.setFont(new Font("楷体", 1, 23)); // 设置字体
		jbback.setForeground(new Color(0x566347)); // 设置字体颜色
		jbback.setHorizontalTextPosition(SwingConstants.CENTER);
		jbback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		bpjframe.add(jLabel);
		bpjframe.add(jbmessage);
		bpjframe.add(jbbill);
		bpjframe.add(jbback);
		//设置各组件的层级
		bpjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
		layeredPane.add(jbmessage,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbbill,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbback,JLayeredPane.MODAL_LAYER);
		bpjframe.setResizable(false);//不允许调整窗体大小
		bpjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
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
		//鼠标移入移出按钮事件
		jbmessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbmessage.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbmessage.setFont(new Font("楷体", 1, 23)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbbill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbbill.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbbill.setFont(new Font("楷体", 1, 23)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbback.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbback.setFont(new Font("楷体", 1, 23)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		return true;
	}

}
