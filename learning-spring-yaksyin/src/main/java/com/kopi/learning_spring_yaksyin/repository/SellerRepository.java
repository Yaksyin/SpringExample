package com.kopi.learning_spring_yaksyin.repository;

import com.kopi.learning_spring_yaksyin.entity.SellerEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntitiy, String> {
}

