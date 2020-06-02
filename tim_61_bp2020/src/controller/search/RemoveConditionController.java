package controller.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

import gui.ConditionComponent;
import gui.SearchDialog;

public class RemoveConditionController extends AbstractAction {
	SearchDialog searchDialog;
	ConditionComponent cc;
	
	public RemoveConditionController(SearchDialog searchDialog) {
		this.searchDialog = searchDialog;
		
		putValue(NAME, "Remove");
		putValue(SHORT_DESCRIPTION, "Remove condition.");
	}
	
	public void setCC(ConditionComponent cc) {
		this.cc = cc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		searchDialog.removeCC(cc);
		
		searchDialog.revalidate();
		searchDialog.repaint();
	}
}
