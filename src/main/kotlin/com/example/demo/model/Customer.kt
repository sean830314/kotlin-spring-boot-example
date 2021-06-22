package com.example.demo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customer")
public class Customer(
    @Id
    val id: Long = -1,

    @Column(name = "firstname")
    val firstName: String = "",

    @Column(name = "lastname")
    val lastName: String = ""


){
    override fun toString(): String{
        return "Customer[id=${id}, firstName=${firstName}, lastName=${lastName}]"
    }
}