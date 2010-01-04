package com.soluvas.samples.eventfx.si;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Sensor {

	private static Log log = LogFactory.getLog(Sensor.class);

	private SyncListener<SensorEvent, String> sensorSyncListener;
	private AsyncListener<SensorEvent> sensorAsyncListener;

	private void fireSensor(SensorEvent event) {
		if (sensorSyncListener != null) {
			String result = sensorSyncListener.update(event);
			log.info("Response: " + result);
		}
		if (sensorAsyncListener != null) {
			sensorAsyncListener.notify(event);
		}
	}

	public void updateText(String text) {
		log.info("updateText: " + text);
		fireSensor(new SensorEvent(text));
	}

	public SyncListener<SensorEvent, String> getSensorSyncListener() {
		return sensorSyncListener;
	}

	public void setSensorSyncListener(SyncListener<SensorEvent, String> sensorSyncListener) {
		this.sensorSyncListener = sensorSyncListener;
	}

	public AsyncListener<SensorEvent> getSensorAsyncListener() {
		return sensorAsyncListener;
	}

	public void setSensorAsyncListener(
			AsyncListener<SensorEvent> sensorAsyncListener) {
		this.sensorAsyncListener = sensorAsyncListener;
	}

}
