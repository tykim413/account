package com.purple.project.account;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.purple.project.account.service.AccountMapper;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
    private AccountMapper accountMapper;

	@RequestMapping("/select")
    public List<HashMap> HelloWorld() {
        return accountMapper.selectList();
    }
	
    @RequestMapping("/insert")
    public String insert(@RequestParam HashMap<String, Object> map) {
    	
    	int result = 0;
    	
    	try{
    		result = accountMapper.insert(map);
    	}catch(Exception e) {
    		result = 0 ;
    	}
    	String resultMsg = "";
        if(result == 0) {
        	resultMsg = "실패";
        }else {
        	resultMsg = "성공";
        }
        
        return resultMsg;
    }
    
    @RequestMapping("/update")
    public String update(@RequestParam HashMap<String, Object> map) {
    	
    	String id = "";
    	if(map.get("id") == null) {
    		return "id 값이 없습니다";
    	}else {
    		id = map.get("id").toString();
    	}
    	 
    	String pwcheck = "";
    	if(map.get("pwcheck") == null) {
    		return "현재 pw 값이 없습니다";
    	}else {
    		pwcheck = map.get("pwcheck").toString();
    	}
    	
    	String pw = "";
    	if(map.get("pw") == null) {
    		return "pw 값이 없습니다";
    	}else {
    		pw = map.get("pw").toString();	
    	}
    	
    	HashMap<Object, String> selectAccount = accountMapper.selectAccount(map);

    	if(!selectAccount.get("pw").toString().equals(pwcheck)) {
    		return "현재 pw 값이 일치하지 않습니다";
    	}
    	
    	int result = 0;
    	
    	try{
    		result = accountMapper.update(map);
    	}catch(Exception e) {
    		result = 0 ;
    	}
    	String resultMsg = "";
        if(result == 0) {
        	resultMsg = "실패";
        }else {
        	resultMsg = "성공";
        }
        
        return resultMsg;
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam HashMap<String, Object> map) {
    	
    	String id = "";
    	if(map.get("id") == null) {
    		return "id 값이 없습니다";
    	}else {
    		id = map.get("id").toString();
    	}
    	
    	String pw = "";
    	if(map.get("pw") == null) {
    		return "pw 값이 없습니다";
    	}else {
    		pw = map.get("pw").toString();	
    	}
    	
    	HashMap<Object, String> selectAccount = accountMapper.selectAccount(map);

    	if(selectAccount == null) {
    		return "일치하는 id가 없습니다";
    	}
    	if(!selectAccount.get("pw").toString().equals(pw)) {
    		return "pw 값이 일치하지 않습니다";
    	}
    	
    	int result = 0;
    	
    	try{
    		result = accountMapper.delete(map);
    	}catch(Exception e) {
    		result = 0 ;
    	}
    	String resultMsg = "";
        if(result == 0) {
        	resultMsg = "실패";
        }else {
        	resultMsg = "성공";
        }
        
        return resultMsg;
    }
    
    
}
