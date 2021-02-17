package cn.xlx.waterboss.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.tools.TextBorderUtlis;
import cn.xlx.waterboss.entity.Owners;

public class WaterbossUI {
	public static void getWaterbossUI(Owners owners) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor1.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame wjframe = new JFrame("业主界面"); // 创建窗体对象并赋标题参数
		wjframe.setSize(740, 700); // 设置窗体大小
		wjframe.setBackground(Color.WHITE); // 设置背景颜色
		wjframe.setLocationRelativeTo(null); // 设置窗体显示位置
		wjframe.setLayout(null); // 无布局
		wjframe.setCursor(cursor);  //设置鼠标样式

		JLabel jLabel = new JLabel("您好，" + owners.getName());
		jLabel.setBounds(235, 30, 310, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 44)); // 设置字体
		jLabel.setForeground(new Color(117, 52,192)); // 设置字体颜色

		//创建一个JLayeredPane用于分层的。
		JLayeredPane layeredPane = new JLayeredPane();
		//创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
		JPanel jp = new JPanel();
		//创建背景图片对象
		ImageIcon image = new ImageIcon("src/images/ownerlogin.jpeg");
		//创建背景的那些东西
		jp.setBounds(0, 10, 735, 700);
		JLabel  jl = new JLabel(image);  //创建一个标签，里面存放image
		jp.add(jl);  //将标签加进面板容器jpanel中

		ImageIcon icon1 = new ImageIcon("src/images/button1.jpeg");
		JButton jpersonal = new JButton("个人中心",icon1); // 创建"个人中心"按钮
		jpersonal.setBounds(135, 250, 460, 70); // 按钮大小和位置
		jpersonal.setFont(new Font("楷体", 1, 23)); // 设置字体
		jpersonal.setForeground(Color.white); // 设置字体颜色
		jpersonal.setHorizontalTextPosition(SwingConstants.CENTER);
		jpersonal.setBorder(new TextBorderUtlis(new Color(0x9632B8),2,true));
		jpersonal.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jpersonal.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jpersonal.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		ImageIcon icon2 = new ImageIcon("src/images/button2.jpeg");
		JButton jbill = new JButton("查询账单",icon2); // 创建"查询账单"按钮
		jbill.setBounds(135, 400, 460, 70); // 按钮大小和位置
		jbill.setFont(new Font("楷体", 1, 23)); // 设置字体
		jbill.setForeground(Color.white); // 设置字体颜色
		jbill.setHorizontalTextPosition(SwingConstants.CENTER);
		jbill.setBorder(new TextBorderUtlis(new Color(0x9632B8),2,true));
		jbill.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbill.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbill.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		wjframe.setResizable(false);//不允许调整窗体大小
		wjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		wjframe.add(jLabel); // 标签加入到界面
		wjframe.add(jpersonal); // 按钮加入到界面
		wjframe.add(jbill); // 按钮加入到界面

		//设置各组件的层级
		wjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
		layeredPane.add(jpersonal,JLayeredPane.MODAL_LAYER);    //将jloname放在该层级面板的高层
		layeredPane.add(jbill,JLayeredPane.MODAL_LAYER);    //将jlopassword放在该层级面板的高
		wjframe.setVisible(true); // 显示窗体

		// 为"个人中心"按钮设置点击事件
		jpersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WPersonalUI.getWPersonalUI(owners);
				wjframe.setVisible(false); // 关闭窗体
			}
		});

		// 为"查询账单"按钮设置点击事件
		jbill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WBillUI.getBillUI(owners);
				wjframe.setVisible(false); // 关闭窗体
			}
		});

		//鼠标移入移出按钮事件
		jpersonal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jpersonal.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand1.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jpersonal.setFont(new Font("楷体", 1, 23)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor1.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wjframe.setCursor(cursor);  //设置鼠标样式
			}
		});

		jbill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbill.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand1.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbill.setFont(new Font("楷体", 1, 23)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor1.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wjframe.setCursor(cursor);  //设置鼠标样式
			}
		});

	}

}
