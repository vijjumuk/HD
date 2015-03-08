package com.homedepot.di.xd.efs.upload;

public class FileParserFactory {

	public static FileParser getFileParserFor(FileType type) throws FormatException {
		
		return new CSVFileParser(type, 
					RecordFormatFactory.getRecordFormatFor(type));
		
	}
}
