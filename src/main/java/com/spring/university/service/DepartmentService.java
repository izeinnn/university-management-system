package com.spring.university.service;

import com.spring.university.Response;
import com.spring.university.model.Department;
import com.spring.university.repository.DepartmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    public Response createDepartment(Department department) {

        if (department.getId() != null) {
            if (departmentRepo.existsById(department.getId())) {
                throw new RuntimeException("Department already exists");
            }
        }
            departmentRepo.save(department);

            return Response.builder()
                    .success(true)
                    .message("Department created successfully")
                    .data(department)
                    .build();
        }

    public Response getDepartmentById(Long id) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return Response.builder()
                .success(true)
                .message("Department retrieved successfully")
                .data(department)
                .build();
    }

    public Response updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        department.setName(departmentDetails.getName());
        department.setBuilding(departmentDetails.getBuilding());
        department.setBudget(departmentDetails.getBudget());
        departmentRepo.save(department);

        return Response.builder()
                .success(true)
                .message("Department updated successfully")
                .data(department)
                .build();
    }

    public Response deleteDepartment(Long id) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        departmentRepo.delete(department);

        return Response.builder()
                .success(true)
                .message("Department deleted successfully")
                .build();
    }

    public Response getAllDepartments() {
        return Response.builder()
                .success(true)
                .message("Departments retrieved successfully")
                .data(departmentRepo.findAll())
                .build();
    }
}