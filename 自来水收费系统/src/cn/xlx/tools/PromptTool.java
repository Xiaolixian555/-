package cn.xlx.tools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class PromptTool {
	public static void getPromptTool(String s) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame pjframe = new JFrame("提示信息");    //创建窗体对象并赋标题参数
		pjframe.setSize(520,290);    //设置窗体大小
		pjframe.setBackground(Color.WHITE);    //设置背景颜色
		pjframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		pjframe.setLayout(null); //无布局
		pjframe.setCursor(cursor);  //设置鼠标样式
		//创建一个JLayeredPane用于分层的。
		JLayeredPane layeredPane = new JLayeredPane();
		//创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
		JPanel jpanel = new JPanel();
		//创建背景图片对象
		ImageIcon image = new ImageIcon("src/images/prompt.jpeg");
		//创建背景的那些东西
		jpanel.setBounds(0, 10, 520, 290);
		JLabel  jlabel = new JLabel(image);  //创建一个标签，里面存放image
		jpanel.add(jlabel);  //将标签加进面板容器jpanel中
		
		JLabel jLabel = new JLabel(s,JLabel.CENTER);
		jLabel.setBounds(0, 28, 520, 80);  //标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 24));  //设置字体
		jLabel.setForeground(Color.black);  //设置字体颜色
		ImageIcon icon = new ImageIcon("src/images/button3.jpeg");
		JButton jButton = new JButton("确定",icon); //创建"确定"按钮
		jButton.setBounds(210, 154, 80, 40);  //按钮大小和位置
		jButton.setFont(new Font("楷体", 1, 20));  //设置字体
		jButton.setForeground(Color.black);  //设置字体颜色
		jButton.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton.setBorder(new TextBorderUtlis(new Color(0x000000),2,true));
		jButton.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jButton.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		
		pjframe.add(jLabel);  //标签加入到界面
		pjframe.add(jButton);  //按钮加入界面
		//设置各组件的层级
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
		layeredPane.add(jButton,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
		pjframe.setResizable(false);//不允许调整窗体大小
		pjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		pjframe.setVisible(true); //窗体显示
		
		//为确定按钮添加点击事件
		jButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				pjframe.setVisible(false); //窗体关闭
			}
		});
		//鼠标移入移出按钮事件
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				pjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 20)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				pjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		return;
	}
}
