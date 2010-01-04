package com.soluvas.samples.eventfx.si;

import java.util.EventListener;

public interface AsyncListener<E> extends EventListener {

	void notify(E event);
}
