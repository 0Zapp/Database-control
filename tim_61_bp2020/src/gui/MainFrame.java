package gui;

import app.AppCore;
import controller.DeleteTopController;
import controller.InsertTopController;
import controller.UpdateTopController;
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

public class MainFrame extends JFrame implements Subscriber {

	private static MainFrame instance = null;

	private AppCore appCore;
	private JTable jTableTop;
	private JTable jTableBottom;
	private MyMenuBar menu;

	private JScrollPane scroll;
	private JSplitPane split;
	private JSplitPane splitTable;
	private JScrollPane scrollTableTop;
	private JScrollPane scrollTableBottom;

	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel buttonPanelTop;

	private JButton DeleteTop;
	private JButton InsertTop;
	private JButton UpdateTop;

	private IRTreeModel IRTreeModel;
	private IRTree IRTree;
	private String topTableName;

	public String getTopTableName() {
		return topTableName;
	}

	public void setTopTableName(String topTableName) {
		this.topTableName = topTableName;
	}

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

		DeleteTop = new JButton("Delete");
		DeleteTop.addActionListener(new DeleteTopController());
		UpdateTop = new JButton("Update");
		UpdateTop.addActionListener(new UpdateTopController());
		InsertTop = new JButton("Insert");
		InsertTop.addActionListener(new InsertTopController());

		buttonPanelTop = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		buttonPanelTop.add(DeleteTop);
		buttonPanelTop.add(InsertTop);
		buttonPanelTop.add(UpdateTop);

		topPanel = new JPanel(new BorderLayout());
		topPanel.add(scrollTableTop, BorderLayout.CENTER);
		topPanel.add(buttonPanelTop, BorderLayout.SOUTH);

		jTableBottom = new JTable();
		jTableBottom.setPreferredScrollableViewportSize(new Dimension(500, 300));
		jTableBottom.setFillsViewportHeight(true);
		scrollTableBottom = new JScrollPane(jTableBottom);

		bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(scrollTableBottom, BorderLayout.CENTER);

		splitTable = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);

		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, splitTable);
		add(split, BorderLayout.CENTER);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);

		this.pack();
		this.setLocationRelativeTo(null);
		topTableName = "loading..";

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

		} else if (notification.getCode() == NotificationCode.TABLE_NAME_CHANGE) {
			topTableName = (String) notification.getData();
		}

		else if (notification.getCode() == NotificationCode.DATA_UPDATED) {
			jTableTop.setModel((TableModel) notification.getData());
			jTableBottom.setModel(appCore.getTableModel());

		} else if (notification.getCode() == NotificationCode.ROW_CHANGE) {
			appCore.readDataFromTable(topTableName);
		}
		try {
			jTableTop.setRowSelectionInterval(0, 0);
		} catch (Exception e) {
			System.out.println("loading...");
		}

	}

	public JTable getjTableTop() {
		return jTableTop;
	}

	public AppCore getAppCore() {
		return appCore;
	}

	public String[] getSelectedTop() {
		int columnCount = jTableTop.getColumnCount();
		String data[] = new String[1 + columnCount * 2];

		data[0] = topTableName;
		for (int i = 0; i < columnCount; i++) {
			data[i + 1] = jTableTop.getColumnName(i);
			data[i + 1 + columnCount] = (String) jTableTop.getValueAt(jTableTop.getSelectedRow(), i);
		}

		return data;
	}

}
