package models.dao;

import models.News;

import java.util.List;

public interface NewsDao {
    void add(News news);
    //void addNewsToDepartment(News news, Department department);

    List<News> getAll();
    List<News>getAllNewsByDepartment(int departmentId);

    void deleteById(int id);
    void clearAll();

}
