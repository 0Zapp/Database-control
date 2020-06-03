package database;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import resource.DBNode;
import resource.data.Row;

import java.util.List;

//@Data
//@AllArgsConstructor
public class DatabaseImplementation implements Database {

	public DatabaseImplementation(Repository repository) {
		super();
		this.repository = repository;
	}

	private Repository repository;

	@Override
	public DBNode loadResource() {
		return repository.getSchema();
	}

	@Override
	public List<Row> readDataFromTable(String tableName) {
		return repository.get(tableName);
	}

	@Override
	public void deleteRow(String[] data) {
		repository.deleteRow(data);

	}

	@Override
	public void InsertRow(String[] data) {
		repository.InsertRow(data);

	}

	@Override
	public void UpdateRow(String[] data, String[] original) {
		repository.updateRow(data, original);

	}

	@Override
	public void FaS(String[] data) {
		repository.FaS(data);
		
	}
	
	@Override
	public List<Row> Search(String[] data) {
		return repository.Search(data);
	}
	
	@Override
	public List<Row> Report(String[] data) {
		return repository.Report(data);
	}
}
