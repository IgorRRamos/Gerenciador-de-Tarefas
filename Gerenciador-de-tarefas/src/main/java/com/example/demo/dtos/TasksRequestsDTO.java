package dtos;

import enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TasksRequestsDTO(@NotBlank String tittle, String description, @NotNull Priority priority, @NotNull LocalDate dueDate) {
}

/*
Essa classe e uma classe do tipo RECORD ela e compacta, sempre sera uma classe do tipo FINAL e adiciona
automaticamente os GET e SET
@NotBlank e uma validaçãao bean validation nao pode ser vazia ou com esçpacos
@NotNull ãcampo nao pode ser vazio
LocalDate esta representando a data de vencimento da tarefa.
 */