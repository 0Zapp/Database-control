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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.report.ReportFieldChanged;
import resource.DBNode;
import resource.enums.AttributeType;
import resource.enums.GroupFunctions;
import resource.implementation.Attribute;
import resource.implementation.Entity;

public class ReportDialog extends JDialog implements ActionListener {
	
	String[] data;
	List<JCheckBox> checkBoxes;
	JComboBox<Attribute> field;
	JComboBox<GroupFunctions> func;

	public ReportDialog(Frame parent, String title, boolean modal) {

		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize((screenWidth / 10) * 4, (screenHeight / 10) * 2);
		setLocationRelativeTo(null);

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		checkBoxes = new ArrayList<JCheckBox>();
		
		func = new JComboBox<GroupFunctions>();
		
		data = new String[3];
		
		Entity table = MainFrame.getInstance().getAppCore().getMainTable();
		data[0] = table.toString();
		field = new JComboBox<Attribute>();
		field.addItemListener(new ReportFieldChanged(checkBoxes, func));
		for(DBNode child : table.getChildren()) {
			if(child instanceof Attribute) {
				Attribute attr = (Attribute)child;
				JCheckBox checkBox = new JCheckBox(attr.toString());
				checkBoxes.add(checkBox);
				if(attr.getType() != AttributeType.IMAGE) {
					field.addItem(attr);
				}
			}
		}
		
		JPanel grid = new JPanel(new GridLayout(2, 0));
		
		JPanel comboSelect = new JPanel();
		comboSelect.add(field);
		comboSelect.add(func);
		grid.add(comboSelect);
		
		JPanel columnSelect = new JPanel();
		for(JCheckBox checkBox : checkBoxes) {
			columnSelect.add(checkBox);
		}
		grid.add(columnSelect);
		
		add(grid, BorderLayout.CENTER);
		
		JButton OK = new JButton("OK");
		OK.addActionListener(this);
		JButton cancel = new JButton("cancel");
		cancel.addActionListener(this);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		buttonPanel.add(OK);
		buttonPanel.add(cancel);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("OK")) {
			data[1] = ((GroupFunctions)func.getSelectedItem()).name() + "(" + ((Attribute)field.getSelectedItem()).toString() + ")";
			data[2] = "";
			for(JCheckBox checkBox : checkBoxes) {
				if(checkBox.isEnabled() && checkBox.isSelected()) {
					data[1] += ", " + checkBox.getText();
					if(data[2].equals("")) {
						data[2] = " GROUP BY " + checkBox.getText();
					} else {
						data[2] += ", " + checkBox.getText();
					}
				}
			}
			MainFrame.getInstance().getAppCore().Report(data);
			// System.out.println(data[1]);
			// System.out.println(data[2]);
		}

		setVisible(false); // you can't see me!
		dispose(); // Destroy the object

	}
}
