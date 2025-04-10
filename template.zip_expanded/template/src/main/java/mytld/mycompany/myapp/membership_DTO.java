package mytld.mycompany.myapp;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("membership_DTO")
public class membership_DTO {
   Integer MIDX,MCODE;
   String MID, MNAME, MNICK, MPASS, MEMAIL, MHP, MJOIN, MDATE;
}
