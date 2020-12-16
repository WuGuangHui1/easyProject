package entity;

/**
 * @author ∂≈ˆŒ”Ó
 */
public class Usecase {
	private int id;
	private String url;
	private String method;
	private String body;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Case [id=" + id + ", url=" + url + ", method=" + method + ", body=" + body + ", phone=" + phone + "]";
	}
	

}
