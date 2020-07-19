package com.redhat.consulting.chmay.thorntailcdi.rest.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapFactory {

	public static Map<String, String> getMap(Collection elements) {
		Map<String, String> map = new HashMap<>();
		
		Iterator iter = elements.iterator();
		
		while (iter.hasNext()) {
			LookupType element = (LookupType) iter.next();
			
			map.put(element.getName(), element.getValue());
		}
		
		return map;
	}
}
