package com.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.study.entity.UserInfo;
import com.study.entity.UserInfoExample;

public interface UserInfoMapper {
	long countByExample(UserInfoExample example);

	int deleteByExample(UserInfoExample example);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	List<UserInfo> selectByExample(UserInfoExample example);

	int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

	int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);
}