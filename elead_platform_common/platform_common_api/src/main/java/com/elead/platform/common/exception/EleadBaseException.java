package com.elead.platform.common.exception;

/**
 * 公共的错误码异常类
 * @author wangxz
 * @date 2017/03/22
 */
public class EleadBaseException extends Exception {
	private static final long serialVersionUID = 1L;

	protected String errorCode;
	protected BaseError error;

	public EleadBaseException() {
		super();
	}

	public EleadBaseException(BaseError error) {
		super();
		this.error = error;
	}

	public EleadBaseException(BaseError error, String errorCode) {
		super();
		this.error = error;
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public BaseError getError() {
		return error;
	}

}
