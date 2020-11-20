package com.digital.epharmacy.repository.CatalogueItem;

import com.digital.epharmacy.entity.Catalogue.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}

