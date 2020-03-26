import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import entity.provider;

class test {

	@Test
	void test() {
		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
			SqlSession sqlsession=fac.openSession();
			List<provider> list=sqlsession.selectList("dao.providerMapper.queryAll");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("id="+list.get(i).getId());
				System.out.println("pname="+list.get(i).getPname());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
