package com.example.board.service;
import com.example.board.model.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BoardService {
    private final BoardRepository repo;
    public BoardService(BoardRepository repo) { this.repo = repo; }
    public List<Board> findAll() { return repo.findAll(); }
    public Board findById(Long id) { return repo.findById(id).orElse(null); }
    public Board save(Board b) { return repo.save(b); }
    public void delete(Long id) { repo.deleteById(id); }
}
