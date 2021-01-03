package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.PromptTool;


public class BusinessProcessingUI {
	public static void getBusinessProcessingUI(Operators operators) {
		JFrame bpjframe = new JFrame("修改业主及其账务"); // 创建窗体对象并赋标题参数
		bpjframe.setSize(740, 540); // 设置窗体大小
		bpjframe.setBackground(Color.WHITE); // 设置背景颜色
		bpjframe.setLocation(300, 200); // 设置窗体显示位置
		bpjframe.setLayout(null); // 无布局

		JLabel jLabel = new JLabel("请输入需要修改的业主Id");
		jLabel.setBounds(200, 30, 350, 180); // 标签大小和位置
		jLabel.setFont(new Font("楷体", 1, 28)); // 设置字体
		jLabel.setForeground(Color.black); // 设置字体颜色
		
		JTextField jTextField = new JTextField();
		jTextField.setBounds(120, 200, 460, 50); // 标签大小和位置
		jTextField.setFont(new Font("宋体", 1, 28)); // 设置字体
		jTextField.setForeground(Color.black); // 设置字体颜色
				
		JButton jconfirm = new JButton("确认");
		jconfirm.setBounds(120, 330, 200, 50); // 标签大小和位置
		jconfirm.setFont(new Font("宋体", 1, 20)); // 设置字体
		jconfirm.setForeground(Color.red); // 设置字体颜色
		
		JButton jback = new JButton("退出");
		jback.setBounds(380, 330, 200, 50); // 标签大小和位置
		jback.setFont(new Font("宋体", 1, 20)); // 设置字体
		jback.setForeground(Color.blue); // 设置字体颜色
		  
		//添加组件并显示窗体
		bpjframe.add(jLabel);
		bpjframe.add(jTextField);
		bpjframe.add(jconfirm);
		bpjframe.add(jback);
		bpjframe.setVisible(true);
		
		//为"确认"按钮添加点击事件
		jconfirm.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(BusinessTypeUI.getBusinessTypeUI(operators, Long.valueOf(jTextField.getText()))){
					bpjframe.setVisible(false);	
				}
				else{
					PromptTool.getPromptTool("此id不存在，请重新输入！");
				}
				
			}
		});
		//为"退出"按钮添加点击事件
		jback.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				OManageUI.getOMangeUI(operators);
				bpjframe.setVisible(false);			
			}
		});
	}
}
