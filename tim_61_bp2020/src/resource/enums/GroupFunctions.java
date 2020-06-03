package resource.enums;

public enum GroupFunctions {
	COUNT (ValidDataType.ALL),
	AVG (ValidDataType.NUMBER);
	
	private final ValidDataType valid;
    
	GroupFunctions(ValidDataType valid) {
    	this.valid = valid;
    }
    
    public ValidDataType getValid() {
    	return valid;
    }
}
