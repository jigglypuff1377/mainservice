package kz.mainservice.Repository;

import jakarta.transaction.Transactional;
import kz.mainservice.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository <Task, Long>{
    List<Task> findAll();
    List<Task> findAllByStatus(String status);
}
