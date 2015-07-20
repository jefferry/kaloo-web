package com.kaloo.core.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class KalooRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 5747454947777414247L;
	
	private Throwable cause;// 保存起因异常

	public KalooRuntimeException(String msg) {
		super(msg);
	}

	public KalooRuntimeException(Throwable cause) {
		this.cause = cause;
	}

	public KalooRuntimeException(String msg, Throwable cause) {
		super(msg);
		this.cause = cause;
	}

	public Throwable getCause() {
		return (this.cause == null ? this : this.cause);
	}

	public String getMessage(){   
		 String message = super.getMessage();   
		 Throwable cause = getCause();   
		   if(cause != null){   
		     message = message + ";nested Exception is " + cause;   
		   }   
		 return message;   
	}	
	
	public void printStackTrace(PrintStream ps) {
		synchronized (ps) {
			if (getCause() == null) {
				super.printStackTrace(ps);
			} else {
				ps.println(this);
				getCause().printStackTrace(ps);
			}
		}
	}
	
	public Throwable getInitialCause() {
	    if (this.cause == null)
	    {
	      return this;
	    }

	    if (this.cause instanceof KalooAppException) {
	      return ((KalooAppException)this.cause).getInitialCause();
	    }

	    return this.cause;
	}

	public void printStackTrace(PrintWriter pw) {
		synchronized (pw) {
			if (getCause() == null) {
				super.printStackTrace(pw);
			} else {
				pw.println(this);
				getCause().printStackTrace(pw);
			}
		}
	}

	public void printStackTrace() {
		printStackTrace(System.err);
	}

}
