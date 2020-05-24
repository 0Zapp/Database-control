package tempClasses;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;


public class WorkspaceTree extends JTree {

	public WorkspaceTree() {

		addTreeSelectionListener(new WorkspaceTreeController());
		setCellEditor(new WorkspaceTreeEditor(this, new DefaultTreeCellRenderer()));
		setCellRenderer(new WorkspaceTreeCellRendered());
		setEditable(true);
	}

	public void addProject(Table project) {
		((WorkspaceModel) getModel()).addTable(project);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
