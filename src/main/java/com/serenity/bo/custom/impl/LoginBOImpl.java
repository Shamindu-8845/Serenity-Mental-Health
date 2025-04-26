package com.serenity.bo.custom.impl;

import com.serenity.bo.custom.LoginBO;
import com.serenity.dao.DAOFactory;
import com.serenity.dao.custom.UserDAO;
import com.serenity.dto.UsersDTO;
import com.serenity.entity.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginBOImpl implements LoginBO {

    UserDAO Userdao = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public List<UsersDTO> checkUser(UsersDTO usersDTO) throws IOException {
        List<Users> users = Userdao.checkUser(new Users(usersDTO.getName(), usersDTO.getPassword(), usersDTO.getJobRole()));
        List<UsersDTO> usersDTOS = new ArrayList<>();

        for (Users users1:users){
            usersDTOS.add(new UsersDTO(users1.getName(),users1.getPassword(),users1.getJobRole()));
        }
        return usersDTOS;
    }
}
