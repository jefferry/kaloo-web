package com.kaloo.core.exception;

public class KalooDaoException extends KalooAppException {
	
	private static final long serialVersionUID = 2409160499190701698L;

	public KalooDaoException(String msg) {
		super(msg);
	}

	public KalooDaoException(Throwable cause) {
		super(cause);
	}
	
	public KalooDaoException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
