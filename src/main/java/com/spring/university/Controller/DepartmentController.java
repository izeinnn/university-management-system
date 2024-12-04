package com.spring.university.Controller;


import com.spring.university.Response;
import com.spring.university.model.Department;
import com.spring.university.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Response> createDepartment(
            @RequestBody Department department){
        return ResponseEntity.ok( departmentService.createDepartment(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    // Update department details
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentDetails));
    }

    // Delete a department
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }

    // Get all departments
    @GetMapping
    public ResponseEntity<Response> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
}
