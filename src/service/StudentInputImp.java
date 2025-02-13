package service;


import dto.StudentDto;
import repository.StudentManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentInputImp implements StudentInput {
    //studentNumber,name,korean,english,math,science,total,average,grade

    StudentIO studentIO;
    private static int studentNumberCounter = 250001;

    public StudentInputImp(StudentIO studentIO) {
        this.studentIO = studentIO;
    }

    public void inputStudent(StudentDto studentDto) {
        if (isDuplicateStudent(studentDto)) {
            throw new RuntimeException();
        }
        StudentDto completeStudent = createPerfectDto(studentDto);
        updateStudentTable(completeStudent);
    }

    //중복정보 검사 (학생이름 + 국어 + 영어 + 수학 + 과학)
    public boolean isDuplicateStudent (StudentDto studentDto) {
        Map<String, StudentDto> studentDtoMap = StudentManager.getInstance().getStudentTable();
        for (StudentDto check : studentDtoMap.values()) {
            if (check.getName().equals(studentDto.getName()) &&
                check.getKorean() == studentDto.getKorean() &&
                check.getEnglish() == studentDto.getEnglish() &&
                check.getMath() == studentDto.getMath() &&
                check.getScience() == studentDto.getScience()) {
                return true;
            }
        }
        return false;
    }

    //Total 계산 (korean + english + math + science)
    public int calcTotal(StudentDto studentDto) {
        return studentDto.getKorean() + studentDto.getEnglish() + studentDto.getMath() + studentDto.getScience();
    }

    //Grade 계산
    public String calcGrade(double average) {
        switch ((int) (average / 10)) {
            case 10:
            case 9: return "A";
            case 8: return "B";
            case 7: return "C";
            case 6: return "D";
            default: return "F";
        }
    }

    //입력 받을때마다 studentNumberCounter(학번)에 1 더하고 String 으로 변환
    public String generateStudentNumber() {
        return String.valueOf(studentNumberCounter++);
    }

    // map(학번,DTO) put
    private void updateStudentTable(StudentDto studentDto) {
        StudentManager.getInstance().getStudentTable().put(studentDto.getStudentNumber(), studentDto);
    }

    //Builder
    public StudentDto createPerfectDto(StudentDto studentDto){
        int total = calcTotal(studentDto);
        double average = total / 4.0;
        String grade = calcGrade(average);

        return StudentDto.builder()
                .studentNumber(generateStudentNumber())
                .name(studentDto.getName())
                .korean(studentDto.getKorean())
                .english(studentDto.getEnglish())
                .math(studentDto.getMath())
                .science(studentDto.getScience())
                .total(total)
                .average(average)
                .grade(grade)
                .build();
    }
}
