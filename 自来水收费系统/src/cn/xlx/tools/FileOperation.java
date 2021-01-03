package cn.xlx.tools;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileOperation  {
	
	//打开文件选择界面，并返回被选中的文档对象
	public static JFileChooser getJFileChooser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException  {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFileChooser fc = new JFileChooser();
		return fc;
	}
}
