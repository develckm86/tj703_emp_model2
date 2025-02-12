package com.tj703.model2_study.dto;

import java.util.Date;

public class EmployeesDto {
    private int empNo;
    private char gender;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;

    @Override
    public String toString() {
        return "{" +
                "empNo:" + empNo +
                ", gender:" + gender +
                ", firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", birthDate:" + birthDate +
                ", hireDate:" + hireDate +
                "}\n";
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
