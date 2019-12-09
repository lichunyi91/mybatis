import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class test {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

   @Test
   public void test(){
       SqlSession sqlSession = sqlSessionFactory.openSession(true);
       EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
       try {
           Employee employee = mapper.getEmpById(5);
           System.out.println(employee);
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           sqlSession.close();
       }

   }
    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        try {
            Employee employee=new Employee();
            employee.setEmpName("xiaohong");
            employee.setEmail("23232@qq.com");
            employee.setGender(0);
            int i = mapper.insertEmployee(employee);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        try {
            Employee employee=new Employee();
            employee.setEmpName("xiaoli");
            employee.setEmail("123123123232@qq.com");
            employee.setGender(1);
            int i = mapper.insertEmployee(employee);
            System.out.println(employee.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        try {
            boolean b = mapper.deleteEmployee(5);
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        try {
            Employee employee=new Employee();
            employee.setId(5);
            employee.setEmpName("xiaonn");
            employee.setEmail("3afdsdfs2@qq.com");
            employee.setGender(1);
            int i = mapper.updateEmployee(employee);
            System.out.println(employee.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test6(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        try {
            Employee empName = mapper.getEmpByIdAndEmpName(3, "xiaohong");
            System.out.println(empName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void test7(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        try {
            Map<Integer, Employee> allEmpsReturnMap = mapper.getAllEmpsReturnMap();
            System.out.println(allEmpsReturnMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}
