package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.xlx.operator.entity.Operators;
import cn.xlx.waterboss.Interface.PromptUI;
import cn.xlx.waterboss.dao.OwnersDao;
import cn.xlx.waterboss.entity.Owners;

public class ModifyMessageUI {
	// 定义当前的面板上的owner
	static Owners currentowner = new Owners();

	public static void getModifyMessageUI(Operators operators,Owners owners) {
		JFrame wpjframe = new JFrame("修改业主信息"); // 创建窗体对象并赋标题参数
		wpjframe.setSize(740, 700); // 设置窗体大小
		wpjframe.setBackground(Color.WHITE); // 设置背景颜色
		wpjframe.setLocation(300, 200); // 设置窗体显示位置
		wpjframe.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("修改业主信息");
		jLabel.setBounds(290, 0, 300, 100); // 标签大小和位置
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
		JButton jbid = new JButton("修改");
		JButton jbname = new JButton("修改");
		JButton jbpassword = new JButton("修改");
		JButton jbaddressid = new JButton("修改");
		JButton jbhousenumber = new JButton("修改");
		JButton jbwatermeter = new JButton("修改");
		JButton jbownertypeid = new JButton("修改");
		JButton jbback = new JButton("返回主界面");
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
		jbid.setBounds(570, 120, 100, 40);
		jbid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbid.setForeground(Color.black); // 设置字体颜色

		jbname.setBounds(570, 170, 100, 40);
		jbname.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbname.setForeground(Color.black); // 设置字体颜色

		jbpassword.setBounds(570, 220, 100, 40);
		jbpassword.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbpassword.setForeground(Color.black); // 设置字体颜色

		jbaddressid.setBounds(570, 270, 100, 40);
		jbaddressid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbaddressid.setForeground(Color.black); // 设置字体颜色

		jbhousenumber.setBounds(570, 320, 100, 40);
		jbhousenumber.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbhousenumber.setForeground(Color.black); // 设置字体颜色

		jbwatermeter.setBounds(570, 370, 100, 40);
		jbwatermeter.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbwatermeter.setForeground(Color.black); // 设置字体颜色

		jbownertypeid.setBounds(570, 470, 100, 40);
		jbownertypeid.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbownertypeid.setForeground(Color.black); // 设置字体颜色

		jbback.setBounds(270, 550, 160, 45);
		jbback.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbback.setForeground(Color.black); // 设置字体颜色

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
