package crud.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import crud.crud.Entity.Product;
import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategoryId(Long postId);
	
	@Transactional
	void deleteByCategoryId(Long categoryId);
}

