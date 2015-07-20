package com.kaloo.core.exception;

public class KalooBusinessException extends KalooAppException {
	
	private static final long serialVersionUID = 2409160499190701698L;

	public KalooBusinessException(String msg) {
		super(msg);
	}

	public KalooBusinessException(Throwable cause) {
		super(cause);
	}
	
	public KalooBusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
