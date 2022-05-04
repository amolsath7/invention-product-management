package com.amdocs.ensemble.repository;

import com.amdocs.ensemble.entity.InventionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventionProductRepository extends JpaRepository<InventionProduct, String> {
}
