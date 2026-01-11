package services;
import dtos.TasksRequestsDTO;
import dtos.TasksResponseDTO;
import interfaces.TasksRepository;
import org.springframework.stereotype.Service;
import tasks.Task;
import enums.TasksStats;
import java.time.LocalDateTime;

@Service //Marca a classe como Servico/Negocio da aplicacao.
public class TaskService {

    private final TasksRepository repository;
    public TaskService(TasksRepository repository) {
        this.repository = repository;
    }

    public TasksResponseDTO create(TasksRequestsDTO dto){
        Task task = new Task();

        task.setTittle(dto.tittle());
        task.setDescription(dto.description());
        task.setPriority(dto.priority());
        task.setStats(TasksStats.PENDING); // Define o estatus na tabela como pendente
        task.setCreatedAt(LocalDateTime.now()); // Essa linha salva a hora da criacao
        task.setDueDate(dto.dueDate()); // Essa linha salva o dia da criacao

        Task saved = repository.save(task);

        //Retorna um DTO de resposta com os dados da tarefa recem criada incluido o ID gerado pelo banco automaticamente
        return new TasksResponseDTO(
                saved.getId(),
                saved.getTittle(),
                saved.getStats(),
                saved.getPriority(),
                saved.getDueDate()
        );

    }
}

/*
Eássa classe e responsavel de criar uma nova tarefa task e salvar no DB, transformando os dados de entrada
(TaskRquestDTO) em uma resposta (TaskResponseDTO)
 */
