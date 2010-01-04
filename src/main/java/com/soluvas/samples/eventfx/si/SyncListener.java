package com.soluvas.samples.eventfx.si;

import java.util.EventListener;

public interface SyncListener<E, R> extends EventListener {

	R update(E event);
}
