package org.lennyrbriones.todo_api.task

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    val id: UUID,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val completed: Boolean = false
)