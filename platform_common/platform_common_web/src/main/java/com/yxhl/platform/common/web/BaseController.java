/**
 * 
 */
package com.yxhl.platform.common.web;

import java.net.URLDecoder;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yxhl.platform.common.CommonResponse;
import com.yxhl.platform.common.entity.ELUser;
import com.yxhl.platform.common.exception.AccessDataException;
import com.yxhl.platform.common.utils.JsonMapper;
import com.yxhl.platform.common.utils.StringHelper;
import com.yxhl.platform.common.web.editor.DateEditor;

/**
 * 控制器支持类
 * 
 * @author ThinkGem
 * @version 2013-3-23
 */
@RestController
@ControllerAdvice
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());


	//	/**
//	 * 验证Bean实例对象
//	 */
//	@Autowired
//	protected Validator validator;
	@Autowired
	protected HttpServletRequest request;


	/**
	 * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
	 */
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		// Date 类型转换
//		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
//			@Override
//			public void setAsText(String text) {
//				setValue(DateHelper.parseDate(text));
//			}
////
////			@Override
////			public String getAsText() {
////				Object value = getValue();
////				return value != null ? DateHelper.formatDate((Date) value) : "";
////			}
//		});
//	}

	@InitBinder
	@Order(0)
	public void initBinder(WebDataBinder binder) {
		// Date 类型转换
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

	protected ELUser getLoginUser() {
		try {
			String elUserInfo = URLDecoder.decode(request.getHeader("el_user_json_str"), "utf-8");
			//logger.debug("用户信息：" + elUserInfo);
			return JsonMapper.fromJsonString(elUserInfo, ELUser.class);
		} catch (Exception e) {
			logger.error("获取登录用户异常", e);
			return null;
		}
	}

	/**
	 * @param
	 * @return
	 * @description 参数验证
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResponse MethodArgumentNotValidHandler(MethodArgumentNotValidException exception) throws Exception {
		logger.error("参数验证失败:", exception);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				"参数验证失败");
	}

	/**
	* @param
	* @return
	* @description 参数绑定验证
	*/
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public CommonResponse MethodArgumentNotValidHandler(BindException exception) throws Exception {
		logger.error("参数绑定验证失败:", exception);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				"缺少请求参数");
	}

	/**
	 * @param
	 * @return
	 * @description 缺少参数
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public CommonResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		logger.error("缺少请求参数", e);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				"缺少请求参数");
	}

	/**
	 * @param
	 * @return
	 * @description 参数解析
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public CommonResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		logger.error("参数解析失败", e);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				"缺少请求参数");
	}


	/**
	 * @param
	 * @return
	 * @description 参数验证失败
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public CommonResponse handleServiceException(ConstraintViolationException e) {
		logger.error("参数验证失败", e);
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		ConstraintViolation<?> violation = violations.iterator().next();
		String message = violation.getMessage();
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				message);
	}

	/**
	 * @param
	 * @return
	 * @description 参数验证
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public CommonResponse handleValidationException(ValidationException e) {
		logger.error("参数验证失败", e);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
				"参数验证失败");
	}

	/**
	 * @param
	 * @return
	 * @description 不支持当前请求
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public CommonResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		logger.error("不支持当前请求方法", e);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()),
				"不支持当前请求");
	}

	/**
	 * @param
	 * @return
	 * @description 不支持当前媒体类型
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public CommonResponse handleHttpMediaTypeNotSupportedException(Exception e) {
		logger.error("不支持当前媒体类型", e);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()),
				"不支持当前媒体类型");
	}

	/**
	 * @param
	 * @return
	 * @description 系统异常
	 */
	@ResponseBody
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public CommonResponse handleException(Exception e) {
		logger.error("系统异常", e);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
				"系统异常，请稍后重试");
	}
	
	@ResponseBody
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(AccessDataException.class)
	public CommonResponse handleAccessDataException(Exception e) {
		logger.error("数据操作权限异常", e);
		return CommonResponse.createCustomCommonResponse(String.valueOf(HttpStatus.OK.value()),
				StringHelper.isBlank(e.getMessage())?"数据操作权限异常":e.getMessage());
	}
}
