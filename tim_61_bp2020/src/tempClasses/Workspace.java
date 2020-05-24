package tempClasses;

import java.util.ArrayList;
import gui.MainFrame;

public class Workspace extends ObservableNode {
	private String path;
	
	public void removeAllProjects() {
		children = new ArrayList<ObservableNode>();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Workspace() {
		super("Workspace");
	}

	public boolean getAllowsChildren() {
		return true;
	}
	
	public void addChild(ObservableNode project) {
		int i = 1;
		project.setName("New Project: " + i);
		while (isNameTaken(project.getName())) {
			i++;
			project.setName("New Project: " + i);
		}
		children.add(project);
	}

	public void removeChild(ObservableNode project) {
		children.remove(project);
		System.out.println("lol workspace");
		//MainFrame.getInstance().changeProjectView(new ProjectView());
	}

}
