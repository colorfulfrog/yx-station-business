import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elead.ppm.project.domain.entity.ELProject;
import com.elead.ppm.project.domain.service.ELProjectService;
import com.elead.ppm.project.provider.ProjProviderApplication;
import com.yxhl.platform.common.redis.util.RedisUtil;


/**
 * Junit Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ProjProviderApplication.class)
public class ELProjectServiceTest {
	
	
	@Autowired
	ELProjectService projectService;
	@Autowired
	private RedisUtil redisUtil;
	
	@Test
	public void testAdd(){
		ELProject entity = new ELProject();
		entity.setParentId("1");
		entity.setCreateBy("1");
		entity.setUpdateBy("1");
		entity.setName("Project3");
		entity.setStartTime(new Date());
		entity.setFinishTime(new Date());
		projectService.insert(entity);
		System.out.println("新增的ID为："+entity.getId());
		
		redisUtil.set("project:"+entity.getId(), entity, 600L);
		
		System.out.println(redisUtil.get("project:"+entity.getId()));
	}
	
	@Test
	public void testGetTreeList(){
		List<ELProject> tree = projectService.getTreeById(1);
		System.out.println(tree);
	}
}
