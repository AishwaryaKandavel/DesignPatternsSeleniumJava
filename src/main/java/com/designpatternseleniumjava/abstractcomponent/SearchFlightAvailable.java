package com.designpatternseleniumjava.abstractcomponent;

import java.util.HashMap;
import java.util.List;

public interface SearchFlightAvailable {
	public void checkAvailability(List<HashMap<String, String>> origDest);
}
