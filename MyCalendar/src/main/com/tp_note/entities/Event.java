package com.tp_note.entities;

import com.tp_note.entities.primitives.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    public Id id;
    public final EventTitle title;
    public final User owner;
    public final LocalDateTime dateDebut;
    public final EventDuration dureeMinutes;
    protected final int displayWidth = 132;

    protected Event(Id id, EventTitle title, User owner, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    protected Event(EventTitle title, User owner, LocalDateTime dateDebut, EventDuration dureeMinutes) {
        this.id = Id.nextValue();
        this.title = title;
        this.owner = owner;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();

    protected String formatLine(String text, int width) {
        StringBuilder result = new StringBuilder();
        int contentWidth = width - 4;
        while (text.length() > contentWidth) {
            result.append("│ ").append(text, 0, contentWidth).append(" │\n");
            text = text.substring(contentWidth);
        }
        result.append("│ ").append(text).append(" ".repeat(contentWidth - text.length())).append(" │");
        return result.toString();
    }

    protected String formatTitle(String title, int width) {
        int contentWidth = width - 4;
        int titleLength = title.length();
        int totalEquals = contentWidth - titleLength - 2;
        int leftEquals = totalEquals / 2;
        int rightEquals = totalEquals - leftEquals;

        return "=".repeat(leftEquals) + " " + title + " " + "=".repeat(rightEquals);
    }

    protected String generateDescription(List<String> content, String title) {
        String border = "┌" + "─".repeat(displayWidth - 2) + "┐\n";
        String footer = "└" + "─".repeat(displayWidth - 2) + "┘\n";

        List<String> formattedContent = new ArrayList<>();
        formattedContent.add(formatTitle(title, displayWidth));
        formattedContent.addAll(content);

        StringBuilder description = new StringBuilder(border);
        for (String line : formattedContent) {
            description.append(formatLine(line, displayWidth)).append("\n");
        }
        description.append(footer);

        return description.toString();
    }

    public boolean isInPeriod(LocalDateTime debut, LocalDateTime fin) {
        return dateDebut.isAfter(debut) && dateDebut.isBefore(fin);
    }

    public void setId(int id) {
        this.id = new Id(id);
    }

    public boolean hasAccess(User user) {
        return owner.equals(user);
    }

    public boolean isConflict(Event event) {
        return dateDebut.isBefore(event.dateDebut.plusMinutes(event.dureeMinutes.duration())) && dateDebut.plusMinutes(dureeMinutes.duration()).isAfter(event.dateDebut);
    }
}