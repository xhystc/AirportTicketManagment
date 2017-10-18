package com.xhystc.airport.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"airline","date"})})
public class Ticket implements Serializable
{
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ticket_id_table")
	@TableGenerator(name = "ticket_id_table",
			table = "hibernate_table",
			pkColumnName = "gen_pk",
			pkColumnValue = "4",
			valueColumnName = "gen_val",
			initialValue = 2,
			allocationSize = 5)
	@Id
	Long id;

	@Version
	Long version=null;

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	Calendar date;

	@Column(nullable = false)
	@Min(0)
	@NotNull
	int stock;

	@NotNull
	@Column(nullable = false)
	@Min(0)
	int total;


	@ManyToOne(optional = false)
	@NotNull
	@JoinColumn(nullable = false,name = "airline")
	Airline airline;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "ticket")
	Set<Order> orders = new HashSet<>();


	public Set<Order> getOrders()
	{
		return orders;
	}

	public void setOrders(Set<Order> orders)
	{
		this.orders = orders;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

	public Calendar getDate()
	{
		return date;
	}

	public void setDate(Calendar date)
	{
		this.date = date;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public Airline getAirline()
	{
		return airline;
	}

	public void setAirline(Airline airline)
	{
		this.airline = airline;
	}

	@Override
	public int hashCode()
	{
		return this.getAirline().hashCode()*7+this.getDate().hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if(o==this) return true;
		if(o!=null && o.getClass()==this.getClass())
		{
			Ticket u = (Ticket)o;
			return this.getAirline().equals(u.getAirline()) && this.getDate().equals(u.getDate()) ;
		}
		return false;
	}

	public void updateTotal(int n)
	{
			stock+=n-total;
			total=n;
			return;
	}
	public boolean backTicket(int n)
	{
		if(n+stock>total)
			return false;
		stock+=n;
		return true;
	}
	public boolean takeTicket(int n)
	{
		if(n>stock)
			return false;
		stock-=n;
		return true;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

}
















