package springboot.demo_springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springboot.demo_springboot.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

}
