package com.redhat.consulting.chmay.thorntailcdi.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.redhat.consulting.chmay.thorntailcdi.rest.generic.LookupType;
import com.redhat.consulting.chmay.thorntailcdi.rest.generic.LookupTypeImpl;
import com.redhat.consulting.chmay.thorntailcdi.rest.generic.MapFactory;
import com.redhat.consulting.chmay.thorntailcdi.rest.generic.NonLookupType;

public class HelloWorldService implements GreeterService {

	@Override
	public String sayHello() {
		Collection coll = new ArrayList();
		
		LookupTypeImpl x = new LookupTypeImpl();
		LookupType y = new LookupTypeImpl();
		NonLookupType z = new NonLookupType();
		
		
		x.setName("LookupImplName");
		x.setValue("LookupImplValue");
		
		y.setName("LookupName");
		y.setValue("LookupValue");

		z.setName("NonLookupName");
		z.setValue("NonLookupValue");

		coll.add(x);
		coll.add(y);
		coll.add(z);
		
		return printMapInTheWorstWay(MapFactory.getMap(coll));
	}
	
	private String printMapInTheWorstWay(Map<String, String> map) {
		String printer = "";
		
		for(String key : map.keySet()) {
			printer += key + " " + map.get(key) + " ";
		}
		
		return printer;
	}
}
