package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.TextBorderUtlis;
import cn.xlx.waterboss.Interface.PromptUI;
import cn.xlx.waterboss.dao.OwnersDao;
import cn.xlx.waterboss.entity.Owners;

public class ModifyMessageUI {
	// 定义当前的面板上的owner
	static Owners currentowner = new Owners();

	public static void getModifyMessageUI(Operators operators,Owners owners) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame wpjframe = new JFrame("修改业主信息"); // 创建窗体对象并赋标题参数
		wpjframe.setSize(740, 700); // 设置窗体大小
		wpjframe.setBackground(Color.WHITE); // 设置背景颜色
		wpjframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		wpjframe.setLayout(null); // 无布局
		wpjframe.setCursor(cursor);  //设置鼠标样式
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
		JLabel jLabel = new JLabel("修改业主信息",JLabel.CENTER);
		jLabel.setBounds(0, 0, 740, 100); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色

		// 定义各种标签
		JLabel jlid = new JLabel("账号id:");
		JLabel jlname = new JLabel("姓名:");
		JLabel jlpassword = new JLabel("密码:");
		JLabel jladdressid = new JLabel("地址id:");
		JLabel jlhousenumber = new JLabel("门牌号:");
		JLabel jlwatermeter = new JLabel("水表编号:");
		JLabel jladddate = new JLabel("登记日期:");
		JLabel jlownertypeid = new JLabel("类型id:");
		// 定义各种输入框
		JTextField jtid = new JTextField();
		JTextField jtname = new JTextField();
		JPasswordField jtpassword = new JPasswordField();
		JTextField jtaddressid = new JTextField();
		JTextField jthousenumber = new JTextField();
		JTextField jtwatermeter = new JTextField();
		JTextField jtadddate = new JTextField();
		JTextField jtownertypeid = new JTextField();
		// 定义各种按钮
		ImageIcon icon1 = new ImageIcon("src/images/button4.jpg");
		ImageIcon icon2 = new ImageIcon("src/images/button3.jpeg");
		JButton jbid = new JButton("修改",icon1);
		JButton jbname = new JButton("修改",icon1);
		JButton jbpassword = new JButton("修改",icon1);
		JButton jbaddressid = new JButton("修改",icon1);
		JButton jbhousenumber = new JButton("修改",icon1);
		JButton jbwatermeter = new JButton("修改",icon1);
		JButton jbownertypeid = new JButton("修改",icon1);
		JButton jbback = new JButton("返回主界面",icon2);
		// 对各种标签的样式
		jlid.setBounds(50, 120, 108, 40);
		jlid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlid.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		jlname.setBounds(50, 170, 108, 40);
		jlname.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlname.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		jlpassword.setBounds(50, 220, 108, 40);
		jlpassword.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlpassword.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		jladdressid.setBounds(50, 270, 108, 40);
		jladdressid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jladdressid.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		jlhousenumber.setBounds(50, 320, 108, 40);
		jlhousenumber.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlhousenumber.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		jlwatermeter.setBounds(50, 370, 108, 40);
		jlwatermeter.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlwatermeter.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		jladddate.setBounds(50, 420, 108, 40);
		jladddate.setFont(new Font("宋体", 1, 20)); // 设置字体
		jladddate.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		jlownertypeid.setBounds(50, 470, 108, 40);
		jlownertypeid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlownertypeid.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		// 对各种输入框的样式
		jtid.setBounds(200, 120, 340, 40);
		jtid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtid.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jtid.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtname.setBounds(200, 170, 340, 40);
		jtname.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtname.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jtname.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtpassword.setBounds(200, 220, 340, 40);
		jtpassword.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtpassword.setForeground(Color.black); // 设置字体颜色
		jtpassword.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jtpassword.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtaddressid.setBounds(200, 270, 340, 40);
		jtaddressid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtaddressid.setForeground(Color.black); // 设置字体颜色
		jtaddressid.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jtaddressid.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jthousenumber.setBounds(200, 320, 340, 40);
		jthousenumber.setFont(new Font("宋体", 1, 20)); // 设置字体
		jthousenumber.setForeground(Color.black); // 设置字体颜色
		jthousenumber.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jthousenumber.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtwatermeter.setBounds(200, 370, 340, 40);
		jtwatermeter.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtwatermeter.setForeground(Color.black); // 设置字体颜色
		jtwatermeter.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jtwatermeter.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtadddate.setBounds(200, 420, 340, 40);
		jtadddate.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtadddate.setForeground(Color.black); // 设置字体颜色
		jtadddate.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jtadddate.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtownertypeid.setBounds(200, 470, 340, 40);
		jtownertypeid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtownertypeid.setForeground(Color.black); // 设置字体颜色
		jtownertypeid.setForeground(new Color(0x0F5F11)); // 设置字体颜色
		jtownertypeid.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		// 对各种按钮的样式
		jbid.setBounds(570, 120, 100, 40);
		jbid.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbid.setForeground(new Color(0x566347)); // 设置字体颜色
		jbid.setHorizontalTextPosition(SwingConstants.CENTER);
		jbid.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbid.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbid.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbid.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jbname.setBounds(570, 170, 100, 40);
		jbname.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbname.setForeground(new Color(0x566347)); // 设置字体颜色
		jbname.setHorizontalTextPosition(SwingConstants.CENTER);
		jbname.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbname.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbname.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbname.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jbpassword.setBounds(570, 220, 100, 40);
		jbpassword.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbpassword.setForeground(new Color(0x566347)); // 设置字体颜色
		jbpassword.setHorizontalTextPosition(SwingConstants.CENTER);
		jbpassword.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbpassword.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbpassword.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbpassword.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jbaddressid.setBounds(570, 270, 100, 40);
		jbaddressid.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbaddressid.setForeground(new Color(0x566347)); // 设置字体颜色
		jbaddressid.setHorizontalTextPosition(SwingConstants.CENTER);
		jbaddressid.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbaddressid.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbaddressid.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbaddressid.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jbhousenumber.setBounds(570, 320, 100, 40);
		jbhousenumber.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbhousenumber.setForeground(new Color(0x566347)); // 设置字体颜色
		jbhousenumber.setHorizontalTextPosition(SwingConstants.CENTER);
		jbhousenumber.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbhousenumber.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbhousenumber.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbhousenumber.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jbwatermeter.setBounds(570, 370, 100, 40);
		jbwatermeter.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbwatermeter.setForeground(new Color(0x566347)); // 设置字体颜色
		jbwatermeter.setHorizontalTextPosition(SwingConstants.CENTER);
		jbwatermeter.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbwatermeter.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbwatermeter.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbwatermeter.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jbownertypeid.setBounds(570, 470, 100, 40);
		jbownertypeid.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbownertypeid.setForeground(new Color(0x566347)); // 设置字体颜色
		jbownertypeid.setHorizontalTextPosition(SwingConstants.CENTER);
		jbownertypeid.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbownertypeid.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbownertypeid.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbownertypeid.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jbback.setBounds(270, 550, 160, 45);
		jbback.setFont(new Font("楷体", 1, 22)); // 设置字体
		jbback.setForeground(new Color(0x566347)); // 设置字体颜色
		jbback.setHorizontalTextPosition(SwingConstants.CENTER);
		jbback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jbback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jbback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jbback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		// 标签标题加入到界面
		wpjframe.add(jLabel);
		// 加载各种标签
		wpjframe.add(jlid);
		wpjframe.add(jlname);
		wpjframe.add(jlpassword);
		wpjframe.add(jladdressid);
		wpjframe.add(jlhousenumber);
		wpjframe.add(jlwatermeter);
		wpjframe.add(jladddate);
		wpjframe.add(jlownertypeid);
		// 加载各种输入框
		wpjframe.add(jtid);
		wpjframe.add(jtname);
		wpjframe.add(jtpassword);
		wpjframe.add(jtaddressid);
		wpjframe.add(jthousenumber);
		wpjframe.add(jtwatermeter);
		wpjframe.add(jtadddate);
		wpjframe.add(jtownertypeid);
		// 加载各种按钮
		wpjframe.add(jbid);
		wpjframe.add(jbname);
		wpjframe.add(jbpassword);
		wpjframe.add(jbaddressid);
		wpjframe.add(jbhousenumber);
		wpjframe.add(jbwatermeter);
		wpjframe.add(jbownertypeid);
		wpjframe.add(jbback);

		// 加载数据内容
		loading(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter, jtadddate, jtownertypeid);
		wpjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
		layeredPane.add(jlid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlname,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlpassword,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jladdressid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlhousenumber,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlwatermeter,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jladddate,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlownertypeid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtname,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtpassword,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtaddressid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jthousenumber,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtwatermeter,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtadddate,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jtownertypeid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbname,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbpassword,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbaddressid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbhousenumber,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbwatermeter,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbownertypeid,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jbback,JLayeredPane.MODAL_LAYER);
		wpjframe.setResizable(false);//不允许调整窗体大小
		wpjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		// 显示窗体
		wpjframe.setVisible(true);

		// 设置jbid修改按钮的点击事件
		jbid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				OwnersDao.update(currentowner);
				PromptUI.getPromptUI();
			}
		});
		// 设置jbname修改按钮的点击事件
		jbname.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				OwnersDao.update(currentowner);
				PromptUI.getPromptUI();
			}
		});
		// 设置jbpassword修改按钮的点击事件
		jbpassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				OwnersDao.update(currentowner);
				PromptUI.getPromptUI();
			}
		});
		// 设置jbaddressid修改按钮的点击事件
		jbaddressid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				OwnersDao.update(currentowner);
				PromptUI.getPromptUI();
			}
		});
		// 设置jbhousenumber修改按钮的点击事件
		jbhousenumber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				OwnersDao.update(currentowner);
				PromptUI.getPromptUI();
			}
		});
		// 设置jbwatermeter修改按钮的点击事件
		jbwatermeter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				OwnersDao.update(currentowner);
				PromptUI.getPromptUI();
			}
		});
		// 设置jbownertypeid修改按钮的点击事件
		jbownertypeid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				OwnersDao.update(currentowner);
				PromptUI.getPromptUI();
			}
		});
		// 设置jbback返回主菜单按钮的点击事件
		jbback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCurrentowner(owners, jtid, jtname, jtpassword, jtaddressid, jthousenumber, jtwatermeter,
						jtownertypeid);
				BusinessTypeUI.getBusinessTypeUI(operators, owners.getId());
				wpjframe.setVisible(false);
			}
		});
		//鼠标移入移出按钮事件
		jbid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbid.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbid.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbname.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbname.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbpassword.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbpassword.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbaddressid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbaddressid.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbaddressid.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbhousenumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbhousenumber.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbhousenumber.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbwatermeter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbwatermeter.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbwatermeter.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbownertypeid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbownertypeid.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbownertypeid.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});
		jbback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbback.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbback.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				wpjframe.setCursor(cursor);  //设置鼠标样式
			}
		});

	}



	// 加载个人中心内容
	public static void loading(Owners o, JTextField jfid, JTextField jfname, JTextField jfpassword,
			JTextField jfaddressid, JTextField jfhousenumber, JTextField jfwatermeter, JTextField jfadddate,
			JTextField jfownertypeid) {
		jfid.setText(o.getId().toString());
		jfname.setText(o.getName());
		jfpassword.setText(o.getPassword());
		jfaddressid.setText(o.getAddressid().toString());
		jfhousenumber.setText(o.getHousenumber());
		jfwatermeter.setText(o.getWatermeter());
		jfadddate.setText(o.getAdddate().toString());
		jfownertypeid.setText(o.getOwnertypeid().toString());

	}

	// 获取当前的面板的内容给currentowner的方法
	public static void setCurrentowner(Owners o, JTextField jfid, JTextField jfname, JTextField jfpassword,
			JTextField jfaddressid, JTextField jfhousenumber, JTextField jfwatermeter, JTextField jfownertypeid) {
		currentowner.setId(Long.valueOf(jfid.getText()));
		currentowner.setName(jfname.getText());
		currentowner.setPassword(jfpassword.getText());
		currentowner.setAddressid(Long.valueOf(jfaddressid.getText()));
		currentowner.setHousenumber(jfhousenumber.getText());
		currentowner.setWatermeter(jfwatermeter.getText());
		currentowner.setAdddate(o.getAdddate());
		currentowner.setOwnertypeid(Long.valueOf(jfownertypeid.getText()));
	}

}
