package com.geojit.slabbasedbilling.system.repository;

import com.geojit.slabbasedbilling.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String userName);
}
