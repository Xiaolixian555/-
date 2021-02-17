package cn.xlx.loginUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;
import cn.xlx.waterboss.Interface.WaterbossUI;
import cn.xlx.waterboss.dao.OwnersDao;


public class OwnerLoginUI {
    // 获取业主登录界面
    public static void getOwnerUI() {
        //鼠标样式定义
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = new ImageIcon("src/images/cursor1.png").getImage();
        Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");

        JFrame ojframe = new JFrame("业主登录界面"); // 创建窗体对象并赋标题参数
        ojframe.setSize(740, 690); // 设置窗体大小
        ojframe.setBackground(Color.WHITE); // 设置背景颜色
        ojframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
        ojframe.setLayout(null); // 无布局
        ojframe.setCursor(cursor);  //设置鼠标样式

        //创建一个JLayeredPane用于分层的。
        JLayeredPane layeredPane = new JLayeredPane();
        //创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
        JPanel jpanel = new JPanel();
        //创建背景图片对象
        ImageIcon image = new ImageIcon("src/images/ownerlogin.jpeg");
        //创建背景的那些东西
        jpanel.setBounds(0, 10, 735, 700);
        JLabel jlabel = new JLabel(image);  //创建一个标签，里面存放image
        jpanel.add(jlabel);  //将标签加进面板容器jpanel中

        JLabel jLabel = new JLabel("业主登录中心");
        jLabel.setBounds(240, 30, 300, 200); // 标签大小和位置
        jLabel.setFont(new Font("楷体", 1, 45)); // 设置字体
        jLabel.setForeground(new Color(117, 52, 192)); // 设置字体颜色

        // 定义账号和密码标签
        JLabel jloname = new JLabel("账号id:");
        JLabel jlopassword = new JLabel("密  码:");

        //定义账号和密码输入框
        JTextField jtoname = new JTextField();
        JPasswordField jtopassword = new JPasswordField();

        //定义登录按钮
        ImageIcon icon = new ImageIcon("src/images/button1.jpeg");
        JButton jButton = new JButton("登录", icon);

        // 设置账号密码标签的样式
        jloname.setBounds(60, 240, 100, 40); // 标签大小和位置
        jloname.setFont(new Font("楷体", 1, 24)); // 设置字体
        jloname.setForeground(new Color(121, 72, 255)); // 设置字体颜色

        jlopassword.setBounds(60, 290, 100, 40); // 标签大小和位置
        jlopassword.setFont(new Font("楷体", 1, 24)); // 设置字体
        jlopassword.setForeground(new Color(236, 189, 252)); // 设置字体颜色
        // 设置账号密码输入框的样式
        jtoname.setBounds(200, 240, 400, 40); // 标签大小和位置
        jtoname.setFont(new Font("宋体", 1, 22)); // 设置字体
        jtoname.setForeground(new Color(0x9632B8)); // 设置字体颜色
        jtoname.setBorder(new TextBorderUtlis(new Color(116, 78, 156), 3, false)); //设置边框

        jtopassword.setBounds(200, 290, 400, 40); // 标签大小和位置
        jtopassword.setFont(new Font("宋体", 1, 22)); // 设置字体
        jtopassword.setForeground(new Color(0x9632B8)); // 设置字体颜色
        jtopassword.setBorder(new TextBorderUtlis(new Color(116, 78, 156), 3, false));  //设置边框
        // 设置登录按钮的样式
        jButton.setBounds(240, 450, 260, 50); // 标签大小和位置
        jButton.setFont(new Font("楷体", 1, 23)); // 设置字体
        jButton.setForeground(Color.white); // 设置字体颜色
        jButton.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton.setBorder(new TextBorderUtlis(new Color(0x9632B8), 2, true));
        jButton.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
        jButton.setContentAreaFilled(false);//设置图片填满按钮所在的区域
        jButton.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

        // 所有标签，输入框，按钮加入到界面
        ojframe.add(jLabel);
        ojframe.add(jloname);
        ojframe.add(jlopassword);
        ojframe.add(jtoname);
        ojframe.add(jtopassword);
        ojframe.add(jButton);

        //设置各组件的层级
        ojframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layeredPane.add(jpanel, JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
        layeredPane.add(jLabel, JLayeredPane.MODAL_LAYER);    //将jLabel放在该层级面板的高层
        layeredPane.add(jloname, JLayeredPane.MODAL_LAYER);    //将jloname放在该层级面板的高层
        layeredPane.add(jlopassword, JLayeredPane.MODAL_LAYER);    //将jlopassword放在该层级面板的高层
        layeredPane.add(jtoname, JLayeredPane.MODAL_LAYER);    //将jtoname放在该层级面板的高层
        layeredPane.add(jtopassword, JLayeredPane.MODAL_LAYER);    //将jtopassword放在该层级面板的高层
        layeredPane.add(jButton, JLayeredPane.MODAL_LAYER);    //将jButton放在该层级面板的高层

        ojframe.setResizable(false);//不允许调整窗体大小
        ojframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
        ojframe.setVisible(true); // 显示窗体

        //为"登录"按钮设置点击事件
        jButton.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                //如果账号密码正确
                if (OwnersDao.checkLogin(Long.valueOf(jtoname.getText()), jtopassword.getText())) {
                    //显示出界面
                    WaterbossUI.getWaterbossUI(OwnersDao.find(Long.valueOf(jtoname.getText())));
                    ojframe.setVisible(false); //关闭登录窗口
                } else {
                    PromptTool.getPromptTool("账号或密码不正确，请重新输入！");
                    jtoname.setText("");
                    jtopassword.setText("");
                }
            }
        });

        //设置回车键盘事件
        jtopassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    jButton.doClick();
                }
            }
        });

        //为"登录"按钮设置鼠标移除移入样式
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jButton.setFont(new Font("楷体", 1, 26)); // 设置字体
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image img = new ImageIcon("src/images/cursorhand1.png").getImage();
                Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
                ojframe.setCursor(cursor);  //设置鼠标样式
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jButton.setFont(new Font("楷体", 1, 23)); // 设置字体
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image img = new ImageIcon("src/images/cursor1.png").getImage();
                Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
                ojframe.setCursor(cursor);  //设置鼠标样式
            }
        });
    }
}
