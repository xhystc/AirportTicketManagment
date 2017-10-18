package com.xhystc.airport.entities;

import net.sf.ehcache.search.expression.Or;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "orders")
public class Order implements Serializable
{
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "order_id_table")
	@TableGenerator(name = "order_id_table",
			table = "hibernate_table",
			pkColumnName = "gen_pk",
			pkColumnValue = "5",
			valueColumnName = "gen_val",
			initialValue = 2,
			allocationSize = 5)
	@Id
	Long id;

	@NotNull
	@JoinColumn(nullable = false)
	@ManyToOne(optional = false)
	Ticket ticket;

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	Calendar date;

	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	@NotNull
	User user;

	@Column(nullable = false)
	@NotBlank
	String sit;

	public String getSit()
	{
		return sit;
	}

	public void setSit(String sit)
	{
		this.sit = sit;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Ticket getTicket()
	{
		return ticket;
	}

	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}

	public Calendar getDate()
	{
		return date;
	}

	public void setDate(Calendar date)
	{
		this.date = date;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}


	@Override
	public int hashCode()
	{
		int sum=0;
		if(this.getDate()!=null)
			sum+=this.getDate().hashCode()*7;
		if(this.getTicket()!=null)
			sum+=this.getTicket().hashCode()*5;
		if(this.getSit()!=null)
			sum+=this.getSit().hashCode();
		return sum;
	}

	@Override
	public boolean equals(Object o)
	{
		if(o==this) return true;
		if(o!=null && o.getClass()==this.getClass())
		{
			Order u = (Order) o;
			return this.getUser().equals(u.getUser()) && this.getDate().equals(u.getDate())&&this.getTicket().equals(u.getTicket()) ;
		}
		return false;
	}

}






