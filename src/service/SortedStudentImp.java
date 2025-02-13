package service;

import dto.StudentDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortedStudentImp implements SortedStudent {
    StudentIO studentIO;



    public SortedStudentImp(StudentIO studentIO) {
        this.studentIO = studentIO;
    }

    @Override // 총점 점수 기준 정렬
    public void printSortedByTotal() {
        Map<String, StudentDto> studentTable = studentIO.getStudentTable(); // 캐싱 데이터 불러옴
        List<StudentDto> studentList = new ArrayList<>(studentTable.values()); // DTO들만  list로 담음

        studentList.sort(Comparator.comparingInt(StudentDto::getTotal).reversed());

        studentList.forEach(System.out::println);

    }

    @Override //평균 점수 기준 정렬
    public void printSortedByAverage() {
        Map<String, StudentDto> studentTable = studentIO.getStudentTable();
        List<StudentDto> studentList = new ArrayList<>(studentTable.values());

        studentList.sort(Comparator.comparingDouble(StudentDto::getAverage).reversed());

    }

    @Override // 학생 이름 기준 정렬
    public void printSortedByName() {
        Map<String, StudentDto> studentTable = studentIO.getStudentTable();
        List<StudentDto> studentList = new ArrayList<>(studentTable.values());

        studentList.sort(Comparator.comparing(StudentDto::getName));

        studentList.forEach(System.out::println);
    }

    @Override  // 학번 기준 정렬
    public void printSortedBySnoNumber() {
        Map<String, StudentDto> studentTable = studentIO.getStudentTable();
        List<StudentDto> studentList = new ArrayList<>(studentTable.values());

        studentList.sort(Comparator.comparing(StudentDto::getStudentNumber));

        studentList.forEach(System.out::println);
    }

    @Override
    public void printSortedByGrade() {
        Map<String, StudentDto> studentTable = studentIO.getStudentTable();
        List<StudentDto> studentList = new ArrayList<>(studentTable.values());
        studentList.sort(Comparator.comparing(StudentDto::getGrade).thenComparing(StudentDto::getName));

        studentList.forEach(System.out::println); //테스트 뿌리기
    }

    public Map<String, StudentDto> printVerify() throws Exception {
        Map<String, StudentDto> studentTable = studentIO.getStudentTable();
        if (studentTable == null){
            throw new Exception("학생 데이터가 존재 하지 않습니다.");
        }
        if (studentTable.isEmpty()){
            throw new Exception("");
        }
        return studentTable;
    }
}
