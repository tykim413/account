package com.purple.project.account.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {

	public List<HashMap> selectList();
	
	public HashMap selectAccount(HashMap<String, Object> map);
	
	public int insert(HashMap<String, Object> map);
	
	public int update(HashMap<String, Object> map);
	
	public int delete(HashMap<String, Object> map);
}
