package com.xhystc.airport.dao.imp;

import com.xhystc.airport.dao.TicketDao;
import com.xhystc.airport.entities.Airline;
import com.xhystc.airport.entities.Ticket;
import org.omg.CORBA.TIMEOUT;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.management.ThreadInfo;
import java.util.Calendar;
import java.util.List;

public class TicketDaoImp implements TicketDao
{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Ticket addTicket(Airline airline, Calendar date, int stock)
	{
		if(airline==null || date==null || stock<0)
			return null;

		Ticket ticket = new Ticket();
		ticket.setAirline(airline);
		ticket.setDate(date);
		ticket.setStock(stock);
		ticket.setTotal(stock);


		entityManager.persist(ticket);

		return ticket;
	}

	@Override
	public List<Ticket> findTickets(Airline airline, Calendar date, boolean stock, int start, int max)
	{
		Calendar currentDate = Calendar.getInstance();

		String queryString = "from Ticket t where '1'='1'";

		if(airline!=null)
			queryString+=" and t.airline= :airline";
		if(date!=null && airline!=null)
			queryString+=" and t.date= :date";
		else
			queryString+=" and t.date> :date";
		if(stock && airline!=null)
			queryString+=" and t.stock > 0";

		Query query = entityManager.createQuery(queryString);

		if(airline!=null)
			query.setParameter("airline",airline);
		if(date!=null)
			query.setParameter("date",date);
		else
			query.setParameter("date",currentDate);
		if(max>0 && start>0)
			query.setFirstResult(start).setMaxResults(max);

		return query.getResultList();
	}

	@Override
	public List<Ticket> findTickets(String dep ,String des, Calendar date, boolean stock, int start, int max)
	{
		Calendar currentDate = Calendar.getInstance();
		String queryString = "from Ticket t where '1'='1' ";

		if(dep!=null && dep.trim().length()>0)
			queryString+=" and t.airline.departure.name like :dep";
		if(des!=null && des.trim().length()>0 )
			queryString+=" and t.airline.destination.name like :des";

		if(date!=null)
			queryString+=" and t.date=:date";
		else
			queryString+=" and t.date> :date";
		if(stock)
			queryString+=" and t.stock > 0";


		Query query = entityManager.createQuery(queryString);

		if(dep!=null && dep.trim().length()>0)
			query.setParameter("dep",dep+"%");
		if(des!=null && des.trim().length()>0)
			query.setParameter("des",des+"%");
		if(date!=null)
			query.setParameter("date",date);
		else
			query.setParameter("date",currentDate);
		if(max>0 && start>0)
			query.setFirstResult(start).setMaxResults(max);
		List<Ticket> ret = query.getResultList();
		System.out.println("search count:"+ret.size());

		return ret;
	}

	@Override
	public List<Ticket> findTickets(Airline airline, boolean stock, int start, int max)
	{
		return findTickets(airline,null,stock,start,max);
	}

	@Override
	public Ticket findTicket(long id, boolean lock)
	{
		Ticket ticket ;
		if(lock)
			ticket  = entityManager.find(Ticket.class,id, LockModeType.OPTIMISTIC);

		else
			ticket = entityManager.find(Ticket.class,id);

		return ticket;
	}

	@Override
	public List<Ticket> findAll(boolean stock,int start, int max)
	{
		return findTickets(null,null,stock,start,max);
	}

	@Override
	public boolean deleteTicket(long id)
	{

		Ticket ticket = entityManager.find(Ticket.class,id);
		if(ticket==null)
			return false;
		entityManager.remove(ticket);

		return true;
	}


}









