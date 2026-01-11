package controllers;
import dtos.TasksRequestsDTO;
import dtos.TasksResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.TaskService;

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

}
