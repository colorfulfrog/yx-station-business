
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yxhl.platform.common.entity.ELUser;
import com.yxhl.platform.common.redis.util.RedisUtil;
import com.yxhl.platform.common.utils.JsonMapper;
import com.yxhl.stationbiz.system.domain.entity.ELProject;
import com.yxhl.stationbiz.web.consumer.WebConsumerApplication;
import com.yxhl.stationbiz.web.consumer.controller.ELProjectController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebConsumerApplication.class)
@WebAppConfiguration
public class ProjectControllerTest extends MockMvcResultMatchers {
	private MockMvc mvc;
	
	@Autowired
    WebApplicationContext webApplicationConnect;
	
	ELProjectController projectController;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build(); 
	}

	@Test
	public void testAddProject() throws Exception {
		RequestBuilder request = null;

		ELProject project = new ELProject();
		project.setName("测试项目");
		project.setCreateBy("1");
		String content = JsonMapper.toJsonString(project);
		ELUser user =new ELUser();
		user.setId(1);
		user.setName("admin");
		user.setCode("1");
		user.setOrgId("1");
		user.setType("1");
		
		String el_user_json_str = JsonMapper.toJsonString(user);
		request = MockMvcRequestBuilders.post("/proj/project").contentType(MediaType.APPLICATION_JSON_VALUE).content(content).header("user_json_str", el_user_json_str);
		ResultActions result =   mvc.perform(request);
		result.andExpect(status().isOk()).andExpect(content().string("success"));
	}
	
	@Test
	public void testRedis() {
		ELProject project = new ELProject();
		project.setId(100001);
		project.setName("测试项目");
		project.setCreateBy("1");
		redisUtil.set("project:100001", project, 600L);
		
		System.out.println("Get Project:100001 from redis:" + redisUtil.get("project:100001"));
	}
}
