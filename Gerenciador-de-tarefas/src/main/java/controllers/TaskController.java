package controllers;
import dtos.TasksResponseDTO;
import dtos.TasksRequestsDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

//@RestController tambem garante que os metodos retornem JSON ou outro body automaticamente.
@RestController // Define a classe como controller, Dizendo ao SPRING que classe vai receber requisicoes HTTP
@RequestMapping("/tasks")
/*
Define a rota base do controller, todas as requisicoes HTTP para URLs que comecam
com /tasks serão direcionados para os metodos dentro dessa classe
Funciona como prefixo da URL
Permie combinar com o @GetMapping e @PostMapping para definir metodos HTTPs especificos
 */


public class TaskController {
    private final TaskService service; //Usando o FINAL ãgarante que o TaskService nao pode ser atribuido novamente

    public TaskController(TaskService service){
        this.service = service;
    }

    public ResponseEntity<TasksResponseDTO> create(@RequestBody @Valid TasksRequestsDTO dto){
        TasksResponseDTO response = service.create(dto); // Chama o service o serice faz a logica de negocio
        //Cria a entidade taks, define os campos, salva no banco via TaskRepository e retorna um DTO  de resposta

        return ResponseEntity.status(HttpStatus.CREATED).body(response); //Cria um objeto indicando que algo foi criado com sucesso.
    }

    /*
    O metodo CREATE  foi criado para retornar um ResponseEntity que ée um objeto SPRING que representa
    a resposta HTTP inteira:  STATUS CODE (200, 201, 404). HEADERS (Cabecalhos HTTP). BODY (Conteudo que vai
    no JSON da resposta)
    O tipo generico <TasksResponseDTO> indica que o BODY da resposta sera um objeto JSON da classe TasksResponseDTO

     @RequestBody -> diz ao SPRING pegue o corpo da resquisicao HTTP (JSON) e converta para um (OBJETO JAVA) do tipo
     TASKREQUESTDTO

     @Valid -> ativa a volidaãcao automatica referente ao @NotNull e @NotBlank no nosso TasksResponseDTO se algum campo
     estiver incorreto ele dispara uma resposta 400 sem entrar no metodo.
     */

    //Metodo para  o SPRING ler os parametros da URL constroi automaticamente  o Pageable
    @GetMapping
    public Page<TasksResponseDTO> list(Pageable pageable){
        return service.list(pageable);
    }

    @GetMapping("/tasks")
    public List<Map<String, Object>> getTasks() {
        return List.of(
                Map.of("id", 1, "name", "Tarefa de teste"),
                Map.of("id", 2, "name", "Outra tarefa")
        );
    }







}
