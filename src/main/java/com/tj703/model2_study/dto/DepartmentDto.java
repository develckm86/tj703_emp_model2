package com.tj703.model2_study.dto;

public class DepartmentDto {
    private String deptNo;
    private String deptName;

    @Override
    public String toString() {
        return "{" +
                "deptNo:'" + deptNo + '\'' +
                ", deptName:'" + deptName + '\'' +
                "}\n";
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
