package api;

import org.springframework.stereotype.Repository;

import lombok.Data;
@Data
@Repository("api_dto")
public class api_dto {
	String midx;
	String pd1,pd2,pd3,pd4,pd5;
	String mid, mname, memail;
	Integer mage;
	
}
