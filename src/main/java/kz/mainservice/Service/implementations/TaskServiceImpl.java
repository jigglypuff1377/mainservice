package kz.mainservice.Service.implementations;

import kz.mainservice.DTO.TaskDTO;
import kz.mainservice.DTO.TaskUpdateDTO;
import kz.mainservice.Entity.Task;
import kz.mainservice.Mappers.TaskMapper;
import kz.mainservice.Repository.TaskRepository;
import kz.mainservice.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public Task addTask(TaskDTO task) {
        if(Objects.isNull(task) || task.getDescription() == null || task.getStatus() == null
                || task.getTitle() == null){
            return null;
        }
        Task taskEntity = taskMapper.DTOtoEntity(task);
        taskEntity.setCreatedAt(LocalDateTime.now());
        taskEntity.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(taskEntity);
    }

    @Override
    public Task updateTask(TaskUpdateDTO task) {
        if(Objects.isNull(task) || task.getDescription() == null || task.getStatus() == null
                || task.getTitle() == null){
            return null;
        }
        Task taskEntity = taskRepository.findById(task.getId()).orElseThrow();
        taskEntity.setUpdatedAt(LocalDateTime.now());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setTitle(task.getTitle());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setId(task.getId());
        return taskRepository.save(taskEntity);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
