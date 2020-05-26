package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;

public class UpdateTopController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] data = MainFrame.getInstance().getSelectedTop();

		MainFrame.getInstance().getAppCore().deleteRow(data);

	}

}
