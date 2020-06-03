package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.ReportDialog;

public class ReportTopController implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getAppCore().getMainTable() != null) {
			ReportDialog dialog = new ReportDialog(MainFrame.getInstance(), "Report", true);
			dialog.setVisible(true);
		}
	}
}
