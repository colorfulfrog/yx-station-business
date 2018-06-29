package com.elead.platform.common.exception;

import java.io.Serializable;

public interface BaseError extends Serializable {

	public String toErrorMessage(String errorCode);
}
