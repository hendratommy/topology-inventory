package dev.hendratommy.training.inventory.framework.adapter.output;

import dev.hendratommy.training.inventory.application.port.output.EventViewOutputPort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EventViewFileAdapter implements EventViewOutputPort {
    private static EventViewFileAdapter instance;

    private EventViewFileAdapter() {
    }

    public static EventViewFileAdapter getInstance() {
        if (instance == null) {
            synchronized (EventViewFileAdapter.class) {
                instance = new EventViewFileAdapter();
            }
        }
        return instance;
    }

    @Override
    public List<String> fetchEvents() {
        List<String> events = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(
                new InputStreamReader(
                        EventViewFileAdapter.class.getClassLoader().
                                getResourceAsStream("events.txt"))).lines()) {
            stream.forEach(line -> {
                events.add(line);
            });
            return events;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read resource", e);
        }
    }
}
