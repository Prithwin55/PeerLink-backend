package com.peerlink_backend.peerlink_backend.data.validations.user;

public interface UserValidation {
    public  boolean checkEmailAlreadyExist(String email);
    public boolean checkUserExistById(long id);
    public boolean checkAlreadyFollows(long id1,long id2);
}
