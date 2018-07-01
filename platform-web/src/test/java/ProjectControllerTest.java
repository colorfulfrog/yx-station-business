
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

import com.elead.platform.common.entity.ELUser;
import com.elead.platform.common.utils.JsonMapper;
import com.elead.ppm.project.consumer.ProjConsumerApplication;
import com.elead.ppm.project.consumer.controller.ELProjectController;
import com.elead.ppm.project.domain.entity.ELProject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjConsumerApplication.class)
@WebAppConfiguration
public class ProjectControllerTest extends MockMvcResultMatchers {
	private MockMvc mvc;
	
	@Autowired
    WebApplicationContext webApplicationConnect;
	
	ELProjectController projectController;
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
}