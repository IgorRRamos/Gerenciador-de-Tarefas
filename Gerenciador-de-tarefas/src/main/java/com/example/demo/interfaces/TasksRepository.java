package com.example.demo.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.tasks.Task;


//Essa classe representa uma camada de acesso a dados, padrãao do JPA eu consigo USAR CRUD sem escrever SQL
public interface TasksRepository extends JpaRepository<Task, Long> {
}
