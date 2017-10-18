package com.xhystc.airport.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Airline implements Serializable
{
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "airline_id_table")
	@TableGenerator(name = "airline_id_table",
			table = "hibernate_table",
			pkColumnName = "gen_pk",
			pkColumnValue = "3",
			valueColumnName = "gen_val",
			initialValue = 2,
			allocationSize = 5)
	@Id
	Long id=null;

	@NotBlank
	@Column(nullable = false)
	String plane;

	@NotNull
	@JoinColumn(nullable = false)
	@ManyToOne(optional = false)
	Airport destination;

	@NotNull
	@JoinColumn(nullable = false)
	@ManyToOne(optional = false)
	Airport departure;

	@NotNull
	AirlineTime time;


	@JsonIgnore
	@BatchSize(size = 5)
	@OneToMany(mappedBy = "airline",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	Set<Ticket> tickets = new HashSet<>();



	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Airport getDestination()
	{
		return destination;
	}

	public void setDestination(Airport destination)
	{
		this.destination = destination;
	}

	public Airport getDeparture()
	{
		return departure;
	}

	public void setDeparture(Airport departure)
	{
		this.departure = departure;
	}

	public String getPlane()
	{
		return plane;
	}

	public void setPlane(String plane)
	{
		this.plane = plane;
	}

	public Set<Ticket> getTickets()
	{
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets)
	{
		this.tickets = tickets;
	}

	public AirlineTime getTime()
	{
		return time;
	}

	public void setTime(AirlineTime time)
	{
		this.time = time;
	}

	@Override
	public int hashCode()
	{
		return this.getPlane().hashCode()*7+this.getTime().hashCode()*3
				+this.getDeparture().hashCode()*5+getDestination().hashCode();
	}


	@Override
	public boolean equals(Object o)
	{
		if(o==this) return true;
		if(o!=null && o.getClass()==this.getClass())
		{
			Airline u = (Airline)o;
			return this.getDestination().equals(u.getDestination()) && this.getDeparture().equals(u.getDeparture()) &&
					this.getPlane().equals(u.plane)&&this.getTime().equals(u.getTime());

		}
		return false;
	}

	public Airline(Airport departure,Airport destination,AirlineTime airlineTime,String plane)
	{
		this.setDeparture(departure);
		this.setDestination(destination);
		this.setTime(airlineTime);
		this.setPlane(plane);
	}
	public Airline()
	{

	}

}













