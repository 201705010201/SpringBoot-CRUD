package com.cc.controller;

import com.cc.dao.DepartmentDao;
import com.cc.dao.EmployeeDao;
import com.cc.pojo.Department;
import com.cc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工，返回列表页面
    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //将结果放在请求中
        model.addAttribute("emps", employees);
        return "emp/list";
    }


    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有部门的信息
       Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
       return "emp/add";
    }

    //员工添加功能
    //接收前端传递的参数，自动封装成为对象[要求前端传递的参数名，和属性名一致]
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        //保存员工信息
        employeeDao.save(employee);
        //回到员工列表页面，可以使用redirect或forward
        return "redirect:/emps";
    }

    //to员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        //根据id查出来员工
        Employee employee = employeeDao.get(id);
        //将员工信息返回页面
        model.addAttribute("emp",employee);
        //查出所有的部门，提供修改选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        //回到员工列表
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
