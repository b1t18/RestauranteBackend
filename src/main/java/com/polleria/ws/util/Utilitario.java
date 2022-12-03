package com.polleria.ws.util;

import java.sql.Date;

public class Utilitario 
{
	public Date obtenerFechaActual()
	{
		long miliseconds = System.currentTimeMillis();
		Date date = new Date(miliseconds);
		return date;
	}
}
