package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.operator.entity.UpdateBill;
import cn.xlx.tools.PromptTool;

public class UpdateBillsUI {
	static ArrayList<UpdateBill> udList = new ArrayList<UpdateBill>(); // 定义账单集合
	static int lines = 0;//行数
	public static void getUpdateBillsUI(Operators operators, Long id) {
		JFrame jfub = new JFrame("账务记录");
		jfub.setSize(1910, 960); // 设置窗体大小
		jfub.setBackground(Color.WHITE); // 设置背景颜色
		jfub.setLocation(10, 60); // 设置窗体显示位置
		jfub.setLayout(null); // 无布局

		JButton jback = new JButton("返回上一层");
		jback.setBounds(40, 22, 140, 50); // 标签大小和位置
		jback.setFont(new Font("宋体", 1, 20)); // 设置字体
		jback.setForeground(Color.blue); // 设置字体颜色

		JLabel jltitle = new JLabel("该业主名下的账务");
		jltitle.setBounds(700, 0, 300, 100); // 标签大小和位置
		jltitle.setFont(new Font("楷体", 1, 32)); // 设置字体
		jltitle.setForeground(Color.red); // 设置字体颜色

		// 列名组件
		JLabel jlid = new JLabel("账单编号");
		jlid.setBounds(50, 120, 80, 30); // 标签大小和位置
		jlid.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlid.setForeground(Color.black); // 设置字体颜色

		JLabel jlyear = new JLabel("账务年份");
		jlyear.setBounds(210, 120, 80, 30); // 标签大小和位置
		jlyear.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlyear.setForeground(Color.black); // 设置字体颜色

		JLabel jlmonth = new JLabel("账务月份");
		jlmonth.setBounds(390, 120, 80, 30); // 标签大小和位置
		jlmonth.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlmonth.setForeground(Color.black); // 设置字体颜色

		JLabel jlnum0 = new JLabel("上月累计数");
		jlnum0.setBounds(560, 120, 100, 30); // 标签大小和位置
		jlnum0.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlnum0.setForeground(Color.black); // 设置字体颜色

		JLabel jlnum1 = new JLabel("本月累计数");
		jlnum1.setBounds(740, 120, 100, 30); // 标签大小和位置
		jlnum1.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlnum1.setForeground(Color.black); // 设置字体颜色

		JLabel jlusenum = new JLabel("本月使用数");
		jlusenum.setBounds(920, 120, 100, 30); // 标签大小和位置
		jlusenum.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlusenum.setForeground(Color.black); // 设置字体颜色

		JLabel jlmoney = new JLabel("应缴金额");
		jlmoney.setBounds(1110, 120, 80, 30); // 标签大小和位置
		jlmoney.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlmoney.setForeground(Color.black); // 设置字体颜色

		JLabel jlisfee = new JLabel("是否已缴");
		jlisfee.setBounds(1290, 120, 80, 30); // 标签大小和位置
		jlisfee.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlisfee.setForeground(Color.black); // 设置字体颜色

		JLabel jlfeedate = new JLabel("缴费日期");
		jlfeedate.setBounds(1480, 120, 80, 30); // 标签大小和位置
		jlfeedate.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlfeedate.setForeground(Color.black); // 设置字体颜色

		JLabel jlfeeuser = new JLabel("收费员");
		jlfeeuser.setBounds(1660, 120, 80, 30); // 标签大小和位置
		jlfeeuser.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlfeeuser.setForeground(Color.black); // 设置字体颜色

		// 文本框组件
		udList = OperatorsDao.getUpdateBills(id);
		int height = 155;
		for (int i = 0; i < udList.size(); i++) {
			lines++;
			JLabel jllid = new JLabel();
			jllid.setBounds(20, height, 130, 30); // 标签大小和位置
			jllid.setFont(new Font("宋体", 1, 18)); // 设置字体
			jllid.setForeground(Color.black); // 设置字体颜色
			jllid.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jllid.setText(udList.get(i).getId().toString());

			JTextField jtyear = new JTextField();
			jtyear.setBounds(180, height, 140, 30); // 标签大小和位置
			jtyear.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtyear.setForeground(Color.black); // 设置字体颜色
			jtyear.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtyear.setText(udList.get(i).getYear());

			JTextField jtmonth = new JTextField();
			jtmonth.setBounds(360, height, 140, 30); // 标签大小和位置
			jtmonth.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtmonth.setForeground(Color.black); // 设置字体颜色
			jtmonth.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtmonth.setText(udList.get(i).getMonth());

			JTextField jtnum0 = new JTextField();
			jtnum0.setBounds(540, height, 140, 30); // 标签大小和位置
			jtnum0.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtnum0.setForeground(Color.black); // 设置字体颜色
			jtnum0.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtnum0.setText(udList.get(i).getNum0().toString());

			JTextField jtnum1 = new JTextField();
			jtnum1.setBounds(720, height, 140, 30); // 标签大小和位置
			jtnum1.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtnum1.setForeground(Color.black); // 设置字体颜色
			jtnum1.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtnum1.setText(udList.get(i).getNum1().toString());

			JTextField jtusenum = new JTextField();
			jtusenum.setBounds(900, height, 140, 30); // 标签大小和位置
			jtusenum.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtusenum.setForeground(Color.black); // 设置字体颜色
			jtusenum.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtusenum.setText(udList.get(i).getUsenum().toString());

			JTextField jtmoney = new JTextField();
			jtmoney.setBounds(1080, height, 140, 30); // 标签大小和位置
			jtmoney.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtmoney.setForeground(Color.black); // 设置字体颜色
			jtmoney.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jtmoney.setText(udList.get(i).getMoney().toString());

			JTextField jtisfee = new JTextField();
			jtisfee.setBounds(1260, height, 140, 30); // 标签大小和位置
			jtisfee.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtisfee.setForeground(Color.black); // 设置字体颜色
			jtisfee.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			if (udList.get(i).getIsfee().equals("y")) {
				jtisfee.setText("已缴费");
			} else {
				jtisfee.setText("未缴费");
			}

			JTextField jtfeedate = new JTextField();
			jtfeedate.setBounds(1440, height, 140, 30); // 标签大小和位置
			jtfeedate.setFont(new Font("宋体", 1, 18)); // 设置字体
			jtfeedate.setForeground(Color.black); // 设置字体颜色
			jtfeedate.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			if (udList.get(i).getFeedate() == null) {
				jtfeedate.setText("暂无记录");
			} else {
				jtfeedate.setText(udList.get(0).getFeedate().toString());
			}

			JLabel jllfeeuser = new JLabel();
			jllfeeuser.setBounds(1620, height, 140, 30); // 标签大小和位置
			jllfeeuser.setFont(new Font("宋体", 1, 18)); // 设置字体
			jllfeeuser.setForeground(Color.black); // 设置字体颜色
			jllfeeuser.setHorizontalAlignment(JTextField.CENTER);// 设置内容居中
			jllfeeuser.setText(udList.get(i).getFeeuser());

			JButton jbchange = new JButton("修改");
			jbchange.setBounds(1780, height, 90, 30); // 标签大小和位置
			jbchange.setFont(new Font("楷体", 1, 18)); // 设置字体
			jbchange.setForeground(Color.blue); // 设置字体颜色

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

			// 对每一个修改按钮进行点击事件
			jbchange.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {				
					ArrayList<UpdateBill> NewList=getNewList(lines, jllid, jtyear, jtmonth, jtnum0, jtnum1, jtusenum, jtmoney, jtisfee, jtfeedate, jllfeeuser);
					OperatorsDao.setUpdateBills(NewList, id); // 执行修改数据库的数据
					PromptTool.getPromptTool("修改成功！");
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

		jfub.setVisible(true);
		
		//返回上一层按钮添加点击事件
		jback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessTypeUI.getBusinessTypeUI(operators, id);
				jfub.setVisible(false);		
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
