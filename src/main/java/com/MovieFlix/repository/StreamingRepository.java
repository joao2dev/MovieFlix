package com.MovieFlix.repository;

import com.MovieFlix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming , Long > {
}
