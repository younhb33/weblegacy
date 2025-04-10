package mytld.mycompany.myapp;

import java.security.MessageDigest;

import org.springframework.stereotype.Repository;

@Repository("md5")
public class md5 {

	public String md5_pass(String mpass) {
		StringBuffer sb = new StringBuffer();

		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(mpass.getBytes());
			for(byte code : md.digest()) {
				sb.append(String.format("%x", code));
			}
		} catch (Exception e) {
			sb.append("error");
		}
		return sb.toString();
	}

}
