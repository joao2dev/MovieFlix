package com.MovieFlix.service;

import com.MovieFlix.entity.Streaming;
import com.MovieFlix.repository.StreamingRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Builder
@AllArgsConstructor
@Service
public class StreamingService {
    private StreamingRepository repository;

//    listar
    public List<Streaming> listarStreamings(){
        return repository.findAll();
    }
//    salvar
    public Streaming salvarStreaming(Streaming streaming){
        return repository.save(streaming);
    }
//    buscarId
    public Streaming buscarStreamingPorId(Long id){
        Optional<Streaming> streaming = repository.findById(id);
        return streaming.orElse(null);

    }
//    deletar
    public void deletarStreamingPorId(Long id){
        repository.deleteById(id);
    }
}
