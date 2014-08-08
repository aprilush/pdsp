package pdsp.access;

import java.util.Date;

import org.json.JSONObject;

import pdsp.Service;

public abstract class Accessor {
	
	private Service service;
	
	public Accessor(Service s) {
		service = s;
	}
	
	public abstract JSONObject getUserInfo();
	
	public abstract JSONObject getAllPeople();
	
	public abstract JSONObject getPerson(); //needs a param to identify the person

	public abstract JSONObject getAllActivities();
	
	public abstract JSONObject getActivity(); // also needs a param 
	
	public abstract JSONObject getIntervalData(Date start, Date end);
	
	public abstract JSONObject getInstantData(Date instant);
	
}
