package app;

import database.Database;
import database.DatabaseImplementation;
import database.MSSQLrepository;
import database.settings.Settings;
import database.settings.SettingsImplementation;
import gui.MainFrame;
import gui.table.TableModel;
//import lombok.Data;
import observer.Notification;
import observer.Publisher;
import observer.Subscriber;
import observer.enums.NotificationCode;
import observer.implementation.PublisherImplementation;
import resource.implementation.Entity;
import resource.implementation.InformationResource;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class AppCore extends PublisherImplementation {

	private Database database;
	private Settings settings;
	private TableModel tableModel;
	private Entity mainTable;

	public AppCore() {
		this.settings = initSettings();
		this.database = new DatabaseImplementation(new MSSQLrepository(this.settings));
		tableModel = new TableModel();
	}

	private Settings initSettings() {
		Settings settingsImplementation = new SettingsImplementation();
		settingsImplementation.addParameter("mssql_ip", Constants.MSSQL_IP);
		settingsImplementation.addParameter("mssql_database", Constants.MSSQL_DATABASE);
		settingsImplementation.addParameter("mssql_username", Constants.MSSQL_USERNAME);
		settingsImplementation.addParameter("mssql_password", Constants.MSSQL_PASSWORD);
		return settingsImplementation;
	}

	public void loadResource() {
		InformationResource ir = (InformationResource) this.database.loadResource();

		this.notifySubscribers(new Notification(NotificationCode.RESOURCE_LOADED, ir));
	}

	public void readDataFromTable(Entity fromTable) {

		if (fromTable != null) {
			mainTable = fromTable;
		}
		try {
			tableModel.setRows(this.database.readDataFromTable(mainTable.toString(),null,null));
			this.notifySubscribers(new Notification(NotificationCode.TABLE_NAME_CHANGE, mainTable.toString()));
			MainFrame.getInstance().addTables();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("!");
		}
	}

	public void addTable(Entity table, String relatedAttribute, String value) {
		TableModel model = new TableModel();
		model.setRows(this.database.readDataFromTable(table.getName(),relatedAttribute,value));
		this.notifySubscribers(new Notification(NotificationCode.ADDED_TABLE, model));
	}

	public TableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(TableModel tableModel) {
		this.tableModel = tableModel;
	}

	public Entity getMainTable() {
		return mainTable;
	}

	public void deleteRow(String[] data) {
		this.database.deleteRow(data);
		this.notifySubscribers(new Notification(NotificationCode.ROW_CHANGE, 1));
	}

	public void InsertRow(String[] data) {
		this.database.InsertRow(data);
		this.notifySubscribers(new Notification(NotificationCode.ROW_CHANGE, 1));

	}

	public void UpdateRow(String[] data, String[] original) {
		this.database.UpdateRow(data, original);
		this.notifySubscribers(new Notification(NotificationCode.ROW_CHANGE, 1));

	}

	public void FaS(String[] data, String[] filter, String[] sort) {
		tableModel.setRows(this.database.FaS(data,filter,sort));
	//	this.notifySubscribers(new Notification(NotificationCode.ROW_CHANGE, 1));

	}

	public void Search(String[] data) {
		tableModel.setRows(this.database.Search(data));
		// this.notifySubscribers(new Notification(NotificationCode.DATA_UPDATED,
		// this.getTableModel()));
	}

	public void Report(String[] data) {
		tableModel.setRows(this.database.Report(data));
		// this.notifySubscribers(new Notification(NotificationCode.DATA_UPDATED,
		// this.getTableModel()));
	}

}
