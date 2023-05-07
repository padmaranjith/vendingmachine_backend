package com.skillstorm.globalexceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Padma Ranjith
 * status - Status code
 * message-To send the error message
 * timestamp - When the error  occurred 
 */

public class MyErrorResponse {
		private int status; 
	    private String message;
	    private LocalDateTime timestamp;
	    
	  
	    public MyErrorResponse(){
	    	
	    }
	    
		public MyErrorResponse(int status, String message, LocalDateTime timestamp) {
			super();
			this.status = status;
			this.message = message;
			this.timestamp = timestamp;
		}


		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
	    
	    

}
