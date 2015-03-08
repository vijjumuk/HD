package com.homedepot.di.xd.efs.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class CSVFileParser implements FileParser {
	private static final String DELIMITER = ",";
	private RecordFormat recordFormat;
	private FileType fileType;
	private static final Logger LOGGER = Logger.getLogger(CSVFileParser.class);
	
	public CSVFileParser(FileType fileType, RecordFormat format) {
		recordFormat = format;
		this.fileType = fileType;
	}
	
	public FileType getFileType() {
		return fileType;
	}
	
	public RecordFormat getRecordFormat() {
		return recordFormat;
	}
	
	public Map<Integer, Object[]> parse(InputStream inputStream) 
			throws FileParserException {
		HashMap<Integer, Object[]> output = new HashMap<Integer, Object[]>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(
					new InputStreamReader(inputStream));
			
			String row =  null;
			Integer rowNumber = 0;
			while ((row = reader.readLine()) != null) {
				if (rowNumber == 0) {
					output.put(rowNumber, parseHeader(row));
					rowNumber++;
					continue;
				}
				else {
					Object[] values = parseRecord(row);
					if(values != null){
						output.put(rowNumber, values);
						rowNumber++;
					}
				}
				LOGGER.error(row);
			}
			
		}
		catch (FormatException ioe) { 
			throw new FileParserException(ioe.getMessage(), ioe);
		}
		catch (IOException ioe) {
			throw new FileParserException(ioe.getMessage(), ioe);

		}
		finally{
//			try {
//				if(reader != null){
//					reader.close();
//				}
//			} catch (IOException e) {
//				LOGGER.error(e.getMessage(), e);
//			}
		}
				
		return output;
	}
	
	private String[] parseHeader(String record) throws FormatException{
		return record.split(DELIMITER);
	}
	
	private Object[] parseRecord(String record) throws FormatException {
		String[] vals = record.split(DELIMITER);
		if (vals.length != recordFormat.getFieldCount())
			return null;
			/*throw new FormatException("Row:" + record + " does not match " + 
					"record format.");*/
		
		Field[] fields = recordFormat.getFields();
		
		Object[] values = new Object[vals.length];
		
		for (int i = 0; i < vals.length; i++) {
			try {
				if (vals[i] != null) vals[i] = vals[i].trim();
				
				if (fields[i].getType().equals(BigDecimal.class)) {
					values[i] = new BigDecimal(vals[i]);
				}
				else if (fields[i].getType().equals(Double.class)) {
					values[i] = Double.valueOf(vals[i]);
				}
				else if (fields[i].getType().equals(Integer.class)) {
					values[i] = Integer.valueOf(vals[i]);
				}
				else if (fields[i].getType().equals(Short.class)) {
					values[i] = Short.valueOf(vals[i]);
				}
				else if (fields[i].getType().equals(String.class)) {
					values[i] = String.valueOf(vals[i]);
				}
				else if (fields[i].getType().equals(Date.class)) {
					values[i] = parseDate(vals[i]);
				}
				else {
					throw new FormatException("Data type " + 
							fields[i].getType().getName() + " is not supported.");
				}

			}
			catch (NumberFormatException nfe) {
				throw new FormatException("Could not cast " + vals[i] + 
						" as a " + fields[i].getType().getName(), nfe);
			}
		}
		
		return values;
		
	}
	
	private Date parseDate(String value) { 
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		
		try {
			date = sdf.parse(value);
		}
		catch (ParseException pe) {
			LOGGER.error(pe.getMessage(), pe);
			return null;
		}
		return date;
	}
	
}
