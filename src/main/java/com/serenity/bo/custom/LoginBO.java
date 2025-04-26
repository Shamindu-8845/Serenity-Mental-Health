package com.serenity.bo.custom;

import com.serenity.bo.SuperBO;
import com.serenity.dto.UsersDTO;

import java.io.IOException;
import java.util.List;

public interface LoginBO extends SuperBO {
    List<UsersDTO> checkUser(UsersDTO usersDTO) throws IOException;
}
