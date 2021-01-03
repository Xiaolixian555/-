package cn.xlx.waterboss.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.xlx.waterboss.dao.OwnerBillDao;
import cn.xlx.waterboss.entity.OwnerBill;
import cn.xlx.waterboss.entity.Owners;

public class WBillUI {
	public static void getBillUI(Owners owners) {
		JFrame wbjframe = new JFrame("账单查询");    //创建窗体对象并赋标题参数
		wbjframe.setSize(740,700);    //设置窗体大小
		wbjframe.setBackground(Color.WHITE);    //设置背景颜色
		wbjframe.setLocation(300,200);    //设置窗体显示位置
		wbjframe.setLayout(null); //无布局
        wbjframe.setVisible(true);    //显示窗体
        
        JLabel jLabel = new JLabel("账单查询");
		jLabel.setBounds(300, 20, 300, 70);  //标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 30));  //设置字体
		jLabel.setForeground(Color.blue);  //设置字体颜色
		
		JButton jbback = new JButton("返回主界面");
		jbback.setBounds(270, 590, 160, 45);
		jbback.setFont(new Font("宋体", 1, 20)); // 设置字体
		jbback.setForeground(Color.black); // 设置字体颜色
		
		//定义各种左标签
		JLabel jllid = new JLabel("业主id:");
		JLabel jllname = new JLabel("业主姓名:");
		JLabel jllyear = new JLabel("账务年份:");
		JLabel jllmonth = new JLabel("账务月份:");
		JLabel jllwater = new JLabel("本月用水量:");
		JLabel jllsum = new JLabel("应缴金额:");
		JLabel jllisfee = new JLabel("是否已缴:");
		JLabel jllfeedate = new JLabel("缴费日期:");
		
		//定义各种右标签
		JLabel jlrid = new JLabel();
		JLabel jlrname = new JLabel();
		JLabel jlryear = new JLabel();
		JLabel jlrmonth = new JLabel();
		JLabel jlrwater = new JLabel();
		JLabel jlrsum = new JLabel();
		JLabel jlrisfee = new JLabel();
		JLabel jlrfeedate = new JLabel();
		
		//设置各种左标签样式
		jllid.setBounds(50, 100, 130, 50);  //标签大小和位置
		jllid.setFont(new Font("宋体", 1, 22));  //设置字体
		jllid.setForeground(Color.black);  //设置字体颜色
		
		jllname.setBounds(50, 160, 130, 50);  //标签大小和位置
		jllname.setFont(new Font("宋体", 1, 22));  //设置字体
		jllname.setForeground(Color.black);  //设置字体颜色
		
		jllyear.setBounds(50, 220, 130, 50);  //标签大小和位置
		jllyear.setFont(new Font("宋体", 1, 22));  //设置字体
		jllyear.setForeground(Color.black);  //设置字体颜色
		
		jllmonth.setBounds(50, 280, 130, 50);  //标签大小和位置
		jllmonth.setFont(new Font("宋体", 1, 22));  //设置字体
		jllmonth.setForeground(Color.black);  //设置字体颜色
		
		jllwater.setBounds(50, 340, 130, 50);  //标签大小和位置
		jllwater.setFont(new Font("宋体", 1, 22));  //设置字体
		jllwater.setForeground(Color.black);  //设置字体颜色
		
		jllsum.setBounds(50, 400, 130, 50);  //标签大小和位置
		jllsum.setFont(new Font("宋体", 1, 22));  //设置字体
		jllsum.setForeground(Color.black);  //设置字体颜色
		
		jllisfee.setBounds(50, 460, 130, 50);  //标签大小和位置
		jllisfee.setFont(new Font("宋体", 1, 22));  //设置字体
		jllisfee.setForeground(Color.black);  //设置字体颜色
		
		jllfeedate.setBounds(50, 520, 130, 50);  //标签大小和位置
		jllfeedate.setFont(new Font("宋体", 1, 22));  //设置字体
		jllfeedate.setForeground(Color.black);  //设置字体颜色
		
		//设置各种右标签样式
		jlrid.setBounds(310, 100, 130, 50);  //标签大小和位置
		jlrid.setFont(new Font("宋体", 1, 22));  //设置字体
		jlrid.setForeground(Color.black);  //设置字体颜色
		
		jlrname.setBounds(310, 160, 130, 50);  //标签大小和位置
		jlrname.setFont(new Font("宋体", 1, 22));  //设置字体
		jlrname.setForeground(Color.black);  //设置字体颜色
		
		jlryear.setBounds(310, 220, 130, 50);  //标签大小和位置
		jlryear.setFont(new Font("宋体", 1, 22));  //设置字体
		jlryear.setForeground(Color.black);  //设置字体颜色
		
		jlrmonth.setBounds(310, 280, 130, 50);  //标签大小和位置
		jlrmonth.setFont(new Font("宋体", 1, 22));  //设置字体
		jlrmonth.setForeground(Color.black);  //设置字体颜色
		
		jlrwater.setBounds(310, 340, 130, 50);  //标签大小和位置
		jlrwater.setFont(new Font("宋体", 1, 22));  //设置字体
		jlrwater.setForeground(Color.black);  //设置字体颜色
		
		jlrsum.setBounds(310, 400, 130, 50);  //标签大小和位置
		jlrsum.setFont(new Font("宋体", 1, 22));  //设置字体
		jlrsum.setForeground(Color.black);  //设置字体颜色
		
		jlrisfee.setBounds(310, 460, 130, 50);  //标签大小和位置
		jlrisfee.setFont(new Font("宋体", 1, 22));  //设置字体
		
		jlrfeedate.setBounds(310, 520, 130, 50);  //标签大小和位置
		jlrfeedate.setFont(new Font("宋体", 1, 22));  //设置字体
		jlrfeedate.setForeground(Color.black);  //设置字体颜色	
		
	
		wbjframe.add(jLabel);  //标签加入到界面
		//加入各种左标签
		wbjframe.add(jllid);
		wbjframe.add(jllname);
		wbjframe.add(jllyear);
		wbjframe.add(jllmonth);
		wbjframe.add(jllwater);
		wbjframe.add(jllsum);
		wbjframe.add(jllisfee);
		wbjframe.add(jllfeedate);
		//加入各种右标签
		wbjframe.add(jlrid);
		wbjframe.add(jlrname);
		wbjframe.add(jlryear);
		wbjframe.add(jlrmonth);
		wbjframe.add(jlrwater);
		wbjframe.add(jlrsum);
		wbjframe.add(jlrisfee);
		wbjframe.add(jlrfeedate);
		
		wbjframe.add(jbback);
		
		//给各种右标签赋值
		OwnerBill ownerBill = OwnerBillDao.find(owners.getId());
		jlrid.setText(ownerBill.getId().toString());
		jlrname.setText(owners.getName());
		jlryear.setText(ownerBill.getYear()+" 年");
		jlrmonth.setText(ownerBill.getMonth()+" 月");
		jlrwater.setText(ownerBill.getUsenum().toString()+" 立方米");
		jlrsum.setText(ownerBill.getMoney().toString()+" RMB");
		if(ownerBill.getIsfee().equals("y")){
			jlrisfee.setForeground(Color.blue);  //设置字体颜色
			jlrisfee.setText("已缴费");
			jlrfeedate.setText(ownerBill.getFeedate().toString());
		}
		else{
			jlrisfee.setForeground(Color.red);  //设置字体颜色
			jlrisfee.setText("未缴费");
			jlrfeedate.setText("无");
		}
		
		// 设置jbback返回主菜单按钮的点击事件
		jbback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WaterbossUI.getWaterbossUI(owners);
				wbjframe.setVisible(false);
			}
		});

			
        wbjframe.setVisible(true);    //显示窗体
	}
}
