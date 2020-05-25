package resource.implementation;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

//import lombok.Data;
//import lombok.ToString;
import resource.DBNode;
import resource.DBNodeComposite;
import resource.enums.AttributeType;

//@Data
//@ToString(callSuper = true)
public class Attribute extends DBNodeComposite {

	private AttributeType attributeType;
	private int length;
	private Attribute inRelationWith;

	public Attribute(String name, DBNode parent) {
		super(name, parent);
	}

	public Attribute(String name, DBNode parent, AttributeType attributeType, int length) {
		super(name, parent);
		this.attributeType = attributeType;
		this.length = length;
	}

	@Override
	public void addChild(DBNode child) {
		if (child != null && child instanceof AttributeConstraint) {
			AttributeConstraint attributeConstraint = (AttributeConstraint) child;
			this.getChildren().add(attributeConstraint);
		}
	}

	public String toString() {

		return name;
	}

}
