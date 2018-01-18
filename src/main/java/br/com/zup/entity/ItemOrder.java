package br.com.zup.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemOrderPK id = new ItemOrderPK();
	
	private Double discount;
	private Integer amount;
	private Double price;
	
	public ItemOrder() {
		
	}

	public ItemOrder(Orders orders, Product product, Double desconto, Integer amount, Double price) {
		super();
		id.setOrder(orders);
		id.setProduct(product);
		this.discount = desconto;
		this.amount = amount;
		this.price = price;
	}
	
	@JsonIgnore
	public Orders getPedido() {
		return id.getOrder();
	}
	
	public Product getProduto() {
		return id.getProduct();
	}
	
	/**
	 * @return the id
	 */
	public ItemOrderPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ItemOrderPK id) {
		this.id = id;
	}

	/**
	 * @return the discount
	 */
	public Double getDesconto() {
		return discount;
	}

	/**
	 * @param amount the discount to set
	 */
	public void setDesconto(Double desconto) {
		this.discount = desconto;
	}

	/**
	 * @return the amount
	 */
	public Integer getQuantidade() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.amount = quantidade;
	}

	/**
	 * @return the price
	 */
	public Double getPreco() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPreco(Double preco) {
		this.price = preco;
	}
	

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrder other = (ItemOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
