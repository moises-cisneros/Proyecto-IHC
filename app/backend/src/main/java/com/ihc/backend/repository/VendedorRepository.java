package com.ihc.backend.repository;

import com.ihc.backend.entity.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, UUID> {

}
