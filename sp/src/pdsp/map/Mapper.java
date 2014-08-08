package pdsp.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pdsp.Service;

public class Mapper  {
	
	private Service service;
	private Map<String, Set<String> > mappings;
	
	public Mapper(Service s) {
		service = s;
		loadMappings();
	}
	
	public boolean loadMappings() {
		mappings = new HashMap<String, Set<String> >();
		//TODO actually load them from somewhere
		return true;
	}
	
	public boolean addMapping(String name, String altName) {
		Set<String> maps = getMappingsFor(name);
		maps.add(altName);
		mappings.put(name, maps);
		Set<String> altMaps = getMappingsFor(altName);
		altMaps.add(name);
		mappings.put(altName, altMaps);
		return true;
	}
	
	public Set<String> getMappingsFor(String name) {
		if (mappings.containsKey(name)) {
			return mappings.get(name);
		} 
		return new HashSet<String>();
	}
	

}
