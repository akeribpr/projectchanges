package config;

import java.io.Serializable;

public class ClientProperties implements Serializable {
	
	public ClientProperties(){};
	
	public ClientProperties(int port, String servAddr) {
		super();
		this.port = port;
		this.servAddr = servAddr;
	}
	private int port;
	private String servAddr;
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getServAddr() {
		return servAddr;
	}
	public void setServAddr(String servAddr) {
		this.servAddr = servAddr;
	}

}
