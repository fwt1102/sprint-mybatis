import com.fwt.pojo.UserInfo;
import com.fwt.service.MenuInfoService;
import com.fwt.service.UserInfoService;
import com.fwt.utils.Page;
import com.fwt.vo.MenuInfoVo;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

public class test {
    ApplicationContext context = new
    ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");

    MenuInfoService menuInfoService = context.getBean(MenuInfoService.class);

    UserInfoService userInfoService = context.getBean(UserInfoService.class);

    @Test
    public void demo(){
        List<MenuInfoVo> menuInfoVos = menuInfoService.listMenu(1);
        for (MenuInfoVo menuInfoVo : menuInfoVos) {
            System.out.println(menuInfoVo);
        }
    }
     @Test
    public void  demoPage(){

//         BeanFactory
//         ListableBeanFactory
//         HierarchicalBeanFactory
//         AutowireCapableBeanFactory

//         ConfigurableBeanFactory

//         ConfigurableListableBeanFactory
//         AbstractAutowireCapableBeanFactory

//         DefaultListableBeanFactory
//

         Page page = new Page();


         int totalCount = userInfoService.selectTotalCount();
         page.setTotalCount(totalCount);
         page.setCurrentPage(1);

         System.out.println(page);
         List<UserInfo> userInfos = userInfoService.SelectPage(page);
         for (UserInfo userInfo : userInfos) {
             System.out.println(userInfo);
         }

     }
}
