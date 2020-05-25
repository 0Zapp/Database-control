package observer;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import observer.enums.NotificationCode;

//@Data
//@AllArgsConstructor
public class Notification {
	private NotificationCode code;
	private Object data;

	public NotificationCode getCode() {
		return code;
	}

	public void setCode(NotificationCode code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Notification(NotificationCode code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}

}
