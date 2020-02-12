package com.cc.dao;

import com.cc.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *部门dao层
 */

@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;


    static{
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "教研部"));
        departments.put(102, new Department(102, "开发部"));
        departments.put(103, new Department(103, "后勤部"));
        departments.put(104, new Department(104, "市场部"));
        departments.put(105, new Department(105, "运营部"));
    }

    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id得到部门信息
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
