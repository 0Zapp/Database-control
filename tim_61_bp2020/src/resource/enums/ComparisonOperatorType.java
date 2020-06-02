package resource.enums;

public enum ComparisonOperatorType {
	// All types
	IS_NOT_NULL ("IS NOT NULL", ValidDataType.ALL),
	IN ("IN", ValidDataType.ALL),
	BETWEEN ("BETWEEN", ValidDataType.ALL),
	EQUALS ("=", ValidDataType.ALL),
	NOT_EQUAL_TO ("<>", ValidDataType.ALL),
	
	// Date and Numerical
	GREATER_THAN_OR_EQUAL (">=", ValidDataType.NUMBER),
	GREATER_THAN (">", ValidDataType.NUMBER),
	LESS_THAN ("<", ValidDataType.NUMBER),
	LESS_THAN_OR_EQUAL  ("<=", ValidDataType.NUMBER),
	
	// Text
	LIKE ("LIKE", ValidDataType.TEXT);
	
	private final String symbolicRepresentation;
	private final ValidDataType valid;

	ComparisonOperatorType(String symbolicRepresentation, ValidDataType valid) {
		this.symbolicRepresentation = symbolicRepresentation;
		this.valid = valid;
	}
	
	@Override
	public String toString() {
		return this.symbolicRepresentation;
	}
	
	public ValidDataType getValid() {
		return this.valid;
	}
}
