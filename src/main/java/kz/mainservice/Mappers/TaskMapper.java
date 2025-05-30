package kz.mainservice.Mappers;

import kz.mainservice.DTO.TaskDTO;
import kz.mainservice.Entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task DTOtoEntity(TaskDTO taskDTO);
    TaskDTO entityToDTO(Task task);
}
