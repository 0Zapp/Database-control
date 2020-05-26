package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FaSDialog extends JDialog implements ActionListener {

	String[] data;
	int cc;
	ArrayList<JTextField> listTF;

	public FaSDialog(Frame parent, String title, boolean modal) {

		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize((screenWidth / 10) * 4, (screenHeight / 10) * 3);
		setLocationRelativeTo(null);

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			listTF = new ArrayList<JTextField>();
			JPanel grid = new JPanel(new GridLayout(0, 5));
			cc = MainFrame.getInstance().getjTableTop().getColumnCount();
			data = MainFrame.getInstance().getSelectedTop();
			for (int i = 0; i < cc; i++) {
				JLabel label = new JLabel(data[i + 1]);
				grid.add(label);
				String f[] = { "Prikazi", "Ne prikazuj" };
				JComboBox<String> filter = new JComboBox<String>(f);
				grid.add(filter);
				String s[] = { "ne sortiraj", "Asc", "Desc" };
				JComboBox<String> sort = new JComboBox<String>(s);
				grid.add(sort);
				JLabel prioritet = new JLabel("Priritet Sortiranja, 1>2:");
				grid.add(prioritet);
				JTextField tf = new JTextField();
				grid.add(tf);
				listTF.add(tf);
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

		if (e.getActionCommand().equals("OK")) {
			for (int i = 0; i < cc; i++) {

				String text = ((JTextField) listTF.get(i)).getText();
				data[data.length / 2 + 1 + i] = text;
			}
			System.out.println("OK");
			MainFrame.getInstance().getAppCore().FaS(data);
		}

		setVisible(false); // you can't see me!
		dispose(); // Destroy the object

	}

}
