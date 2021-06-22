package com.example.demo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "student")
public class Student(
    @Id
    val id: Long = -1,

    @Column(name = "firstname")
    val firstName: String = "",

    @Column(name = "lastname")
    val lastName: String = "",

    @Column(name = "age")
    val age: Long =0,

    @Column(name = "major")
    val major: String = "",

    @Column(name = "minor")
    val minor: String = "",

    @Column(name = "college")
    val college: String = "",


){
    override fun toString(): String{
        return "Student[id=${id}, firstName=${firstName}, lastName=${lastName}, age=${age}, major=${major}, minor=${minor}, college=${college}]"
    }
}