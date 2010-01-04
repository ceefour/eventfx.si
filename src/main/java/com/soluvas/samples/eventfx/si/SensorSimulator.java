package com.soluvas.samples.eventfx.si;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensorSimulator {
	
	private static Log log = LogFactory.getLog(SensorSimulator.class);
	
	@Autowired
	private Sensor sensor;
	private ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

	@PostConstruct
	public void initialize() {
		scheduledExecutor.scheduleAtFixedRate(new Runnable() {
			
			public void run() {
				sensor.updateText("Something happens at " + SimpleDateFormat.getTimeInstance().format(new Date()));
			}
		}, 2000, 2000, TimeUnit.MILLISECONDS);
		log.info("Sensor simulator initialized.");
	}
	
	@PreDestroy
	public void destroy() throws InterruptedException {
		log.info("Destroying Sensor simulator...");
		scheduledExecutor.shutdown();
		scheduledExecutor.awaitTermination(2000, TimeUnit.MILLISECONDS);
	}
}
