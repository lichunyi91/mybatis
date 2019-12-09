package com.atguigu.dao;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    public Employee getEmpById(Integer id);

    public Employee getEmpByIdAndEmpName(@Param("id") Integer id, @Param("empName") String empName);

    public Employee getEmployeeByIdAndEmpName(Map<String, Object> map);

    public int insertEmployee(Employee employee);

    public int insertEmployee2(Employee employee);

    public int updateEmployee(Employee employee);

    public boolean deleteEmployee(Integer id);

    public Map<String, Object> getEmpByIdReturnMap(Integer id);

    public List<Employee> getAllEmps();

    @MapKey("id")
    public Map<Integer, Employee> getAllEmpsReturnMap();

}
