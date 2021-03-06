package com.groupdocs.comparison.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import com.groupdocs.comparison.Informer;
import com.groupdocs.comparison.common.documentinfo.DocumentInfo;
import com.groupdocs.comparison.common.license.License;
import com.groupdocs.comparison.common.license.Metered;
//ExStart:commonutilitiesclass
public class Utilities {

	// ExStart:CommonProperties
	
	public final static String sourcePath = "./Data/SourceFiles/";
	public final static String targetPath = "./Data/TargetFiles/";
	public static final String resultFilePath = "./Data/ResultFiles/";
	public static final String resultImagePath = "Data/ResultFiles/ResultImages/";
	public final static String resultFile = "result";
	public static final String licensePath = "E://GroupDocs.Total.Java.lic";
	public final static String sourcePassword = "pass";
	public final static String targetPassword = "pass";
	public static String outputFileName(String extension) {
		String resultPath = resultFilePath + resultFile + extension;
		return resultPath;
	}
	// ExEnd:CommonProperties

	/**
	 * This method applies product license from file
	 * 
	 */
	public static void applyLicenseFromFile() {
		//ExStart:applyLicenseFromFile
		try {
			// Setup license
			License lic = new License();
			lic.setLicense(licensePath);
			if(License.isValidLicense()){
				System.out.println("License is validated");
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		//ExEnd:applyLicenseFromFile
	}
	/*
	 * get project base directories
	 */
	public static Path getProjectBaseDir() {
		Properties props = new Properties();
		try {
			InputStream i = Utilities.class.getResourceAsStream("/project.properties");
			props.load(i);
		} catch (IOException x) {
			throw new RuntimeException(x);
		}
		return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
	}
	/**
	 * This method applies product license from stream
	 * 
	 */
	public static void applyLicenseFromStream(String filePath) {
		// ExStart:ApplyLicenseFromStreamObj
		try {
			// Obtain license stream
			FileInputStream licenseStream = new FileInputStream(filePath);

			// Setup license
			License lic = new License();
			lic.setLicense(licenseStream);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:ApplyLicenseFromStreamObj
	}
	
	public static void meteredLicense(String filePath) {
		// ExStart:meteredLicense
		try {
			// Obtain license stream
			Metered metered = new Metered();
			metered.setMeteredKey("****", "****");
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:meteredLicense
	}
	
	public static void getDocumentInfo(String sourceFile) {
		// ExStart:getDocumentInfo
		Informer informer = new Informer();
		// Get information about document from filePath
		String sourceFilePath = sourcePath + sourceFile;
		DocumentInfo documentInfo = informer.getDocumentInfo(sourceFilePath);
		// ExEnd:getDocumentInfo
	}
	
	public static InputStream sourceStream(String sourceFile) throws Throwable {
		String sourceFilePath = sourcePath + sourceFile;
		InputStream sourceStream = new FileInputStream(sourceFilePath);
		return sourceStream;
	}
	public static InputStream targetStream(String targetFile) throws Throwable {
		String targetFilePath = targetPath + targetFile;
		InputStream targetStream = new FileInputStream(targetFilePath);
		return targetStream;
	
	}
}
//ExEnd:commonutilitiesclass
