package IRTree;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;

public class IRTreeEditor extends DefaultTreeCellEditor implements ActionListener {

	private Object stavka = null;
	private JTextField edit = null;

	public IRTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
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
		if (stavka instanceof Entity) {
			((Entity) stavka).setName(e.getActionCommand());
		} else if (stavka instanceof Attribute) {
			((Attribute) stavka).setName(e.getActionCommand());
		} else {
			((AttributeConstraint) stavka).setName(e.getActionCommand());
		}

	}

}