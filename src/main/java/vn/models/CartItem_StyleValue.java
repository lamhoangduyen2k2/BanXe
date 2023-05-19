package vn.models;

public class CartItem_StyleValue {
	private int cartItemId;
	private int styleValueId;
	private CartItem cartItem;
	private StyleValue styleValue;
	
	public CartItem_StyleValue(int cartItemId, int styleValueId, CartItem cartItem, StyleValue styleValue) {
		super();
		this.cartItemId = cartItemId;
		this.styleValueId = styleValueId;
		this.cartItem = cartItem;
		this.styleValue = styleValue;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getStyleValueId() {
		return styleValueId;
	}

	public void setStyleValueId(int styleValueId) {
		this.styleValueId = styleValueId;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public StyleValue getStyleValue() {
		return styleValue;
	}

	public void setStyleValue(StyleValue styleValue) {
		this.styleValue = styleValue;
	}
	
}
