package com.harsha.springdomainevents.domain.student.aggregate;

class StudentRootEntity {
    private Long id;
    private BasicInfoVO basicInfoVO;
    private AcademicInfoVO academicInfoVO;

    StudentRootEntity(Long id, BasicInfoVO basicInfoVO, AcademicInfoVO academicInfoVO) {
        this.id = id;
        this.basicInfoVO = basicInfoVO;
        this.academicInfoVO = academicInfoVO;
    }

    BasicInfoVO getBasicInfoVO() {
        return basicInfoVO;
    }

    AcademicInfoVO getAcademicInfoVO() {
        return academicInfoVO;
    }

    Long getId() {
        return id;
    }
}
