package com.tp_note;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.register.UserAlreadyExistsException;
import com.tp_note.exceptions.events.EventConflictException;
import com.tp_note.services.AuthService;
import com.tp_note.services.CalendarManager;

public class MainTest {
    public static void main(String[] args) throws LogInException, JsonProcessingException, UserAlreadyExistsException, EventConflictException {

        AuthService.getInstance().logIn("admin", "admin");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        String json = mapper.writeValueAsString(CalendarManager.getInstance().getEventList());
        System.out.println(json);

        String json2 = mapper.writeValueAsString(CalendarManager.getInstance().getEventList());
        System.out.println(json2);

        String json3 = mapper.writeValueAsString(AuthService.getInstance().getAuths());
        System.out.println(json3);
    }
}
