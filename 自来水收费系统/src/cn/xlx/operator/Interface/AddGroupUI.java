package cn.xlx.operator.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.FileOperation;
import cn.xlx.tools.InsertGroupData;
import cn.xlx.tools.PromptTool;

public class AddGroupUI {
	public static void getAddGroupUI(Operators operators) {
		JFrame jfadd = new JFrame("批量添加业主"); // 创建窗体对象并赋标题参数
		jfadd.setSize(740, 700); // 设置窗体大小
		jfadd.setBackground(Color.WHITE); // 设置背景颜色
		jfadd.setLocation(300, 200); // 设置窗体显示位置
		jfadd.setLayout(null); // 无布局

		// 定义各种组件
		JLabel jLabel = new JLabel("批量导入业主");
		JButton jButton = new JButton("打开文件");
		JButton jback = new JButton("返回上一层");

		// 定义各种组件样式
		jLabel.setSize(740, 700); // 设置标签大小
		jLabel.setBounds(240, 30, 540, 280); // 设置窗体显示位置和大小
		jLabel.setFont(new Font("楷体", 1, 40)); // 设置字体
		jLabel.setForeground(Color.black); // 设置字体颜色

		jButton.setSize(740, 700); // 设置按钮大小
		jButton.setFont(new Font("宋体", 1, 24)); // 设置字体
		jButton.setForeground(Color.red); // 设置字体颜色
		jButton.setBounds(220, 300, 300, 60); // 设置显示位置和大小

		jback.setSize(740, 700); // 设置按钮大小
		jback.setFont(new Font("宋体", 1, 24)); // 设置字体
		jback.setForeground(Color.blue); // 设置字体颜色
		jback.setBounds(220, 440, 300, 60); // 设置显示位置和大小

		// 为两按钮添加点击事件
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InsertGroupData igd = new InsertGroupData();
				try {
					JFileChooser jf = new JFileChooser();
					jf = FileOperation.getJFileChooser(); 
					int type = jf.showOpenDialog(null);
					if(type == 1){
						PromptTool.getPromptTool("未选择文件，请重试！");
						
					}
					else{
						igd.insert(jf.getSelectedFile().getPath(), "T_OWNERS");
						PromptTool.getPromptTool("批量导入成功！");
					}
					
				} catch (Exception e1) {
					// 处理所有异常
					e1.printStackTrace();
				}
			}
		});

		jback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OwnerAddTypeUI.getOwnerAddTypeUI(operators);
				jfadd.setVisible(false);
			}
		});

		// 组件加进来并显示窗体
		jfadd.add(jLabel);
		jfadd.add(jButton);
		jfadd.add(jback);
		jfadd.setVisible(true);

	}
}
