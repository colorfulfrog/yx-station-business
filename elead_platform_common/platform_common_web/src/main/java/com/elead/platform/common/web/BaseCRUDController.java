package com.elead.platform.common.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.elead.platform.common.CommonResponse;
import com.elead.platform.common.entity.BaseObject;
import com.elead.platform.common.service.IELService;
import com.elead.platform.common.utils.GenericeClassUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wangxz
 * @class_name BaseCRUDController
 * @description base crud controller
 * @date 2017/8/31
 */
@Api
@RestController
public abstract class BaseCRUDController<T extends BaseObject,S extends IELService<T>> extends BaseController {

    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);

    @Autowired
    protected S service;

    /**
     * @param
     * @return
     * @description
     * @author wangxz
     * @version v1.0
     * @date 2017/8/31
     */
    @ApiOperation(value = "根据Id查询实体", notes = "selectById")
    @ApiImplicitParam(name = "id", value = "实体id", required = true)
    @GetMapping(value = "/{id}")
    @ResponseBody
    public CommonResponse selectById(@PathVariable(value = "id") final String id) {
        T entity = service.selectById(id);
        return CommonResponse.createCommonResponse(entity);
    }

    /**
     * @param
     * @return
     * @description
     * @author wangxz
     * @version v1.0
     * @date 2017/8/31
     */
    @ApiOperation(value = "新增实体", notes = "add")
    @ApiImplicitParam(name = "entity", value = "实体Json", required = true, dataType = "application/json")
    @PostMapping(value = "")
    @ResponseBody
    public CommonResponse add(@Valid @RequestBody final T entity) {
    	// TODO ID
        //entity.setId(IdWorker.get32UUID());
        return service.insert(entity) ? CommonResponse.createCommonResponse(entity)
                : CommonResponse.createExceptionsCommonResponse();
    }

    /**
     * @param
     * @return
     * @description
     * @author wangxz
     * @version v1.0
     * @date 2017/8/31
     */
    @ApiOperation(value = "更新", notes = "update")
    @ApiImplicitParam(name = "entity", value = "实体Json", required = true, dataType = "application/json")
    @PutMapping(value = "/{id}")
    @ResponseBody
    public CommonResponse update(@PathVariable(value = "id") final String id, @RequestBody final T entity) {
        //TODO 恢复
    	//entity.setId(id);
    	entity.setId(Integer.parseInt(id));
        return service.updateById(entity) ? CommonResponse.createCommonResponse(entity) :
                CommonResponse.createExceptionsCommonResponse();
    }

    /**
     * @param
     * @return
     * @description
     * @author wangxz
     * @version v1.0
     * @date 2017/8/31
     */
    @ApiOperation(value = "根据Id删除实体", notes = "delete")
    @ApiImplicitParam(name = "id", value = "实体id", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public CommonResponse delete(@PathVariable(value = "id") final String id) {
        return service.deleteById(id) ? CommonResponse.createCommonResponse() :
                CommonResponse.createExceptionsCommonResponse();
    }

    /**
     * 查询所有实体
     */
    @ApiOperation(value = "查询所有实体", notes = "findAllEntitys")
    @SuppressWarnings({"rawtypes", "unchecked"})
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResponse findAllEntitys(T entity) {
        EntityWrapper<T> ew = new EntityWrapper<>();
        ew.setEntity(entity);
        return CommonResponse.createCommonResponse(service.selectList(ew));
    }
}
