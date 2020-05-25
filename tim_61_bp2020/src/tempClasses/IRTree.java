package tempClasses;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

import resource.implementation.Entity;


public class IRTree extends JTree {

	public IRTree() {

		addTreeSelectionListener(new IRTreeController());
		setCellEditor(new IRTreeEditor(this, new DefaultTreeCellRenderer()));
		setCellRenderer(new IRTreeCellRendered());
		setEditable(true);
	}

	public void addProject(Entity entity) {
		((IRTreeModel) getModel()).addEntity(entity);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
