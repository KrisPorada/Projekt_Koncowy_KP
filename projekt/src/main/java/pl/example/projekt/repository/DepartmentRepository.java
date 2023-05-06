package pl.example.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.example.projekt.web.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
