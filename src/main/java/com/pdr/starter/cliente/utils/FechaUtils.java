package com.pdr.starter.cliente.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pdr.starter.cliente.repository.CbzPropiedadesCommonRepository;


@Component
public class FechaUtils {

	private static final String FECHA_FORMAT = "dd/MM/yyyy";
	private static final String FECHA_FORMAT_HH_MM = "dd/MM/yyyy HH:mm";

	private static CbzPropiedadesCommonRepository propRepository;

	@Autowired
	private CbzPropiedadesCommonRepository propRepositoyInject;

	@PostConstruct
	void init() {
		propRepository = this.propRepositoyInject;
	}

	public static Date getDate() {
		return propRepository.getDate();
	}

	public static String getDayMonthYear(Date fecha) {
		String fechaString = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' YYYY").format(fecha);
		return fechaString;
	}

	public static String getDay(Date fecha) {
		// Dias de la semana
		String DIA[] = { "DOMINGO", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		return DIA[calendar.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public static Boolean isFestivo(Date fecha) {
		Integer countfest = propRepository.getDiaFestivo(fecha);
		return countfest > 0 ? Boolean.TRUE : Boolean.FALSE;
	}

	public static String dateFormatddmmyyy(Date fecha) {
		SimpleDateFormat x = new SimpleDateFormat(FECHA_FORMAT);
		return x.format(fecha);
	}

	public static Date stringTodateddmmyyyhhmm(String fecha) {
		Date ret = null;
		try {
			SimpleDateFormat x = new SimpleDateFormat(FECHA_FORMAT_HH_MM);
			ret = x.parse(fecha);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ret;
	}

	public static Boolean comparaFechaEquals(Date fecha1, Date fecha2) {
		Boolean ret = Boolean.FALSE;
		if (dateFormatddmmyyy(fecha1).equals(dateFormatddmmyyy(fecha2)))
			ret = Boolean.TRUE;

		return ret;
	}
	
	
	public static Date fechaLimitHours(Date fecha) {
		Date ret = null;
		try {
			String fechaAct =  dateFormatddmmyyy(fecha) + " 23:59";
			return stringTodateddmmyyyhhmm(fechaAct);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ret;
	}

}
