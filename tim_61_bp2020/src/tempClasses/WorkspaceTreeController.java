package tempClasses;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import gui.MainFrame;

public class WorkspaceTreeController implements TreeSelectionListener {

	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub

		TreePath path = e.getPath();
		int mode = 0;// 0-selektovan workspace
						// 1-selektovan project
						// 2-selectovan document
						// 3-selectovan page;
		Workspace workspace = null;
		Table project = null;
		Atribut document = null;
		Constraint page = null;

		for (int i = 0; i < path.getPathCount(); i++) {
			mode = i;
			switch (mode) {
			case 0:
				workspace = (Workspace) path.getPathComponent(i);
				break;
			case 1:
				project = (Table) path.getPathComponent(i);
				break;
			case 2:
				document = (Atribut) path.getPathComponent(i);
				break;
			case 3:
				page = (Constraint) path.getPathComponent(i);
				break;

			default:
				break;
			}

		}

		System.out.println(path.getPath());
		//MainFrame.getInstance().changeProjectView(path.getParentPath(), project, document, page, mode);

	}

}