package dev.hendratommy.training.inventory.application.port.output;

import java.util.List;

public interface EventViewOutputPort {
    List<String> fetchEvents();
}
