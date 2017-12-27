package com.bjtu.item.entity;

public class Item {

	private Long id;
	private Byte status;
	private String name;
	private Double price;
	private Long createTime;
	private Long updateTime;
	private String desc;
	private String image;
	private Integer stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", status=" + status +
				", name='" + name + '\'' +
				", price=" + price +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", desc='" + desc + '\'' +
				", image='" + image + '\'' +
				", stock=" + stock +
				'}';
	}
}