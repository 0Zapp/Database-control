package controller.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

import gui.SearchDialog;

public class NewConditionController extends AbstractAction {
	SearchDialog searchDialog;
	
	public NewConditionController(SearchDialog searchDialog) {
		this.searchDialog = searchDialog;
		
		putValue(NAME, "Add");
		putValue(SHORT_DESCRIPTION, "Add an additional condition.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		searchDialog.createCC();
		
		searchDialog.revalidate();
		searchDialog.repaint();
	}
}
