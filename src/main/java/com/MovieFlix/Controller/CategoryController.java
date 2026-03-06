package com.MovieFlix.Controller;

import com.MovieFlix.entity.Category;
import com.MovieFlix.mapper.CategoryMapper;
import com.MovieFlix.request.CategoryRequest;
import com.MovieFlix.response.CategoryResponse;
import com.MovieFlix.response.StreamingResponse;
import com.MovieFlix.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    final CategoryService categoryService;


    @GetMapping("/listar")
    public ResponseEntity<List<CategoryResponse>> listarCategorys(){
        List<Category> categorys = categoryService.listarTodasCategorys();

        return ResponseEntity.ok(categorys.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());
    }
    @PostMapping("/salvar")
    public ResponseEntity<CategoryResponse> salvarCategory(@RequestBody CategoryRequest request){
        Category category = CategoryMapper.toCategory(request);
        Category CategorySaved = categoryService.salvarCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(CategorySaved));
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarCategoryId(@PathVariable Long id){
       Category category = categoryService.buscarCategoryId(id);
       if (category != null){
           CategoryResponse encontrada = CategoryMapper.toCategoryResponse(category);
           return ResponseEntity.ok(encontrada);
       }return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nao enonctrada");
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarCategory(@PathVariable Long id){
         categoryService.deletarCategory(id);
         return ResponseEntity.ok("categoria deletada com sucesso");
    }
}
