package com.momo.dto;

public class Job {
	private String jobCode;
	private String jobName;
	
	@Override
	public String toString()  {
		return jobCode+ "/" +jobName;
	}

	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobname() {
		return jobName;
	}

	public void setJobname(String jobname) {
		this.jobName = jobname;
	}

	

}
