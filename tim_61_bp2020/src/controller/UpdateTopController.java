package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.InsertDialog;
import gui.MainFrame;
import gui.UpdateDialog;

public class UpdateTopController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		UpdateDialog dialog = new UpdateDialog(MainFrame.getInstance(), "Update", true);
		dialog.setVisible(true);

	}

}
