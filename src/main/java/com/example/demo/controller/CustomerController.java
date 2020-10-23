package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }


    @GetMapping("")
    public String home(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "home";
    }
    @GetMapping("/data")
    public ResponseEntity<Iterable<Customer>> customerResponseEntity(){
//        List list = (List)customerService.findAll();
//        System.out.println("------------------------------" + list.size());
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Iterable<Customer>> createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable Long id){
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<Customer>> search(@PathVariable String name){

        return new ResponseEntity<>(customerService.findAllByNameContaining(name),HttpStatus.OK);
    }
//    @GetMapping("/searchId/{id}")
//    public ResponseEntity<Customer> searchId(@PathVariable Long id){
//        Optional<Customer> customer = customerService.findById(id);
//        System.out.println(customer);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
