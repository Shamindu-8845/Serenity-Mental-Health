package com.serenity.dao.custom;

import com.serenity.dao.CrudDAO;
import com.serenity.entity.TherapyPrograms;

import java.io.IOException;
import java.util.List;

public interface TherapyProgramsDAO extends CrudDAO<TherapyPrograms> {

    List getAllPrograms() throws IOException;
}
