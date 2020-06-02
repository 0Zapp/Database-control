package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

import controller.search.AttributeChangedListener;
import controller.search.RemoveConditionController;
import observer.Notification;
import observer.Subscriber;
import resource.enums.AttributeType;
import resource.enums.ComparisonOperatorType;
import resource.enums.LogicalOperatorType;
import resource.implementation.Attribute;

public class ConditionComponent implements Subscriber {
	
	private JComboBox<LogicalOperatorType> chainOperator;
	private JCheckBox negation;
	private JComboBox<Attribute> field;
	private JComboBox<ComparisonOperatorType> comparisonOperators;
	private JFormattedTextField searchTerm;
	private JButton remove;
	
	public ConditionComponent(List<Attribute> columns, boolean first, RemoveConditionController controller) {
		super();
		
		if(!first) {
			chainOperator = new JComboBox<LogicalOperatorType>(LogicalOperatorType.values());
		}
		negation = new JCheckBox("NOT");
		
		searchTerm = new JFormattedTextField();
		searchTerm.setPreferredSize(new Dimension(550,24));
		comparisonOperators = new JComboBox<ComparisonOperatorType>();
		comparisonOperators.setPreferredSize(new Dimension(150, 24));
		field = new JComboBox<Attribute>();
		field.addItemListener(new AttributeChangedListener(comparisonOperators));
		for(Attribute attr : columns) {
			if(attr.getType() != AttributeType.IMAGE) {
				field.addItem(attr);
			}
		}
		field.setPreferredSize(new Dimension(150, 24));
		
		if(remove != null) {
			controller.setCC(this);
			remove = new JButton(controller);
		}
	}
	
	public List<JComponent> getParts() {
		List<JComponent> components = new ArrayList<JComponent>();
		components.add(chainOperator);
		components.add(negation);
		components.add(field);
		components.add(comparisonOperators);
		components.add(searchTerm);
		components.add(remove);
		return components;
	}
	
	public String getClause() {
		String clause = "";
		if(chainOperator != null) {
			LogicalOperatorType log = (LogicalOperatorType)chainOperator.getSelectedItem();
			clause += " " + log.name() + " ";
		}
		if(negation.isSelected()) {
			clause += "NOT ";
		}
		Attribute attr = (Attribute)field.getSelectedItem();
		clause += attr.getName() + " ";
		ComparisonOperatorType comp = (ComparisonOperatorType)comparisonOperators.getSelectedItem();
		clause += comp.toString();
		if(!searchTerm.getText().equals("")) {
			clause += " " + searchTerm.getText();
		}
		return clause;
	}
	
	@Override
	public void update(Notification notification) {
	}

}
