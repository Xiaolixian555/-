package cn.xlx.waterboss.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import cn.xlx.tools.TextBorderUtlis;
import cn.xlx.waterboss.dao.OwnerBillDao;
import cn.xlx.waterboss.entity.OwnerBill;
import cn.xlx.waterboss.entity.Owners;

public class WBillUI {
    public static void getBillUI(Owners owners) {
        //鼠标样式定义
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = new ImageIcon("src/images/cursor1.png").getImage();
        Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
        JFrame wbjframe = new JFrame("账单查询");    //创建窗体对象并赋标题参数
        wbjframe.setSize(740, 690);    //设置窗体大小
        wbjframe.setBackground(Color.WHITE);    //设置背景颜色
        wbjframe.setLocationRelativeTo(null); // 设置窗体显示位置(居中)
        wbjframe.setLayout(null); //无布局
        wbjframe.setVisible(true);    //显示窗体
        wbjframe.setCursor(cursor);  //设置鼠标样式

        //创建一个JLayeredPane用于分层的。
        JLayeredPane layeredPane = new JLayeredPane();
        //创建一个面板容器Panel和一个标签Label用于存放图片，作为背景。
        JPanel jpanel = new JPanel();
        //创建背景图片对象
        ImageIcon image = new ImageIcon("src/images/ownerlogin.jpeg");
        //创建背景的那些东西
        jpanel.setBounds(0, 10, 735, 730);
        JLabel jlabel = new JLabel(image);  //创建一个标签，里面存放image
        jpanel.add(jlabel);  //将标签加进面板容器jpanel中

        JLabel jLabel = new JLabel("账单查询");
        jLabel.setBounds(298, 20, 300, 60);  //标签大小和位置
        jLabel.setFont(new Font("楷体", 1, 32));  //设置字体
        jLabel.setForeground(new Color(59, 41, 156));  //设置字体颜色

        ImageIcon icon = new ImageIcon("src/images/button1.jpeg");
        JButton jbback = new JButton("返回主界面", icon);
        jbback.setBounds(270, 570, 160, 45);
        jbback.setFont(new Font("楷体", 1, 23)); // 设置字体
        jbback.setForeground(Color.white); // 设置字体颜色
        jbback.setHorizontalTextPosition(SwingConstants.CENTER);
        jbback.setBorder(new TextBorderUtlis(new Color(0x9632B8), 2, true));
        jbback.setOpaque(false);//设置控件是否透明，true为不透明，false为透明
        jbback.setContentAreaFilled(false);//设置图片填满按钮所在的区域
        jbback.setMargin(new Insets(0, 0, 0, 0));//设置按钮边框和标签文字之间的距离

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
        jllid.setBounds(50, 90, 130, 50);  //标签大小和位置
        jllid.setFont(new Font("宋体", 1, 22));  //设置字体
        jllid.setForeground(Color.black);  //设置字体颜色

        jllname.setBounds(50, 150, 130, 50);  //标签大小和位置
        jllname.setFont(new Font("宋体", 1, 22));  //设置字体
        jllname.setForeground(Color.black);  //设置字体颜色

        jllyear.setBounds(50, 210, 130, 50);  //标签大小和位置
        jllyear.setFont(new Font("宋体", 1, 22));  //设置字体
        jllyear.setForeground(Color.black);  //设置字体颜色

        jllmonth.setBounds(50, 270, 130, 50);  //标签大小和位置
        jllmonth.setFont(new Font("宋体", 1, 22));  //设置字体
        jllmonth.setForeground(Color.black);  //设置字体颜色

        jllwater.setBounds(50, 330, 130, 50);  //标签大小和位置
        jllwater.setFont(new Font("宋体", 1, 22));  //设置字体
        jllwater.setForeground(Color.black);  //设置字体颜色

        jllsum.setBounds(50, 390, 130, 50);  //标签大小和位置
        jllsum.setFont(new Font("宋体", 1, 22));  //设置字体
        jllsum.setForeground(Color.black);  //设置字体颜色

        jllisfee.setBounds(50, 450, 130, 50);  //标签大小和位置
        jllisfee.setFont(new Font("宋体", 1, 22));  //设置字体
        jllisfee.setForeground(Color.black);  //设置字体颜色

        jllfeedate.setBounds(50, 510, 130, 50);  //标签大小和位置
        jllfeedate.setFont(new Font("宋体", 1, 22));  //设置字体
        jllfeedate.setForeground(Color.black);  //设置字体颜色

        //设置各种右标签样式
        jlrid.setBounds(340, 90, 130, 50);  //标签大小和位置
        jlrid.setFont(new Font("宋体", 1, 22));  //设置字体
        jlrid.setForeground(Color.black);  //设置字体颜色

        jlrname.setBounds(340, 150, 130, 50);  //标签大小和位置
        jlrname.setFont(new Font("宋体", 1, 22));  //设置字体
        jlrname.setForeground(Color.black);  //设置字体颜色

        jlryear.setBounds(340, 210, 130, 50);  //标签大小和位置
        jlryear.setFont(new Font("宋体", 1, 22));  //设置字体
        jlryear.setForeground(Color.black);  //设置字体颜色

        jlrmonth.setBounds(340, 270, 130, 50);  //标签大小和位置
        jlrmonth.setFont(new Font("宋体", 1, 22));  //设置字体
        jlrmonth.setForeground(Color.black);  //设置字体颜色

        jlrwater.setBounds(340, 330, 130, 50);  //标签大小和位置
        jlrwater.setFont(new Font("宋体", 1, 22));  //设置字体
        jlrwater.setForeground(Color.black);  //设置字体颜色

        jlrsum.setBounds(340, 390, 130, 50);  //标签大小和位置
        jlrsum.setFont(new Font("宋体", 1, 22));  //设置字体
        jlrsum.setForeground(Color.black);  //设置字体颜色

        jlrisfee.setBounds(340, 450, 130, 50);  //标签大小和位置
        jlrisfee.setFont(new Font("宋体", 1, 22));  //设置字体

        jlrfeedate.setBounds(340, 510, 130, 50);  //标签大小和位置
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
        jlryear.setText(ownerBill.getYear() + " 年");
        jlrmonth.setText(ownerBill.getMonth() + " 月");
        jlrwater.setText(ownerBill.getUsenum().toString() + " 立方米");
        jlrsum.setText(ownerBill.getMoney().toString() + " RMB");
        if (ownerBill.getIsfee().equals("y")) {
            jlrisfee.setForeground(Color.blue);  //设置字体颜色
            jlrisfee.setText("已缴费");
            jlrfeedate.setText(ownerBill.getFeedate().toString());
        } else {
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
        //鼠标移入移出按钮事件
        jbback.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jbback.setFont(new Font("楷体", 1, 26)); // 设置字体
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image img = new ImageIcon("src/images/cursorhand1.png").getImage();
                Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
                wbjframe.setCursor(cursor);  //设置鼠标样式
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jbback.setFont(new Font("楷体", 1, 23)); // 设置字体
                Toolkit tk = Toolkit.getDefaultToolkit();
                Image img = new ImageIcon("src/images/cursor1.png").getImage();
                Cursor cursor = tk.createCustomCursor(img, new Point(10, 10), "norm");
                wbjframe.setCursor(cursor);  //设置鼠标样式
            }
        });
        //设置各组件的层级
        wbjframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layeredPane.add(jpanel, JLayeredPane.DEFAULT_LAYER);     //将jpanel放在该层级面板的最低层（背景图）
        layeredPane.add(jLabel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllid, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllname, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllyear, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllmonth, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllwater, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllsum, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllisfee, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jllfeedate, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlrid, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlrname, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlryear, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlrmonth, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlrwater, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlrsum, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlrisfee, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jlrfeedate, JLayeredPane.MODAL_LAYER);
        layeredPane.add(jbback, JLayeredPane.MODAL_LAYER);

        wbjframe.setResizable(false);//不允许调整窗体大小
        wbjframe.setLayeredPane(layeredPane);     //将窗体的层级面板设置为layeredPane
        wbjframe.setVisible(true);    //显示窗体
    }
}
