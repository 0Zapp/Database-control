package resource;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.ToString;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

//@Data
//@ToString(callSuper = true)
public abstract class DBNodeComposite extends DBNode {

	public List<DBNode> getChildren() {
		return children;
	}

	public void setChildren(List<DBNode> children) {
		this.children = children;
	}

	private List<DBNode> children;

	public DBNodeComposite(String name, DBNode parent) {
		super(name, parent);
		this.children = new ArrayList<>();
	}

	public DBNodeComposite(String name, DBNode parent, ArrayList<DBNode> children) {
		super(name, parent);
		this.children = children;
	}

	public abstract void addChild(DBNode child);

	public DBNode getChildByName(String name) {
		for (DBNode child : this.getChildren()) {
			if (name.equals(child.getName())) {
				return child;
			}
		}
		return null;
	}

	@Override
	public Enumeration<DBNode> children() {
		return (Enumeration<DBNode>) children;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
		// return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return children.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	@Override
	public boolean isLeaf() {
		// mozda true ponekad, ali mislim da treba false da vrati
		return false;
	}

}
