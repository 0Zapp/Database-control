package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.InsertDialog;
import gui.MainFrame;

public class InsertTopController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		InsertDialog dialog = new InsertDialog(MainFrame.getInstance(), "Insert", true);
		dialog.setVisible(true);

	}

}
