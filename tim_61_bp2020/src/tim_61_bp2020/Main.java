package tim_61_bp2020;

import javax.swing.SwingUtilities;


public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mf = new MainFrame();
				mf.setVisible(true);
			}
		});

	}

}
