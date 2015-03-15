import org.junit.Test;

import com.collect.alipay.domain.Cust;
import com.collect.alipay.util.UUIDUtil;

public class JsonTest {
	
	@Test
	public void test(){
		Cust u = new Cust();
		u.setAddr("addr");
		
		System.out.println(u);
		
		System.out.println(UUIDUtil.randomUUID());
		
		
	}

}
