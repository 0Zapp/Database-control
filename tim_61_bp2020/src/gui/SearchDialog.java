package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.search.NewConditionController;
import controller.search.RemoveConditionController;
import resource.DBNode;
import resource.implementation.Attribute;
import resource.implementation.Entity;

public class SearchDialog extends JDialog implements ActionListener {
	
	String[] data;
	ArrayList<ConditionComponent> listConditions;
	JPanel grid;
	JPanel newCondition;
	GridBagConstraints c;
	List<Attribute> availableColumns;
	
	public SearchDialog(Frame parent, String title, boolean modal) {

		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize((screenWidth / 10) * 7, (screenHeight / 10) * 7);
		setLocationRelativeTo(null);

		Entity table = MainFrame.getInstance().getAppCore().getMainTable();
		data = new String[2];
		data[0] = table.toString();
		availableColumns = new ArrayList<Attribute>();
		for(DBNode child : table.getChildren()) {
			if(child instanceof Attribute) {
				Attribute attr = (Attribute)child;
				availableColumns.add(attr);
			}
		}
		
		listConditions = new ArrayList<ConditionComponent>();
		
		grid = new JPanel();
		grid.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JScrollPane scroller = new JScrollPane(grid);
		this.add(scroller);
		
		listConditions.add(new ConditionComponent(availableColumns, true, null));
		
		JButton newConditionButton = new JButton(new NewConditionController(this));
		newCondition = new JPanel();
		newCondition.add(newConditionButton);
		
		JButton OK = new JButton("OK");
		OK.addActionListener(this);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		buttonPanel.add(OK);
		buttonPanel.add(cancel);

		add(buttonPanel, BorderLayout.SOUTH);
		
		refreshContents();
	}
	
	public void createCC() {
		RemoveConditionController controller = new RemoveConditionController(this);
		
		ConditionComponent cc = new ConditionComponent(availableColumns, false, controller); 
		listConditions.add(cc);
		
		refreshContents();
	}
	
	public void removeCC(ConditionComponent cc) {
		listConditions.remove(cc);
		
		refreshContents();
	}
	
	private void addRow(ConditionComponent cc) {
		List<JComponent> parts = cc.getParts();
		for(JComponent part : parts) {
			if(part != null) {
				grid.add(part, c);
			}
			c.gridx++;
		}
		c.gridx = 0;
		c.gridy++;
	}
	
	private void refreshContents() {
		grid.removeAll();
		
		c.weighty = 0;
		c.insets = new Insets(20, 5, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		
		for(ConditionComponent cc : listConditions) {
			addRow(cc);
		}
		
		c.weighty = 1;
		c.gridwidth = 5;
		grid.add(newCondition, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("OK")) {
			data[1] = "";
			for(ConditionComponent cc : listConditions) {
				data[1] += cc.getClause();
			}
			//System.out.println(data[1]);
			MainFrame.getInstance().getAppCore().Search(data);
		}

		setVisible(false); // you can't see me!
		dispose(); // Destroy the object

	}
}
