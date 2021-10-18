package com.daddycodess.demo;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrolmentId implements Serializable {

    private Long studentId;
    private Long courseId;

    public EnrolmentId(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public EnrolmentId() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  true;
        if(obj == null || getClass() != obj.getClass()) return false;
        EnrolmentId that = (EnrolmentId) obj;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode(){
        return  Objects.hash(studentId, courseId);
    }
}
