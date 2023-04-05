package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Represents a log of alarm system events.
public class EventLog implements Iterable<Event> {
    private static EventLog theLog;
    private Collection<Event> events;

// EFFECT: Gets instance of EventLog - creates it if it doesn't already exist and returns instance of EventLog
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }

        return theLog;
    }

// EFFECT: Adds event to event log
    public void logEvent(Event e) {
        events.add(e);
    }

// EFFECT: Clears event log
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
