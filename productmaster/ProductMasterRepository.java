package com.sensei.savedesk.repository.productmaster;
import com.sensei.savedesk.domain.productmaster.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Long> {
}
