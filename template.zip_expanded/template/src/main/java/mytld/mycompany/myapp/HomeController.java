package mytld.mycompany.myapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BasicDataSource dbinfo;
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String home() {
		try {
			Connection con = this.dbinfo.getConnection();
			String sql = "select count(*) as ctn from MEMBER";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			this.logger.info(rs.getString("ctn"));
			
			this.logger.info(con.toString());
			this.logger.info("테스트 진행중");
			
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			this.logger.error(e.toString());
			this.logger.debug("오류발생");
		}
		
		return "/WEB-INF/views/home";
	}
	
}
