package com.stefan.poslovnabanka.jasper;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;

import com.stefan.poslovnabanka.controller.KorisnikController;

import net.sf.jasperreports.data.DataAdapter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Reporti {
	
	public InputStream izvodKlijentaJasper(Map reportParams,JRDataSource jrDataSource) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
	    OutputStream os = new ByteArrayOutputStream();
	    try {
	      String compiledFile = "./reports/IzvodKlijenta.jasper";
	      JasperCompileManager.compileReportToFile("./src/main/java/com/stefan/poslovnabanka/jasper/IzvodKlijenta.jrxml", compiledFile);
	      JasperPrint jrprint = JasperFillManager.fillReport(compiledFile, reportParams,jrDataSource);
	      JasperExportManager.exportReportToPdfFile(jrprint, "./exported/izvod.pdf");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return new ByteArrayInputStream(((ByteArrayOutputStream) os).toByteArray());
	  }
	
public InputStream spisakRacunaJasper(Map reportParams,JRDataSource jrDataSource) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
	    OutputStream os = new ByteArrayOutputStream();
	    try {
	      String compiledFile = "./reports/SpisakRacuna.jasper";
	      JasperCompileManager.compileReportToFile("./src/main/java/com/stefan/poslovnabanka/jasper/SpisakRacuna.jrxml", compiledFile);
	      JasperPrint jrprint = JasperFillManager.fillReport(compiledFile, reportParams,jrDataSource);
	      JasperExportManager.exportReportToPdfFile(jrprint, "./exported/spisak.pdf");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return new ByteArrayInputStream(((ByteArrayOutputStream) os).toByteArray());
	  }
}
