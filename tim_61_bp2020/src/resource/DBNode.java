package resource;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class DBNode implements TreeNode {

	private String name;
	@ToString.Exclude
	private DBNode parent;

}
