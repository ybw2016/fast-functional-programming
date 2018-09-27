package com.fast.programming.service.example.field;

import com.fast.programming.service.FeatureBase;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author bowen.yan
 * @date 2018-08-08
 */
public class GetAndSetFieldValue extends FeatureBase {
    @Override
    protected String getComment() {
        return "函数式编程使代码简洁 ->  3 * N行  ->  1 * N行";
    }

    @Override
    protected void runOld() {
        printStudent();
    }

    @Override
    protected void runNew() {
        printStudentNew();
    }

    public void printStudent() {
        Student student = new Student();
        StudentNew studentNew = getLatestStudent();

        // 将studentNew的字段绑定到student中
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(studentNew.getUserName())) {
            student.setUserName(studentNew.getUserName());
        }
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(studentNew.getMobile())) {
            student.setMobile(studentNew.getMobile());
        }
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(studentNew.getAddress())) {
            student.setAddress(studentNew.getAddress());
        }

        System.out.println("student -> " + student);
    }

    public void printStudentNew() {
        Student student = new Student();
        StudentNew studentNew = getLatestStudent();

        // 将studentNew的字段绑定到student中
        checkAndBindStudent(student, studentNew, stuNew -> stuNew.getUserName(), stu -> stu.setUserName(studentNew.getUserName()));
        checkAndBindStudent(student, studentNew, stuNew -> stuNew.getMobile(), stu -> stu.setMobile(studentNew.getMobile()));
        checkAndBindStudent(student, studentNew, stuNew -> stuNew.getAddress(), stu -> stu.setAddress(studentNew.getAddress()));

        // 100个赋值  100 * 3 = 300行
        // 100行
        System.out.println("student -> " + student);
    }

    private StudentNew getLatestStudent() {
        // read from 3rd system
        return new StudentNew("张三", "13811119999", "北京市海淀区启迪科技大厦D座27层");
    }

    // 如果Getter, Binder有多个参数的时候，就应该自定义函数式接口
    private void checkAndBindStudent(Student student, StudentNew studentNew, Function<StudentNew, String> getter, Consumer<Student> binder) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(getter.apply(studentNew))) {
            binder.accept(student);
        }
    }
}
