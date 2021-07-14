package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
/**
 * MyBatisUtils工具类,创建全局唯一的SqlSessionFactory对象
 */
public class MyBatisUtils {
    //保证MyBatis的对象全局唯一的特性 //利用static(静态)属于类不属于对象,且全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;
    //利用静态块在初始化类时实例化sqlSessionFactory
    static{
        Reader reader= null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            //初始化错误时,通过抛出异常ExceptionInInitializerError通知调用者，类的初始化过程中产生的错误
            throw  new ExceptionInInitializerError(e);
        }

    }

    /**
     * openSession 创建一个新的SqlSession对象
     * @return SqlSession对象
     */
    //在后续的数据表中，利用SqlSession完成数据表的增删改查操作
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 释放一个有效的SqlSession对象
     * @param session 准备释放SqlSession对象
     */
    public static void closeSession(SqlSession session){
        if(session != null){
            session.close();
        }
    }

}
