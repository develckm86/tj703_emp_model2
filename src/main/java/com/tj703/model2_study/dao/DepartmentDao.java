package com.tj703.model2_study.dao;

import com.tj703.model2_study.dto.DepartmentDto;

public interface DepartmentDao extends CRUD<DepartmentDto, String> {
    DepartmentDto findByDeptNoAndDeptName(DepartmentDto dept) throws Exception;
}
