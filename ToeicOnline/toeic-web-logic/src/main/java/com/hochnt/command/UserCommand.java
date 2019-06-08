package com.hochnt.command;

import com.hnthoc.core.dto.UserDTO;
import com.hnthoc.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand(){
        this.pojo = new UserDTO();
    }
}
