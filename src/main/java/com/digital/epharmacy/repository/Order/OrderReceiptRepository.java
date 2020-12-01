package com.digital.epharmacy.repository.Order;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RepositoryRestResource(collectionResourceRel = "receipts", path = "receipts")
public interface OrderReceiptRepository extends JpaRepository<OrderReceipt, Long> {

}
