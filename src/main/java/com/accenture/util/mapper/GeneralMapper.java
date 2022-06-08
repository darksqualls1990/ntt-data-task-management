package com.accenture.util.mapper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("generalMapper")
public class GeneralMapper {

	
	@Autowired
	private Mapper mapper;
	
	/**
	 * Turn one object into another on the first level
	 * 
	 * @param object
	 * @return new istance class
	 */
	@SuppressWarnings("unchecked")
	public <T, E> T mapConverter(E object, Class classResult) {
		T objectResult = null; 
		if(object != null) {
			objectResult = (T) mapper.map(object, classResult);
		}
		return objectResult;
	}
	
	/**
	 * Turn one object into another using mapId related to xml 
	 * definition
	 * 
	 * @param <E> object to convert
	 * @param classResult class of object associated to new instance
	 * @param mapId id in configuration for mapping
	 * 
	 * @return <T> new istance class
	 */
	@SuppressWarnings("unchecked")
	public <T, E> T mapConverter(E object, Class classResult, String mapId) {
		T objectResult = null; 
		if(object != null) {
			if(mapId != null && !mapId.isEmpty()) {
				objectResult = (T) mapper.map(object, classResult, mapId);
			}else {
				objectResult = (T) mapper.map(object, classResult);
			}
		}
		return objectResult;
	}
	
	/**
	 * Turn one object into another using mapId related to xml 
	 * definition
	 * 
	 * @param List<E> of object to convert
	 * @param classResult class of object associated to new instance
	 * 
	 * @return new istance classDTO
	 */
    @SuppressWarnings("unchecked")
	public <T, E> List<T> mapListConverter(List<E> object, Class classResult) {		
		List<T> listResult = null; 
        if(object != null) {
            listResult = (List<T>) object.stream()
					.map(item -> mapConverter(item, classResult))
					.collect(Collectors.toList());	
		}
		return listResult;
	}
    
    /**
	 * Turn one object into another using mapId related to xml 
	 * definition
	 * 
	 * @param Iterable<E> of object to convert
	 * @param classResult class of object associated to new instance
	 * 
	 * @return new istance classDTO
	 */
    public <T, E> List<T> mapIterableConverter(Iterable<E> object, Class classResult) {		
    	List<T> listResult = null; 
        if(object != null) {
			
        	Iterator<E> iterator = object.iterator();
        	listResult = new LinkedList<T>();
        	
			while(iterator.hasNext()) {
			    listResult.add(mapConverter(iterator.next(), classResult));
			}	
		}
		return listResult;
	}
    
    /**
  	 * Turn one object into another using mapId related to xml 
  	 * definition
  	 * 
  	 * @param Iterable<E> of object to convert
  	 * @param classResult class of object associated to new instance
  	 * 
  	 * @return new istance classDTO
  	 */
      public <T, E> List<T> mapIterableConverter(Iterable<E> object, Class classResult, String mapId) {		
      	List<T> listResult = null; 
          if(object != null) {
  			
          	Iterator<E> iterator = object.iterator();
          	listResult = new LinkedList<T>();
          	
  			while(iterator.hasNext()) {
  			    listResult.add(mapConverter(iterator.next(), classResult, mapId));
  			}	
  		}
  		return listResult;
  	}
	
	/**
	 * Turn one object into another on the first level
	 * 
	 * @param List of object
	 * @param classResult class of object associated to new instance
	 * @param mapId id in configuration for mapping
	 * 
	 * @return new istance classDTO
	 */
	@SuppressWarnings("unchecked")
	public <T, E> List<T> mapListConverter(List<E> object, Class classResult, String mapId) {
		
		List<T> listResult = null; 
		if(object != null) {
			listResult = (List<T>) object.stream()
					.map(item -> mapConverter(item, classResult, mapId))
					.collect(Collectors.toList());	
		}
		return listResult;
	}
}
