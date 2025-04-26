package com.serenity.bo.custom;

import com.serenity.bo.SuperBO;
import com.serenity.dto.UsersDTO;

import java.io.IOException;

public interface ChangeCredentialsBO extends SuperBO {
    boolean saveCredentials(UsersDTO usersDTO) throws IOException;
}
