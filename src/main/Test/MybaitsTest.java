import com.loveyj.mapper.UserMapper;
import com.loveyj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybaitsTest {



    @Test
    public  void Test() throws IOException {

        SqlSession sqlSession = MybatisUtils.openSqlSession();


        UserMapper user = sqlSession.getMapper(UserMapper.class);

             List<User> list=   user.getUser();

        for (User user1:list) {
            System.out.println(user1);
        }
                sqlSession.close();
            }
        }



