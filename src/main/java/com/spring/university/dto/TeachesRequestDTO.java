
package com.spring.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachesRequestDTO {
    private Integer year;
    private Long courseId;
    private Long instructorId;
    private Long sectionId;


}