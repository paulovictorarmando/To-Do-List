package dev.To_Do_List.repositories;

import dev.To_Do_List.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository {
    List<Task> findByUserId(Long userId);
}
