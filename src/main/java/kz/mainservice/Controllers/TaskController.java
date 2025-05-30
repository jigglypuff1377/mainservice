package kz.mainservice.Controllers;

import kz.mainservice.DTO.TaskDTO;
import kz.mainservice.DTO.TaskUpdateDTO;
import kz.mainservice.Entity.Task;
import kz.mainservice.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping(value = "/get")
    public ResponseEntity<Task> getTask(@RequestParam Long taskId){
        if(taskService.getTask(taskId) == null){
            throw new IllegalArgumentException("No task found");
        }
        return new ResponseEntity<Task>(taskService.getTask(taskId), HttpStatus.OK);
    }
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Task>> getAllTask(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addTask(@RequestBody TaskDTO taskDTO){
        try {
            taskService.addTask(taskDTO);
            return new ResponseEntity<>("task added", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/delete")
    public ResponseEntity<?> deleteTask(@RequestParam Long id){
        try {
            taskService.deleteTask(id);
            return new ResponseEntity<>("task deleted", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateTask(@RequestBody TaskUpdateDTO taskDTO){
        try {
            taskService.updateTask(taskDTO);
            return new ResponseEntity<>("task updated", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
