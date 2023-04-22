package com.example.library.Controller;

import com.example.library.Entity.Student;
import com.example.library.RequestDto.StudentRequestDto;
import com.example.library.ResponseDto.StudentResponseDto;
import com.example.library.ResponseDto.UpdateEmailRequestDto;
import com.example.library.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/get_student_by_id")
    public StudentResponseDto getStudent(@RequestParam("id") Integer id) {
        return studentService.getStudentById(id);

    }
    @PutMapping("/updateEmail")
    public StudentResponseDto updateStudentEmail(@RequestBody UpdateEmailRequestDto updateEmailRequestDto){

        return studentService.updateStudentEmail(updateEmailRequestDto);

    }
}
