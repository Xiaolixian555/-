package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;

public class AddSingleUI {
	public static void getOwnerAddUI(Operators operators) {
		JFrame jfadd = new JFrame("添加业主"); // 创建窗体对象并赋标题参数
		jfadd.setSize(740, 700); // 设置窗体大小
		jfadd.setBackground(Color.WHITE); // 设置背景颜色
		jfadd.setLocation(300, 200); // 设置窗体显示位置
		jfadd.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("添加业主");
		jLabel.setBounds(300, 0, 300, 100); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 33)); // 设置字体
		jLabel.setForeground(Color.blue); // 设置字体颜色

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
		JButton jButton = new JButton("添加");
		JButton jback = new JButton("返回上一层");

		// 对各种标签的样式
		jlid.setBounds(50, 120, 108, 40);
		jlid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlid.setForeground(Color.black); // 设置字体颜色

		jlname.setBounds(50, 170, 108, 40);
		jlname.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlname.setForeground(Color.black); // 设置字体颜色

		jlpassword.setBounds(50, 220, 108, 40);
		jlpassword.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlpassword.setForeground(Color.black); // 设置字体颜色

		jladdressid.setBounds(50, 270, 108, 40);
		jladdressid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jladdressid.setForeground(Color.black); // 设置字体颜色

		jlhousenumber.setBounds(50, 320, 108, 40);
		jlhousenumber.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlhousenumber.setForeground(Color.black); // 设置字体颜色

		jlwatermeter.setBounds(50, 370, 108, 40);
		jlwatermeter.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlwatermeter.setForeground(Color.black); // 设置字体颜色

		jladddate.setBounds(50, 420, 108, 40);
		jladddate.setFont(new Font("宋体", 1, 20)); // 设置字体
		jladddate.setForeground(Color.black); // 设置字体颜色

		jlownertypeid.setBounds(50, 470, 108, 40);
		jlownertypeid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jlownertypeid.setForeground(Color.black); // 设置字体颜色

		// 对各种输入框的样式
		jtid.setBounds(200, 120, 340, 40);
		jtid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtid.setForeground(Color.black); // 设置字体颜色

		jtname.setBounds(200, 170, 340, 40);
		jtname.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtname.setForeground(Color.black); // 设置字体颜色

		jtpassword.setBounds(200, 220, 340, 40);
		jtpassword.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtpassword.setForeground(Color.black); // 设置字体颜色

		jtaddressid.setBounds(200, 270, 340, 40);
		jtaddressid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtaddressid.setForeground(Color.black); // 设置字体颜色

		jthousenumber.setBounds(200, 320, 340, 40);
		jthousenumber.setFont(new Font("宋体", 1, 20)); // 设置字体
		jthousenumber.setForeground(Color.black); // 设置字体颜色

		jtwatermeter.setBounds(200, 370, 340, 40);
		jtwatermeter.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtwatermeter.setForeground(Color.black); // 设置字体颜色

		jtadddate.setBounds(200, 420, 340, 40);
		jtadddate.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtadddate.setForeground(Color.black); // 设置字体颜色

		jtownertypeid.setBounds(200, 470, 340, 40);
		jtownertypeid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jtownertypeid.setForeground(Color.black); // 设置字体颜色

		// 对各种按钮的样式
		jButton.setBounds(160, 550, 160, 45);
		jButton.setFont(new Font("宋体", 1, 20)); // 设置字体
		jButton.setForeground(Color.black); // 设置字体颜色

		jback.setBounds(400, 550, 160, 45);
		jback.setFont(new Font("宋体", 1, 20)); // 设置字体
		jback.setForeground(Color.black); // 设置字体颜色

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
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				jfadd.setVisible(false); // 关闭本窗体
				OwnerAddTypeUI.getOwnerAddTypeUI(operators);  //返回上一层
				AddSuccessPrompt.getAddSuccessPrompt();  //弹出"添加成功"提示窗
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
	}
}
