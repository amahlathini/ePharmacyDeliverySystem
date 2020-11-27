package com.digital.epharmacy.controller.Order;


import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.service.Order.Impl.OrderReceiptServiceImpl;
import com.digital.epharmacy.service.Order.OrderReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/receipts")
public class OrderReceiptController {

    @Autowired
    private OrderReceiptServiceImpl orderReceiptService;

    @PostMapping("/create")
    public OrderReceipt create(@RequestBody OrderReceipt order_receipt) {
        OrderReceipt createdOrderReceipt = OrderReceiptFactory.createOrderReceipt(order_receipt.getOrder());

        return orderReceiptService.create(createdOrderReceipt);
    }

    @GetMapping("/read/{order_number}")
    public OrderReceipt read(@PathVariable Long receipt_number){
        return orderReceiptService.read(receipt_number);
    }

    @PostMapping("/update")
    public OrderReceipt update(@RequestBody OrderReceipt order_receipt){
        return orderReceiptService.update(order_receipt);
    }

    @GetMapping("/")
    public Set<OrderReceipt> getAll(){
        return orderReceiptService.getAll();
    }

    @DeleteMapping("/delete/{receipt_number}")
    public boolean delete(@PathVariable Long receipt_number){
        return orderReceiptService.delete(receipt_number);
    }
}

