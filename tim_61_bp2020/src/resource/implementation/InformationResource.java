package resource.implementation;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import lombok.Data;
import lombok.ToString;
import resource.DBNode;
import resource.DBNodeComposite;

@Data
@ToString(callSuper = true)
public class InformationResource extends DBNodeComposite {

	public InformationResource(String name) {
		super(name, null);
	}

	@Override
	public void addChild(DBNode child) {
		if (child != null && child instanceof Entity) {
			Entity entity = (Entity) child;
			this.getChildren().add(entity);
		}
	}

	public String toString() {

		return name;
	}

}
