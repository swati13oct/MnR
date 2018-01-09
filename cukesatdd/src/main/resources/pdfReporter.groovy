@Grab('org.apache.pdfbox:pdfbox:2.0.1')
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File; 
import java.io.IOException;

PDFMergerUtility PDFOverviewMerger = new PDFMergerUtility();
PDFOverviewMerger.setDestinationFileName("target/cucumber-results-feature-overview-merged.pdf");

PDFMergerUtility PDFTestResultsMerger = new PDFMergerUtility();
PDFTestResultsMerger.setDestinationFileName("target/cucumber-results-test-results-merged.pdf");

File pdfFile = new File("target");

for(Object f : pdfFile.list())
{
        if(f.toString().startsWith("RunMRATDD"))
        {
           // println "File name/ folder:::"+f.toString();
            File pdfOverViewFile = new File("target/"+f.toString()+"/cucumber-results-feature-overview.pdf");
            PDFOverviewMerger.addSource(pdfOverViewFile);
            
            File pdfTestResultsFile = new File("target/"+f.toString()+"/cucumber-results-test-results.pdf");
            PDFTestResultsMerger.addSource(pdfTestResultsFile);
        }      
}

PDFOverviewMerger.mergeDocuments();
PDFTestResultsMerger.mergeDocuments();