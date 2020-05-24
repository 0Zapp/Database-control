package resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DBNode {

    private String name;
    @ToString.Exclude
    private DBNode parent;


}
