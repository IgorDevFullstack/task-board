package com.example.board.controller;
import com.example.board.model.Board;
import com.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/boards")
@CrossOrigin(origins = "*")
public class BoardController {
    private final BoardService service;
    public BoardController(BoardService service) { this.service = service; }
    @GetMapping public List<Board> all() { return service.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<Board> one(@PathVariable Long id) {
        Board b = service.findById(id);
        return b != null ? ResponseEntity.ok(b) : ResponseEntity.notFound().build();
    }
    @PostMapping public Board create(@RequestBody Board b) { return service.save(b); }
    @PutMapping("/{id}")
    public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody Board b) {
        Board existing = service.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        existing.setName(b.getName());
        return ResponseEntity.ok(service.save(existing));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
