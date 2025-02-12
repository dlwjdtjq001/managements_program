package service;


import dto.StudentDto;

import java.util.Map;
import java.util.Scanner;

public class StudentInputImp implements StudentInput {
    StudentIO studentIO;
    private static int studentNumberCounter = 250001;

    //studentNumber,name,korean,english,math,science,total,average,grade
    public StudentInputImp(StudentIO studentIO) {
        this.studentIO = studentIO;
    }

    public int calcTotal(StudentDto studentDto) {
        return studentDto.getKorean() + studentDto.getEnglish() + studentDto.getMath() + studentDto.getScience();
    }
    public double calcAverage(StudentDto studentDto) {
        return studentDto.getTotal() / 4.0;
    }
    public String generateStudentNumber() {
        return String.valueOf(studentNumberCounter++);
    }

    public void inputStudent(StudentDto studentDto) {
        String newStudentNumber = generateStudentNumber();
        StudentDto completeStudent = createPerfectDto(newStudentNumber, studentDto);
        studentIO.updateStudentTable(completeStudent);
    }

    public StudentDto createPerfectDto(String studentNumber, StudentDto studentDto){
        return StudentDto.builder()
                .studentNumber(studentNumber)
                .name(studentDto.getName())
                .korean(studentDto.getKorean())
                .english(studentDto.getEnglish())
                .math(studentDto.getMath())
                .science(studentDto.getScience())
                .total(calcTotal(studentDto))
                .average(calcAverage(studentDto))
                .grade(calcGrade(calcAverage(studentDto)))
                .build();
    }
    public String calcGrade(double average) {
        switch ((int) average / 10) {
            case 10:
            case 9: return "A";
            case 8: return "B";
            case 7: return "C";
            case 6: return "D";
            default: return "F";
        }
    }
}
