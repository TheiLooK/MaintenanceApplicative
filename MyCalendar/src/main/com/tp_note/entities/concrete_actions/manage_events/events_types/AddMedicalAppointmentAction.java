package com.tp_note.entities.concrete_actions.manage_events.events_types;

import com.tp_note.entities.Event;
import com.tp_note.entities.concrete_actions.manage_events.AddEventAction;
import com.tp_note.entities.event_types.MedicalAppointmentEvent;
import com.tp_note.entities.primitives.Doctor;
import com.tp_note.entities.primitives.EventDuration;
import com.tp_note.entities.primitives.EventPlace;
import com.tp_note.entities.primitives.EventTitle;
import com.tp_note.services.AuthService;
import com.tp_note.services.DisplayService;

public class AddMedicalAppointmentAction extends AddEventAction {
    private static AddMedicalAppointmentAction instance;

    private AddMedicalAppointmentAction() {
        super("Ajouter un rendez-vous médical");
    }

    public static AddMedicalAppointmentAction getInstance() {
        if (instance == null) {
            instance = new AddMedicalAppointmentAction();
        }
        return instance;
    }

    @Override
    public void perform() {
        event = createEvent();
        super.perform();
    }

    @Override
    protected Event createEvent() {
        DisplayService displayService = DisplayService.getInstance();
        EventDetails details = getCommonEventDetails();

        displayService.printTexte("Ajout d'un rendez-vous médical");

        String doctorName = displayService.printInputString("Entrez le nom du docteur : ");
        String speciality = displayService.printInputString("Entrez la spécialité du docteur : ");
        String place = displayService.printInputString("Entrez le lieu du rendez-vous : ");

        return new MedicalAppointmentEvent(
                new Doctor(doctorName, speciality),
                new EventPlace(place),
                new EventTitle(details.title()),
                AuthService.getInstance().getLoggedUser(),
                details.date(),
                new EventDuration(details.duration())
        );
    }
}