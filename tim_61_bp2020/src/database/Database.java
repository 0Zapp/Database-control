package database;

import resource.DBNode;
import resource.data.Row;

import java.util.List;

public interface Database {

	DBNode loadResource();

	void deleteRow(String[] data);

	List<Row> readDataFromTable(String tableName, String relatedAttribute, String value);

	void InsertRow(String[] data);

	void UpdateRow(String[] data, String[] original);

	List<Row> FaS(String[] data, String[] filter, String[] sort);

	List<Row> Search(String[] data);

	List<Row> Report(String[] data);

}
