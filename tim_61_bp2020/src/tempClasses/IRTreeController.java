package tempClasses;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import gui.MainFrame;
import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

public class IRTreeController implements TreeSelectionListener {

	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub

		TreePath path = e.getPath();
		int mode = 0;// 0-selektovan workspace
						// 1-selektovan project
						// 2-selectovan document
						// 3-selectovan page;
		InformationResource informationResource = null;
		Entity entity = null;
		Attribute attribute = null;
		AttributeConstraint attributeConstraint = null;

		for (int i = 0; i < path.getPathCount(); i++) {
			mode = i;
			switch (mode) {
			case 0:
				informationResource = (InformationResource) path.getPathComponent(i);
				break;
			case 1:
				entity = (Entity) path.getPathComponent(i);
				break;
			case 2:
				attribute = (Attribute) path.getPathComponent(i);
				break;
			case 3:
				attributeConstraint = (AttributeConstraint) path.getPathComponent(i);
				break;

			default:
				break;
			}

		}

		System.out.println(path.getPath());
		//MainFrame.getInstance().changeProjectView(path.getParentPath(), project, document, page, mode);

	}

}