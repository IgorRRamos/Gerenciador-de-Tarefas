package com.example.demo.dtos;
import com.example.demo.enums.Priority;
import com.example.demo.enums.TasksStats;
import java.time.LocalDate;

public record TasksResponseDTO(Long id, String tittle, TasksStats stats, Priority priority, LocalDate dueDate) {
}

/*
Essa classe e uma classe do tipo RECORD ela e compacta, sempre sera uma classe do tipo FINAL e adiciona
automaticamente os GET e SET
Define oque a API vai retornar e evita expor dados
 */