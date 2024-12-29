package crud.crud.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import crud.crud.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Page findByNameContaining(String categoryName, Pageable pageable);


}

