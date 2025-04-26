package com.serenity.bo.custom;

import com.serenity.bo.SuperBO;
import com.serenity.dto.TherapySessionsDTO;

import java.io.IOException;
import java.util.List;

public interface TherapySessionSchedulingBO extends SuperBO {
    boolean saveTherapySession(TherapySessionsDTO therapySessionsDTO) throws IOException;

    boolean updateTherapySession(TherapySessionsDTO therapySessionsDTO) throws IOException;

    String getLastId() throws IOException;

    List getAllPatientId() throws IOException;

    List getAllTherapyId() throws IOException;

    List getAllProgramId() throws IOException;
}
