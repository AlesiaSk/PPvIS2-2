package Model;

public class Job {
	
		public  String job;
		public Job(String foName) {
	           this.job = new String(foName);
	       }
		
		 public String getJob() {
				return job;
			}

			public void setJob(String job) {
				this.job = job;
			}
	
}
