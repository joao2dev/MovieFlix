package com.MovieFlix.service;

import com.MovieFlix.entity.Category;
import com.MovieFlix.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class CategoryService {
     final CategoryRepository categoryRepository;

     public List<Category> listarTodasCategorys(){
         return categoryRepository.findAll();
     }
    public Category salvarCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category buscarCategoryId(Long id){
         Optional<Category> category = categoryRepository.findById(id);
         return category
                 .orElseThrow(() -> new RuntimeException("categoria nao encontrada"));
    }
    public void deletarCategory(Long id){
         categoryRepository.deleteById(id);
    }
}
