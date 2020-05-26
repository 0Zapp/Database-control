package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsertDialog extends JDialog implements ActionListener {

	String[] data;
	int cc;
	ArrayList<JTextField> listTF;

	public InsertDialog(Frame parent, String title, boolean modal) {

		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize((screenWidth / 10) * 3, (screenHeight / 10) * 3);
		setLocationRelativeTo(null);

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {

			JPanel grid = new JPanel(new GridLayout(0, 2));
			cc = MainFrame.getInstance().getjTableTop().getColumnCount();
			data = MainFrame.getInstance().getSelectedTop();
			listTF = new ArrayList<JTextField>();
			for (int i = 0; i < cc; i++) {
				JLabel label = new JLabel(data[i + 1]);
				JTextField tf = new JTextField();
				listTF.add(tf);
				grid.add(label);
				grid.add(tf);
			}

			JButton OK = new JButton("OK");
			OK.addActionListener(this);
			JButton cancel = new JButton("cancel");
			cancel.addActionListener(this);

			add(grid, BorderLayout.CENTER);

			JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			buttonPanel.add(OK);
			buttonPanel.add(cancel);

			add(buttonPanel, BorderLayout.SOUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < cc; i++) {

			String text = ((JTextField) listTF.get(i)).getText();
			data[data.length / 2 + 1 + i] = text;
		}

		if (e.getActionCommand().equals("OK")) {
			System.out.println("OK");
			MainFrame.getInstance().getAppCore().InsertRow(data);
		}

		setVisible(false); // you can't see me!
		dispose(); // Destroy the object

	}

}
