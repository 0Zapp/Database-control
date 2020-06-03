package controller.report;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import gui.SearchDialog;
import resource.enums.ComparisonOperatorType;
import resource.enums.GroupFunctions;
import resource.enums.ValidDataType;
import resource.implementation.Attribute;

public class ReportFieldChanged implements ItemListener {
	
	List<JCheckBox> checkBoxes;
	JComboBox<GroupFunctions> func;
	
	public ReportFieldChanged(List<JCheckBox> checkBoxes, JComboBox<GroupFunctions> func) {
		this.checkBoxes = checkBoxes;
		this.func = func;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
          Attribute attr = (Attribute)e.getItem();
          func.removeAllItems();
          for(GroupFunctions function : GroupFunctions.values()) {
        	  if(function.getValid() == ValidDataType.ALL || function.getValid() == attr.getType().getValid()) {
        		  func.addItem(function);
        	  }
          }
          for(JCheckBox checkBox : checkBoxes) {
        	  if(checkBox.getText().equals(attr.toString())) {
        		  checkBox.setEnabled(false);
        	  } else {
        		  checkBox.setEnabled(true);
        	  }
          }
       }
	}

}
