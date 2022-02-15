package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T16:20:14-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoria.getIdCategoria() != null ) {
            category.setCategoryId( categoria.getIdCategoria() );
        }
        category.setCategory( categoria.getDescripcion() );
        category.setActive( categoria.getEstado() );

        return category;
    }

    @Override
    public Categoria toCagoria(Category categoria) {
        if ( categoria == null ) {
            return null;
        }

        Categoria categoria1 = new Categoria();

        categoria1.setIdCategoria( categoria.getCategoryId() );
        categoria1.setDescripcion( categoria.getCategory() );
        categoria1.setEstado( categoria.getActive() );

        return categoria1;
    }
}
