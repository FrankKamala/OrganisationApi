package models.dao;

import models.Department;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO department (name, description, noOfEmployees) VALUES (:name, :description, :noOfEmployees)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM department")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM department WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void update(int id, String name, String description, int nOfEmployees) {
        String sql = "UPDATE department SET (name, description, noOfEmployees) = (:name, :description, :noOfEmployees) WHERE id=:id"; //CHECK!!!
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .addParameter("noOfEmployees", nOfEmployees)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from department WHERE id = :id";
        String deleteJoin = "DELETE from departments_users WHERE departmentId = :departmentId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("departmentId", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    @Override
    public void clearAll() {
        String sql = "DELETE FROM department";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addDepartmentToUser(Department department, Users users) {
        String sql = "INSERT INTO departments_users (departmentId, usersId) VALUES (:departmentId, :usersId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", department.getId())
                    .addParameter("usersId", users.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Users> getAllUsersInDepartment(int departmentId) {
        List<Users> users = new ArrayList<>();

        String joinQuery = "SELECT usersId FROM departments_users WHERE departmentId = :departmentId";

        try (Connection con = sql2o.open()) {
            List<Integer> allUsersIds = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);
            for (Integer usersId : allUsersIds){
                String usersQuery = "SELECT * FROM users WHERE id = :usersId";
                users.add(
                        con.createQuery(usersQuery)
                                .addParameter("usersId", usersId)
                                .executeAndFetchFirst(Users.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return users;
    }
}
