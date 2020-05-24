package tempClasses;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer {

	public WorkspaceTreeCellRendered() {

		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof Constraint) {
			setIcon(new ImageIcon("images/page-icon.png"));

		} else if (value instanceof Table) {
			setIcon(new ImageIcon("images/project-icon.png"));

		} else if (value instanceof Atribut) {
			setIcon(new ImageIcon("images/document-icon.png"));

		} else if (value instanceof Workspace) {
			setIcon(new ImageIcon("images/workspace-icon.png"));

		}

		return this;
	}

}