package ex0925_el;

public class Product {
	private String code = "A01";
	private String name = "새우깡";
	private int qty = 5;
	private int price = 1500;
	
	public Product() {
		System.out.println("Product 생성자 호출....");
	}

	public String getCode() {
		System.out.println("getCode....");
		return code;
	}

	public String getName() {
		System.out.println("getName....");
		return name;
	}

	public int getQty() {
		System.out.println("getQty....");
		return qty;
	}

	public int getPrice() {
		System.out.println("getPrice....");
		return price;
	}
	
}
