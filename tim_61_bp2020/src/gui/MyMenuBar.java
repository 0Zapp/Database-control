package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {
	
	private JFrame parent = null;

	public MyMenuBar(JFrame parent) {

		this.parent = parent;

		JMenu fileMenu = new JMenu("File");
		add(fileMenu);

		JMenu editMenu = new JMenu("Analyze");
		add(editMenu);

		JMenu graphicsMenu = new JMenu("Window");
		add(graphicsMenu);

		JMenu helpMenu = new JMenu("Help");
		add(helpMenu);

	}
}
