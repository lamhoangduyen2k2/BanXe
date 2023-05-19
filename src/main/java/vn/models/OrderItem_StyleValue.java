package vn.models;

public class OrderItem_StyleValue {
	private int orderItemId;
	private int styleValueId;
	private _Order order;
	private StyleValue styleValue;
	
	public OrderItem_StyleValue(int orderItemId, int styleValueId, _Order order, StyleValue styleValue) {
		super();
		this.orderItemId = orderItemId;
		this.styleValueId = styleValueId;
		this.order = order;
		this.styleValue = styleValue;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getStyleValueId() {
		return styleValueId;
	}

	public void setStyleValueId(int styleValueId) {
		this.styleValueId = styleValueId;
	}

	public _Order getOrder() {
		return order;
	}

	public void setOrder(_Order order) {
		this.order = order;
	}

	public StyleValue getStyleValue() {
		return styleValue;
	}

	public void setStyleValue(StyleValue styleValue) {
		this.styleValue = styleValue;
	}
	
}
