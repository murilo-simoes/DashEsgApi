package DashEsgApi.DashEsgApi.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Books{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	String title;
	Double price;
	Integer qty;
	
	
	public Books() {}
	
	public Books(String title, Double price, Integer qty) {
		this.title = title;
		this.price = price;
		this.qty = qty;
	}
	
	public Books(Integer id, String title, Double price, Integer qty) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.qty = qty;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
	 public Books copy() {
		 	Books copy = new Books();
	        copy.title = this.title;
	        copy.price = this.price;
	        copy.qty   = this.qty;
	        return copy;
	    }
	 
		@Override
		public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Books Books = (Books) obj;
	        return qty == Books.qty &&
	                Objects.equals(title, Books.title) &&
	                Double.compare(Books.price, price) == 0;
		}

		@Override
		public String toString() {
			return "Titulo: " + this.title + " Price: " + this.price + " Qty: " + this.qty;
		}
		
		@Override
	    public int hashCode() {
	        return Objects.hash(title, price, qty);
	    }
		
		
	
}
