package mytld.mycompany.myapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import api.api_mapper;

@Repository("membership_DAO")
public class membership_DAO implements membership_mapper {
	@Resource(name = "sqltemp")
	public SqlSessionTemplate st;
	
	Map<String, String> mp = null;
	
	@Override
	public int join_insert(membership_DTO dto) {
		int result = st.insert("join_insert",dto);
		return result;
	}
	
	@Override
	public List<membership_DTO> id_info(String mid, String mpass) {
		//Map 생성하는 이유 : mapper.xml에서 choose를 사용하여 각 when(조건) 별로 query를 다르게 실행시키기 위함
		this.mp = new HashMap<>();
		
		if (mpass != "") {
			mp.put("part", "login");
			mp.put("mid", mid);
			mp.put("mpass", mpass);
		}else {
			mp.put("part", "myinfo");
			mp.put("mid", mid);
		}
		
		//해당 조건에 mapper값을 return 받음
		List<membership_DTO> all = this.st.selectList("id_info",this.mp);
		System.out.println(all);
		return all;
	}
	
	
	@Override
	public String id_row(String mid) {
		String result = null;
		try {
			//id검토시 Oracle : 대문자/소문자 구분함
			result = st.selectOne("id_row", mid);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
}
