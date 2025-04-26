package com.serenity.bo.custom.impl;

import com.serenity.bo.custom.ChangeCredentialsBO;
import com.serenity.dao.DAOFactory;
import com.serenity.dao.custom.UserDAO;
import com.serenity.dto.UsersDTO;
import com.serenity.entity.Users;

import java.io.IOException;

public class ChangeCredentialsBOImpl implements ChangeCredentialsBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveCredentials(UsersDTO usersDTO) throws IOException {
        return userDAO.save(new Users(usersDTO.getName(),usersDTO.getPassword(),usersDTO.getJobRole()));
    }
}
