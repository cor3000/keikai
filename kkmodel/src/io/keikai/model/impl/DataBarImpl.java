/* DataBarImpl.java

	Purpose:
		
	Description:
		
	History:
		Oct 26, 2015 12:41:22 PM, Created by henrichen

	Copyright (C) 2015 Potix Corporation. All Rights Reserved.
*/

package io.keikai.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.keikai.model.SBook;
import io.keikai.model.SCFValueObject;
import io.keikai.model.SColor;
import io.keikai.model.SDataBar;

/**
 * @author henri
 *
 */
public class DataBarImpl implements SDataBar, Serializable {
	private static final long serialVersionUID = -4969929958321921242L;
	
	private List<SCFValueObject> valueObjects;
	private SColor color;
	private int minLength = 10; //ZSS-1142: default to 10
	private int maxLength = 90; //ZSS-1142: default to 90
	private boolean showValue = true; //ZSS-1161: default to true
	
	@Override
	public List<SCFValueObject> getCFValueObjects() {
		return valueObjects;
	}
	
	public void addValueObject(SCFValueObject vobject) {
		if (valueObjects == null) {
			valueObjects = new ArrayList<SCFValueObject>();
		}
		valueObjects.add(vobject);
	}

	@Override
	public SColor getColor() {
		return color;
	}
	
	public void setColor(SColor color) {
		this.color = color;
	}

	@Override
	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	
	@Override
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
	@Override
	public boolean isShowValue() {
		return showValue;
	}
	
	public void setShowValue(boolean b) {
		showValue = b;
	}

	//ZSS-1142
	public DataBarImpl cloneDataBar(SBook book) {
		DataBarImpl bar = new DataBarImpl();
		for (SCFValueObject vo : valueObjects) {
			CFValueObjectImpl vo0 = (CFValueObjectImpl) vo;
			bar.addValueObject(vo0.cloneCFValueObject());
		}
		ColorImpl color0 = (ColorImpl) color;
		bar.color = color0.cloneColor(book);
		bar.minLength = minLength;
		bar.maxLength = maxLength;
		bar.showValue = showValue;
		
		return bar;
	}
}
