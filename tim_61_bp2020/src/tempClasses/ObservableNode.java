package tempClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;

public abstract class ObservableNode extends Observable implements TreeNode, Serializable {

	protected ArrayList<ObservableNode> children = new ArrayList<>();
	protected String name;
	protected boolean visible;

	public ObservableNode(String name) {
		this.name = name;
		visible = true;
	}

	public Enumeration<ObservableNode> children() {
		return (Enumeration<ObservableNode>) children;
	}

	public ArrayList<ObservableNode> getChildren() {
		return children;
	}

	public boolean getAllowsChildren() {
		return false;
	}

	public TreeNode getChildAt(int childIndex) {
		return children.get(childIndex);
	}

	public int getChildCount() {
		return children.size();
	}

	public boolean isVisible() {
		return visible;
	}

	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	public TreeNode getParent() {
		return null;
	}

	public boolean isLeaf() {
		return false;
	}

	public String toString() {
		return name;
	}

	public abstract void addChild(ObservableNode node);

	protected boolean isNameTaken(String name2) {

		for (ObservableNode child : children) {
			if (child.getName().equals(name2)) {
				return true;
			}
		}

		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers(name);
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		setChanged();
		notifyObservers(this.visible);
	}

	public void doNothing() {
		setChanged();
		notifyObservers();
	}

	public void doNothing(ObservableNode node) {
		setChanged();
		notifyObservers(node);
	}

	public void removeChild(ObservableNode node) {
		try {
			children.get(children.indexOf(node)).setVisible(false);
			children.remove(node);
			setChanged();
			notifyObservers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
