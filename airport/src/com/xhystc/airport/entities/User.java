package com.xhystc.airport.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.sf.ehcache.search.expression.Not;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.beans.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable
{
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "user_id_table")
	@TableGenerator(name = "user_id_table",
			table = "hibernate_table",
			pkColumnName = "gen_pk",
			pkColumnValue = "6",
			valueColumnName = "gen_val",
			initialValue = 2,
			allocationSize = 5)
	@Id
	Long id;

	@Length(min=4,max=20)
	@NotBlank
	@Column(unique = true,nullable = false,length = 20)
	String username;


	@Length(min=4,max=20)
	@NotBlank
	@Column(nullable = false,length = 20)
	String password;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "user",fetch = FetchType.EAGER)
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

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public int hashCode()
	{
		/*int sum=0;
		if(this.getUsername()!=null)
			sum+=this.getUsername().hashCode();
		if(this.getPassword()!=null)
			sum+=this.getPassword().hashCode();
		return sum;*/
		if(this.getPassword()==null)
			System.out.println("password null");
		if(this.getUsername()==null)
			System.out.println("username null");

		return this.getUsername().hashCode()*5+this.getPassword().hashCode();

	}

	@Override
	public boolean equals(Object o)
	{
		if(o==this) return true;
		if(o!=null && o.getClass()==this.getClass())
		{
			User u = (User)o;
			return this.getUsername().equals(u.getUsername()) && getPassword().equals(u.getPassword());
		}
		return false;
	}

	public User(String username,String password)
	{
		this.setUsername(username);
		this.setPassword(password);
	}
	public User()
	{
		this.password="";
		this.username="";
	}

}















