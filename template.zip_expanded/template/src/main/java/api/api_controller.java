package api;
//CRUD
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONParserConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import oracle.jdbc.driver.configuration.JsonParser;
/*
 this.logger.info : 해당 메소드에서 실행된 값을 출력하는 역할
 this.logger.error : catch에서 사용하는 형태 error발생시 출력되는 메세지
 this.logger.debug : 해당 코드가 정상적으로 작동하는 테스트 메세지를 출력할 때 씀
 this.logger.trace : 해당 코드에 문제가 발생시 좀 더 상세하게 문제사항을 출력
 this.logger.warn : 현재 코드에 대해서 향후 문제가 발생 될 수 있는 원인에 대한 메세지를 출력
 this.logger.fatal : 치명적인 오류 발생시 출력되는 역할
 
 jackson => ajax => JSON, GSON 라이브러리
 Spring-boot는 jackson없이도 put으로 던질시
 dto 받음
 
 예) /api/data.do/{data}
 @PutMapping	//C
 @DeleteMapping	//D
 @PatchMapping 	//U
 
 @GetMapping, @PostMapping(HTML형식) => JSON을 바로 허락 예) /api/data.do	//R
*/
@Controller
public class api_controller {
	//log로 문제사항 및 실행사항을 체크하는 라이브러리
	private static final Logger logger = LoggerFactory.getLogger(api_controller.class);
	
	PrintWriter pw = null;
	@Resource(name = "api_dao")
	api_dao dao;
	
	
	//@RequestBody String data | this.logger.info(data); : 정상적으로 값을 받아서 출력 확인
	@PutMapping("/ajax/ajax14/{key}")		//insert (DTO기본)
	public String ajax14(ServletResponse res, @PathVariable(name = "key") String key,
			@RequestBody String data
			) {
		try {
			this.pw = res.getWriter();
			if (key.equals("a123456")) {
				this.logger.info(data);
				//String => Map 해서 저장 
				Map<String,String> mp = new HashMap<String, String>();
				JSONObject jo = new JSONObject(data);
				Iterator<String> keys = jo.keys();	//Iterator : 키만 뽑는 인터페이스 
				while(keys.hasNext()) {
					String keynm = keys.next();		//키명
					mp.put(keynm, jo.getString(keynm).toString());
				}
				this.logger.info(mp.toString());
				int result = this.dao.api_mapper(mp);
				//				this.logger.info(String.valueOf(result));
				if(result > 0) {
					this.pw.write("ok");	//프론트에서 Ajax로 보내오면 백은 pw.write로 메세지를 적어줌! alert는 프론트가 처리함!
				}else {
					this.pw.write("no");
				}
			} else {
				this.pw.write("key error");
			}

		} catch (Exception e) {

		}
		return null;
	}
	
	//@RequestPart : MultipartFile
	//@RequestParam : name 또는 파라미터
	//@ResponseBody + @Mapping : method 선언시에 사용
	//@ResponseBody : 응답에 대한 결과값을 해당 메소드에 바로 출력할 때 사용
	//@RequestBody : 배열값을 처리하는 어너테이션
	@DeleteMapping("/ajax/ajax13/{key}") //delete
	   public String ajax13(ServletResponse res, 
			   @PathVariable(name = "key") String key,
			   @RequestBody String midx
			   //@RequestBody String midx 
				   ) {
	      try {
	         this.pw = res.getWriter();
	         if (key.equals("a123456")) {
	            this.logger.info(midx);
	        	 
	        	 this.pw.write("delete_ok");
	         } else {
	            this.pw.write("key error");
	         }
	      } catch (Exception e) {
	         this.pw.write("error");
	      }
	      return null;
	   }
		
	
	
	
	
	/*
	 @PathVariable : URL 파라미터 값을 가져오는 어너테이션 {id}=> 가상의 파라미터 값
	 JSON.stringify에 대한 정보값을 처리하지 못함
	 */
	@PatchMapping("/ajax/ajax12.do/{data}") //만약 {이름}설정하면 밑에 name="이름"같게 해야 함
	public String ajax12(HttpServletResponse res,
			@PathVariable(name = "data")String data,
			@RequestBody String myinfo
			) {
		try {
			this.pw = res.getWriter();
			if(data.equals("patch_myinfo")) {
				this.logger.info(myinfo);
				this.pw.write("ok");
			}else {
				
				this.pw.write("error");
				
			}
			
			//this.logger.info(mid);
			
			/*
			String user[] = mid.split(",");
			this.logger.info(user[1]);
			this.logger.info(user[2]);
			this.logger.info(user[3]);
			*/
			
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//ECMA - POST통신 (배열방식) - array방식
	@PostMapping("/ajax/ajax11.do")
	/*//JSON.stringify => 전송시 @RequestBody로 받아야 함
	public String ajax11(HttpServletResponse res,
			@RequestBody String data) {
	*/
	/*
	public String ajax11(HttpServletResponse res, 
			@RequestParam("mid") String mid,
			@RequestParam("mname") String mname
	*/
	public String ajax11(HttpServletResponse res, 
			@ModelAttribute api_dto dto
			) {
		try {
			this.logger.info(dto.getMage().toString());
			this.logger.info(dto.getMname().toString());
			this.logger.info(dto.getMid().toString());
			this.pw = res.getWriter();
			this.pw.write("ok");
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}
	
	
	//ECMA - Ajax(POST)
	@PostMapping("/ajax/ajax10.do")
	public String ajax10(HttpServletResponse res,
			@RequestParam(name = "mid")String mid) {
		
		try {
			this.logger.info(mid);
			this.pw = res.getWriter();
			this.pw.write("ok");
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		
		
		return null;
	}
	
	
	
	
	
	//ECMA - Ajax(GET)
	@GetMapping("/ajax/ajax9.do")
	public String ajax9(HttpServletResponse res,
			@RequestParam(name = "mid")String mid
			) {
		
		try {
			this.logger.info(mid);
			this.pw = res.getWriter();
			this.pw.write("ok");
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//value = "name값명", defaultValue="기본값", required=false (필수가 아님) - Ajax FormData();
	@PostMapping("/ajax/ajax8.do")
	public String ajax8(
		@RequestParam(name="fdata", defaultValue = "", required = false)String fdata,
		HttpServletResponse res
		) {
		try {
			System.out.println(fdata);
			String rdata[] = fdata.split(",");
			this.logger.info(rdata[0]);
			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		
		return null;
	}
	
	
	
	//각각의 다른 키로 POST전송시 (Jquery형태) - DTO
	//Front-end에서 파라미터 형태로 문자열 기준으로 POST전속시 Back-end에서는 dto로 활성화
	@PostMapping("/ajax/ajax7.do")
	public String ajax7(api_dto dto,ServletResponse res) {
		//
		try {
			this.logger.info(dto.getPd1());
			this.logger.info(dto.getPd4());
			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}
	
	
	
	
	//각각의 다른 키로 데이터를 받아서 처리 (JSON.stringify)
	/*
	@PostMapping("/ajax/ajax7.do")
	public String ajax7(@RequestBody String alldata, ServletResponse res) {
		try {
			
			this.logger.info(alldata);
			JSONObject jo = new JSONObject(alldata);
			Iterator i = jo.keys(); //Iterator : 키 이름을 순차적으로 가져오는 인터페이스
 			while(i.hasNext()) {
				String a = i.next().toString(); //키 이름값
				this.logger.info(jo.getString(a)); //해당 키 값의 데이터
				this.logger.info(a);
			}
			
			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		return null;
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//JQuery-Ajax (POST) => JSON.stringify (대표키가 없는 경우)
	@PostMapping("/ajax/ajax6.do")
	public String ajax6(@RequestBody String all_data, ServletResponse res) {
		try {
			this.logger.info(all_data);
			//대표키가 있는 경우
			JSONObject jo = new JSONObject(all_data);
			this.logger.info(jo.get("userdata").toString());
			
			/*//대표키가 없을 경우
			 JSONArray ja = new JSONArray(all_data);
			 this.logger.info(ja.get(0).toString());
			*/
			
			this.pw = res.getWriter();
			this.pw.write("ok");
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		
		
		return null;
	}
	
	

	
	//Jquery - 배열값을 GET으로 받아서 처리한 메소드
	@GetMapping("/ajax/ajax5.do")
	public String ajax5(@RequestParam("no")String no, ServletResponse res) {
		
		try {
			this.logger.info(no);
			JSONArray ja = new JSONArray(no); //[]
			int w = 0;
			while(w < ja.length()) {
				this.logger.info(ja.get(w).toString());
				w++;
			}
			
			this.pw = res.getWriter();
			this.pw.write("ok");
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		
		
		return null;
	}

	
	
	
	
	
	//JSON.stringify : Front-end가 전송시 무조건 @RequestBody로 처리
	@PostMapping("/ajax/ajax4.do")
	public String ajax4(ServletResponse res,@RequestBody String pd) {

		try {
			this.logger.info(pd);
			
			JSONArray ja = new JSONArray(pd);
			int w = 0;
			this.logger.info(String.valueOf(ja.length()));
			while(w < ja.length()) {
				JSONObject jo = (JSONObject)ja.get(w);
				String usernm = jo.get("pd"+(w+1)).toString();
				
				this.logger.info(usernm);
				w++;
			}
			
			
			
			this.pw = res.getWriter();
			this.pw.write("ok");
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		
		return null;
	}
	
	
	
	
	/*
	@RequestHeader : ajax에만 사용하는 어너테이션/Headers의 값이며, 키에 맞는 데이터를 가져올 수 있음
	Front-end : setRequestHeader에 key, value값을 보낼 경우에만 사용함
	
	@RequestBody :ajax.setRequestHeader에 content-type, application/json으로 전송이 되었을 경우 
	
	 */
	@PostMapping("/ajax/ajax3.do")
	public String ajax3(ServletResponse res,
			@RequestBody String pd) {
		
		//@RequestHeader(name = "User") String user
		//this.logger.info(user);
		
		this.logger.info(pd);
		try {
			
			this.pw = res.getWriter();
			this.pw.write("ok");
			
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	 //Array/문자열 형태로 전송시 Get 형태의 메소드와 동일하게 POST 값을 처리하면 됨
	@PostMapping("/ajax/ajax2.do")
	public String ajax2(ServletResponse res, 
			@RequestParam(name = "product") String pd[],
			@RequestParam(name = "person") String person) {
		try {
			this.logger.info(pd[0]);
			this.logger.info(person);
			this.pw = res.getWriter();
			this.pw.write("ok");
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
        return null;
	}
	
	
	
	
		//js - Ajax(GET)
	 	//문자열 + ok, no, error => GET(product)
	 @GetMapping("/ajax/ajax1.do")
     public String ajax1(@RequestParam(name="product")String data, ServletResponse res) {
        this.logger.info(data);
		 /*
		  Front-end에서 보낸 name값을 원시배열로 받을 경우 자동으로 배열로 변경처리 됨
		  단, String으로 배열 자료형을 사용하지 않을 경우 split을 이용하여 값을 분리 시켜야 함
		  */
        try {
			this.pw = res.getWriter();
			this.pw.print("ok");//결과값이 Front-end에 보내짐
		} catch (Exception e) {
			this.logger.error(e.toString());
		}
        return null;
     }

}
