package com.MovieFlix.Controller;

import com.MovieFlix.entity.Streaming;
import com.MovieFlix.mapper.StreamingMapper;
import com.MovieFlix.request.StreamingRequest;
import com.MovieFlix.response.StreamingResponse;
import com.MovieFlix.service.StreamingService;
import lombok.AllArgsConstructor;
import org.apache.el.stream.Stream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {
    private StreamingService service;

    @GetMapping("/listar")
    public ResponseEntity<List<StreamingResponse>> listarStreamings(){
        List<Streaming> streamings = service.listarStreamings();
        return ResponseEntity.ok(streamings.stream()
                .map(StreamingMapper::toResponse)
                .toList());
    }
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarStreaming(@RequestBody StreamingRequest request){
        Streaming streaming = StreamingMapper.toStreaming(request);
        StreamingResponse salvo = StreamingMapper.toResponse(service.salvarStreaming(streaming));
        return ResponseEntity.status(HttpStatus.CREATED).body("streaming salvo!");
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Streaming streaming = service.buscarStreamingPorId(id);
        if (streaming != null){
            return ResponseEntity.ok(StreamingMapper.toResponse(streaming));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nao encontrado");
    }
    @DeleteMapping("/deletar/{id}")
    public void DeletarStreamingPorId(@PathVariable Long id){
        service.deletarStreamingPorId(id);
    }
}
