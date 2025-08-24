package com.example.board.controller;
import com.example.board.model.Task;
import com.example.board.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) { this.service = service; }
    @GetMapping public List<Task> all() { return service.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<Task> one(@PathVariable Long id) {
        Task t = service.findById(id);
        return t != null ? ResponseEntity.ok(t) : ResponseEntity.notFound().build();
    }
    @PostMapping public Task create(@RequestBody Task t) { return service.save(t); }
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task t) {
        Task existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setTitle(t.getTitle());
        existing.setDescription(t.getDescription());
        existing.setStatus(t.getStatus());
        return ResponseEntity.ok(service.save(existing));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
