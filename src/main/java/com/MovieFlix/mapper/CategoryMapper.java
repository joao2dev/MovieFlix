package com.MovieFlix.mapper;

import com.MovieFlix.entity.Category;
import com.MovieFlix.request.CategoryRequest;
import com.MovieFlix.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }
    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }
}
