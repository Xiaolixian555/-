package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;

public class AddSingleUI {
	public static void getOwnerAddUI(Operators operators) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame jfadd = new JFrame("添加业主"); // 创建窗体对象并赋标题参数
		jfadd.setSize(740, 700); // 设置窗体大小
		jfadd.setBackground(Color.WHITE); // 设置背景颜色
		jfadd.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		jfadd.setCursor(cursor);  //设置鼠标样式
		jfadd.setLayout(null); // 无布局

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

		JLabel jLabel = new JLabel("添加业主");
		jLabel.setBounds(300, 0, 300, 110); // 标签大小和位置
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
		JButton jButton = new JButton("添加",icon1);
		JButton jback = new JButton("返回上一层",icon2);

		// 对各种标签的样式
		jlid.setBounds(50, 120, 108, 40);
		jlid.setFont(new Font("宋体", 1, 21)); // 设置字体
		jlid.setForeground(new Color(0x166F0C)); // 设置字体颜色

		jlname.setBounds(50, 170, 108, 40);
		jlname.setFont(new Font("宋体", 1, 21)); // 设置字体
		jlname.setForeground(new Color(0x166F0C)); // 设置字体颜色

		jlpassword.setBounds(50, 220, 108, 40);
		jlpassword.setFont(new Font("宋体", 1, 21)); // 设置字体
		jlpassword.setForeground(new Color(0x166F0C)); // 设置字体颜色

		jladdressid.setBounds(50, 270, 108, 40);
		jladdressid.setFont(new Font("宋体", 1, 21)); // 设置字体
		jladdressid.setForeground(new Color(0x166F0C)); // 设置字体颜色

		jlhousenumber.setBounds(50, 320, 108, 40);
		jlhousenumber.setFont(new Font("宋体", 1, 21)); // 设置字体
		jlhousenumber.setForeground(new Color(0x166F0C)); // 设置字体颜色

		jlwatermeter.setBounds(50, 370, 108, 40);
		jlwatermeter.setFont(new Font("宋体", 1, 21)); // 设置字体
		jlwatermeter.setForeground(new Color(0x166F0C)); // 设置字体颜色

		jladddate.setBounds(50, 420, 108, 40);
		jladddate.setFont(new Font("宋体", 1, 21)); // 设置字体
		jladddate.setForeground(new Color(0x166F0C)); // 设置字体颜色

		jlownertypeid.setBounds(50, 470, 108, 40);
		jlownertypeid.setFont(new Font("宋体", 1, 21)); // 设置字体
		jlownertypeid.setForeground(new Color(0x166F0C)); // 设置字体颜色

		// 对各种输入框的样式
		jtid.setBounds(200, 120, 340, 40);
		jtid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtid.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtid.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtname.setBounds(200, 170, 340, 40);
		jtname.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtname.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtname.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtpassword.setBounds(200, 220, 340, 40);
		jtpassword.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtpassword.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtpassword.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtaddressid.setBounds(200, 270, 340, 40);
		jtaddressid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtaddressid.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtaddressid.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jthousenumber.setBounds(200, 320, 340, 40);
		jthousenumber.setFont(new Font("宋体", 1, 20)); // 设置字体
		jthousenumber.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jthousenumber.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtwatermeter.setBounds(200, 370, 340, 40);
		jtwatermeter.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtwatermeter.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtwatermeter.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtadddate.setBounds(200, 420, 340, 40);
		jtadddate.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtadddate.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtadddate.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		jtownertypeid.setBounds(200, 470, 340, 40);
		jtownertypeid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtownertypeid.setForeground(new Color(0x2C711C)); // 设置字体颜色
		jtownertypeid.setBorder(new TextBorderUtlis(new Color(0x2C711C),3,false));

		// 对各种按钮的样式
		jButton.setBounds(160, 550, 160, 45);
		jButton.setFont(new Font("楷体", 1, 22)); // 设置字体
		jButton.setForeground(new Color(0x566347)); // 设置字体颜色
		jButton.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jButton.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jButton.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jButton.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		jback.setBounds(400, 550, 160, 45);
		jback.setFont(new Font("楷体", 1, 22)); // 设置字体
		jback.setForeground(new Color(0x566347)); // 设置字体颜色
		jback.setHorizontalTextPosition(SwingConstants.CENTER);
		jback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		// 标签标题加入到界面
		jfadd.add(jLabel);
		// 加载各种标签
		jfadd.add(jlid);
		jfadd.add(jlname);
		jfadd.add(jlpassword);
		jfadd.add(jladdressid);
		jfadd.add(jlhousenumber);
		jfadd.add(jlwatermeter);
		jfadd.add(jladddate);
		jfadd.add(jlownertypeid);
		// 加载各种输入框
		jfadd.add(jtid);
		jfadd.add(jtname);
		jfadd.add(jtpassword);
		jfadd.add(jtaddressid);
		jfadd.add(jthousenumber);
		jfadd.add(jtwatermeter);
		jfadd.add(jtadddate);
		jfadd.add(jtownertypeid);
		// 加载各种按钮
		jfadd.add(jButton);
		jfadd.add(jback);
		//设置各组件的层级
		jfadd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		layeredPane.add(jButton,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jback,JLayeredPane.MODAL_LAYER);
		jfadd.setResizable(false);//不允许调整窗体大小
		jfadd.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		// 本窗体显示
		jfadd.setVisible(true);

		// 为按钮"添加"添加点击事件
		jButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormatHiddenHour = new SimpleDateFormat("yyyy-MM-dd");
				java.sql.Date date = null;
				try {
					//将字符串转化为java.sql.date
					String s = dateFormatHiddenHour.format(dateFormatHiddenHour.parse(jtadddate.getText()));
					date = java.sql.Date.valueOf(s);
					OperatorsDao.addOwner(Long.valueOf(jtid.getText()), jtname.getText(), jtpassword.getText(),
							Long.valueOf(jtaddressid.getText()), jthousenumber.getText(), jtwatermeter.getText(), date,
							Long.valueOf(jtownertypeid.getText()));
					if(OperatorsDao.ifadd){  //判断被影响条数所决定的ifdelete值
						jfadd.setVisible(false); // 关闭本窗体
						OwnerAddTypeUI.getOwnerAddTypeUI(operators);  //返回上一层
						PromptTool.getPromptTool("添加成功！");  //弹出"添加成功"提示窗
					}
					else{
						//显示该id已存在窗体
						PromptTool.getPromptTool("该id已存在！");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}



			}
		});
		// 为按钮"返回上一层"添加点击事件
		jback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OwnerAddTypeUI.getOwnerAddTypeUI(operators); //返回上一层
				jfadd.setVisible(false); // 关闭本窗体
			}
		});
		//鼠标移入移出按钮事件
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}
		});
		jback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}
		});
		//设置回车键盘事件
		jtownertypeid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='\n'){
					jButton.doClick();
				}
			}
		});
	}
}
