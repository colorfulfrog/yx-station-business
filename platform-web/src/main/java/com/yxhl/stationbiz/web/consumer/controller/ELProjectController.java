package com.yxhl.stationbiz.web.consumer.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.yxhl.platform.common.CommonResponse;
import com.yxhl.platform.common.constants.CodeUtils;
import com.yxhl.platform.common.web.BaseController;
import com.yxhl.stationbiz.system.domain.entity.ELProject;
import com.yxhl.stationbiz.system.domain.service.ELProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "项目信息")
@RequestMapping(value = "/proj")
public class ELProjectController extends BaseController {
	@Autowired
	private ELProjectService projectService;

	@ApiOperation("分页查询")
	@PostMapping(value = "/list", produces = "application/json;charset=UTF-8")
	public CommonResponse list(@RequestParam("currentPage")String currentPage,@RequestParam("pageSize")String pageSize, ELProject project) {
		if(!StringUtils.isNotBlank(currentPage) & !StringUtils.isNotBlank(pageSize)){
			currentPage="1";
            pageSize="10";
        }
		Page<ELProject> page = new Page<ELProject>(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
		Page<ELProject> result = projectService.selPageList(page, project);
		return CommonResponse.createCommonResponse(result);
	}
	
	@ApiOperation("查询单个项目基本信息")
	@GetMapping(value = "/project/{projectId}", produces = "application/json;charset=UTF-8")
	public CommonResponse getInfoById(@PathVariable("projectId") Integer projectId) {
		ELProject project = projectService.selectById(projectId);
		return CommonResponse.createCommonResponse(project);
	}
	
	@ApiOperation("新增项目基本信息")
	@PostMapping(value = "/project", produces = "application/json;charset=UTF-8")
	public CommonResponse addProject(@RequestBody ELProject project) {
		boolean isAdded = projectService.insert(project);
		if(isAdded) {
			return CommonResponse.createCommonResponse(project);
		}else {
			return CommonResponse.createCustomCommonResponse(CodeUtils.FAIL_CODE, "新增项目失败!");
		}
	}
	
	@ApiOperation("修改项目基本信息")
	@PutMapping(value = "/project", produces = "application/json;charset=UTF-8")
	public CommonResponse updateProject(@RequestBody ELProject project) {
		boolean isAdded = projectService.updateById(project);
		if(isAdded) {
			return CommonResponse.createCommonResponse();
		}else {
			return CommonResponse.createCustomCommonResponse(CodeUtils.FAIL_CODE, "修改项目失败!");
		}
	}
	
	@ApiOperation("删除项目")
	@DeleteMapping(value = "/project/{projectId}", produces = "application/json;charset=UTF-8")
	public CommonResponse delById(@PathVariable("projectId") Integer projectId) {
		boolean isDel = projectService.deleteById(projectId);
		if(isDel) {
			return CommonResponse.createCommonResponse();
		}else {
			return CommonResponse.createCustomCommonResponse(CodeUtils.FAIL_CODE, "删除项目失败!");
		}
	}
}