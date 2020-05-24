package tempClasses;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener {

	private Object stavka = null;
	private JTextField edit = null;

	public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}

	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4,
			int arg5) {

		// super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
		stavka = arg1;

		edit = new JTextField(arg1.toString());
		edit.addActionListener(this);
		return edit;
	}

	public boolean isCellEditable(EventObject arg0) {
		if (arg0 instanceof MouseEvent)
			if (((MouseEvent) arg0).getClickCount() == 3) {
				return true;
			}
		return false;
	}

	public void actionPerformed(ActionEvent e) {
		if (stavka instanceof Table) {
			((Table) stavka).setName(e.getActionCommand());
		} else if (stavka instanceof Atribut) {
			((Atribut) stavka).setName(e.getActionCommand());
		} else {
			((Constraint) stavka).setName(e.getActionCommand());
		}

	}

}