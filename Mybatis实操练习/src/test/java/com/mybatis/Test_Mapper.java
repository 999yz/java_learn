package com.mybatis;

import com.mybatis.mapper.TestMapper;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test_Mapper {

    @Test
    public void testMapperAll(){
        SqlSession session = MyBatisUtils.openSession();
        TestMapper testMapper = session.getMapper(TestMapper.class);
        System.out.println(testMapper.MapperSelectAll());
        MyBatisUtils.closeSession(session);
    }


}
