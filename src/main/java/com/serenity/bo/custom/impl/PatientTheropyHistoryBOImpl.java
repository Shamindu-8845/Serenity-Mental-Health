package com.serenity.bo.custom.impl;

import com.serenity.bo.custom.PatientTheropyHistoryBO;
import com.serenity.dao.DAOFactory;
import com.serenity.dao.custom.TherapySessionsDAO;
import com.serenity.dto.TherapySessionsDTO;
import com.serenity.entity.TherapySessions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientTheropyHistoryBOImpl implements PatientTheropyHistoryBO {
    TherapySessionsDAO therapySessionsDAO = (TherapySessionsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.THERAPY_SESSION);
    @Override
    public List<TherapySessionsDTO> getAll() throws IOException {

        List<TherapySessions> all = therapySessionsDAO.getAll();

        List<TherapySessionsDTO> therapySessionsDTOS = new ArrayList<>();

        for (TherapySessions therapySessions:all) {
            therapySessionsDTOS.add(new TherapySessionsDTO(therapySessions.getId(),therapySessions.getTherapyPrograms().getId(),therapySessions.getPatients().getId(),therapySessions.getTherapyPrograms().getId(),therapySessions.getCost(),therapySessions.getDescription()));
        }
        return therapySessionsDTOS;
    }
}
