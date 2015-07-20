package com.kaloo.core.exception;

public class KalooWebException extends KalooAppException {
	
	private static final long serialVersionUID = 2409160499190701698L;

	public KalooWebException(String msg) {
		super(msg);
	}

	public KalooWebException(Throwable cause) {
		super(cause);
	}
	
	public KalooWebException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
