package com.harsha.springdomainevents.domain.student.aggregate;

class AcademicInfoVO {
    private Double overallGrade;
    private Double totalCredits;

    AcademicInfoVO(Double overallGrade, Double totalCredits) {
        this.overallGrade = overallGrade;
        this.totalCredits = totalCredits;
    }

    Double getOverallGrade() {
        return overallGrade;
    }

    Double getTotalCredits() {
        return totalCredits;
    }

}
