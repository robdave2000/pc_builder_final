package com.davis.pcbuilderserver.services;

import com.davis.pcbuilderserver.dtos.PcDto;
import com.davis.pcbuilderserver.dtos.UserDto;

import java.util.List;

public interface UserServices {
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);

    String addPcToUser(Long userId, Long pcId);

    List<PcDto> getPcsByUser(Long userId);
}
