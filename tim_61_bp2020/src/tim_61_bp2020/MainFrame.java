/**
 * 
 */
package tim_61_bp2020;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 6726587869617328519L;
	
	private JTable tblStudenti;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initTable();

		// Zaglavlje kolone se ne mora ručno ubacivati. JScrollPane će odraditi
		// taj posao.
		add(new JScrollPane(tblStudenti));

		pack();

		setLocationRelativeTo(null);
	}

	private void initTable() {
		// Zaglavlja kolona
		Object[] columns = new Object[] { "Dosije", "Ime", "Prezime" };

		Object[][] data = { { "ra1/2011", "Petar", "Petrović" },
				{ "ra1/2011", "Lazar", "Lazić" },
				{ "ra2/2011", "Milan", "Kovačević" },
				{ "ra3/2011", "Ana", "Petrović" },
				{ "ra4/2011", "Bojan", "Bakić" },
				{ "ra5/2011", "Dragan", "Kovačević" },
				{ "ra6/2011", "Ivan", "Ivić" } };

		tblStudenti = new JTable(data, columns);

		// Poželjna veličina pogleda tabele u okviru scrollpane-a. Layout
		// manager uzima ovu osobinu u obzir.
		tblStudenti.setPreferredScrollableViewportSize(new Dimension(500, 400));

		// Širenje tabele kompletno po visini pogleda scrollpane-a.
		tblStudenti.setFillsViewportHeight(true);
	}

}
