package com.elead.ppm.project.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elead.platform.common.CommonResponse;
import com.elead.platform.common.web.BaseController;
import com.elead.ppm.project.domain.entity.ELProject;
import com.elead.ppm.project.domain.service.ELProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "项目信息")
@RequestMapping(value = "/proj")
public class ELProjectController extends BaseController {
	@Autowired
	private ELProjectService projectService;

	@ApiOperation("保存项目基本信息")
	@PostMapping(value = "/project", produces = "application/json;charset=UTF-8")
	public CommonResponse addProject(ELProject project) {
		try{
			projectService.insert(project);
			System.out.println("返回自增ID："+project.getId());
			return CommonResponse.createCommonResponse(project);
		} catch (Exception ex) {
			return CommonResponse.createWrongParamCommonResponse(ex.getLocalizedMessage());
		}
	}
}