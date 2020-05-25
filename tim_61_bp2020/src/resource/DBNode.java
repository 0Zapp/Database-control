package resource;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public abstract class DBNode implements TreeNode {

	protected String name;
//	@ToString.Exclude
	private DBNode parent;

	public DBNode(String name, DBNode parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DBNode getParent() {
		return parent;
	}

	public void setParent(DBNode parent) {
		this.parent = parent;
	}

}
