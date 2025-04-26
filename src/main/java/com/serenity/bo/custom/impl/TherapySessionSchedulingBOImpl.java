package com.serenity.bo.custom.impl;

import com.serenity.bo.custom.TherapySessionSchedulingBO;
import com.serenity.dao.DAOFactory;
import com.serenity.dao.custom.PatientsDAO;
import com.serenity.dao.custom.TherapistDAO;
import com.serenity.dao.custom.TherapyProgramsDAO;
import com.serenity.dao.custom.TherapySessionsDAO;
import com.serenity.dto.TherapySessionsDTO;
import com.serenity.entity.Patients;
import com.serenity.entity.Therapists;
import com.serenity.entity.TherapyPrograms;
import com.serenity.entity.TherapySessions;

import java.io.IOException;
import java.util.List;

public class TherapySessionSchedulingBOImpl implements TherapySessionSchedulingBO {
    TherapySessionsDAO therapySessionsDAO = (TherapySessionsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.THERAPY_SESSION);
    PatientsDAO patientsDAO = (PatientsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PATIENTS);
    TherapyProgramsDAO therapyProgramsDAO = (TherapyProgramsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.THERAPIST_PROGRAM);
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.THERAPIST);
    @Override
    public boolean saveTherapySession(TherapySessionsDTO therapySessionsDTO) throws IOException {

        Patients patients = patientsDAO.getbyId(therapySessionsDTO.getPatient());
        TherapyPrograms therapyPrograms = therapyProgramsDAO.getbyId(therapySessionsDTO.getProgram());
        Therapists therapists = therapistDAO.getbyId(therapySessionsDTO.getTherapy());
        return therapySessionsDAO.save(new TherapySessions(therapySessionsDTO.getCost(), therapySessionsDTO.getDescription(), patients, therapists, therapyPrograms));
    }

    @Override
    public boolean updateTherapySession(TherapySessionsDTO therapySessionsDTO) throws IOException {
        Patients patients = patientsDAO.getbyId(therapySessionsDTO.getPatient());
        TherapyPrograms therapyPrograms = therapyProgramsDAO.getbyId(therapySessionsDTO.getProgram());
        Therapists therapists = therapistDAO.getbyId(therapySessionsDTO.getTherapy());
        return therapySessionsDAO.update(new TherapySessions(therapySessionsDTO.getCost(), therapySessionsDTO.getDescription(), patients, therapists, therapyPrograms));
    }

    @Override
    public String getLastId() throws IOException {
        int lastId = therapySessionsDAO.getLastId();
        return String.format("TS%03d",lastId);
    }

    @Override
    public List getAllPatientId() throws IOException {
        return patientsDAO.getAllId();
    }

    @Override
    public List getAllTherapyId() throws IOException {
        return therapyProgramsDAO.getAllId();
    }

    @Override
    public List getAllProgramId() throws IOException {
        return therapistDAO.getAllId();
    }
}
