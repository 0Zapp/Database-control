package gui;

import app.AppCore;
//import lombok.Data;
import observer.Notification;
import observer.Subscriber;
import observer.enums.NotificationCode;
import resource.implementation.InformationResource;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeNode;

import IRTree.IRTree;
import IRTree.IRTreeModel;

import java.awt.*;

//@Data
public class MainFrame extends JFrame implements Subscriber {

	private static MainFrame instance = null;

	private AppCore appCore;
	private JTable jTableTop;
	private JTable jTableBottom;
	private JScrollPane jsp;
	private JPanel bottomStatus;

	private MyMenuBar menu;

	private JScrollPane scroll;
	private JSplitPane split;
	private JSplitPane splitTable;
	private JScrollPane scrollTableTop;
	private JScrollPane scrollTableBottom;

	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel buttonPanelTop;
	private JPanel buttonPanelBottom;

	private JButton RefreshTop;
	private JButton DeleteTop;
	private JButton AddTop;
	private JButton CommitTop;

	private JButton RefreshBottom;
	private JButton DeleteBottom;
	private JButton AddBottom;
	private JButton CommitBottom;

	private IRTreeModel IRTreeModel;
	private IRTree IRTree;

	private MainFrame() {

	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
	}

	private void initialise() {
		initialiseWorkspaceTree();
		initialiseGui();
		SwingUtilities.updateComponentTreeUI(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setVisible(true);
	}

	private void initialiseWorkspaceTree() {
		IRTree = new IRTree();
		IRTreeModel = new IRTreeModel(new InformationResource("loading...."));
		IRTree.setModel(IRTreeModel);
		SwingUtilities.updateComponentTreeUI(this);

	}

	private void initialiseGui() {

		menu = new MyMenuBar(this);
		this.setJMenuBar(menu);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Baze Projekat");

		scroll = new JScrollPane(IRTree);
		scroll.setPreferredSize(new Dimension(250, 250));
		scroll.setMinimumSize((new Dimension(200, 200)));
		scroll.setMaximumSize(new Dimension(300, 300));

		jTableTop = new JTable();
		jTableTop.setPreferredScrollableViewportSize(new Dimension(500, 300));
		jTableTop.setFillsViewportHeight(true);
		scrollTableTop = new JScrollPane(jTableTop);

		RefreshTop = new JButton("Refresh");
		DeleteTop = new JButton("Delete");
		AddTop = new JButton("Add");
		CommitTop = new JButton("Commit");

		buttonPanelTop = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		buttonPanelTop.add(RefreshTop);
		buttonPanelTop.add(DeleteTop);
		buttonPanelTop.add(AddTop);
		buttonPanelTop.add(CommitTop);

		topPanel = new JPanel(new BorderLayout());
		topPanel.add(scrollTableTop, BorderLayout.CENTER);
		topPanel.add(buttonPanelTop, BorderLayout.SOUTH);

		jTableBottom = new JTable();
		jTableBottom.setPreferredScrollableViewportSize(new Dimension(500, 300));
		jTableBottom.setFillsViewportHeight(true);
		scrollTableBottom = new JScrollPane(jTableBottom);

		RefreshBottom = new JButton("Refresh");
		DeleteBottom = new JButton("Delete");
		AddBottom = new JButton("Add");
		CommitBottom = new JButton("Commit");

		buttonPanelBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		buttonPanelBottom.add(RefreshBottom);
		buttonPanelBottom.add(DeleteBottom);
		buttonPanelBottom.add(AddBottom);
		buttonPanelBottom.add(CommitBottom);

		bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(scrollTableBottom, BorderLayout.CENTER);
		bottomPanel.add(buttonPanelBottom, BorderLayout.SOUTH);

		splitTable = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);

		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, splitTable);
		add(split, BorderLayout.CENTER);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);

		this.pack();
		this.setLocationRelativeTo(null);

	}

	public void setAppCore(AppCore appCore) {
		this.appCore = appCore;
		this.appCore.addSubscriber(this);
		this.jTableTop.setModel(appCore.getTableModel());
		this.jTableBottom.setModel(appCore.getTableModel());
	}

	@Override
	public void update(Notification notification) {

		if (notification.getCode() == NotificationCode.RESOURCE_LOADED) {
			IRTreeModel.setRoot((TreeNode) notification.getData());

		}

		else {
			jTableTop.setModel((TableModel) notification.getData());
			jTableBottom.setModel(appCore.getTableModel());
		}

	}

	public AppCore getAppCore() {
		return appCore;
	}
}
