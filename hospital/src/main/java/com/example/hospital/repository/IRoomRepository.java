package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Room;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
}
