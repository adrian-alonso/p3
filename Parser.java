package p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import javax.servlet.*;

public class Parser {
  String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
  String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
  String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

  String nextFile;
  ArrayList<String> filesList = new ArrayList<String>();
  int files = 0;
  HashMap<String, Document> docsMap = new HashMap<String, Document>();
  HashMap<String, String> urlsMap = new HashMap<String, String>();
  ArrayList<String> degreesList = new ArrayList<String>();
  ArrayList<String> okdregreesURL = new ArrayList<String>();

  //Listas para guardar los errores de las excepciones
  ArrayList<WarningFile> warningsFiles = new ArrayList<WarningFile>();
  ArrayList<ErrorFile> errorsFiles = new ArrayList<ErrorFile>();
  ArrayList<FatalErrorFile> fatalErrorsFiles = new ArrayList<FatalErrorFile>();

  //CONSTRUCTOR
  public Parser() {
  }

  //METODOS
  public HashMap<String,Document> parser(String file_xml, String xsd_url, ServletContext servletcontext) {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setValidating(true);
    dbf.setNamespaceAware(true);

    File file_xsd = new File(xsd_url);
    dbf.setAttribute(JAXP_SCHEMA_LANGUAGE,W3C_XML_SCHEMA);
    dbf.setAttribute(JAXP_SCHEMA_SOURCE,file_xsd);

    DocumentBuilder db = null;
    try {
      db  = dbf.newDocumentBuilder();
    } catch(ParserConfigurationException pce) {
    }

    filesList.add(file_xml);
    files = 1;
    boolean moreEAML = searchEAML(filesList.get(0), db, servletcontext);
    while (files < filesList.size()) {
      moreEAML = searchEAML(filesList.get(files), db, servletcontext);
      files = files+1;
    }

    return docsMap;
  }

  public boolean searchEAML(String url, DocumentBuilder db, ServletContext servletcontext) {
    boolean moreFiles = false;

    //Llama gestor de errores
    EAML_ErrorHandler eaml_ErrorHandler = new EAML_ErrorHandler();
    db.setErrorHandler(eaml_ErrorHandler);

    Document doc = null;
    try {
      doc = db.parse(url);
    } catch(SAXException saxe) {
    } catch (IOException ioe) {
    }

    //Obtenemos archivos EAML
    XPathFactory xpathfactory = XPathFactory.newInstance();
    XPath xpath = xpathfactory.newXPath();
    String exp = "//EAML";

    String degree = null;
    try {

      //Obtenemos el grado
      NodeList degreenode = doc.getElementsByTagName("Name");
      degree = ((Element)degreenode.item(0)).getTextContent();
      //Obtenemos los nodos eaml
      NodeList eamlnodes = (NodeList)xpath.evaluate(exp, doc, XPathConstants.NODESET);

      //Buscamos mas ficheros EAML
      for (int i = 0; i < eamlnodes.getLength(); i++) {
        String nextFile_url = ((Element)eamlnodes.item(i)).getTextContent();
        nextFile = nextFile_url;
        if (!filesList.contains("http://gssi.det.uvigo.es/users/agil/public_html/SINT/20-21/" + nextFile) && !nextFile.equals("")) {
            filesList.add("http://gssi.det.uvigo.es/users/agil/public_html/SINT/20-21/" + nextFile);
            moreFiles = true;
        }
        // if (!filesList.contains(servletcontext.getRealPath("/p3/20-21_EAML/" + nextFile)) && !nextFile.equals("")) {
        //     filesList.add(servletcontext.getRealPath("/p3/20-21_EAML/" + nextFile));
        //     moreFiles = true;
        // }
      }

    } catch(NullPointerException npe) {
    } catch (XPathExpressionException xpe_e) {
    }

    //En caso de warnings
    if (eaml_ErrorHandler.getWarning() == 1) {
      WarningFile warning = new WarningFile(url, eaml_ErrorHandler.getWarningList());
      boolean anywarning = false;
      for (int i = 0; i < warningsFiles.size(); i++) {
        if (warningsFiles.get(i).getWarningID().equals(warning.getWarningID())) {
          anywarning = true;
        }
      }
      if (!anywarning) {
        warningsFiles.add(warning);
      }
    }

    //En caso de errores
    if (eaml_ErrorHandler.getError() == 1) {
      ErrorFile error = new ErrorFile(url, eaml_ErrorHandler.getErrorList());
      boolean anyerror = false;
      for (int i = 0; i < errorsFiles.size(); i++) {
        if (errorsFiles.get(i).getErrorID().equals(error.getErrorID())) {
          anyerror = true;
        }
      }
      if (!anyerror) {
        errorsFiles.add(error);
      }
    }

    //En caso de errores fatales
    if (eaml_ErrorHandler.getFatalError() == 1) {
      FatalErrorFile fatalerror = new FatalErrorFile(url, eaml_ErrorHandler.getFatalErrorList());
      boolean anyfatalerror = false;
      for (int i = 0; i < fatalErrorsFiles.size(); i++) {
        if (fatalErrorsFiles.get(i).getFatalErrorID().equals(fatalerror.getFatalErrorID())) {
          anyfatalerror = true;
        }
      }
      if (!anyfatalerror) {
        fatalErrorsFiles.add(fatalerror);
      }
    }

    //En caso de que el fichero este correcto
    if ((eaml_ErrorHandler.getWarning() == 0) && (eaml_ErrorHandler.getError() == 0) && (eaml_ErrorHandler.getFatalError() == 0)) {
      if ((degree != null) && (!(docsMap.containsKey(degree)))) {
        docsMap.put(degree,doc);
      }
      //Creamos lista con los nombres de las tituaciones y los enlaces a sus respectivos archvivos XML
      if ((degree != null) && (!(urlsMap.containsKey(degree)))) {
        urlsMap.put(degree,url);
      }
    }

    return moreFiles;
  }

  public HashMap<String, String> getDegreesList() {
    return this.urlsMap;
  }

  //METODOS PARA OBTENER LAS LISTAS
  public ArrayList<WarningFile> getWarningsFiles() {
    return warningsFiles;
  }

  public ArrayList<ErrorFile> getErrorsFiles() {
    return errorsFiles;
  }

  public ArrayList<FatalErrorFile> getFatalErrorsFiles() {
    return fatalErrorsFiles;
  }
}
