package models.dao;

import models.Department;
import models.Users;

import java.util.List;

public interface DepartmentDao {
    void add(Department department);
    void addDepartmentToUser(Department department, Users users);

    List<Department> getAll();
    List<Users> getAllUsersInDepartment(int departmentId);

    Department findById(int id);

    void update(int id, String name, String description, int nOfEmployees);

    void deleteById(int id);
    void clearAll();
}
