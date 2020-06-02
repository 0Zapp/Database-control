package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.FaSDialog;
import gui.MainFrame;

public class FaSController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		FaSDialog dialog = new FaSDialog(MainFrame.getInstance(), "Filter & Sort", true);
		dialog.setVisible(true);

	}

}
