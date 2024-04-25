package com.geojit.slabbasedbilling.system.repository;

import com.geojit.slabbasedbilling.system.model.AuthenticationToken;
import com.geojit.slabbasedbilling.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken,Long> {
AuthenticationToken findByUser(User user);
}
