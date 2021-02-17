package cn.xlx.operator.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import cn.xlx.operator.dao.OperatorsDao;
import cn.xlx.operator.entity.Operators;
import cn.xlx.operator.entity.ViewOwner;
import cn.xlx.tools.PromptTool;
import cn.xlx.tools.TextBorderUtlis;

public class ViewAllOwnersUI {
    public static boolean ishave = false;

    public static void getViewAllOwnersUI(Operators operators) {
        //鼠标样式定义
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = new ImageIcon("src/images/cursor2.png").getImage();
        Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
        JFrame jfvao = new JFrame("查看管理业主");
        jfvao.setSize(1280, 900); // 设置窗体大小
        jfvao.setBackground(Color.WHITE); // 设置背景颜色
        jfvao.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
        jfvao.setCursor(cursor);  //设置鼠标样式
        jfvao.setLayout(null); // 无布局
        //创建一个JLayeredPane用于分层的。
        JLayeredPane layeredPane = new JLayeredPane();
        //创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
        JPanel jpanel = new JPanel();
        //创建背景图片对象
		ImageIcon imageIcon = new ImageIcon("src/images/operatorlogin.jpeg");    // Icon由图片文件形成
		Image image0 = imageIcon.getImage();                         // 但这个图片太大不适合做Icon
		// 为把它缩小点，先要取出这个Icon的image ,然后缩放到合适的大小
		Image bigImage = image0.getScaledInstance(1280, 900, Image.SCALE_FAST);
		// 再由修改后的Image来生成合适的Icon
		ImageIcon image = new ImageIcon(bigImage);
        //创建背景的那些东西
        jpanel.setBounds(0, 0, 1280, 900);
        JLabel jlabel = new JLabel(image);  //创建一个标签，里面存放image
        jpanel.add(jlabel);  //将标签加进面板容器jpanel中

        ImageIcon icon = new ImageIcon("src/images/button3.jpeg");
        JButton jback = new JButton("返回上一层", icon);
        jback.setBounds(40, 25, 140, 50); // 标签大小和位置
        jback.setFont(new Font("楷体", 1, 21)); // 设置字体
        jback.setForeground(new Color(0x566347)); // 设置字体颜色
        jback.setHorizontalTextPosition(SwingConstants.CENTER);
        jback.setBorder(new TextBorderUtlis(new Color(0x2C711C), 2, true));
        jback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
        jback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
        jback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

        JLabel jltitle = new JLabel("您所管理的业主");
        jltitle.setBounds(500, 0, 300, 100); // 标签大小和位置
        jltitle.setFont(new Font("楷体", 1, 32)); // 设置字体
        jltitle.setForeground(new Color(0x166F0C)); // 设置字体颜色

        // 列名组件
        JLabel jlid = new JLabel("业主编号");
        jlid.setBounds(30, 120, 80, 30); // 标签大小和位置
        jlid.setFont(new Font("宋体", 1, 18)); // 设置字体
        jlid.setForeground(new Color(0x0F5F11)); // 设置字体颜色

        JLabel jlname = new JLabel("业主姓名");
        jlname.setBounds(210, 120, 80, 30); // 标签大小和位置
        jlname.setFont(new Font("宋体", 1, 18)); // 设置字体
        jlname.setForeground(new Color(0x0F5F11)); // 设置字体颜色

        JLabel jltype = new JLabel("业主类型");
        jltype.setBounds(390, 120, 80, 30); // 标签大小和位置
        jltype.setFont(new Font("宋体", 1, 18)); // 设置字体
        jltype.setForeground(new Color(0x0F5F11)); // 设置字体颜色

        JLabel jlarea = new JLabel("所在区域");
        jlarea.setBounds(570, 120, 80, 30); // 标签大小和位置
        jlarea.setFont(new Font("宋体", 1, 18)); // 设置字体
        jlarea.setForeground(new Color(0x0F5F11)); // 设置字体颜色

        JLabel jlmoney = new JLabel("应缴金额");
        jlmoney.setBounds(750, 120, 80, 30); // 标签大小和位置
        jlmoney.setFont(new Font("宋体", 1, 18)); // 设置字体
        jlmoney.setForeground(new Color(0x0F5F11)); // 设置字体颜色

        JLabel jlisfee = new JLabel("是否已缴");
        jlisfee.setBounds(930, 120, 80, 30); // 标签大小和位置
        jlisfee.setFont(new Font("宋体", 1, 18)); // 设置字体
        jlisfee.setForeground(new Color(0x0F5F11)); // 设置字体颜色

        JLabel jldate = new JLabel("缴费日期");
        jldate.setBounds(1110, 120, 80, 30); // 标签大小和位置
        jldate.setFont(new Font("宋体", 1, 18)); // 设置字体
        jldate.setForeground(new Color(0x0F5F11)); // 设置字体颜色

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
                jlid1.setForeground(new Color(0x0F5F11)); // 设置字体颜色
                jlid1.setText(list.get(i).getId().toString());

                JLabel jlname1 = new JLabel("业主姓名");
                jlname1.setBounds(210, height, 80, 30); // 标签大小和位置
                jlname1.setFont(new Font("宋体", 1, 18)); // 设置字体
                jlname1.setForeground(new Color(0x0F5F11)); // 设置字体颜色
                jlname1.setText(list.get(i).getName());

                JLabel jltype1 = new JLabel("业主类型");
                jltype1.setBounds(370, height, 130, 30); // 标签大小和位置
                jltype1.setFont(new Font("宋体", 1, 18)); // 设置字体
                jltype1.setForeground(new Color(0x0F5F11)); // 设置字体颜色
                jltype1.setText(list.get(i).getOwnertypename());

                JLabel jlarea1 = new JLabel("所在区域");
                jlarea1.setBounds(570, height, 80, 30); // 标签大小和位置
                jlarea1.setFont(new Font("宋体", 1, 18)); // 设置字体
                jlarea1.setForeground(new Color(0x0F5F11)); // 设置字体颜色
                jlarea1.setText(list.get(i).getArea());

                JLabel jlmoney1 = new JLabel("应缴金额");
                jlmoney1.setBounds(750, height, 80, 30); // 标签大小和位置
                jlmoney1.setFont(new Font("宋体", 1, 18)); // 设置字体
                jlmoney1.setForeground(new Color(0x0F5F11)); // 设置字体颜色
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
                jldate1.setForeground(new Color(0x0F5F11)); // 设置字体颜色
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
                layeredPane.add(jlid1, JLayeredPane.MODAL_LAYER);
                layeredPane.add(jlname1, JLayeredPane.MODAL_LAYER);
                layeredPane.add(jlarea1, JLayeredPane.MODAL_LAYER);
                layeredPane.add(jlmoney1, JLayeredPane.MODAL_LAYER);
                layeredPane.add(jlisfee1, JLayeredPane.MODAL_LAYER);
                layeredPane.add(jldate1, JLayeredPane.MODAL_LAYER);
                layeredPane.add(jltype1, JLayeredPane.MODAL_LAYER);
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
        jfvao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layeredPane.add(jpanel, JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
        layeredPane.add(jltitle, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jback, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlid, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlname, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlarea, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlmoney, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlisfee, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jldate, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jltype, JLayeredPane.MODAL_LAYER);
        jfvao.setResizable(false);//不允许调整窗体大小
        jfvao.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
        jfvao.setVisible(true);
        if (!ishave) {
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
        //鼠标移入移出按钮事件
        jback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jback.setFont(new Font("楷体", 1, 23)); // 设置字体
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image img = new ImageIcon("src/images/cursorhand2.png").getImage();
                Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
                jfvao.setCursor(cursor);  //设置鼠标样式
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jback.setFont(new Font("楷体", 1, 21)); // 设置字体
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image img = new ImageIcon("src/images/cursor2.png").getImage();
                Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
                jfvao.setCursor(cursor);  //设置鼠标样式
            }
        });
    }
}
