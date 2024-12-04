package com.spring.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectionDto {

    private String semester;
    private Long year;
    private Long classRoomId;
    private Long courseId;
    private Long timSlotId;

}
