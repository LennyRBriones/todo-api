package org.lennyrbriones.todo_api.task


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val repo: TaskRepository
) {

    @GetMapping
    fun getAll(): List<Task> = repo.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody req: CreateTaskRequest): Task {
        val task = Task(
            id = UUID.randomUUID(),
            title = req.title.trim()
        )
        return repo.save(task)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Task {
        return repo.findById(id)
            .orElseThrow { RuntimeException("Task not found") }
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @RequestBody req: CreateTaskRequest
    ): Task {
        val existing = repo.findById(id)
            .orElseThrow { RuntimeException("Task not found") }

        val updated = existing.copy(
            title = req.title
        )

        return repo.save(updated)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) {
        repo.deleteById(id)
    }
}


data class CreateTaskRequest(
    val title: String
)