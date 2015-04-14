package com.nickbd.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class RegistrationKey implements WritableComparable {

		Text cookieId = new Text();
		Text sessionId = new Text();
		
		public RegistrationKey(String cookieId, String sessionId) {
			super();
			this.cookieId.set(cookieId);
			this.sessionId.set(sessionId);
		}
		
		public RegistrationKey() {
		}

		@Override
		public void readFields(DataInput in) throws IOException {
			cookieId.readFields(in);
			sessionId.readFields(in);
		}
		
		@Override
		public void write(DataOutput out) throws IOException {
			cookieId.write(out);
			sessionId.write(out);
		}
		
		@Override
		public int compareTo(Object o) {
			RegistrationKey ok = (RegistrationKey) o;
			int res = cookieId.compareTo(ok.cookieId);
			if (res == 0) {
				return sessionId.compareTo(ok.sessionId);
			} else {
				return res;
			}
		}

		public Text getCookieId() {
			return cookieId;
		}

		public void setCookieId(String cookieId) {
			this.cookieId.set(cookieId);
		}

		public Text getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId.set(sessionId);
		}
}
