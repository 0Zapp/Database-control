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
	String[]filter;
	String[]sort;
	int cc;
	ArrayList<JComboBox<String>> filterList;
	ArrayList<JComboBox<String>> sortList;

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
			filterList=new ArrayList<JComboBox<String>>();
			sortList=new ArrayList<JComboBox<String>>();
			
			JPanel grid = new JPanel(new GridLayout(0, 3));
			cc = MainFrame.getInstance().getjTableTop().getColumnCount();
			
			data = MainFrame.getInstance().getSelectedTop();
			filter = new String[cc];
			sort = new String[cc];
			
			for (int i = 0; i < cc; i++) {
				JLabel label = new JLabel(data[i + 1]);
				grid.add(label);
				
				String f[] = { "Prikazi", "Ne prikazuj" };
				JComboBox<String> filter = new JComboBox<String>(f);
				filter.setSelectedIndex(0);
				grid.add(filter);
				
				String s[] = { "ne sortiraj", "Asc", "Desc" };
				JComboBox<String> sort = new JComboBox<String>(s);
				sort.setSelectedIndex(0);
				grid.add(sort);
				
				filterList.add(filter);
				sortList.add(sort);
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
				String text = ((JComboBox<String>) filterList.get(i)).getSelectedItem().toString();
				filter[i] = text;
				
				text = ((JComboBox<String>) sortList.get(i)).getSelectedItem().toString();
				sort[i] = text;
				
				
			}

			MainFrame.getInstance().getAppCore().FaS(data,filter,sort);
		}

		setVisible(false); // you can't see me!
		dispose(); // Destroy the object

	}

}
