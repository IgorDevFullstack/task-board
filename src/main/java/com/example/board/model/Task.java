package com.example.board.model;
import jakarta.persistence.*;
@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    public Task() {}
    public Task(String title, String description, String status) {
        this.title = title; this.description = description; this.status = status;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Board getBoard() { return board; }
    public void setBoard(Board board) { this.board = board; }
}
