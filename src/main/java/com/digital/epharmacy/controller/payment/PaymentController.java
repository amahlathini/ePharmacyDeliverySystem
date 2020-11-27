package com.digital.epharmacy.controller.payment;
//Matthew Pearce - Payment Controller

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import com.digital.epharmacy.service.Order.Impl.OrderServiceImpl;
import com.digital.epharmacy.service.Order.OrderService;
import com.digital.epharmacy.service.Payment.PaymentService;
import com.digital.epharmacy.service.Payment.impl.PaymentServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/create/{order_number}")
    public Payment create(@PathVariable Long order_number) {
//        ResponseEntity<Payment>  errorMap = (ResponseEntity<Payment>) validationService.MapValidationService(result);
//
//        if(errorMap != null){
//
//            return errorMap;
//        }

        Order order = orderService.read(order_number);

        Payment newPayment = PaymentFactory
                .makePayment(
                        order
                );
        return paymentService.create(newPayment);

    }

    @GetMapping("/read/{payment_ref}")
    public Payment read (@PathVariable Long payment_ref){

        return paymentService.read(payment_ref);
    }

    @PostMapping("/update")
    public Payment update(@Valid @RequestBody Payment payment){
        return paymentService.update(payment);
    }

    @GetMapping("/")
    public Set<Payment>getAll(){
        return paymentService.getAll();
    }

    @DeleteMapping("/delete/{payment_ref}")
    public boolean delete(@PathVariable Long payment_ref){
        return paymentService.delete(payment_ref);
    }
}
