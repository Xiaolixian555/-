package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import cn.xlx.operator.entity.Operators;
import cn.xlx.tools.FileOperation;
import cn.xlx.tools.InsertGroupData;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;

public class AddGroupUI {
    public static void getAddGroupUI(Operators operators) {
        //鼠标样式定义
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = new ImageIcon("src/images/cursor2.png").getImage();
        Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
        JFrame jfadd = new JFrame("批量添加业主"); // 创建窗体对象并赋标题参数
        jfadd.setCursor(cursor);  //设置鼠标样式
        jfadd.setSize(740, 700); // 设置窗体大小
        jfadd.setBackground(Color.WHITE); // 设置背景颜色
        jfadd.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
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
        JLabel jlabel = new JLabel(image);  //创建一个标签，里面存放image
        jpanel.add(jlabel);  //将标签加进面板容器jpanel中
        // 定义各种组件
        JLabel jLabel = new JLabel("批量导入业主");
        JButton jButton = new JButton("打开文件",icon1);
        JButton jback = new JButton("返回上一层",icon2);

        // 定义各种组件样式
        jLabel.setSize(740, 700); // 设置标签大小
        jLabel.setBounds(240, 30, 540, 280); // 设置窗体显示位置和大小
        jLabel.setFont(new Font("楷体", 1, 40)); // 设置字体
        jLabel.setForeground(new Color(0x166F0C)); // 设置字体颜色

        jButton.setSize(740, 700); // 设置按钮大小
        jButton.setFont(new Font("楷体", 1, 24)); // 设置字体
        jButton.setBounds(220, 300, 300, 60); // 设置显示位置和大小
		jButton.setForeground(new Color(0x566347)); // 设置字体颜色
		jButton.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jButton.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jButton.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jButton.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

        jback.setSize(740, 700); // 设置按钮大小
        jback.setFont(new Font("楷体", 1, 24)); // 设置字体
        jback.setBounds(220, 440, 300, 60); // 设置显示位置和大小
		jback.setForeground(new Color(0x566347)); // 设置字体颜色
		jback.setHorizontalTextPosition(SwingConstants.CENTER);
		jback.setBorder(new TextBorderUtlis(new Color(0x2C711C),2,true));
		jback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
		jback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
		jback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

        // 为两按钮添加点击事件
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                InsertGroupData igd = new InsertGroupData();
                try {
                    JFileChooser jf = new JFileChooser();
                    jf = FileOperation.getJFileChooser();
                    int type = jf.showOpenDialog(null);
                    if (type == 1) {
                        PromptTool.getPromptTool("未选择文件，请重试！");

                    } else {
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
		//设置各组件的层级
		jfadd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.add(jpanel,JLayeredPane.DEFAULT_LAYER);         //将jpanel放在该层级面板的最低层（背景图）
		layeredPane.add(jLabel,JLayeredPane.MODAL_LAYER);                   //将jLabel放在该层级面板的高层
		layeredPane.add(jButton,JLayeredPane.MODAL_LAYER);
		layeredPane.add(jback,JLayeredPane.MODAL_LAYER);
		jfadd.setResizable(false);//不允许调整窗体大小
		jfadd.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
        jfadd.setVisible(true);

		// 为按钮设置鼠标移出移入事件
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}
		});
		jback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 26)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jback.setFont(new Font("楷体", 1, 24)); // 设置字体
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image img = new ImageIcon("src/images/cursor2.png").getImage();
				Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
				jfadd.setCursor(cursor);  //设置鼠标样式
			}
		});

	}
}
