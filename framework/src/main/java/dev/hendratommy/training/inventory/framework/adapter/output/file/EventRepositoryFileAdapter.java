package dev.hendratommy.training.inventory.framework.adapter.output.file;

import dev.hendratommy.training.inventory.application.repository.EventRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EventRepositoryFileAdapter implements EventRepository {
    private static EventRepositoryFileAdapter instance;

    private EventRepositoryFileAdapter() {
    }

    public static EventRepositoryFileAdapter getInstance() {
        if (instance == null) {
            synchronized (EventRepositoryFileAdapter.class) {
                instance = new EventRepositoryFileAdapter();
            }
        }
        return instance;
    }

    @Override
    public List<String> findAll() {
        List<String> events = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(
                new InputStreamReader(
                        EventRepositoryFileAdapter.class.getClassLoader().
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
