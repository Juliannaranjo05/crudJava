package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Rooms;

public interface RoomsRepository extends JpaRepository
<Rooms, Integer>
{

}
