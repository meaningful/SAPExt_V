package bean;

public class UserInfo {
	
		private int id ; 
		private String customID ; // 身份证信息
		private String sapUsername ; //SAP 系统用户名
		private String sapPassword ; //SAP系统密码（加密后的密文）
		private String sapPw ; //SAP系统密码 ， 明文
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCustomID() {
			return customID;
		}
		public void setCustomID(String customID) {
			this.customID = customID;
		}
		public String getSapUsername() {
			return sapUsername;
		}
		public void setSapUsername(String sapUsername) {
			this.sapUsername = sapUsername;
		}
		public String getSapPassword() {
			return sapPassword;
		}
		public void setSapPassword(String sapPassword) {
			this.sapPassword = sapPassword;
		}
		public String getSapPw() {
			return sapPw;
		}
		public void setSapPw(String sapPw) {
			this.sapPw = sapPw;
		}
		
}
