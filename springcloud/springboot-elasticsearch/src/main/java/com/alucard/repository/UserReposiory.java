package com.alucard.repository;

import com.alucard.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserReposiory extends CrudRepository<UserEntity, String> {

}