package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Pc;
import com.davis.pcbuilderserver.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;

    private String username;

    private String password;

    private Set<Pc> pcSet = new HashSet<>();

    public UserDto(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.pcSet = user.getPcSet();
    }
}
