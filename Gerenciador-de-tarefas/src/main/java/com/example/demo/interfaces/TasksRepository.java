package interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import tasks.Task;

//Essa classe representa uma camada de acesso a dados, padrãao do JPA eu consigo USAR CRUD sem escrever SQL
public interface TasksRepository extends JpaRepository<Task, Long> {
}
