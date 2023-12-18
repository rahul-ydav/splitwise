package com.example.splitwise.exceptions;

public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException(Long GroupId){
        super("Group Not found with given groupId : "+ GroupId);
    }
}
