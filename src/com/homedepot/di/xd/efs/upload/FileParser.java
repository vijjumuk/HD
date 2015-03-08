package com.homedepot.di.xd.efs.upload;

import java.io.InputStream;
import java.util.Map;

public interface FileParser {

	public Map<Integer, Object[]> parse(InputStream inputStream) 
				throws FileParserException;
	
	public FileType getFileType();
	
	public RecordFormat getRecordFormat();
	
}
