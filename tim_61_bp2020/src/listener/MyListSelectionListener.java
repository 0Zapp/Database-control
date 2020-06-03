package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.MainFrame;
import resource.DBNode;
import resource.enums.ConstraintType;
import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

public class MyListSelectionListener implements ListSelectionListener {

	@Override

	public void valueChanged(ListSelectionEvent e) {
		MainFrame.getInstance().removeAlltabs();
		InformationResource ir = MainFrame.getInstance().getIr();
		for (DBNode entity : ir.getChildren()) {
			if (entity.getName().equals(MainFrame.getInstance().getTopTableName())) {
				for (DBNode attribute : ((Entity) entity).getChildren()) {
					for (DBNode ac : ((Attribute) attribute).getChildren()) {
						if (((AttributeConstraint) ac).getConstraintType().equals(ConstraintType.FOREIGN_KEY)) {
							String AttributeName = ((Attribute) attribute).getName();
							String relatedAttribute = ((Attribute) attribute).getInRelationWith().getName();
							Entity relatedTable = (Entity) ((Attribute) attribute).getInRelationWith().getParent();
							String value = null;

							JTable jTableTop = MainFrame.getInstance().getjTableTop();
							int columnCount = jTableTop.getColumnCount();
							int row = jTableTop.getSelectedRow();
							if (row > 0) {
								for (int i = 0; i < columnCount; i++) {
									if (jTableTop.getColumnName(i).equals(AttributeName)) {
										value = (String) jTableTop.getValueAt(row, i);
									}

								}

								try {
									// relatedTable
									MainFrame.getInstance().setTabName(relatedTable.getName());
									MainFrame.getInstance().getAppCore().addTable(relatedTable, relatedAttribute,
											value);

								} catch (Exception ex) {
									// TODO: handle exception
								}
							}
						}
					}
				}
			}
		}
	}

}
