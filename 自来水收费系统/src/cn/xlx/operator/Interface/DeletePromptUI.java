package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.PromptTool;


public class DeletePromptUI {
	public static void getDeletePromptUI(Operators operators,Long id) {
		JFrame isdelJF = new JFrame("提示信息"); // 创建窗体对象并赋标题参数
		isdelJF.setSize(520, 300); // 设置窗体大小
		isdelJF.setBackground(Color.WHITE); // 设置背景颜色
		isdelJF.setLocation(470, 430); // 设置窗体显示位置
		isdelJF.setLayout(null); // 无布局
		
		JLabel jLabel = new JLabel("您确定要删除该业主吗？");
		jLabel.setBounds(120, 20, 280, 80); // 标签大小和位置
		jLabel.setFont(new Font("宋体", 1, 22)); // 设置字体
		jLabel.setForeground(Color.black); // 设置字体颜色
		
		JButton jbyes = new JButton("确定");
		jbyes.setBounds(80, 150, 130, 40); // 标签大小和位置
		jbyes.setFont(new Font("宋体", 1, 18)); // 设置字体
		jbyes.setForeground(Color.red); // 设置字体颜色
		
		JButton jbno = new JButton("取消");
		jbno.setBounds(240, 150, 130, 40); // 标签大小和位置
		jbno.setFont(new Font("宋体", 1, 18)); // 设置字体
		jbno.setForeground(Color.blue); // 设置字体颜色
		
		//加载所有组件
		isdelJF.add(jLabel);
		isdelJF.add(jbyes);
		isdelJF.add(jbno);
		
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
	}
}
