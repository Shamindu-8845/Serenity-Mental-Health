package com.serenity.bo.custom.impl;

import com.serenity.bo.custom.TherapyProgramManagementBO;
import com.serenity.dao.DAOFactory;
import com.serenity.dao.custom.TherapyProgramsDAO;
import com.serenity.dto.TherapyProgramsDTO;
import com.serenity.entity.TherapyPrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TherapyProgramManagementBOImpl implements TherapyProgramManagementBO {

    TherapyProgramsDAO therapyProgram = (TherapyProgramsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.THERAPIST_PROGRAM);
    @Override
    public boolean saveTherapy(TherapyProgramsDTO therapyProgramsDTO) throws IOException {
        return therapyProgram.save(new TherapyPrograms(therapyProgramsDTO.getName(),therapyProgramsDTO.getDuration(),therapyProgramsDTO.getCost(),therapyProgramsDTO.getDescription()));
    }

    @Override
    public boolean deleteTherapyProgram(String id) throws IOException {
        return therapyProgram.delete(id);
    }

    @Override
    public boolean updateTherapyProgram(TherapyProgramsDTO therapyProgramsDTO) throws IOException {
        return therapyProgram.update(new TherapyPrograms(therapyProgramsDTO.getId(),therapyProgramsDTO.getName(),therapyProgramsDTO.getDuration(),therapyProgramsDTO.getCost(),therapyProgramsDTO.getDescription()));
    }

    @Override
    public List<TherapyProgramsDTO> getTherapyPrograms() throws IOException {
        List<TherapyPrograms> all = therapyProgram.getAll();
        List<TherapyProgramsDTO> therapyProgramsDTOS=new ArrayList<>();
        for (TherapyPrograms therapyPrograms:all){
            therapyProgramsDTOS.add(new TherapyProgramsDTO(therapyPrograms.getName(),therapyPrograms.getDuration(),therapyPrograms.getCost(),therapyPrograms.getDescription()));
        }

        return therapyProgramsDTOS;
    }

    @Override
    public String getLastId() throws IOException {
        int lastId = therapyProgram.getLastId();
        return String.format("TP%03d",lastId);
    }
}
