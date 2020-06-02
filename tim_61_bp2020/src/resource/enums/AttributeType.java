package resource.enums;

public enum AttributeType {
    CHAR (ValidDataType.TEXT),
    VARCHAR (ValidDataType.TEXT),
    TEXT (ValidDataType.TEXT),
    DATE (ValidDataType.NUMBER),
    TIME (ValidDataType.NUMBER),
    DATETIME (ValidDataType.NUMBER),
    FLOAT (ValidDataType.NUMBER),
    REAL (ValidDataType.NUMBER),
    BIT (ValidDataType.NUMBER),
    BIGINT (ValidDataType.NUMBER),
    NUMERIC (ValidDataType.NUMBER),
    DECIMAL (ValidDataType.NUMBER),
    INT (ValidDataType.NUMBER),
    IMAGE (ValidDataType.UNKNOWN),
    SMALLINT (ValidDataType.NUMBER),
    NVARCHAR (ValidDataType.TEXT);
    
    private final ValidDataType valid;
    
    AttributeType(ValidDataType valid) {
    	this.valid = valid;
    }
    
    public ValidDataType getValid() {
    	return valid;
    }
}
