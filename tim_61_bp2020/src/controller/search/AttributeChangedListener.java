package controller.search;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import resource.enums.ComparisonOperatorType;
import resource.enums.ValidDataType;
import resource.implementation.Attribute;

public class AttributeChangedListener implements ItemListener {
	
	JComboBox<ComparisonOperatorType> compOperators;
	
	public AttributeChangedListener(JComboBox<ComparisonOperatorType> compOperators) {
		this.compOperators = compOperators;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
          Attribute attr = (Attribute)e.getItem();
          compOperators.removeAllItems();
          for(ComparisonOperatorType type : ComparisonOperatorType.values()) {
        	  if(type.getValid() == ValidDataType.ALL || type.getValid() == attr.getType().getValid()) {
        		  compOperators.addItem(type);
        	  }
          }
       }
	}

}
