package api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("api_dao")
public class api_dao implements api_mapper{
	int result = 0;
	
	@Resource(name="sqltemp")
	public SqlSessionTemplate ss;
	
	@Override
	public int api_mapper(Map<String, String> data) {
		this.result  = ss.insert("pdtest",data);
		return this.result;
	}
	
	@Override
	public List<api_dto> pdlist() {
		List<api_dto> all = ss.selectList("pdlist");
		return all;
	}

}
