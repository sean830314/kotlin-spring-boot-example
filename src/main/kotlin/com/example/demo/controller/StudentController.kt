package com.example.demo.controller

import com.example.demo.model.Student
import com.example.demo.repository.StudentRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController(val studentRepository: StudentRepository)
{
    @GetMapping("/save")
    fun addStudent(): String{
        studentRepository.save(Student(1, "Jack", "Smith", 19,"Tourism","Finance","Management" ))
        studentRepository.save(Student(2, "Adam", "Johnson", 20,"Tourism","International Business","Management" ))
        studentRepository.save(Student(3, "Kim", "Smith", 21,"Tourism","Accounting","Management" ))
        studentRepository.save(Student(4, "David", "Williams", 22,"Computer Science","Commercial Design","Electrical and Computer Engineering" ))
        studentRepository.save(Student(5, "Peter", "Davis", 23,"Computer Science","Electrical Engineering","Electrical and Computer Engineering" ))
        return "Done"
    }

    @GetMapping("/major")
    fun fetchDataByMajor(@RequestParam("major") major: String): String{
        var result = ""

        for(student in studentRepository.findByMajor(major)){
            result += student.toString() + "</br>"
        }

        return result
    }

    @GetMapping("/minor")
    fun fetchDataByMinor(@RequestParam("minor") minor: String): String{
        var result = ""

        for(student in studentRepository.findByMinor(minor)){
            result += student.toString() + "</br>"
        }

        return result
    }

    @GetMapping("/college")
    fun fetchDataByCollege(@RequestParam("college") college: String): String{
        var result = ""

        for(student in studentRepository.findByCollege(college)){
            result += student.toString() + "</br>"
        }

        return result
    }

    @PostMapping
    fun saveStudent(@RequestBody student: Student): Student
    {
        return studentRepository.save(student)
    }

    @GetMapping("/{id}")
    fun getStudent(@PathVariable id: Long): String
    {
        return studentRepository.findById(id).toString()
    }

    @GetMapping
    fun getAllStudents(): String
    {
        var result = ""

        for(student in studentRepository.findAll()){
            result += student.toString() + "</br>"
        }

        return result
    }

    @PutMapping
    fun updateStudent(@RequestBody student: Student)
    {
        studentRepository.save(student)
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long)
    {
        studentRepository.deleteById(id)
    }
}