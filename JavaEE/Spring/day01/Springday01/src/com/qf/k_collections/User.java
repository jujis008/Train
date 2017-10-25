package com.qf.k_collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {
	// List  Set  Map  数组  properties
	private List<String> listData;
	
	private String[] arrayData;

	private Set<String> setData;
	
	private Map<String,Object> mapData[];
	
	private Properties props;
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [\nlistData=" + listData + ", \narrayData=" + Arrays.toString(arrayData) + ", \nsetData=" + setData
				+ ", \nmapData=" + Arrays.toString(mapData) + ", \nprops=" + props + "]";
	}

	public List<String> getListData() {
		return listData;
	}

	public void setListData(List<String> listData) {
		this.listData = listData;
	}

	public String[] getArrayData() {
		return arrayData;
	}

	public void setArrayData(String[] arrayData) {
		this.arrayData = arrayData;
	}

	public Set<String> getSetData() {
		return setData;
	}

	public void setSetData(Set<String> setData) {
		this.setData = setData;
	}

	public Map<String, Object>[] getMapData() {
		return mapData;
	}

	public void setMapData(Map<String, Object>[] mapData) {
		this.mapData = mapData;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	
	

}
