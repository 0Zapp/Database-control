package resource.data;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

//@Data
public class Row {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getFields() {
		return fields;
	}

	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}

	private String name;
	private Map<String, Object> fields;

	public Row() {
		this.fields = new HashMap<>();
	}

	public void addField(String fieldName, Object value) {
		this.fields.put(fieldName, value);
	}

	public void removeField(String fieldName) {
		this.fields.remove(fieldName);
	}

}
