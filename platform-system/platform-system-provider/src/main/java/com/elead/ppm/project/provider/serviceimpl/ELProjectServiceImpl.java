package com.elead.ppm.project.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.platform.common.service.service.TreeService;
import com.elead.ppm.project.domain.entity.ELProject;
import com.elead.ppm.project.domain.service.ELProjectService;
import com.elead.ppm.project.provider.dao.ELProjectDao;

@Service(value = "projectService")
public class ELProjectServiceImpl extends TreeService<ELProjectDao, ELProject> implements ELProjectService {

	@Autowired
	private ELProjectDao projectDao;

}