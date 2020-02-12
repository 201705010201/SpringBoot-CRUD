package com.cc.dao;

import com.cc.pojo.Department;
import com.cc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工Dao
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    //员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "教研部")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "开发部")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "后勤部")));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "市场部")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "运营部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加员工
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        //给员工设置部门
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }


    //得到所有员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id得到员工信息
    public Employee get(Integer id){
        return employees.get(id);
    }

    //根据id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

}
