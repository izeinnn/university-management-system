package com.spring.university.service;

import com.spring.university.model.ClassRoom;
import com.spring.university.repository.ClassRoomRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassRoomService {

    private final ClassRoomRepo classRoomRepo;

    // Method to add a new classroom
    public ClassRoom addClassRoom(ClassRoom classRoom) {
        return classRoomRepo.save(classRoom);
    }

    // Method to get a classroom by ID
    public ClassRoom getClassRoomById(Long id) {
        return classRoomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
    }

    // Method to update a classroom
    public ClassRoom updateClassRoom(Long id, ClassRoom classRoomDetails) {
        ClassRoom classRoom = getClassRoomById(id);
        classRoom.setBuilding(classRoomDetails.getBuilding());
        classRoom.setRoomNumber(classRoomDetails.getRoomNumber());
        classRoom.setCapacity(classRoomDetails.getCapacity());
        return classRoomRepo.save(classRoom);
    }

    // Method to delete a classroom
    public void deleteClassRoom(Long id) {
        classRoomRepo.deleteById(id);
    }

}
