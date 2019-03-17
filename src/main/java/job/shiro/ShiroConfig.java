package job.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("webManager")DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        factoryBean.setSecurityManager(manager);
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/","anon");
        filterMap.put("/process","anon");
        filterMap.put("/login","anon");
//        filterMap.put("/*", "authc");

        factoryBean.setLoginUrl("login");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        return factoryBean;
    }
    @Bean(name = "webManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(userRealm);

        return webSecurityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm realm(){
        return new UserRealm();
    }
}
