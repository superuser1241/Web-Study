package ex0930.dto;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private int age;
	private String phone;
	private String addr;
	private String joinDate;
	
	public MemberDTO() {}
	public MemberDTO(String id, String pwd, String name, int age, String phone, String addr, String joinDate) {
		this(id,pwd,name,age,phone,addr);
		this.joinDate = joinDate;
	}
	public MemberDTO(String id, String pwd, String name, int age, String phone, String addr) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDTO [id=");
		builder.append(id);
		builder.append(", pwd=");
		builder.append(pwd);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", addr=");
		builder.append(addr);
		builder.append(", joinDate=");
		builder.append(joinDate);
		builder.append("]");
		return builder.toString();
	}
}
