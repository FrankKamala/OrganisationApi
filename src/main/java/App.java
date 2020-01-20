import com.google.gson.Gson;
import models.dao.Sql2oDepartmentDao;
import models.dao.Sql2oNewsDao;
import models.dao.Sql2oUsersDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import exceptions.ApiException;
import models.Department;
import models.News;
import models.Users;

import java.util.List;

import static spark.Spark.*;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;


public class App {

    public static void main(String[] args) {
        Sql2oUsersDao usersDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();


        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/OrgApi.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");


        departmentDao = new Sql2oDepartmentDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();


        post("/departments/new", "application/json",(req,res) ->{
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });
        get("/departments","application/json",(req,res)->{
            res.body("application/json");
            return gson.toJson(departmentDao.getAll());
        });
        get("/departments/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentDao.findById(departmentId));
        });

        //
        post("/departments/:departmentId/news/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            News news = gson.fromJson(req.body(), News.class);
            news.setDepartmentId(departmentId); //we need to set this separately because it comes from our route, not our JSON input.
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });

        get("/departments/:id/news", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            List<News> allNews;
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with that id: \"%s\" Here", req.params("id")));
            }
            allNews = newsDao.getAllNewsByDepartment(departmentId);
            return gson.toJson(allNews);
        });
        post("/users/new", "application/json", (req, res) -> {
            Users users = gson.fromJson(req.body(), Users.class);
            usersDao.add(users);
            res.status(201);
            return gson.toJson(users);
        });

        get("/users", "application/json", (req, res) -> {
            return gson.toJson(usersDao.getAll());
        });

    }

}
