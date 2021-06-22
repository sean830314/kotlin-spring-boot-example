package com.example.demo.repository
import com.example.demo.model.Student
import org.springframework.data.repository.CrudRepository

interface StudentRepository: CrudRepository<Student, Long>{
    fun findByMajor(major: String): List<Student>
    fun findByMinor(minor: String): List<Student>
    fun findByCollege(college: String): List<Student>
}