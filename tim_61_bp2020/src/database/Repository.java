package database;

import resource.DBNode;
import resource.data.Row;

import java.util.List;

public interface Repository {

	DBNode getSchema();

	List<Row> get(String from);

	void deleteRow(String[] data);

	void updateRow(String[] data, String[] original);

	void InsertRow(String[] data);
}
