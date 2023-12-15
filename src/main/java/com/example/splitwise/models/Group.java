package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expense_groups")
public class Group extends BaseModel{
    private String groupName;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> members;
    @ManyToMany
    private List<User> admins;
}
