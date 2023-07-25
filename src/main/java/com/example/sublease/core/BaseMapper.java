package com.example.sublease.core;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    public T get(String id);
    public T get(T entity);
    public  T findUniqueByProperty(@Param("propertyName") String propertyName, @Param("value") Object value);

    // In case pagination
    public List<T> findList(T entity);
    public List<T> findAllList(T entity);
    @Deprecated
    public List<T> findAllList();
    public int insert(T entity);
    public int update(T entity);
    @Deprecated
    public int delete(String id);
    public int delete(T entity);

    @Select("${sql}")
    public List<Map<String, Object>>  execSelectSql(@Param(value="sql")String sql);

    @Update("${sql}")
    public void execUpdateSql(@Param("sql") String sql);

    @Insert("${sql}")
    public void execInsertSql(@Param("sql") String sql);

    @Delete("${sql}")
    public void execDeleteSql(@Param("sql") String sql);
}
