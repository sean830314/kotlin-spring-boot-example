package com.example.demo.controller

import com.example.demo.model.Customer
import com.example.demo.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class WebController {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @RequestMapping("/save")
    fun process(): String{
        customerRepository.save(Customer(1, "Jack", "Smith"))
        customerRepository.save(Customer(2, "Adam", "Johnson"))
        customerRepository.save(Customer(3, "Kim", "Smith"))
        customerRepository.save(Customer(4, "David", "Williams"))
        customerRepository.save(Customer(5, "Peter", "Davis"))
        return "Done"
    }


    @RequestMapping("/findall")
    fun findAll(): String{
        var result = ""

        for(cust in customerRepository.findAll()){
            result += cust.toString() + "</br>"
        }

        return result
    }

    @RequestMapping("/findbyid")
    fun findById(@RequestParam("id") id: Long): String{
        return customerRepository.findById(id).toString()
    }

    @RequestMapping("/findbylastname")
    fun fetchDataByLastName(@RequestParam("lastname") lastName: String): String{
        var result = ""

        for(cust in customerRepository.findByLastName(lastName)){
            result += cust.toString() + "</br>"
        }

        return result
    }
}