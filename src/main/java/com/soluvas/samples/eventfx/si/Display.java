package com.soluvas.samples.eventfx.si;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Display implements SyncListener<SensorEvent, String>, AsyncListener<SensorEvent> {
	
	private static Log log = LogFactory.getLog(Display.class);
	private String name;
	
	@PostConstruct
	public void initialize() {
		log.info("Display " + getName() + " created.");
	}

	@Override
	public String update(SensorEvent event) {
		log.info("[" + name + "] is updated: '" + event.getText() + "'");
		return getName() + " received " + event.getText();
	}

	@Override
	public void notify(SensorEvent event) {
		log.info("[" + name + "] is notified: '" + event.getText() + "'");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
