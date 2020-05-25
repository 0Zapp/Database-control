package resource.implementation;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import lombok.Data;
import lombok.ToString;
import resource.DBNode;
import resource.enums.ConstraintType;

@Data
@ToString(callSuper = true)
public class AttributeConstraint extends DBNode {

    private ConstraintType constraintType;

    public AttributeConstraint(String name, DBNode parent, ConstraintType constraintType) {
        super(name, parent);
        this.constraintType = constraintType;
    }

    @Override
	public Enumeration children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		return 0;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}
	
	public String toString() {

		return name;
	}

}
