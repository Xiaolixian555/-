package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;


public class DeletePromptUI {
	public static void getDeletePromptUI(Operators operators,Long id) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame isdelJF = new JFrame("提示信息"); // 创建窗体对象并赋标题参数
		isdelJF.setSize(520, 300); // 设置窗体大小
		isdelJF.setBackground(Color.WHITE); // 设置背景颜色
		isdelJF.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		isdelJF.setCursor(cursor);  //设置鼠标样式
		isdelJF.setLayout(null); // 无布局
		//创建一个JLayeredPane用于分层的。
		JLayeredPane layeredPane = new JLayeredPane();
		//创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
		JPanel jpanel = new JPanel();
		//创建背景图片对象
		ImageIcon image = new ImageIcon("src/images/prompt.jpeg");
		//创建背景的那些东西
		jpanel.setBounds(0, 10, 745, 700);
		JLabel  jlabel = new JLabel(image);  //创建一个标签，里面存放image
		jpanel.add(jlabel);  //将标签加进面板容器jpanel中
		JLabel jLabel = new JLabel("您确定要删除该业主吗？");
		jLabel.setBounds(126, 30, 300, 80); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 26)); // 设置字体
		jLabel.setForeground(new Color(0x000000)); // 设置字体颜色

		ImageIcon icon1 = new ImageIcon("src/images/button3.jpeg");
		JButton jbyes = new JButton("确定",icon1);
		jbyes.setBounds(110, 160, 130, 40); // 标签大小和位置
		jbyes.setFont(new Font("楷体", 1, 21)); // 设置字体
		jbyes.setForeground(Color.red); // 设置字体颜色
		jbyes.setHorizontalTextPosition(SwingConstants.CENTER);
		jbyes.setBorder(new TextBorderUtlis(new Color(0x712A12),2,true));
		jbyes.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbyes.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbyes.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		ImageIcon icon2 = new ImageIcon("src/images/button3.jpeg");
		JButton jbno = new JButton("取消",icon2);
		jbno.setBounds(290, 160, 130, 40); // 标签大小和位置
		jbno.setFont(new Font("楷体", 1, 21)); // 设置字体
		jbno.setForeground(Color.blue); // 设置字体颜色
		jbno.setHorizontalTextPosition(SwingConstants.CENTER);
		jbno.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbno.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbno.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbno.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离
		
		//加载所有组件
		isdelJF.add(jLabel);
		isdelJF.add(jbyes);
		isdelJF.add(jbno);
		//设置各组件的层级
		isdelJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
		layeredPane.add(jbyes,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbno,JLayeredPane.MODAL_LAYER);
		isdelJF.setResizable(false);//不允许调整窗体大小
		isdelJF.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		//显示本窗体
		isdelJF.setVisible(true);
		
		//为"确定"按钮添加点击事件
		jbyes.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//关闭当前提示框
				isdelJF.setVisible(false);
				//做删除操作
				OperatorsDao.deleteOwner(id); //先删除
				if(OperatorsDao.ifdelete){  //判断被影响条数所决定的ifdelete值
					//显示删除成功窗体
					DeleteSuccessPrompt.getDeleteSuccessPrompt();				
				}
				else{
					//显示该id不存在窗体
					PromptTool.getPromptTool("该id不存在！");
				}
				
			}
		});
		//为"取消"按钮添加点击事件
		jbno.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				isdelJF.setVisible(false);			
			}
		});
		//鼠标移入移出按钮事件
		jbyes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbyes.setFont(new Font("楷体", 1, 23)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				isdelJF.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbyes.setFont(new Font("楷体", 1, 21)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				isdelJF.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbno.setFont(new Font("楷体", 1, 23)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				isdelJF.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbno.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				isdelJF.setCursor(cursor);  //设置鼠标样式
			}
		});

	}
}
