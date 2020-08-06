package com.harsha.springdomainevents.domain.classOfCourse;

class ClassLocationVO {
    private String hallNumber;
    private String buildingNumber;

    ClassLocationVO(String hallNumber, String buildingNumber) {
        this.hallNumber = hallNumber;
        this.buildingNumber = buildingNumber;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }
}
