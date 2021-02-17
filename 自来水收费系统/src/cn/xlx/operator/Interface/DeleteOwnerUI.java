package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;

public class DeleteOwnerUI {
	public static void getDeleteOwnerUI(Operators operators) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame deljframe = new JFrame("删除业主界面"); // 创建窗体对象并赋标题参数
		deljframe.setCursor(cursor);  //设置鼠标样式
		deljframe.setSize(740, 700); // 设置窗体大小
		deljframe.setBackground(Color.WHITE); // 设置背景颜色
		deljframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		deljframe.setLayout(null); // 无布局
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
		JLabel jLabel = new JLabel("删除业主界面");
		jLabel.setBounds(250, 30, 300, 200); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色

		JLabel jlid = new JLabel("删除业主id：");
		jlid.setBounds(50, 220, 200, 50); // 标签大小和位置
		jlid.setFont(new Font("楷体", 1, 26)); // 设置字体
		jlid.setForeground(new Color(0x166F0C)); // 设置字体颜色

		JTextField jtid = new JTextField();
		jtid.setBounds(210, 220, 400, 50); // 输入框大小和位置
		jtid.setFont(new Font("宋体", 1, 24)); // 设置字体
		jtid.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtid.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		JButton jbdel = new JButton("删除",icon1);
		jbdel.setBounds(150, 480, 170, 50); // 标签大小和位置
		jbdel.setFont(new Font("楷体", 1, 24)); // 设置字体
		jbdel.setForeground(new Color(0x566347)); // 设置字体颜色
		jbdel.setHorizontalTextPosition(SwingConstants.CENTER);
		jbdel.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbdel.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbdel.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbdel.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		JButton jbback = new JButton("返回上一层",icon2);
		jbback.setBounds(410, 480, 170, 50); // 标签大小和位置
		jbback.setFont(new Font("楷体", 1, 24)); // 设置字体
		jbback.setForeground(new Color(0x566347)); // 设置字体颜色
		jbback.setHorizontalTextPosition(SwingConstants.CENTER);
		jbback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		// 加载所有组件
		deljframe.add(jLabel);
		deljframe.add(jlid);
		deljframe.add(jtid);
		deljframe.add(jbdel);
		deljframe.add(jbback);

		deljframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);         //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);                   //将jLabel放在该层级面板的高层
		layeredPane.add(jlid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbdel,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbback,JLayeredPane.MODAL_LAYER);
		deljframe.setResizable(false);//不允许调整窗体大小
		deljframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		// 显示本窗体
		deljframe.setVisible(true);

		// 为"删除"按钮添加点击事件
		jbdel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtid.getText().equals("")) {
					PromptTool.getPromptTool("id号不能为空！");					
				} else {
					DeletePromptUI.getDeletePromptUI(operators, Long.valueOf(jtid.getText())); // 调出是否删除界面					
				}
			}
		});
		// 为"返回上一层"按钮添加点击事件
		jbback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deljframe.setVisible(false); // 关闭当前窗体
				OManageUI.getOMangeUI(operators); // 打开上一层
			}
		});
		// 为按钮设置鼠标移出移入事件
		jbdel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbdel.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				deljframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbdel.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				deljframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbback.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				deljframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbback.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				deljframe.setCursor(cursor);  //设置鼠标样式
			}
		});

		//设置回车键盘事件
		jtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='\n'){
					jbdel.doClick();
				}
			}
		});
	}
}
