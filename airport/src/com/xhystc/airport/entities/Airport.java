
package com.xhystc.airport.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"location","name"})})
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Airport implements Serializable
{
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "airport_id_table")
	@TableGenerator(name = "airport_id_table",
			table = "hibernate_table",
			pkColumnName = "gen_pk",
			pkColumnValue = "2",
			valueColumnName = "gen_val",
			initialValue = 2,
			allocationSize = 5)
	@Id
	Long id;


	@NotBlank
	@Length(min = 2,max = 20)
	@Column(nullable = false,length = 20)
	String name;

	@NotBlank
	@Length(min = 2,max = 20)
	@Column(nullable = false,length = 20)
	String location;



	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}



	@Override
	public int hashCode()
	{
		return this.getLocation().hashCode()*7+this.getName().hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if(o==this) return true;
		if(o!=null && o.getClass()==this.getClass())
		{
			Airport u = (Airport)o;
			return this.getLocation().equals(u.getLocation()) && this.getName().equals(u.getName()) ;
		}
		return false;
	}

	public Airport(String name,String location)
	{
		this.setName(name);
		this.setLocation(location);
	}
	public Airport()
	{
		name="";
		location="";
	}
}


















