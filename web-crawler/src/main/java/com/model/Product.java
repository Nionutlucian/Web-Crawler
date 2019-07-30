package com.model;

public class Product {

	private String title;
	private String provider;
	private String image;
	private String price;
	private String url;
	private String codProdus;
	private String celPrice;
	
	public String getCelPrice() {
		return celPrice;
	}

	public void setCelPrice(String celPrice) {
		this.celPrice = celPrice;
	}

	public String getCodProdus() {
		return codProdus;
	}

	public void setCodProdus(String codProdus) {
		this.codProdus = codProdus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", provider=" + provider + ", image=" + image + ", price=" + price + ", url="
				+ url + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
