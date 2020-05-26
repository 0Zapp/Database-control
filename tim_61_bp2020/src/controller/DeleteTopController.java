package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;

public class DeleteTopController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// MainFrame.getInstance().addTables();

		String[] data = MainFrame.getInstance().getSelectedTop();

		MainFrame.getInstance().getAppCore().deleteRow(data);

	}

}
