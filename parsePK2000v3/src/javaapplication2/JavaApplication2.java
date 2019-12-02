/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static javaapplication2.JavaApplication6.*;

/**
 *
 * @author K3123
 */
public class JavaApplication2 {
    
   static int paragCTL1 = 0; 
   static int paragCTL2 = 0;
   static StringBuilder taskE = new StringBuilder();
   static StringBuilder taskG = new StringBuilder();
   
   static List<Integer> positionMain = new ArrayList<Integer>();
    
     /**
      * The following procedure will load the content of a file into a List of 
      * JavaParser objects
      * @param args List of string parameters to access the file
      * @param stemF - Boolean status that indicates if Stemming has been 
      * flagged
      * @return - The following function returns the a multi-dimensional array
      */  
  public static List<JavaParser>  mainFileLoader( String[] args, boolean stemF ) 
     {
        String[] docData = new String[2];
        String readdata1;
        String dataValue;
        int j = 0;
        List<JavaParser> javaWordList = new ArrayList<JavaParser>();
      
        try
        {   
          
            Scanner scan = new Scanner(new FileInputStream(args[0]));
            while(scan.hasNextLine())
            { 
              readdata1 = scan.nextLine();  
                               
              if ( readdata1.contains("<P ID=")){
                    docData = readdata1.split("=");
                    docData[1] = docData[1].replace(">","");
                    paragCT++;
                    System.out.println("Current Document : " + docData[1]);
              }
                for(String data : readdata1.split(","))
                {
                    dataValue = cleanWord(data,stemF);
                    if (validateWord(data)){
                              
                       if (! wordExists(javaWordList,dataValue) ){
                            
                             JavaParser newWord = new JavaParser();
                             newWord.setwordId(j++);
                             newWord.setCollectionFrequency(1);
                             newWord.setwordName(dataValue);
                             newWord.addActualWord(data);
                             newWord.addDocMapStruct(docData[1]);
                             newWord.addDocListStruct(docData[1]);
                             newWord.addDocumentID(docData[1]);
                             javaWordList.add(newWord);
                            
                        }else{
 
                           JavaParser existingWord = wordSearch(javaWordList,
                                   dataValue);
                     
                           existingWord.setCollectionFrequency
                          (existingWord.getCollectionFrequency()+1);
                           existingWord.addDocumentID(docData[1]); 
                           existingWord.updateDocMapStruct(docData[1]);
                           existingWord.updateDocListStruct(docData[1]);
                           existingWord.addActualWord(data);
                         
                        }                  
                    }
                }
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println("Cannot Open File" + e.getMessage());
        }
        
         return javaWordList;
  }
  
    /**
   * The following function will search the dictionary based on the provided 
   * word name and return the corresponding JavaParser object
   * @param word - List of JavaParser objects
   * @param selection - word that is used to search the list of JavaParser 
   * objects
   * @return - JavaParser objected identified during the search
   */
  public static JavaParser1 wordSearch1( List<JavaParser1>  word, 
            String selection )
  {
        JavaParser1 validateCheck = new JavaParser1();
        
        for(JavaParser1 data : word)
          {
            if( data.getwordName().toLowerCase().equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               validateCheck = data; 
               break;
             }          
          }   
        return validateCheck;
  }
  
    /**
    * Function will determine the number of objects in a file that is larger 
    * than 80000. 
    * @param dataS - Integer value that indicates if a import file contains 
    * queries or documents and also if Stem was flagged
    */
   public static void serializedNCount(int dataS){
        
        String type;
        int count = 0;
        
        switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;               
            case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    

            default : type = dictFileList[1];
                      break;
        }
 
     try {
                
                FileInputStream file = new FileInputStream(type);
                ObjectInputStream in = new ObjectInputStream(file);
                List<nameList> tempObj;
                while((tempObj = (List<nameList>) in.readObject()) != null){
                count++;
                }
                in.close();
           } catch (FileNotFoundException e) {
              System.out.printf("System can not find file : %s %n", 
                          type);
 
           } catch (EOFException e) {
             System.out.printf("System has found %d objects in file : %s %n", 
                          count,type);
                  
           } catch (IOException e) {
             System.out.printf("System had issue with file : %s %n", 
                          type);
           } catch (ClassNotFoundException ex) {
             System.out.printf("System had Class issue with file : %s %n", 
                          type);
         }
     
     
         serilizationData.add(new documentID1(type,count));
    
   }
     /**
    * Function will determine the number of objects in a file that is larger 
    * than 80000. 
    * @param dataS - Integer value that indicates if a import file contains 
    * queries or documents and also if Stem was flagged
    */
   public static void serializedWCount(int dataS){
        
        String type;
        int count = 0;
        
        switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;               
             case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    

            default : type = dictFileList[1];
                      break;
        }
 
     try {
                
                FileInputStream file = new FileInputStream(type);
                ObjectInputStream in = new ObjectInputStream(file);
                List<Web_Query_Data> tempObj;
                while((tempObj = (List<Web_Query_Data>) in.readObject()) != null){
                count++;
                }
                in.close();
           } catch (FileNotFoundException e) {
              System.out.printf("System can not find file : %s %n", 
                          type);
 
           } catch (EOFException e) {
             System.out.printf("System has found %d objects in file : %s %n", 
                          count,type);
                  
           } catch (IOException e) {
             System.out.printf("System had issue with file : %s %n", 
                          type);
           } catch (ClassNotFoundException ex) {
             System.out.printf("System had Class issue with file : %s %n", 
                          type);
         }
     
     
         serilizationData.add(new documentID1(type,count));
    
   }
   
   public static void serializedPKCount(int dataS){
        
        String type;
        int count = 0;
        
        switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;               
             case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    

            default : type = dictFileList[1];
                      break;
        }
 
     try {
                
                FileInputStream file = new FileInputStream(type);
                ObjectInputStream in = new ObjectInputStream(file);
                List<PK2000Data> tempObj;
                while((tempObj = (List<PK2000Data>) in.readObject()) != null){
                count++;
                }
                in.close();
           } catch (FileNotFoundException e) {
              System.out.printf("System can not find file : %s %n", 
                          type);
 
           } catch (EOFException e) {
             System.out.printf("System has found %d objects in file : %s %n", 
                          count,type);
                  
           } catch (IOException e) {
             System.out.printf("System had issue with file : %s %n", 
                          type);
           } catch (ClassNotFoundException ex) {
             System.out.printf("System had Class issue with file : %s %n", 
                          type);
         }
     
     
         serilizationData.add(new documentID1(type,count));
    
   } 
   
   
  public static void serializedQCount(int dataS){
        
        String type;
        int count = 0;
        
        switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;               
             case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    
            default : type = dictFileList[1];
                      break;
        }
 
     try {
                
                FileInputStream file = new FileInputStream(type);
                ObjectInputStream in = new ObjectInputStream(file);
                List<queryData2> tempObj;
                while((tempObj = (List<queryData2>) in.readObject()) != null){
                count++;
                }
                in.close();
           } catch (FileNotFoundException e) {
              System.out.printf("System can not find file : %s %n", 
                          type);
 
           } catch (EOFException e) {
             System.out.printf("System has found %d objects in file : %s %n", 
                          count,type);
                  
           } catch (IOException e) {
             System.out.printf("System had issue with file : %s %n", 
                          type);
           } catch (ClassNotFoundException ex) {
             System.out.printf("System had Class issue with file : %s %n", 
                          type);
         }
     
     
         serilizationData.add(new documentID1(type,count));
    
   }
   /**
    * Function sorts the dictionary and writes the results to a file specified 
    * by the user
    * @param word - List of JavaParser objects 
    * @param dataS - Integer value that indicates if a import file contains 
    * queries or documents and also if Stem was flagged
    */   
  
  public static nameList nameSearch1( List<nameList>  word, 
            String selection )
  {
        nameList validateCheck = new nameList();
        
        for(nameList data : word)
          {
            if( data.getName().toLowerCase().equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               validateCheck = data; 
               break;
             }          
          }   
        return validateCheck;
  }
  
  public static Web_Query_Data webSearch1( List<Web_Query_Data>  word, 
            String selection )
  {
        Web_Query_Data validateCheck = new Web_Query_Data();
        
        for(Web_Query_Data data : word)
          {
            if( data.getUserID().toLowerCase().equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               validateCheck = data; 
               break;
             }          
          }   
        return validateCheck;
  }  
  public static queryData2 querySearch1( List<queryData2>  word, 
            String selection )
  {
        queryData2 validateCheck = new queryData2();
        
        for(queryData2 data : word)
          {
            if( data.getQuery1().toLowerCase().equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               validateCheck = data; 
               break;
             }          
          }   
        return validateCheck;
  } 
 /**
  * The following function will determine if a word exists in the dictionary 
  * and returns a boolean result
  * @param word -  List of JavaParser objects
  * @param selection - String word that will be used to search the JavaParser 
  * objects
  * @return - boolean result of searching the list of JavaParser objects 
  */
  public static boolean wordExists1(  List<JavaParser1>  word, 
            String selection) 
    {
        
        for(JavaParser1 data : word)
          {
            if( data.getwordName().toLowerCase().
                    equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               return true; 
         
            }
          }
        return false;
    }
  
    public static boolean webExists1(  List<Web_Query_Data>  word, 
            String selection) 
    {
        
        for(Web_Query_Data data : word)
          {
            if( data.getUserID().toLowerCase().
                    equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               return true; 
         
            }
          }
        return false;
    }
    public static boolean queryExists1(  List<queryData2>  word, 
            String selection) 
    {
        
        for(queryData2 data : word)
          {
            if( data.getQuery1().toLowerCase().
                    equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               return true; 
         
            }
          }
        return false;
    } 
    
    
   public static boolean nameExists1(  List<nameList>  word, 
            String selection) 
    {
        
        for(nameList data : word)
          {
            if( data.getName().toLowerCase().
                    equalsIgnoreCase(selection.
                    toLowerCase()))
            {
               return true; 
         
            }
          }
        return false;
    }
   /**
      * The following procedure will load the content of a file into a List of 
      * JavaParser objects
      * @param args List of string parameters to access the file
      * @param stemF - Boolean status that indicates if Stemming has been 
      * flagged
      * @return - The following function returns the a multi-dimensional array
      */  
  public static List<Web_Query_Data>  mainFileLoaderW( String[] args) 
     {
        
        String readdata1;
        int countE = 0, countG = 0;
        
        int j = 0;
        List<Web_Query_Data> javaWordList = new ArrayList<Web_Query_Data>();
      
        try
        {   
          
            Scanner scan = new Scanner(new FileInputStream(args[0] + 
                    args[1]));
            while(scan.hasNextLine())
            { 
              readdata1 = scan.nextLine();  
              paragCT++;                 
            
            int count = readdata1.split("\\t").length;
            
            String[] docData = new String[count];  
            docData = readdata1.split("\\t");
             System.out.printf("%d Current Document : %s %n",paragCT,readdata1);
                 
                   if ( count > 1 ){
                       if (docData[1].toLowerCase().
                               matches(taskG.toString()) == false ){
                            if ( taskG.length() <=0 ){
                              taskG.append(docData[1].toLowerCase());
                            }else{
                              taskG.append("|").append(docData[1].toLowerCase()); 
                             }
                             Web_Query_Data newWord = new Web_Query_Data();
                             newWord.setWebDocID(j++);
                             newWord.setTimeStamp(docData[0]);
                             newWord.setUserID(docData[1].toLowerCase());
                             newWord.setRankNum(Integer.parseInt(docData[2]));
            
                             if ( count > 3 ){
                               newWord.setQueryData(docData[3]);
                               newWord.addQueryDetails(docData[3]);
                               newWord.addQueryInfo(docData[3], docData[0], 
                                     docData[2]);
                             }
                             newWord.setQueryCT(1);
                             javaWordList.add(newWord);
                            
                        }else{
 
                          Web_Query_Data existingWord = webSearch1(javaWordList,
                                   docData[1].toLowerCase());
                           existingWord.setQueryCT(existingWord.
                                   getQueryCT() + 1);
                           if ( count > 3 ){
                           if ( existingWord.getQueryDetails().
                                   indexOf(docData[3]) < 0 ){
                               existingWord.addQueryDetails(docData[3]);
                               existingWord.addQueryInfo(docData[3], docData[0], 
                                     docData[2]);
                           }
                           }
                   
                        }                  
 
                }
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println("Cannot Open File" + e.getMessage());
        }

         return javaWordList;
  }   
  
   public static List<PK2000Data>  mainFileLoaderPK( String[] args) 
     {
        
        String readdata1;
        StringBuilder consolidatePK = new StringBuilder();
        int countE = 0, countG = 0;
        
        int j = 0;
        List<PK2000Data> javaWordList = new ArrayList<PK2000Data>();
      
        try
        {   
          
            Scanner scan = new Scanner(new FileInputStream(args[0] + 
                    args[1]));
            while(scan.hasNextLine())
            { 
              readdata1 = scan.nextLine().replaceAll("\n", "").
                      replaceAll("\r",  "");
              readdata1 = readdata1.replace("\r\n", " ").replace("\n", " "); 
              readdata1 = readdata1.replaceAll("\n", "").replaceAll("\r", "");
              paragCT++;                 
            
            int count = readdata1.split(",").length;
            
            String[] docData = new String[count * 2];  
            docData = readdata1.split(",");
             System.out.printf("%d Current Document : %s %n",paragCT,readdata1);
             System.out.printf("%d Current Document : %s %n",docData.length,cleanWord(docData[0],false));
                 if (cleanWord(docData[0],false).contains("problemid") == false){
                            PK2000Data newWord = new PK2000Data();
                            newWord.setPAC2000ID(j++);
                            newWord.setProblemID(docData[0]);
                            newWord.setApplication(docData[1]);
                            newWord.setSeverity(docData[2]);
                            newWord.setPriority(docData[3]);
                            newWord.setBriefProblemSummar(docData[4]);
                            consolidatePK.append(docData[4]).
                                    append(" ");
                            newWord.setTypeReqVSx(docData[5]);
                            newWord.setCauseCode(docData[6]);
                             consolidatePK.append(docData[6]).
                                    append(" ");
                            newWord.setStatus(docData[7]);
                            newWord.setDTReported(docData[8]);
                            newWord.setDDMonthYr(docData[9]);
                            newWord.setDTClosed(docData[10]);
                            newWord.setDTResolved(docData[11]);
                            newWord.setEACO(docData[12]);
                            newWord.setEACOIssueID(docData[13]);
                            newWord.setOwnerGroup(docData[14]);
                            newWord.setResponsibleGroup(docData[15]);
                            newWord.setClosedBy(docData[16]);
                            newWord.setClosedByGroupx002(docData[17]);
                            newWord.setResolutionID(docData[18]);
                            newWord.setResolvedBy(docData[19]);
                            newWord.setResolvedByGroupx0(docData[20]);
                            newWord.setRCARespTech(docData[21]);
                            newWord.setRCAResponsibleGrou(docData[22]);
                            newWord.setRCASearchString(docData[23]);
                            newWord.setRCAStatus(docData[24]);
                            newWord.setCoADOU(docData[25]);
                            newWord.setCoEmpIDx00(docData[26]);
                            newWord.setCoFirstName(docData[27]);
                            newWord.setOData(docData[28]);
                            newWord.setAddress(docData[29]);
                            newWord.setCity(docData[30]);
                            newWord.setState(docData[31]);
                            newWord.setSubmitDT(docData[32]);
                            newWord.setSubmitterGroup(docData[33]);
                            newWord.setSubmitterTechnologyx0020(docData[34]);
                            newWord.setPlatform(docData[35]);
                            newWord.setAssignee(docData[36]);
                            newWord.setType1(docData[37]);
                            newWord.setSubType(docData[38]);
                            newWord.setResolvedDuration(docData[39]);
                            newWord.setClosedDuration(docData[40]);
                            newWord.setActualDuration(docData[41]);
                            newWord.setActualDurationHRs(docData[42]);
                            newWord.setBusinessImpactClas(docData[43]);
                            newWord.setOData3rdPartyInvo(docData[44]);
                            newWord.setOData4BlockerRequ(docData[45]);
                            newWord.setMajorProblemReview(docData[46]);
                            newWord.setTimelineRequiredx(docData[47]);
                            newWord.setRootCauseAnalysis(docData[48]);
                            newWord.setType1GroupId(docData[49]);
                            newWord.setExcelDTRepo(docData[50]);
                            newWord.setExcelDTClos(docData[51]);
                            newWord.setExcelSubmitDx002f(docData[52]);
                            newWord.setExcelDTReso(docData[53]);
                            newWord.setExcelDailyDate(docData[54]);
                            newWord.setODataOID(docData[55]);
                            newWord.setClassPK2000(docData[56]);
                            newWord.setID1(docData[57]);
                            newWord.setModified(docData[58]);
                            newWord.setCreated(docData[59]);
                            newWord.setAuthorId(docData[60]);
                            newWord.setEditorId(docData[61]);
                            newWord.setODataUIVersionString(docData[62]);
                            newWord.setAttachments(docData[63]);
                            newWord.setGUID(docData[64]);
                            newWord.setMonthYear(docData[65]);
                            newWord.setWeekEnding(docData[66]);
                            newWord.setDayMonthYear(docData[67]);
                            newWord.setRankNum(newWord.getPAC2000ID());
                            newWord.setTextFullDetails(consolidatePK.toString());
    
                            newWord.setQueryCT(1);
                            javaWordList.add(newWord);
                            consolidatePK.delete(1, consolidatePK.length());
                 }
                }                  
 
                
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println("Cannot Open File" + e.getMessage());
        }

         return javaWordList;
  }   
   
   
   public static List<queryData2> update1(List<queryData2> wordW){
      String http = "((http:\\/\\/|https:\\/\\/)?(www.)?(([a-zA-Z0-9-]){2,}\\.){1,4}([a-zA-Z]){2,6}(\\/([a-zA-Z-_\\/\\.0-9#:?=&;,]*)?)?)";

       List<queryData2> newW = new ArrayList<queryData2>();
       
       newW.addAll(wordW);
       
         for ( queryData2 data1 : newW ){
           if(data1.getQuery1().toLowerCase().startsWith("what")){
              data1.setQuestion(Boolean.TRUE);
           }
           if (data1.getQuery1().toLowerCase().matches(http) == true){
              data1.setWebSite(Boolean.TRUE);
           } 
           if(data1.getQuery1().toLowerCase().startsWith("who")){
              data1.setQuestion(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().startsWith("where")){
              data1.setQuestion(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().startsWith("when")){
              data1.setQuestion(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().startsWith("why")){
              data1.setQuestion(Boolean.TRUE);
           } 
           if(data1.getQuery1().toLowerCase().startsWith("could")){
              data1.setQuestion(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().endsWith("?")){
              data1.setQuestion(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().contains("al gore")){
               data1.setNameAlGore(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().contains("johns hopkins")){
               data1.setNameJohnHs(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().contains("john hopkins")){
               data1.setNameJohnH(Boolean.TRUE);
           }
           if(data1.getQuery1().toLowerCase().contains("www.") &&
                 data1.getQuery1().toLowerCase().contains(".com")  ){
               data1.setWebSite(Boolean.TRUE);
           }
          if(data1.getQuery1().toLowerCase().contains("http:\\/\\/.") &&
                 data1.getQuery1().toLowerCase().contains(".html")  ){
               data1.setWebSite(Boolean.TRUE);
           } 
          if(data1.getQuery1().toLowerCase().contains("http:\\/\\/.")) {
               data1.setWebSite(Boolean.TRUE);
           }
         if( data1.getQuery1().matches("[A-Z]&&[^a-z]") == true  ){
               data1.setAllUpper(Boolean.TRUE);
           } 
         if( data1.getQuery1().matches("[a-z]&&[^A-Z]") == true  ){
               data1.setAllLower(Boolean.TRUE);
           } 
         if( data1.getQuery1().matches("[a-z]&&[A-Z]") == true  ){
               data1.setMixedW(Boolean.TRUE);
           } 
         }
       return newW;
       
   } 
   
   public static List<queryData2> mainQueryLoader(List<Web_Query_Data> wordW){
        processTimeData("mainQueryLoader","started");
       List<queryData2> dataQ = new ArrayList<queryData2>();
       int j = 0;
       for(Web_Query_Data dataW : wordW){
           for(String dataB : dataW.getQueryDetails().toString().
                   split("\\|")){
               if ( queryExists1(dataQ,dataB) == false){
                 queryData2 newQ = new queryData2();
                 newQ.setQueryID(j++);
                 newQ.setQueryCT(1);
                 newQ.setQuery1(dataB);
                 newQ.addUserID(dataW.getUserID());
                 dataQ.add(newQ);
               }else{
                  queryData2 newO = querySearch1(dataQ,dataB);
                  newO.setQueryCT(newO.getQueryCT() + 1);
                  newO.addUserID(dataW.getUserID());
               }
           }   
           
       }
        processTimeData("mainQueryLoader","ended");
       return dataQ;
       
   }

   public static List<queryData2> mainQueryLoader2(List<Web_Query_Data> wordW){
        processTimeData("mainQueryLoader2","started");
       List<queryData2> dataQ = new ArrayList<queryData2>();
       int j = 0;
       for(Web_Query_Data dataW : wordW){
           for(String dataB : dataW.getQueryDetails().toString().
                   split("\\|")){
               if ( queryExists1(dataQ,dataB) == false){
                 queryData2 newQ = new queryData2();
                 newQ.setQueryID(j++);
                 newQ.setQueryCT(1);
                 newQ.setQuery1(dataB);
                 for(documentID3 dataWQ :dataW.getQueryInfo() ){
                     for(String dataQ1 : dataWQ.getTimeStamp()){
                       newQ.addTimeS(dataQ1);
                     }
                     for(int dataQ2 : dataWQ.getPosition()){
                         newQ.addRankS(Integer.toString(dataQ2));
                     }
                     
                 }
                 newQ.addUserID(dataW.getUserID());
                 dataQ.add(newQ);
               }else{
                  queryData2 newO = querySearch1(dataQ,dataB);
                  newO.setQueryCT(newO.getQueryCT() + 1);
                  newO.addUserID(dataW.getUserID());
                  for(documentID3 dataWQ :dataW.getQueryInfo() ){
                     for(String dataQ1 : dataWQ.getTimeStamp()){
                       newO.addTimeS(dataQ1);
                     }
                     for(int dataQ2 : dataWQ.getPosition()){
                         newO.addRankS(Integer.toString(dataQ2));
                     }
                     
                 }
               }
           }   
           
       }
       processTimeData("mainQueryLoader2","ended");
       return dataQ;
       
   }
   
   public static List<JavaParser> mainWordLoader1(List<queryData2> query,
           boolean stemF){
        processTimeData("mainWordLoader1","started");
       List<JavaParser> wordD = new ArrayList<JavaParser>();
       int j = 0;
       for(queryData2 queryD : query){
          String qID =  Integer.toString(queryD.getQueryID());
           for(String dataQ : queryD.getQuery1().split(" ")){
                String dataValue = cleanWord(dataQ,stemF);
                    if (validateWord(dataValue)){      
                       if (! wordExists(wordD,dataValue) ){
                            
                             JavaParser newWord = new JavaParser();
                             newWord.setwordId(j);
                             newWord.setCollectionFrequency(1);
                             newWord.setwordName(dataValue);
                             newWord.addActualWord(dataQ);
                             newWord.addDocMapStruct(qID);
                             newWord.addDocListStruct(qID);
                             newWord.addDocumentID(qID);
                             newWord.setWordType("non-stopword");
                             wordD.add(newWord);
                            
                        }else{
 
                           JavaParser existingWord = wordSearch(wordD,
                                   dataValue);
                           existingWord.setCollectionFrequency
                          (existingWord.getCollectionFrequency()+1);
                           existingWord.addDocumentID(qID); 
                           existingWord.updateDocMapStruct(qID);
                           existingWord.updateDocListStruct(qID);
                           existingWord.addActualWord(dataQ);
                         
                        }
              }else if (dataValue.toLowerCase().matches(stopWords.
                      toLowerCase()) == true){
                       if (! wordExists(wordD,dataValue) ){
                             JavaParser newWord = new JavaParser();
                             newWord.setwordId(j);
                             newWord.setCollectionFrequency(1);
                             newWord.setwordName(dataValue);
                             newWord.addActualWord(dataQ);
                             newWord.addDocMapStruct(qID);
                             newWord.addDocListStruct(qID);
                             newWord.addDocumentID(qID);
                             newWord.setWordType("stopword");
                             wordD.add(newWord);
                            
                        }else{
 
                           JavaParser existingWord = wordSearch(wordD,
                                   dataValue);
                           existingWord.setCollectionFrequency
                          (existingWord.getCollectionFrequency()+1);
                           existingWord.addDocumentID(qID); 
                           existingWord.updateDocMapStruct(qID);
                           existingWord.updateDocListStruct(qID);
                           existingWord.addActualWord(dataQ);
                         
                        }
          }
       }
      }
        processTimeData("mainWordLoader1","ended");
       return wordD;
   }
   
   
   public static List<JavaParser> mainPKLoader1(List<PK2000Data> query,
           boolean stemF){
       processTimeData("mainPKLoader1","started");
       List<JavaParser> wordD = new ArrayList<JavaParser>();
       int j = 0;
       int count;
       for(PK2000Data queryD : query){
          count = queryD.getTextFullDetails().split(" ").length;          
          String qID =  Integer.toString(queryD.getPAC2000ID());
           for(String dataQ : queryD.getTextFullDetails().split(" ")){
               System.out.println(dataQ);
                String dataValue = cleanWord(dataQ,stemF);
                    if (validateWord(dataValue)){      
                       if (! wordExists(wordD,dataValue) ){
                             JavaParser newWord = new JavaParser();
                             newWord.setwordId(j);
                          if ( queryD.getTypeReqVSx().toLowerCase().
                                     contains("incident") == true){
                              newWord.setIncidentCT(newWord.getIncidentCT() + 1);
                           }else{
                              newWord.setRequestCT(newWord.getRequestCT() + 1);
                          }
               
                             newWord.setCollectionFrequency(1);
                             newWord.setwordName(dataValue);
                             newWord.addActualWord(dataQ);
                             newWord.addDocMapStruct(qID);
                             newWord.addDocListStruct(queryD.getProblemID());
                             newWord.addDocumentID(qID);
                             newWord.setWordType("non-stopword");
                             wordD.add(newWord);
                            
                        }else{
 
                           JavaParser existingWord = wordSearch(wordD,
                                   dataValue);
                         if ( queryD.getTypeReqVSx().toLowerCase().
                                     contains("incident") == true){
                              existingWord.setIncidentCT(existingWord.getIncidentCT() + 1);
                           }else{
                              existingWord.setRequestCT(existingWord.getRequestCT() + 1);
                          }
                           existingWord.setCollectionFrequency
                          (existingWord.getCollectionFrequency()+1);
                           existingWord.addDocumentID(qID); 
                           existingWord.updateDocMapStruct(qID);
                           existingWord.updateDocListStruct(queryD.getProblemID());
                           existingWord.addActualWord(dataQ);
                         
                        }
              }else if (dataValue.toLowerCase().matches(stopWords.
                      toLowerCase()) == true){
                       if (! wordExists(wordD,dataValue) ){
                             JavaParser newWord = new JavaParser();
                             newWord.setwordId(j);
                             newWord.setCollectionFrequency(1);
                             newWord.setwordName(dataValue);
                             newWord.addActualWord(dataQ);
                             newWord.addDocMapStruct(qID);
                              if ( queryD.getTypeReqVSx().toLowerCase().
                                     contains("incident") == true){
                              newWord.setIncidentCT(newWord.getIncidentCT() + 1);
                           }else{
                              newWord.setRequestCT(newWord.getRequestCT() + 1);
                          }
                             newWord.addDocListStruct(queryD.getProblemID());
                             newWord.addDocumentID(qID);
                             newWord.setWordType("stopword");
                             wordD.add(newWord);
                            
                        }else{
 
                           JavaParser existingWord = wordSearch(wordD,
                                   dataValue);
                           existingWord.setCollectionFrequency
                          (existingWord.getCollectionFrequency()+1);
                           existingWord.addDocumentID(qID); 
                           existingWord.updateDocMapStruct(qID);
                          if ( queryD.getTypeReqVSx().toLowerCase().
                                     contains("incident") == true){
                              existingWord.setIncidentCT(existingWord.getIncidentCT() + 1);
                           }else{
                              existingWord.setRequestCT(existingWord.getRequestCT() + 1);
                          }
                           existingWord.updateDocListStruct(queryD.getProblemID());
                           existingWord.addActualWord(dataQ);
                         
                        }
          }
       }
      }
        processTimeData("mainPKLoader1","ended");
       return wordD;
   }
   
   public static List<nameList> mainLoader(String[] args) {
        // TODO code application logic here
         processTimeData("mainLoader","started");
        File folder = new File("D:\\Downloads\\names\\");
        File[] listOfFiles = folder.listFiles();
        String[] docData = new String[2];
        StringBuilder dataF = new StringBuilder();
        StringBuilder dataFX = new StringBuilder();
        List<nameList> nameL2= new ArrayList<nameList>();
        String readdata1;
        String dataValue;
        String oldFileName;
        int j = 0;
 for (File file : listOfFiles) {
  if (file.isFile()&& file.getName().contains("yob") ) {
       oldFileName = file.getName();
       System.out.printf("%d Yes we were working on %s %n",j, oldFileName);
      try {
         
          Scanner scan = new Scanner(file);
           while(scan.hasNextLine())
            { 
              readdata1 = scan.nextLine();
              String[] data = new String[4];
              data = readdata1.split(",");
              
               if ( data[0].toLowerCase().matches(taskE.
                       toString()) == false){
                   
                  nameList nameW = new nameList();
              
                  if ( taskE.length() <=0 ){
                     taskE.append(data[0].toLowerCase());
                  }else{
                     taskE.append("|").append(data[0].toLowerCase()); 
                  }
                  nameW.setName(data[0].toLowerCase());
                  nameW.setGender(data[1]);
                  nameW.setYear(Integer.parseInt(data[2]));
                  nameW.setNameCt(1);
                  nameL2.add(nameW);
               }else{
                  nameList nameS = nameSearch1(nameL2,data[0]);
                  nameS.setNameCt(nameS.getNameCt() + 1);
               }
               j++;
            }
            
           scan.close();
          // Scanner 
      } catch (FileNotFoundException ex) {
         ex.printStackTrace();
      }
      
      
      
  }
 }
  processTimeData("mainLoader","ended");     
  return  nameL2;
  
  }
   
   /**
   * Function that imports data from the lexicon used for keyword search
   * @param dataS - Integer value that indicates if a import file contains 
   * queries or documents and also if Stem was flagged
   * @return - JavaParser object
   */
  public static List<nameList> deserializeDictionaryName(int dataS){
      List<nameList>  word = new ArrayList<nameList>();
      processTimeData("deserializeDictionaryName","started");
      String outFile;
       switch(dataS){
            case 1 : outFile = dictFileList[2];
                           break;
            case 3 : outFile = dictFileList[1];
                           break;
            case 0 : outFile = dictFileList[6];
                           break;
            case 2 : outFile = dictFileList[5];
                         break;
            case 4 : outFile = dictFileList[14];
                         break;
            case 5 : outFile = dictFileList[15];
                         break;       
            case 6 : outFile = dictFileList[16];
                         break;       
            case 7 : outFile = dictFileList[17];
                         break;                                
            default :   outFile = dictFileList[1];
                      break;
        }
      
       try {
                
                ObjectInputStream in = new ObjectInputStream(new 
                FileInputStream(outFile));
                List<nameList> tempObj;
                int count = searchSeriData(serilizationData,outFile);
                if ( count > 1 ){
                    for(int i = 0; i < count; i++ ){
                        tempObj = (List<nameList>) in.readObject();
                        word.addAll(tempObj);
                    }
                }else{
                  word = (List<nameList>) in.readObject();
                }
                if (debugType.equalsIgnoreCase("Debug6")){
                System.out.println("Serialized data is read from " + 
                        outFile);
                }
                in.close();
           } catch (FileNotFoundException e) {
                  System.out.printf("System can not find file : %s %n", 
                          outFile);
           } catch (IOException e) {
                  System.out.printf("System had issue with file : %s %n", 
                          outFile);
            } catch (ClassNotFoundException e) {
               e.printStackTrace();
        }
     
      processTimeData("deserializeDictionaryName","ended");
      return word;
  }

   /**
   * Function that imports data from the lexicon used for keyword search
   * @param dataS - Integer value that indicates if a import file contains 
   * queries or documents and also if Stem was flagged
   * @return - JavaParser object
   */
  public static List<Web_Query_Data> deserializeDictionaryWeb(int dataS){
      List<Web_Query_Data>  word = new ArrayList<Web_Query_Data>();
      processTimeData("deserializeDictionaryWeb","started");
      String outFile;
       switch(dataS){
            case 1 : outFile = dictFileList[2];
                           break;
            case 3 : outFile = dictFileList[1];
                           break;
            case 0 : outFile = dictFileList[6];
                           break;
            case 2 : outFile = dictFileList[5];
                         break;
            case 4 : outFile = dictFileList[14];
                         break;
            case 5 : outFile = dictFileList[15];
                         break;       
            case 6 : outFile = dictFileList[16];
                         break;       
            case 7 : outFile = dictFileList[17];
                         break;                                
            default :   outFile = dictFileList[1];
                      break;
        }
      
       try {
                
                ObjectInputStream in = new ObjectInputStream(new 
                FileInputStream(outFile));
                List<Web_Query_Data> tempObj;
                int count = searchSeriData(serilizationData,outFile);
                if ( count > 1 ){
                    for(int i = 0; i < count; i++ ){
                        tempObj = (List<Web_Query_Data>) in.readObject();
                        word.addAll(tempObj);
                    }
                }else{
                  word = (List<Web_Query_Data>) in.readObject();
                }
                if (debugType.equalsIgnoreCase("Debug6")){
                System.out.println("Serialized data is read from " + 
                        outFile);
                }
                in.close();
           } catch (FileNotFoundException e) {
                  System.out.printf("System can not find file : %s %n", 
                          outFile);
           } catch (IOException e) {
                  System.out.printf("System had issue with file : %s %n", 
                          outFile);
            } catch (ClassNotFoundException e) {
               e.printStackTrace();
        }
     
      processTimeData("deserializeDictionaryWeb","ended");
      return word;
  }
  
  public static List<PK2000Data> deserializeDictionaryPK(int dataS){
      List<PK2000Data>  word = new ArrayList<PK2000Data>();
      processTimeData("deserializeDictionaryPK","started");
      String outFile;
       switch(dataS){
            case 1 : outFile = dictFileList[2];
                           break;
            case 3 : outFile = dictFileList[1];
                           break;
            case 0 : outFile = dictFileList[6];
                           break;
            case 2 : outFile = dictFileList[5];
                         break;
            case 4 : outFile = dictFileList[14];
                         break;
            case 5 : outFile = dictFileList[15];
                         break;       
            case 6 : outFile = dictFileList[16];
                         break;       
            case 7 : outFile = dictFileList[17];
                         break;                                
            default :   outFile = dictFileList[1];
                      break;
        }
      
       try {
                
                ObjectInputStream in = new ObjectInputStream(new 
                FileInputStream(outFile));
                List<PK2000Data> tempObj;
                int count = searchSeriData(serilizationData,outFile);
                if ( count > 1 ){
                    for(int i = 0; i < count; i++ ){
                        tempObj = (List<PK2000Data>) in.readObject();
                        word.addAll(tempObj);
                    }
                }else{
                  word = (List<PK2000Data>) in.readObject();
                }
                if (debugType.equalsIgnoreCase("Debug6")){
                System.out.println("Serialized data is read from " + 
                        outFile);
                }
                in.close();
           } catch (FileNotFoundException e) {
                  System.out.printf("System can not find file : %s %n", 
                          outFile);
           } catch (IOException e) {
                  System.out.printf("System had issue with file : %s %n", 
                          outFile);
            } catch (ClassNotFoundException e) {
               e.printStackTrace();
        }
     
      processTimeData("deserializeDictionaryPK","ended");
      return word;
  }
  
 /**
   * Function that imports data from the lexicon used for keyword search
   * @param dataS - Integer value that indicates if a import file contains 
   * queries or documents and also if Stem was flagged
   * @return - JavaParser object
   */
  public static List<queryData2> deserializeDictionaryQuery(int dataS){
      List<queryData2>  word = new ArrayList<queryData2>();
      processTimeData("deserializeDictionaryQuery","started");
      String outFile;
       switch(dataS){
            case 1 : outFile = dictFileList[2];
                           break;
            case 3 : outFile = dictFileList[1];
                           break;
            case 0 : outFile = dictFileList[6];
                           break;
            case 2 : outFile = dictFileList[5];
                         break;
            case 4 : outFile = dictFileList[14];
                         break;
            case 5 : outFile = dictFileList[15];
                         break;       
            case 6 : outFile = dictFileList[16];
                         break;       
            case 7 : outFile = dictFileList[17];
                         break;                                
            default :   outFile = dictFileList[1];
                      break;
        }
      
       try {
                
                ObjectInputStream in = new ObjectInputStream(new 
                FileInputStream(outFile));
                List<queryData2> tempObj;
                int count = searchSeriData(serilizationData,outFile);
                if ( count > 1 ){
                    for(int i = 0; i < count; i++ ){
                        tempObj = (List<queryData2>) in.readObject();
                        word.addAll(tempObj);
                    }
                }else{
                  word = (List<queryData2>) in.readObject();
                }
                if (debugType.equalsIgnoreCase("Debug6")){
                System.out.println("Serialized data is read from " + 
                        outFile);
                }
                in.close();
           } catch (FileNotFoundException e) {
                  System.out.printf("System can not find file : %s %n", 
                          outFile);
           } catch (IOException e) {
                  System.out.printf("System had issue with file : %s %n", 
                          outFile);
            } catch (ClassNotFoundException e) {
               e.printStackTrace();
        }
     
      processTimeData("deserializeDictionaryQuery","ended");
      return word;
  }
    /**
    * Function will determine the number of objects in a file that is larger 
    * than 80000. 
    * @param dataS - Integer value that indicates if a import file contains 
    * queries or documents and also if Stem was flagged
    */
   public static void serializedFCount(int dataS){
        
        String type;
        int count = 0;
        
        switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;           
            case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                                               
            default : type = dictFileList[1];
                      break;
        }
 
     try {
                
                FileInputStream file = new FileInputStream(type);
                ObjectInputStream in = new ObjectInputStream(file);
                List<JavaParser> tempObj;
                while((tempObj = (List<JavaParser>) in.readObject()) != null){
                count++;
                }
                in.close();
           } catch (FileNotFoundException e) {
              System.out.printf("System can not find file : %s %n", 
                          type);
 
           } catch (EOFException e) {
             System.out.printf("System has found %d objects in file : %s %n", 
                          count,type);
                  
           } catch (IOException e) {
             System.out.printf("System had issue with file : %s %n", 
                          type);
           } catch (ClassNotFoundException ex) {
             System.out.printf("System had Class issue with file : %s %n", 
                          type);
         }
     
     
         serilizationData.add(new documentID1(type,count));
    
   }
   /**
    * Function sorts the dictionary and writes the results to a file specified 
    * by the user
    * @param word - List of JavaParser objects 
    * @param dataS - Integer value that indicates if a import file contains 
    * queries or documents and also if Stem was flagged
    */   
 
   public static void serializeDictionaryName(List<nameList>  word, 
           int dataS){
          Collections.sort(word, nameList.NameComparator);
          FileOutputStream fileOut;
          String type;
         processTimeData("serializeDictionaryName","started");          
         switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;     
            case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    
            default : type = dictFileList[1];
                      break;
        }
           
          try {
             fileOut = new FileOutputStream(type);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(word);
             out.close();
             fileOut.close();
           } catch (FileNotFoundException e) {

                  e.printStackTrace();
           } catch (IOException e) {

                  e.printStackTrace();
           }  
         processTimeData("serializeDictionaryName","ended");
     }
    
  /**
    * Function sorts the dictionary, then writes the results to a default file
    * @param word - List of JavaParser objects 
    * @param dataS - Integer value that indicates if a import file contains 
    * queries or documents and also if Stem was flagged 
    */  
   public static void serializeDictionaryWeb(List<Web_Query_Data>  word, 
           int dataS){
          Collections.sort(word, Web_Query_Data.WebComparator);
          FileOutputStream fileOut;
          String type;
         processTimeData("serializeDictionaryWeb","started");          
         switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;     
            case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    
            default : type = dictFileList[1];
                      break;
        }
           
          try {
               if (debugType.equalsIgnoreCase("Debug3")){
                System.out.printf("Actual size %d splitter num %d %s %n ",
                      word.size(),
                      word.size()/splitNumber[0], type);
               }
             if ( word.size()/splitNumber[0] >= 100 ){
               List<Web_Query_Data> wordSplit1 = new ArrayList<Web_Query_Data>();
              
              wordSplit1.addAll( word.subList(0, (word.size()/63)));
              fileOut = new FileOutputStream(type);
              ObjectOutputStream out1 = new ObjectOutputStream(fileOut);
              out1.writeObject(wordSplit1);
              out1.close();
              int countP = word.size()/splitNumber[0];
              int countP2 = countP * 2;
              int countP3 = word.size();
              int count = 0;
              for(int i = countP + 1 ; i <= word.size(); ){ 
              fileOut = new FileOutputStream(type,true);
              AppendOutputStream out2 = new AppendOutputStream(fileOut){
                                @Override
                protected void writeStreamHeader() throws IOException {
                  reset();
                }
              };
               wordSplit1 = new ArrayList<Web_Query_Data>(); 
               if (debugType.equalsIgnoreCase("Debug3")){
               System.out.printf("Exporting objects %d to %d to %s %n",
                       i,countP2,type);
               }
               wordSplit1.addAll(word.subList(i, countP2));
               out2.writeObject(wordSplit1);
               out2.close();
               i = countP2 + 1;
               countP2 = countP2 + countP;
               count++;
               if (countP2 > countP3){
                   countP2 = countP3;
               }
              }
              serilizationData.add(new documentID1(type,count));
             }else{
                fileOut = new FileOutputStream(type);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(word);
                out.close();
                fileOut.close();
            }

           } catch (IOException e) {
                  e.printStackTrace();
           }  
           
         processTimeData("serializeDictionaryWeb","ended");
     }
    
   
   public static void serializeDictionaryPK(List<PK2000Data>  word, 
           int dataS){
          Collections.sort(word, PK2000Data.PK2000Comparator);
          FileOutputStream fileOut;
          String type;
         processTimeData("serializeDictionaryPK","started");          
         switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;     
            case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    
            default : type = dictFileList[1];
                      break;
        }
           
          try {
               if (debugType.equalsIgnoreCase("Debug3")){
                System.out.printf("Actual size %d splitter num %d %s %n ",
                      word.size(),
                      word.size()/splitNumber[0], type);
               }
             if ( word.size()/splitNumber[0] >= 100 ){
               List<PK2000Data> wordSplit1 = new ArrayList<PK2000Data>();
              
              wordSplit1.addAll( word.subList(0, (word.size()/63)));
              fileOut = new FileOutputStream(type);
              ObjectOutputStream out1 = new ObjectOutputStream(fileOut);
              out1.writeObject(wordSplit1);
              out1.close();
              int countP = word.size()/splitNumber[0];
              int countP2 = countP * 2;
              int countP3 = word.size();
              int count = 0;
              for(int i = countP + 1 ; i <= word.size(); ){ 
              fileOut = new FileOutputStream(type,true);
              AppendOutputStream out2 = new AppendOutputStream(fileOut){
                                @Override
                protected void writeStreamHeader() throws IOException {
                  reset();
                }
              };
               wordSplit1 = new ArrayList<PK2000Data>(); 
               if (debugType.equalsIgnoreCase("Debug3")){
               System.out.printf("Exporting objects %d to %d to %s %n",
                       i,countP2,type);
               }
               wordSplit1.addAll(word.subList(i, countP2));
               out2.writeObject(wordSplit1);
               out2.close();
               i = countP2 + 1;
               countP2 = countP2 + countP;
               count++;
               if (countP2 > countP3){
                   countP2 = countP3;
               }
              }
              serilizationData.add(new documentID1(type,count));
             }else{
                fileOut = new FileOutputStream(type);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(word);
                out.close();
                fileOut.close();
            }

           } catch (IOException e) {
                  e.printStackTrace();
           }  
           
         processTimeData("serializeDictionaryPK","ended");
     }
    
    /**
    * Function sorts the dictionary, then writes the results to a default file
    * @param word - List of JavaParser objects 
    * @param dataS - Integer value that indicates if a import file contains 
    * queries or documents and also if Stem was flagged 
    */  
   public static void serializeDictionaryQuery(List<queryData2>  word, 
           int dataS){
          Collections.sort(word, queryData2.QueryComparator);
          FileOutputStream fileOut;
          String type;
         processTimeData("serializeDictionaryQuery","started");          
         switch(dataS){
            case 1 : type = dictFileList[2];
                           break;
            case 3 : type = dictFileList[1];
                           break;
            case 0 : type = dictFileList[6];
                           break;
            case 2 : type = dictFileList[5];
                           break;     
            case 4 : type = dictFileList[14];
                           break;                
            case 5 : type = dictFileList[15];
                           break;         
            case 6 : type = dictFileList[16];
                           break;         
            case 7 : type = dictFileList[17];
                           break;            
            case 8 : type = dictFileList[18];
                           break;                                    
            default : type = dictFileList[1];
                      break;
        }
           
          try {
               if (debugType.equalsIgnoreCase("Debug3")){
                System.out.printf("Actual size %d splitter num %d %s %n ",
                      word.size(),
                      word.size()/splitNumber[0], type);
               }
             if ( word.size()/splitNumber[0] >= 100 ){
               List<queryData2> wordSplit1 = new ArrayList<queryData2>();
              
              wordSplit1.addAll( word.subList(0, (word.size()/63)));
              fileOut = new FileOutputStream(type);
              ObjectOutputStream out1 = new ObjectOutputStream(fileOut);
              out1.writeObject(wordSplit1);
              out1.close();
              int countP = word.size()/splitNumber[0];
              int countP2 = countP * 2;
              int countP3 = word.size();
              int count = 0;
              for(int i = countP + 1 ; i <= word.size(); ){ 
              fileOut = new FileOutputStream(type,true);
              AppendOutputStream out2 = new AppendOutputStream(fileOut){
                                @Override
                protected void writeStreamHeader() throws IOException {
                  reset();
                }
              };
               wordSplit1 = new ArrayList<queryData2>(); 
               if (debugType.equalsIgnoreCase("Debug3")){
               System.out.printf("Exporting objects %d to %d to %s %n",
                       i,countP2,type);
               }
               wordSplit1.addAll(word.subList(i, countP2));
               out2.writeObject(wordSplit1);
               out2.close();
               i = countP2 + 1;
               countP2 = countP2 + countP;
               count++;
               if (countP2 > countP3){
                   countP2 = countP3;
               }
              }
              serilizationData.add(new documentID1(type,count));
             }else{
                fileOut = new FileOutputStream(type);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(word);
                out.close();
                fileOut.close();
            }

           } catch (IOException e) {
                  e.printStackTrace();
           }  
          
         processTimeData("serializeDictionaryQuery","ended");
     }
     
   
   /**
  * Function will display the complete list of javaFinalParser objects that contain
  * the word represented by the string w 
  * @param word - List of javaFinalParser objects
  * @param w - String word to use to search the list of JavaParser objects
  */
 public static void printWordDetailsNameS(List<nameList>  word, String w )
  {
       int count = 0, count2 = 0;
       Collections.sort(word,new nameList());  
       float m;  
          
        for(nameList data : word)
          {
            if(data.getName().equalsIgnoreCase(w.toLowerCase())){
            System.out.printf("%-20s %-20s %-20s %n","Name","Gender",
                    "Name Frequence");
                System.out.printf("%-20s %-2s %-5d %n",data.getName(),
                  data.getGender(),
                  data.getNameCt());
                  count = count + data.getNameCt();
                  count2++;
            }
          }
         if (count2 == 0 ){
             System.out.println(w + " was not found in the dictionary ");
         }
  }
 
    /**
  * Function will display the complete list of javaFinalParser objects that contain
  * the word represented by the string w 
  * @param word - List of javaFinalParser objects
  * @param w - String word to use to search the list of JavaParser objects
  */
 public static void printWordDetailsName(List<nameList>  word)
  {
       int count = 0, count2 = 0;
       Collections.sort(word,new nameList());  
       float m;  
       
       System.out.printf("%-15s %-2s %-5s %n","Name","G",
                    "Freq");       
        for(nameList data : word)
          {
            

                System.out.printf("%-15s %-2s %-5d %n",
                  data.getName(),
                  data.getGender(),
                  data.getNameCt());
                  count = count + data.getNameCt();
                  count2++;
            
          }
        
  }
 
 /**
  * Function will display the complete list of javaFinalParser objects that contain
  * the word represented by the string w 
  * @param word - List of javaFinalParser objects
  * @param w - String word to use to search the list of JavaParser objects
  */
 public static void printWordDetailWeb(List<Web_Query_Data>  word)
  {
       int count = 0, count2 = 0;
       Collections.sort(word,new Web_Query_Data());  
       float m;  
       
       System.out.printf("%-15s %-2s %-5s %n","Name","G",
                    "Freq");       
        for(Web_Query_Data data : word)
          {
            

                System.out.printf("%-15s %-2s %-5d %n",
                  data.getUserID(),
                  data.getTimeStamp(),
                  data.getQueryCT());
                  count = count + data.getQueryCT();
                  count2++;
            
          }
        
  }
 
 public static void printWordDetailPK2000(List<PK2000Data>  word)
  {
       int count = 0, count2 = 0;
       Collections.sort(word,new PK2000Data());  
       float m;  
       
       System.out.printf("%-5s %-15s %-2s %-5s %n","ID","Name","G",
                    "Freq");       
        for(PK2000Data data : word)
          {

                System.out.printf("%-5d %-15s %-20s %-5d %n",
                  data.getPAC2000ID(),
                  data.getProblemID(),
                  data.getApplication(),
                  data.getQueryCT());
                  count = count + data.getQueryCT();
                  count2++;
            
          }
        
  }
 
  public static void printWordDetailQeury(List<queryData2>  query)
  {
       int count = 0, count2 = 0;
       Collections.sort(query,queryData2.QueryCTComparator);  
       
       System.out.printf("%-300s %-2s %-20s %n","Query","Freq", "UserIDs");       
        for(queryData2 data : query)
          {
            

                  System.out.printf("%-300s %-5d ",
                  data.getQuery1(),
                  data.getQueryCT());
                  count = count + data.getQueryCT();
                  for(documentID1 userD : data.getUserID()){
                      System.out.printf(" (%s , %d) ", userD.getDocID(),
                              userD.getTermCount());
                  }
                  System.out.println();
                  count2++;
                  if ( count2 <= 21 ){
                      break;
                  }
          }
        
  }
  
    public static void mainInt(String[] args, Boolean stemF){
        
        List<PK2000Data> webM = new ArrayList<PK2000Data>();
        List<JavaParser> wordD2 = new ArrayList<JavaParser>();
        
        int[] queryDataS = new int[20]; 
           if ( stemF == false){
               queryDataS[0] =  1;
               queryDataS[1] =  3;
               queryDataS[2] =  4;
               queryDataS[3] =  5;
               queryDataS[4] =  6;
               queryDataS[5] =  7;
               queryDataS[6] =  8;
           }else{
               queryDataS[0] =  0;
               queryDataS[1] =  2; 
               queryDataS[2] =  4;
               queryDataS[3] =  5;
               queryDataS[4] =  6;
               queryDataS[5] =  7;
               queryDataS[6] =  8;
               
           }

        if ( checkFileExist(queryDataS[1],"I") == false){
            webM = mainFileLoaderPK(args);
            serializeDictionaryPK(webM,queryDataS[1]);
        }else{
            serializedPKCount(queryDataS[1]);   
            webM = deserializeDictionaryPK(queryDataS[1]); 
        }
        printWordDetailPK2000(webM);
      
   
        if ( checkFileExist(queryDataS[5],"I") == false ){
            wordD2 = mainPKLoader1(webM,false);
            serializeFDictionary(wordD2,queryDataS[5]);
        }else{
            serializedQCount(queryDataS[5]);
            wordD2 = deserializeDictionary(queryDataS[5]);
        }
        
        printWordDetails(wordD2);
        printDocIDWordDetails2(wordD2);
    }
   
    /**
     * @param args the command line arguments
     */
  /**
     * This procedure is the main portion of the program that will be used to 
     * initialize the application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length == 2 ){ 
           setFilesDetails(args[0]);
           splitNumber[0] = 64;
           splitNumber[1] = 2;
           processTimeData("main","started");
           mainInt(args,false);
           processTimeData("main","ended");
        }else{ 
           System.out.println("Please enter the location and filename of the "
                   + "input file that contains the corpus and "
                   + "input file that contains the queries. Also, please "
                   + "enter the location that will store the output files "
                   + "and enter a number from (1-50) for the "
                   + "number of concurrent processes to run. Note : "
                   + "if your memory is under 16 GB, it is recommended to "
                   + "select a small number between (1-5).");
           System.out.printf("Ex: %s %s %s %d %n", "C:\\Users\\k3123\\Documents"
                   + "\\fire10.en.utf81", "C:\\Users\\k3123\\Documents\\fire10."
                   +"topics.txt","C:\\Users\\K3123\\Documents\\", 63);
              
           System.out.printf("Ex: %s %s %s %d %n", "D:\\John Hopkins School\\"
                   + "fire10.en.utf81", "D:\\John Hopkins School\\fire10"
                   + "topics.txt","D:\\John Hopkins School\\" , 63);
           
        }
                
    }
    
    
}
