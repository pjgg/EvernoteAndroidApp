package com.example.pjgg.evernoteapp.session;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ActivityEnum {
	MAIN_ACTIVITY("MainActivity"),
	LOGIN_ACTIVITY("LoginActivity"),
	CREATE_NOTE_ACTIVITY("CreateNoteActivity"),
	SHOW_NOTE_ACTIVITY("ShowNoteActivity"),
	UNKNOWN("unknown");
	
	private String type;
	private static final Map<String,ActivityEnum> lookUp = new HashMap<String,ActivityEnum>();
	
	static {
		for(ActivityEnum activityEnum : EnumSet.allOf(ActivityEnum.class))
			lookUp.put(activityEnum.getCode(), activityEnum);
	}
	
	private ActivityEnum(String type){
		this.type = type;
	}


	public String getCode(){
		if(null != type) return type;
		else return  "unknown";
	}

	public ActivityEnum getType(final String code){
		if (lookUp.containsKey(code))
			return lookUp.get(code);
		return UNKNOWN;
	}
}

