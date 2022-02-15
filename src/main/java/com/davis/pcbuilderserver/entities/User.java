package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "pc_id"})},
            name = "UsersPcs",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "pc_id")}
    )
    @EqualsAndHashCode.Exclude
    private Set<Pc> pcSet = new HashSet<>();

    public User(UserDto userDto)
    {
        this.id = userDto.getId();
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.pcSet = userDto.getPcSet();
    }

    public void addPcToUser(Pc pc)
    {
        pcSet.add(pc);
        pc.getUserSet().add(this);
    }
}
