import com.fwt.dto.WangeditorDto;
import com.fwt.utils.HttpClientUtility;
import com.fwt.vo.LombokTest;
import org.junit.Test;

import java.util.Date;

public class Lombok {


    @Test
    public void Lombok(){

        String s = HttpClientUtility.get("http://localhost:8081/selectAllUser");
        System.out.println(s);
    }
}
