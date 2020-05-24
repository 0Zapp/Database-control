package resource.implementation;

import lombok.Data;
import lombok.ToString;
import resource.DBNode;
import resource.enums.ConstraintType;

@Data
@ToString(callSuper = true)
public class AttributeConstraint extends DBNode {

    private ConstraintType constraintType;

    public AttributeConstraint(String name, DBNode parent, ConstraintType constraintType) {
        super(name, parent);
        this.constraintType = constraintType;
    }
}
