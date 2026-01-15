package com.example.demo.model.tasks;
import com.example.demo.enums.Priority;
import com.example.demo.enums.TasksStats;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity //Para o HIBERNATE mapear essa classe como uma tabela no DB
@Table (name = "tasks") // Define o nome da tabela no DB, se default o HIBERNATE criaria com nome aleatorio.

public class Task {

    @Id // Define como chave primaria no DB, cada valor sera unico na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define que cada valor sera gerado automaticamente e o valor sera conhecido apenas apos o INSERT no DB
    private long id; // Preferencia ao usar o LONG porque o banco de dados normalmente trabalha com numeros longos

    private String tittle;
    private String description;

    @Enumerated(EnumType.STRING) //Para salvar o ENUM no banco de dadoãs como STRING, sera como no ENUM mesmo se PENDENTE OU FEITO
    private TasksStats stats;

    @Enumerated(EnumType.STRING)
    private Priority priority; //Para salvar o ENUM no banco de dados como STRING, sera como no ENUM mesmo se FACIL, MEDIO OU DIFICIL


    public Task() {}

    private LocalDate dueDate;
    private LocalDateTime createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TasksStats getStats() {
        return stats;
    }

    public void setStats(TasksStats stats) {
        this.stats = stats;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
