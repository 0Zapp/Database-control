package IRTree;

import javax.swing.tree.DefaultTreeModel;

import resource.DBNode;
import resource.implementation.InformationResource;

public class IRTreeModel extends DefaultTreeModel {

	public IRTreeModel() {
		super(new InformationResource(null));

	}
	
	public IRTreeModel(InformationResource ir) {
		super(ir);

	}

	public void addEntity(DBNode entity) {
		((InformationResource) getRoot()).addChild(entity);
	}

}
