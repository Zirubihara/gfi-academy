package com.gfieast.akademia.repository;

import java.util.List;

import com.gfieast.akademia.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByUserId(Long id);
}
