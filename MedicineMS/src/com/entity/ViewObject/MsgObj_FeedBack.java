package com.entity.ViewObject;

public class MsgObj_FeedBack {
		private String msg;
		private String msg_cont;
	
		private String delete_msg; 
		private String delete_msg_cont;
		
		private String update_msg; 
		private String update_msg_cont;
		
		private String find_msg;
		private String find_msg_cont;
		public MsgObj_FeedBack() {
			super();
		}
		public MsgObj_FeedBack(String msg, String msg_cont) {
			super();
			this.msg = msg;
			this.msg_cont = msg_cont;
		}
		public MsgObj_FeedBack(String msg, String msg_cont, String delete_msg, String delete_msg_cont,
				String update_msg, String update_msg_cont, String find_msg, String find_msg_cont) {
			super();
			this.msg = msg;
			this.msg_cont = msg_cont;
			this.delete_msg = delete_msg;
			this.delete_msg_cont = delete_msg_cont;
			this.update_msg = update_msg;
			this.update_msg_cont = update_msg_cont;
			this.find_msg = find_msg;
			this.find_msg_cont = find_msg_cont;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getMsg_cont() {
			return msg_cont;
		}
		public void setMsg_cont(String msg_cont) {
			this.msg_cont = msg_cont;
		}
		public String getDelete_msg() {
			return delete_msg;
		}
		public void setDelete_msg(String delete_msg) {
			this.delete_msg = delete_msg;
		}
		public String getDelete_msg_cont() {
			return delete_msg_cont;
		}
		public void setDelete_msg_cont(String delete_msg_cont) {
			this.delete_msg_cont = delete_msg_cont;
		}
		public String getUpdate_msg() {
			return update_msg;
		}
		public void setUpdate_msg(String update_msg) {
			this.update_msg = update_msg;
		}
		public String getUpdate_msg_cont() {
			return update_msg_cont;
		}
		public void setUpdate_msg_cont(String update_msg_cont) {
			this.update_msg_cont = update_msg_cont;
		}
		public String getFind_msg() {
			return find_msg;
		}
		public void setFind_msg(String find_msg) {
			this.find_msg = find_msg;
		}
		public String getFind_msg_cont() {
			return find_msg_cont;
		}
		public void setFind_msg_cont(String find_msg_cont) {
			this.find_msg_cont = find_msg_cont;
		}
		@Override
		public String toString() {
			return "MsgObj_FeedBack [msg=" + msg + ", msg_cont=" + msg_cont + ", delete_msg=" + delete_msg
					+ ", delete_msg_cont=" + delete_msg_cont + ", update_msg=" + update_msg + ", update_msg_cont="
					+ update_msg_cont + ", find_msg=" + find_msg + ", find_msg_cont=" + find_msg_cont + "]";
		}
		
		
		
		
		
}
