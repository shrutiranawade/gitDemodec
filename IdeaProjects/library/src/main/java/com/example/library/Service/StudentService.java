package com.example.library.Service;

import com.example.library.Entity.Card;
import com.example.library.Entity.Student;
import com.example.library.Enum.CardStatus;
import com.example.library.Repository.StudentRepository;
import com.example.library.RequestDto.StudentRequestDto;
import com.example.library.ResponseDto.CardResponseDto;
import com.example.library.ResponseDto.StudentResponseDto;
import com.example.library.ResponseDto.UpdateEmailRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setEmail(studentRequestDto.getEmail());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-01-05");
        student.setCard(card);

        student.setCard(card);
        studentRepository.save(student);

        return "Student Added Successfully";
    }

    public StudentResponseDto getStudentById(Integer id){
StudentResponseDto studentResponseDto = new StudentResponseDto();
Student student = studentRepository.findById(id).get();

studentResponseDto.setName(student.getName());
studentResponseDto.setAge(student.getAge());
studentResponseDto.setEmail(student.getEmail());
studentResponseDto.setDepartment(student.getDepartment());
studentResponseDto.setMobNo(student.getMobNo());
studentResponseDto.setId(student.getId());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setCardId(student.getCard().getCardId());
        cardResponseDto.setStatus(student.getCard().getStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdationDate(student.getCard().getUpdationDate());
        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;
    }
public StudentResponseDto updateStudentEmail(UpdateEmailRequestDto updateEmailRequestDto){
        Student student = studentRepository.findById(updateEmailRequestDto.getId()).get();
        student.setEmail(updateEmailRequestDto.getEmail());

        Student updatedStudent = studentRepository.save(student);
        //prepare student response
    StudentResponseDto studentResponseDto = new StudentResponseDto();
    studentResponseDto.setName(updatedStudent.getName());
    studentResponseDto.setEmail(updatedStudent.getEmail());
    studentResponseDto.setId(updatedStudent.getId());

    return studentResponseDto;
}
}
