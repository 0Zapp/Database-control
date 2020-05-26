package database;

import resource.DBNode;
import resource.data.Row;

import java.util.List;

public interface Database {

	DBNode loadResource();

	void deleteRow(String[] data);

	List<Row> readDataFromTable(String tableName);

	void InsertRow(String[] data);

	void UpdateRow(String[] data, String[] original);

	void FaS(String[] data);

}
