package tempClasses;

public class Atribut extends ObservableNode {

	public Atribut(String name) {
		super(name);
	}

	public void addChild(ObservableNode node) {
		int i = 1;
		node.setName("New Page: " + i);
		while (isNameTaken(node.getName())) {
			i++;
			node.setName("New Page: " + i);
		}
		children.add(node);
		setChanged();
		notifyObservers(node);
	}

}
