package com.agusrichard.amenity_reservation_system.repos;

import com.agusrichard.amenity_reservation_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
