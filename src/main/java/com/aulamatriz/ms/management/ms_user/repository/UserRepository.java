package com.aulamatriz.ms.management.ms_user.repository;

import com.aulamatriz.ms.management.ms_user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
