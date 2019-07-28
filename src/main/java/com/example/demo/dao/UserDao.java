package com.example.demo.dao;


import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ips
 * @version 1.0 2018-12-30 9:34:22
 */
public interface UserDao {

   List<UserEntity> selectList(UserEntity userEntity);

   //查询所有的身份证号(分页)
   List<String> selectAllIdentNo(Map<String,Object> map);

   //查询所有的身份证数量
   Long countIdentNo();

   //根据身份证去查询这个身份证所有的用户
   List<UserEntity> selectUserByIdentNo(String identNo);

}
