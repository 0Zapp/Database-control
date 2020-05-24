package tempClasses;

import javax.swing.tree.DefaultTreeModel;

public class WorkspaceModel extends DefaultTreeModel {

	public WorkspaceModel() {
		super(new Workspace());

	}

	public void addTable(ObservableNode table) {
		((Workspace) getRoot()).addChild(table);
	}

}
