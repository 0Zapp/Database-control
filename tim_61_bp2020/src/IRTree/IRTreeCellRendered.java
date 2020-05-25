package IRTree;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

public class IRTreeCellRendered extends DefaultTreeCellRenderer {

	public IRTreeCellRendered() {

		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof AttributeConstraint) {
			setIcon(new ImageIcon("images/page-icon.png"));

		} else if (value instanceof Entity) {
			setIcon(new ImageIcon("images/project-icon.png"));

		} else if (value instanceof Attribute) {
			setIcon(new ImageIcon("images/document-icon.png"));

		} else if (value instanceof InformationResource) {
			setIcon(new ImageIcon("images/workspace-icon.png"));

		}

		return this;
	}

}