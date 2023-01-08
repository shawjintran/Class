package com.shaw.txclass;

import com.shaw.txclass.entity.User;
import com.shaw.txclass.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TxClassApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	void findAll() {
		List<User> users = userMapper.selectList(null);
		users.forEach((user)-> System.out.println(user) );
	}

}
