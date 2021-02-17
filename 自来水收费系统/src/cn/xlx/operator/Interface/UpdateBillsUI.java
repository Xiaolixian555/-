package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.operator.entity.UpdateBill;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;

public class UpdateBillsUI {
	static ArrayList<UpdateBill> udList = new ArrayList<UpdateBill>(); // 定义账单集合
	static int lines = 0;//行数
	public static void getUpdateBillsUI(Operators operators, Long id) {
		//鼠标样式定义
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon("src/images/cursor2.png").getImage();
		Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
		JFrame jfub = new JFrame("账务记录");
		jfub.setSize(1910, 960); // 设置窗体大小
		jfub.setBackground(Color.WHITE); // 设置背景颜色
		jfub.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
		jfub.setCursor(cursor);  //设置鼠标样式
		jfub.setLayout(null); // 无布局
		JLayeredPane layeredPane = new JLayeredPane();
		//创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
		JPanel jpanel = new JPanel();
		//创建背景图片对象
		ImageIcon imageIcon = new ImageIcon("src/images/operatorlogin.jpeg");    // Icon由图片文件形成
		Image image0 = imageIcon.getImage();                         // 但这个图片太大不适合做Icon
		// 为把它缩小点，先要取出这个Icon的image ,然后缩放到合适的大小
		Image bigImage = image0.getScaledInstance(1910, 960, Image.SCALE_FAST);
		// 再由修改后的Image来生成合适的Icon
		ImageIcon image = new ImageIcon(bigImage);
		//创建背景的那些东西
		jpanel.setBounds(0, 0, 1910, 960);
		JLabel jlabel = new JLabel(image);  //创建一个标签，里面存放image
		jpanel.add(jlabel);  //将标签加进面板容器jpanel中
		ImageIcon icon1 = new ImageIcon("src/images/button3.jpeg");
		ImageIcon icon2 = new ImageIcon("src/images/button4.jpg");
		JButton jback = new JButton("返回上一层",icon1);
		jback.setBounds(40, 22, 140, 50); // 标签大小和位置
		jback.setFont(new Font("楷体", 1, 20)); // 设置字体
		jback.setForeground(new Color(0x566347)); // 设置字体颜色
		jback.setHorizontalTextPosition(SwingConstants.CENTER);
		jback.setBorder(new TextBorderUtlis(new Color(0x2C711C), 2, true));
		jback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

		JLabel jltitle = new JLabel("该业主名下的账务");
		jltitle.setBounds(780, 0, 300, 100); // 标签大小和位置
		jltitle.setFont(new Font("楷体", 1, 32)); // 设置字体
		jltitle.setForeground(new Color(0x166F0C)); // 设置字体颜色

		// 列名组件
		JLabel jlid = new JLabel("账单编号");
		jlid.setBounds(50, 120, 80, 30); // 标签大小和位置
		jlid.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlid.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlyear = new JLabel("账务年份");
		jlyear.setBounds(210, 120, 80, 30); // 标签大小和位置
		jlyear.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlyear.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlmonth = new JLabel("账务月份");
		jlmonth.setBounds(390, 120, 80, 30); // 标签大小和位置
		jlmonth.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlmonth.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlnum0 = new JLabel("上月累计数");
		jlnum0.setBounds(560, 120, 100, 30); // 标签大小和位置
		jlnum0.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlnum0.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlnum1 = new JLabel("本月累计数");
		jlnum1.setBounds(740, 120, 100, 30); // 标签大小和位置
		jlnum1.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlnum1.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlusenum = new JLabel("本月使用数");
		jlusenum.setBounds(920, 120, 100, 30); // 标签大小和位置
		jlusenum.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlusenum.setForeground(Color.black); // 设置字体颜色

		JLabel jlmoney = new JLabel("应缴金额");
		jlmoney.setBounds(1110, 120, 80, 30); // 标签大小和位置
		jlmoney.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlmoney.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlisfee = new JLabel("是否已缴");
		jlisfee.setBounds(1290, 120, 80, 30); // 标签大小和位置
		jlisfee.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlisfee.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlfeedate = new JLabel("缴费日期");
		jlfeedate.setBounds(1480, 120, 80, 30); // 标签大小和位置
		jlfeedate.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlfeedate.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		JLabel jlfeeuser = new JLabel("收费员");
		jlfeeuser.setBounds(1660, 120, 80, 30); // 标签大小和位置
		jlfeeuser.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlfeeuser.setForeground(new Color(0x0F5F11)); // 设置字体颜色

		// 文本框组件
		udList = OperatorsDao.getUpdateBills(id);
		int height = 155;
		for (int i = 0; i < udList.size(); i++) {
			lines++;
			JLabel jllid = new JLabel();
			jllid.setBounds(20, height, 130, 30); // 标签大小和位置
			jllid.setFont(new Font("宋体", 1, 18)); // 设置字体
			jllid.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jllid.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jllid.setText(udList.get(i).getId().toString());

			JTextField jtyear = new JTextField();
			jtyear.setBounds(180, height, 140, 30); // 标签大小和位置
			jtyear.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtyear.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtyear.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtyear.setText(udList.get(i).getYear());

			JTextField jtmonth = new JTextField();
			jtmonth.setBounds(360, height, 140, 30); // 标签大小和位置
			jtmonth.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtmonth.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtmonth.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtmonth.setText(udList.get(i).getMonth());

			JTextField jtnum0 = new JTextField();
			jtnum0.setBounds(540, height, 140, 30); // 标签大小和位置
			jtnum0.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtnum0.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtnum0.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtnum0.setText(udList.get(i).getNum0().toString());

			JTextField jtnum1 = new JTextField();
			jtnum1.setBounds(720, height, 140, 30); // 标签大小和位置
			jtnum1.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtnum1.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtnum1.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtnum1.setText(udList.get(i).getNum1().toString());

			JTextField jtusenum = new JTextField();
			jtusenum.setBounds(900, height, 140, 30); // 标签大小和位置
			jtusenum.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtusenum.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtusenum.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtusenum.setText(udList.get(i).getUsenum().toString());

			JTextField jtmoney = new JTextField();
			jtmoney.setBounds(1080, height, 140, 30); // 标签大小和位置
			jtmoney.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtmoney.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtmoney.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtmoney.setText(udList.get(i).getMoney().toString());

			JTextField jtisfee = new JTextField();
			jtisfee.setBounds(1260, height, 140, 30); // 标签大小和位置
			jtisfee.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtisfee.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtisfee.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			if (udList.get(i).getIsfee().equals("y")) {
				jtisfee.setText("已缴费");
			} else {
				jtisfee.setText("未缴费");
			}

			JTextField jtfeedate = new JTextField();
			jtfeedate.setBounds(1440, height, 140, 30); // 标签大小和位置
			jtfeedate.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtfeedate.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jtfeedate.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			if (udList.get(i).getFeedate() == null) {
				jtfeedate.setText("暂无记录");
			} else {
				jtfeedate.setText(udList.get(0).getFeedate().toString());
			}

			JLabel jllfeeuser = new JLabel();
			jllfeeuser.setBounds(1620, height, 140, 30); // 标签大小和位置
			jllfeeuser.setFont(new Font("宋体", 1, 18)); // 设置字体
			jllfeeuser.setForeground(new Color(0x0F5F11)); // 设置字体颜色
			jllfeeuser.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jllfeeuser.setText(udList.get(i).getFeeuser());

			JButton jbchange = new JButton("修改",icon1);
			jbchange.setBounds(1780, height, 90, 30); // 标签大小和位置
			jbchange.setFont(new Font("楷体", 1, 20)); // 设置字体
			jbchange.setForeground(new Color(0x566347)); // 设置字体颜色
			jbchange.setHorizontalTextPosition(SwingConstants.CENTER);
			jbchange.setBorder(new TextBorderUtlis(new Color(0x2C711C), 2, true));
			jbchange.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
			jbchange.setContentAreaFilled(false);//设置图片填满按钮所在的区域
			jbchange.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

			// 数据列加载
			jfub.add(jllid);
			jfub.add(jtyear);
			jfub.add(jtmonth);
			jfub.add(jtnum0);
			jfub.add(jtnum1);
			jfub.add(jtusenum);
			jfub.add(jtmoney);
			jfub.add(jtisfee);
			jfub.add(jtfeedate);
			jfub.add(jllfeeuser);
			jfub.add(jbchange);
			layeredPane.add(jllid, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtyear, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtmonth, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtnum0, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtnum1, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtusenum, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtmoney, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtisfee, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jtfeedate, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jllfeeuser, JLayeredPane.MODAL_LAYER);
			layeredPane.add(jbchange, JLayeredPane.MODAL_LAYER);
			// 对每一个修改按钮进行点击事件
			jbchange.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {				
					ArrayList<UpdateBill> NewList=getNewList(lines, jllid, jtyear, jtmonth, jtnum0, jtnum1, jtusenum, jtmoney, jtisfee, jtfeedate, jllfeeuser);
					OperatorsDao.setUpdateBills(NewList, id); // 执行修改数据库的数据
					PromptTool.getPromptTool("修改成功！");
				}
			});
			//鼠标移入移出按钮事件
			jbchange.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					jbchange.setFont(new Font("楷体", 1, 22)); // 设置字体
					Toolkit tk = Toolkit.getDefaultToolkit();
					Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
					Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
					jfub.setCursor(cursor);  //设置鼠标样式
				}

				@Override
				public void mouseExited(MouseEvent e) {
					jbchange.setFont(new Font("楷体", 1, 20)); // 设置字体
					Toolkit tk = Toolkit.getDefaultToolkit();
					Image img = new ImageIcon("src/images/cursor2.png").getImage();
					Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
					jfub.setCursor(cursor);  //设置鼠标样式
				}
			});
			height = height + 40; // 行高加40

		}

		// 加载组件并显示窗体
		jfub.add(jltitle);
		jfub.add(jback);
		jfub.add(jlid);
		jfub.add(jlyear);
		jfub.add(jlmonth);
		jfub.add(jlnum0);
		jfub.add(jlnum1);
		jfub.add(jlusenum);
		jfub.add(jlmoney);
		jfub.add(jlisfee);
		jfub.add(jlfeedate);
		jfub.add(jlfeeuser);
		jfub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel, JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jltitle, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jback, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlid, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlyear, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlmonth, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlnum0, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlnum1, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlusenum, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlmoney, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlisfee, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlfeedate, JLayeredPane.MODAL_LAYER);
		layeredPane.add(jlfeeuser, JLayeredPane.MODAL_LAYER);
		jfub.setResizable(false);//不允许调整窗体大小
		jfub.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
		jfub.setVisible(true);
		
		//返回上一层按钮添加点击事件
		jback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessTypeUI.getBusinessTypeUI(operators, id);
				jfub.setVisible(false);		
			}
		});
		//返回上一层添加鼠标移入移出按钮事件
		jback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 22)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfub.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 20)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfub.setCursor(cursor);  //设置鼠标样式
			}
		});

	}

	// 获取当前填好的集合
	private static ArrayList<UpdateBill> getNewList(int lines,JLabel jllid,JTextField jbyear,JTextField jbmonth,JTextField jbnum0,JTextField jbnum1,JTextField jbusenum,JTextField jbmoney,JTextField jbisfee,JTextField jbfeedate,JLabel jllfeeuser){
		ArrayList<UpdateBill> newlist = new ArrayList<UpdateBill>();
		for(int i=0; i<lines;i++){
			UpdateBill updateBill = new UpdateBill();
			updateBill.setId(Long.valueOf(jllid.getText()));
			updateBill.setYear(jbyear.getText());
			updateBill.setMonth(jbmonth.getText());
			updateBill.setNum0(Long.valueOf(jbnum0.getText()));
			updateBill.setNum1(Long.valueOf(jbnum1.getText()));
			updateBill.setUsenum(Long.valueOf(jbusenum.getText()));
			updateBill.setMoney(Long.valueOf(jbmoney.getText()));
			updateBill.setIsfee(jbisfee.getText());
			
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ); 
			String aa=jbfeedate.getText(); 
			java.util.Date timeDate = null; 		
			try { 
				timeDate = sdf.parse(aa); 
				} 
			catch (Exception e) { 
				// TODO 自动生成 catch 块 
				e.printStackTrace(); 
				}//util类型 
				java.sql.Date dateTime = new java.sql.Date(timeDate.getTime()); //sql类型
			
			updateBill.setFeedate(dateTime);
			updateBill.setFeeuser(jllfeeuser.getText());
			newlist.add(updateBill);			
		}
		return newlist;
	}
}
