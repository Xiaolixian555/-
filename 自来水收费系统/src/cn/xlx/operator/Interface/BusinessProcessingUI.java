package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;


public class BusinessProcessingUI {
	public static void getBusinessProcessingUI(Operators operators) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame bpjframe = new JFrame("修改业主及其账务"); // 创建窗体对象并赋标题参数
		bpjframe.setSize(740, 540); // 设置窗体大小
		bpjframe.setBackground(Color.WHITE); // 设置背景颜色
		bpjframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		bpjframe.setCursor(cursor);  //设置鼠标样式
		bpjframe.setLayout(null); // 无布局
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

		JLabel jLabel = new JLabel("请输入需要修改的业主Id");
		jLabel.setBounds(190, 20, 400, 180); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 30)); // 设置字体
		jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色
		
		JTextField jTextField = new JTextField();
		jTextField.setBounds(130, 180, 460, 50); // 标签大小和位置
		jTextField.setFont(new Font("宋体", 1, 27)); // 设置字体
		jTextField.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jTextField.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));
		ImageIcon icon1 = new ImageIcon("src/images/button4.jpg");
		JButton jconfirm = new JButton("确认",icon1);
		jconfirm.setBounds(130, 320, 200, 50); // 标签大小和位置
		jconfirm.setFont(new Font("楷体", 1, 24)); // 设置字体
		jconfirm.setForeground(new Color(0x566347)); // 设置字体颜色
		jconfirm.setHorizontalTextPosition(SwingConstants.CENTER);
		jconfirm.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jconfirm.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jconfirm.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jconfirm.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		ImageIcon icon2 = new ImageIcon("src/images/button4.jpeg");
		JButton jback = new JButton("返回",icon2);
		jback.setBounds(400, 320, 200, 50); // 按钮大小和位置
		jback.setFont(new Font("楷体", 1, 24)); // 设置字体
		jback.setForeground(new Color(0x566347)); // 设置字体颜色
		jback.setHorizontalTextPosition(SwingConstants.CENTER);
		jback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		  
		//添加组件并显示窗体
		bpjframe.add(jLabel);
		bpjframe.add(jTextField);
		bpjframe.add(jconfirm);
		bpjframe.add(jback);
		bpjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
		layeredPane.add(jTextField,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jconfirm,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jback,JLayeredPane.MODAL_LAYER);
		bpjframe.setResizable(false);//不允许调整窗体大小
		bpjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		bpjframe.setVisible(true);
		
		//为"确认"按钮添加点击事件
		jconfirm.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BusinessTypeUI.getBusinessTypeUI(operators, Long.valueOf(jTextField.getText()))){
					bpjframe.setVisible(false);	
				}
				else{
					PromptTool.getPromptTool("此id不存在，请重新输入！");
				}
				
			}
		});
		//为"退出"按钮添加点击事件
		jback.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				OManageUI.getOMangeUI(operators);
				bpjframe.setVisible(false);			
			}
		});
		//鼠标移入移出按钮事件
		jconfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jconfirm.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jconfirm.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				bpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		//设置回车键盘事件
		jTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='\n'){
					jconfirm.doClick();
				}
			}
		});
	}
}
