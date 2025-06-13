package de.ait.tasks.dto;

import de.ait.tasks.model.Priority;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class TaskRequestDto {
    private String description;
    private Priority priority;
}
