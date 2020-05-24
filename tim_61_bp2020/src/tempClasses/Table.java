package tempClasses;

public class Table extends ObservableNode {

	private String path;

	public Table(String name) {
		super(name);		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public void addChild(ObservableNode node) {
		int i = 1;
		node.setName("New Document: " + i);
		while (isNameTaken(node.getName())) {
			i++;
			node.setName("New Document: " + i);
		}
		children.add(node);
		setChanged();
		notifyObservers(node);
	}	
	
}
