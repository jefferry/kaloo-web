package com.kaloo.core.exception;

public class KalooSaoException extends KalooAppException {
	
	private static final long serialVersionUID = 2409160499190701698L;

	public KalooSaoException(String msg) {
		super(msg);
	}

	public KalooSaoException(Throwable cause) {
		super(cause);
	}
	
	public KalooSaoException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
