package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.operator.entity.ViewOwner;
import cn.xlx.tools.PromptTool;

public class ViewAllOwnersUI {
	public static boolean ishave=false;
	public static void getViewAllOwnersUI(Operators operators) {
		JFrame jfvao = new JFrame("查看管理业主");
		jfvao.setSize(1280, 900); // 设置窗体大小
		jfvao.setBackground(Color.WHITE); // 设置背景颜色
		jfvao.setLocation(300, 100); // 设置窗体显示位置
		jfvao.setLayout(null); // 无布局

		JButton jback = new JButton("返回上一层");
		jback.setBounds(40, 22, 140, 50); // 标签大小和位置
		jback.setFont(new Font("宋体", 1, 20)); // 设置字体
		jback.setForeground(Color.blue); // 设置字体颜色

		JLabel jltitle = new JLabel("您所管理的业主");
		jltitle.setBounds(500, 0, 300, 100); // 标签大小和位置
		jltitle.setFont(new Font("楷体", 1, 32)); // 设置字体
		jltitle.setForeground(Color.red); // 设置字体颜色

		// 列名组件
		JLabel jlid = new JLabel("业主编号");
		jlid.setBounds(30, 120, 80, 30); // 标签大小和位置
		jlid.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlid.setForeground(Color.black); // 设置字体颜色

		JLabel jlname = new JLabel("业主姓名");
		jlname.setBounds(210, 120, 80, 30); // 标签大小和位置
		jlname.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlname.setForeground(Color.black); // 设置字体颜色

		JLabel jltype = new JLabel("业主类型");
		jltype.setBounds(390, 120, 80, 30); // 标签大小和位置
		jltype.setFont(new Font("宋体", 1, 18)); // 设置字体
		jltype.setForeground(Color.black); // 设置字体颜色

		JLabel jlarea = new JLabel("所在区域");
		jlarea.setBounds(570, 120, 80, 30); // 标签大小和位置
		jlarea.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlarea.setForeground(Color.black); // 设置字体颜色

		JLabel jlmoney = new JLabel("应缴金额");
		jlmoney.setBounds(750, 120, 80, 30); // 标签大小和位置
		jlmoney.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlmoney.setForeground(Color.black); // 设置字体颜色

		JLabel jlisfee = new JLabel("是否已缴");
		jlisfee.setBounds(930, 120, 80, 30); // 标签大小和位置
		jlisfee.setFont(new Font("宋体", 1, 18)); // 设置字体
		jlisfee.setForeground(Color.black); // 设置字体颜色

		JLabel jldate = new JLabel("缴费日期");
		jldate.setBounds(1110, 120, 80, 30); // 标签大小和位置
		jldate.setFont(new Font("宋体", 1, 18)); // 设置字体
		jldate.setForeground(Color.black); // 设置字体颜色

		// 数据列
		ArrayList<ViewOwner> list = OperatorsDao.getViewOwners(operators.getId());
		if (list.size() == 0) {
			ishave = false;
		} else {
			int height = 160;
			ishave = true;
			for (int i = 0; i < list.size(); i++) {
				JLabel jlid1 = new JLabel("业主编号");
				jlid1.setBounds(30, height, 80, 30); // 标签大小和位置
				jlid1.setFont(new Font("宋体", 1, 18)); // 设置字体
				jlid1.setForeground(Color.black); // 设置字体颜色
				jlid1.setText(list.get(i).getId().toString());

				JLabel jlname1 = new JLabel("业主姓名");
				jlname1.setBounds(210, height, 80, 30); // 标签大小和位置
				jlname1.setFont(new Font("宋体", 1, 18)); // 设置字体
				jlname1.setForeground(Color.black); // 设置字体颜色
				jlname1.setText(list.get(i).getName());

				JLabel jltype1 = new JLabel("业主类型");
				jltype1.setBounds(370, height, 130, 30); // 标签大小和位置
				jltype1.setFont(new Font("宋体", 1, 18)); // 设置字体
				jltype1.setForeground(Color.blue); // 设置字体颜色
				jltype1.setText(list.get(i).getOwnertypename());

				JLabel jlarea1 = new JLabel("所在区域");
				jlarea1.setBounds(570, height, 80, 30); // 标签大小和位置
				jlarea1.setFont(new Font("宋体", 1, 18)); // 设置字体
				jlarea1.setForeground(Color.black); // 设置字体颜色
				jlarea1.setText(list.get(i).getArea());

				JLabel jlmoney1 = new JLabel("应缴金额");
				jlmoney1.setBounds(750, height, 80, 30); // 标签大小和位置
				jlmoney1.setFont(new Font("宋体", 1, 18)); // 设置字体
				jlmoney1.setForeground(Color.black); // 设置字体颜色
				jlmoney1.setText(list.get(i).getMoney().toString() + " RMB");

				JLabel jlisfee1 = new JLabel("是否已缴");
				jlisfee1.setBounds(930, height, 80, 30); // 标签大小和位置
				jlisfee1.setFont(new Font("宋体", 1, 18)); // 设置字体
				if (list.get(i).getIsfee().toString().equals("y")) {
					jlisfee1.setForeground(Color.blue); // 设置字体颜色
					jlisfee1.setText("已缴费");
				} else {
					jlisfee1.setForeground(Color.red); // 设置字体颜色
					jlisfee1.setText("未缴费");
				}

				JLabel jldate1 = new JLabel("缴费日期");
				jldate1.setBounds(1090, height, 100, 30); // 标签大小和位置
				jldate1.setFont(new Font("宋体", 1, 18)); // 设置字体
				jldate1.setForeground(Color.black); // 设置字体颜色
				if (list.get(i).getFeedate() == null) {
					jldate1.setText("暂无记录");
				} else {
					jldate1.setText(list.get(i).getFeedate().toString());
				}

				// 加载组件
				jfvao.add(jlid1);
				jfvao.add(jlname1);
				jfvao.add(jlarea1);
				jfvao.add(jlmoney1);
				jfvao.add(jlisfee1);
				jfvao.add(jldate1);
				jfvao.add(jltype1);

				height = height + 30;

			}
		}

		// 加载组件并显示窗体
		jfvao.add(jltitle);
		jfvao.add(jback);
		jfvao.add(jlid);
		jfvao.add(jlname);
		jfvao.add(jlarea);
		jfvao.add(jlmoney);
		jfvao.add(jlisfee);
		jfvao.add(jldate);
		jfvao.add(jltype);
				
		jfvao.setVisible(true);
		if(!ishave){
			PromptTool.getPromptTool("抱歉，您暂无可管理的业主！");
		}
		
		//为"返回按钮"添加点击事件
		jback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OperatorUI.getOperatorUI(operators);
				jfvao.setVisible(false);		
			}
		});
	}
}
