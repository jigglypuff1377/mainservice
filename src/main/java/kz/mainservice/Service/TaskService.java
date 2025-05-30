package kz.mainservice.Service;

import kz.mainservice.DTO.TaskDTO;
import kz.mainservice.DTO.TaskUpdateDTO;
import kz.mainservice.Entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task addTask(TaskDTO task);
    Task updateTask(TaskUpdateDTO task);
    Task getTask(Long id);
    void deleteTask(Long id);
    List<Task> getAllTasks();

}
