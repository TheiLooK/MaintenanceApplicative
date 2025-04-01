package com.tp_note.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tp_note.DataGenerator;
import com.tp_note.entities.Event;
import com.tp_note.entities.event_types.MeetingEvent;
import com.tp_note.entities.event_types.PeriodicEvent;
import com.tp_note.entities.event_types.PersonalEvent;
import com.tp_note.entities.event_types.TaskEvent;
import com.tp_note.entities.lists.EventList;
import com.tp_note.entities.lists.event.TaskEventList;
import com.tp_note.entities.primitives.Id;
import com.tp_note.entities.primitives.User;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.register.UserAlreadyExistsException;
import com.tp_note.exceptions.events.DeleteEventException;
import com.tp_note.exceptions.events.EventConflictException;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
public class CalendarManager {
    private final EventList events;
    private static CalendarManager instance = null;
    private static final String FILE_PATH = "src/ressources/events.json";
    private final ObjectMapper mapper;

    public CalendarManager() {
        this.events = EventList.empty();
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.registerSubtypes(
                new NamedType(MeetingEvent.class, "MeetingEvent"),
                new NamedType(PeriodicEvent.class, "PeriodicEvent"),
                new NamedType(PersonalEvent.class, "PersonalEvent"),
                new NamedType(TaskEvent.class, "TaskEvent")
        );
        loadEventsFromFile();
    }

    public static CalendarManager getInstance() {
        if (instance == null) {
            instance = new CalendarManager();
        }
        return instance;
    }

    private void loadEventsFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            try {
                // Créer un objectMapper spécifique pour la lecture
                ObjectMapper tempMapper = new ObjectMapper();
                tempMapper.registerModule(new JavaTimeModule());
                tempMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
                tempMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

                // Lire d'abord comme une structure de données générique
                List<Object> rawEvents = tempMapper.readValue(file, tempMapper.getTypeFactory().constructCollectionType(List.class, Object.class));

                for (Object rawEvent : rawEvents) {
                    try {
                        Map<String, Object> eventMap = (Map<String, Object>) rawEvent;
                        String eventType = determineEventType(eventMap);

                        // Ajouter le type à l'objet map
                        eventMap.put("type", eventType);

                        // Convertir en JSON avec type
                        String eventJson = tempMapper.writeValueAsString(eventMap);

                        // Utiliser le mapper standard avec la configuration de sous-types pour désérialiser
                        Event event = mapper.readValue(eventJson, Event.class);
                        events.addEvent(event);
                    } catch (Exception e) {
                        System.out.println("Erreur lors du traitement d'un événement: " + e.getMessage());
                        e.printStackTrace();
                    }
                }

                System.out.println(events.getEvents().size() + " événements chargés avec succès");

            } catch (Exception e) {
                System.out.println("Erreur lors du chargement des événements: " + e.getMessage());
            }
        } else {
            System.out.println("Le fichier des événements est vide ou n'existe pas.");
        }
    }

    private String determineEventType(Map<String, Object> eventMap) {
        if (eventMap.containsKey("participants") && eventMap.containsKey("eventPlace")) {
            return "MeetingEvent";
        } else if (eventMap.containsKey("frequency")) {
            return "PeriodicEvent";
        } else if (eventMap.containsKey("task")) {
            return "TaskEvent";
        } else if (eventMap.containsKey("celebratedPerson") && eventMap.containsKey("birthdayYear")) {
            return "BirthdayEvent";
        } else if (eventMap.containsKey("doctor")) {
            return "MedicalAppointmentEvent";
        } else if (eventMap.containsKey("speakers") && eventMap.containsKey("place")) {
            return "ConferenceEvent";
        } else {
            return "PersonalEvent";
        }
    }

    private void saveEventsToFile() {
        try {
            mapper.writeValue(new File(FILE_PATH), events.getEvents());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EventList eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return new EventList(
                getEventList().getEvents().stream()
                        .filter(e -> e.isInPeriod(debut, fin))
                        .toList()
        );
    }

    public void addEvent(Event e) throws EventConflictException {
        if (events.isConflict(e)) {
            throw new EventConflictException();
        }
        events.addEvent(e);
        saveEventsToFile();
    }

    public void removeEvent(Id id) throws DeleteEventException {
        events.removeEvent(id);
        saveEventsToFile();
    }

    private EventList getEventList(User user) {
        return new EventList(
                events.getEvents().stream()
                        .filter(e -> e.hasAccess(user))
                        .toList()
        );
    }

    public EventList getEventList() {
        return getEventList(AuthService.getInstance().getLoggedUser());
    }

    public TaskEventList getTasks() {
        return new TaskEventList(
                getEventList().getEvents().stream()
                        .filter(TaskEvent.class::isInstance)
                        .map(e -> (TaskEvent) e)
                        .toList()
        );
    }
}