package com.laoliu.crud.dao;

import com.laoliu.crud.bean.Employee;
import com.laoliu.crud.bean.EmployeeExample;
import com.laoliu.crud.bean.EmployeeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int deleteByPrimaryKey(EmployeeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    Employee selectByPrimaryKey(EmployeeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_emp
     *
     * @mbggenerated Tue Mar 16 18:44:53 CST 2021
     */
    int updateByPrimaryKey(Employee record);
}