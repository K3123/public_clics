/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author u480031
 */
public class PK2000Data implements Comparator<PK2000Data>, 
        Serializable{

private int  PAC2000ID ; 
private String ProblemID ;
private String Application ;
private String Severity ;
private String Priority ;
private String BriefProblemSummar ;
private String TypeReqVSx ;
private String CauseCode ;
private String Status ;
private String DTReported ;
private String DDMonthYr ;
private String DTClosed ;
private String DTResolved ;
private String EACO ;
private String EACOIssueID ;
private String OwnerGroup ;
private String ResponsibleGroup ;
private String ClosedBy ;
private String ClosedByGroupx002 ;
private String ResolutionID ;
private String ResolvedBy ;
private String ResolvedByGroupx0 ;
private String RCARespTech ;
private String RCAResponsibleGrou ;
private String RCASearchString ;
private String RCAStatus ;
private String CoADOU ;
private String CoEmpIDx00 ;
private String CoFirstName ;
private String OData ;
private String Address ;
private String City ;
private String State ;
private String SubmitDT ;
private String SubmitterGroup ;
private String SubmitterTechnologyx0020 ;
private String Platform ;
private String Assignee ;
private String Type1 ;
private String SubType ;
private String ResolvedDuration ;
private String ClosedDuration ;
private String ActualDuration ;
private String ActualDurationHRs ;
private String BusinessImpactClas ;
private String OData3rdPartyInvo ;
private String OData4BlockerRequ ;
private String MajorProblemReview ;
private String TimelineRequiredx ;
private String RootCauseAnalysis ;
private String Type1GroupId ;
private String ExcelDTRepo ;
private String ExcelDTClos ;
private String ExcelSubmitDx002f ;
private String ExcelDTReso ;
private String ExcelDailyDate ;
private String ODataOID ;
private String ClassPK2000 ;
private String ID1 ;
private String Modified ;
private String Created ;
private String AuthorId ;
private String EditorId ;
private String ODataUIVersionString ;
private String Attachments ;
private String GUID ;
private String MonthYear ;
private String WeekEnding ;
private String DayMonthYear ;
private Boolean question = false;
private Boolean stopW = false;
private Boolean mixedW = false;
private int coutWords = 0;
private int countChar = 0;
private int rankNum;
private String queryData;
private int queryCT = 0;
private StringBuilder textFullDetails = new StringBuilder();

public String getTextFullDetails() {
    return textFullDetails.toString();
}

public void setTextFullDetails(String textFullDetails) {
    this.textFullDetails.append(textFullDetails);
}


public PK2000Data() {
    
}

public int getQueryCT() {
        return queryCT;
}


public void setQueryCT(int queryCT) {
        this.queryCT = queryCT;
}

    public Boolean getStopW() {
        return stopW;
    }

    public void setStopW(Boolean stopW) {
        this.stopW = stopW;
    }

    public Boolean getMixedW() {
        return mixedW;
    }

    public void setMixedW(Boolean mixedW) {
        this.mixedW = mixedW;
    }

    public int getPAC2000ID() {
        return PAC2000ID;
    }

    public void setPAC2000ID(int PAC2000ID) {
        this.PAC2000ID = PAC2000ID;
    }

    public Boolean getQuestion() {
        return question;
    }

    public void setQuestion(Boolean question) {
        this.question = question;
    }

    public int getCoutWords() {
        return coutWords;
    }

    public void setCoutWords(int coutWords) {
        this.coutWords = coutWords;
    }

    public int getCountChar() {
        return countChar;
    }

    public void setCountChar(int countChar) {
        this.countChar = countChar;
    }

    public int getRankNum() {
        return rankNum;
    }

    public void setRankNum(int rankNum) {
        this.rankNum = rankNum;
    }

    public String getQueryData() {
        return queryData;
    }

    public void setQueryData(String queryData) {
        this.queryData = queryData;
    }

public static Comparator<PK2000Data>  PK2000Comparator = 
            new Comparator<PK2000Data>() {

	public int compare(PK2000Data s1, PK2000Data s2) {
	   String word1 = s1.getProblemID().toLowerCase();
	   String word2 = s2.getProblemID ().toLowerCase();
	   //ascending order
	   return word1.compareTo(word2);

    }};
public PK2000Data(String ProblemID, String Application, String Severity, 
            String Priority,String BriefProblemSummar, String TypeReqVSx, 
            String CauseCode, String Status, String DTReported, 
            String DDMonthYr, String DTClosed, String DTResolved, String EACO, 
            String EACOIssueID, String OwnerGroup, String ResponsibleGroup, 
            String ClosedBy, String ClosedByGroupx002, String ResolutionID, 
            String ResolvedBy, String ResolvedByGroupx0, String RCARespTech, 
            String RCAResponsibleGrou, String RCASearchString, String RCAStatus, 
            String CoADOU, String CoEmpIDx00, String CoFirstName, String OData, 
            String Address, String City, String State, String SubmitDT, 
            String SubmitterGroup, String SubmitterTechnologyx0020, 
            String Platform, String Assignee, String Type1, String SubType, 
            String ResolvedDuration, String ClosedDuration, 
            String ActualDuration, String ActualDurationHRs, 
            String BusinessImpactClas, String OData3rdPartyInvo, 
            String OData4BlockerRequ, String MajorProblemReview, 
            String TimelineRequiredx, String RootCauseAnalysis, 
            String Type1GroupId, String ExcelDTRepo, String ExcelDTClos, 
            String ExcelSubmitDx002f, String ExcelDTReso, String ExcelDailyDate, 
            String ODataOID, String ClassPK2000, String ID1, String Modified, 
            String Created, String AuthorId, String EditorId, 
            String ODataUIVersionString, String Attachments, 
            String GUID, String MonthYear, String WeekEnding, 
            String DayMonthYear) {
        this.ProblemID = ProblemID;
        this.Application = Application;
        this.Severity = Severity;
        this.Priority = Priority;
        this.BriefProblemSummar = BriefProblemSummar;
        this.TypeReqVSx = TypeReqVSx;
        this.CauseCode = CauseCode;
        this.Status = Status;
        this.DTReported = DTReported;
        this.DDMonthYr = DDMonthYr;
        this.DTClosed = DTClosed;
        this.DTResolved = DTResolved;
        this.EACO = EACO;
        this.EACOIssueID = EACOIssueID;
        this.OwnerGroup = OwnerGroup;
        this.ResponsibleGroup = ResponsibleGroup;
        this.ClosedBy = ClosedBy;
        this.ClosedByGroupx002 = ClosedByGroupx002;
        this.ResolutionID = ResolutionID;
        this.ResolvedBy = ResolvedBy;
        this.ResolvedByGroupx0 = ResolvedByGroupx0;
        this.RCARespTech = RCARespTech;
        this.RCAResponsibleGrou = RCAResponsibleGrou;
        this.RCASearchString = RCASearchString;
        this.RCAStatus = RCAStatus;
        this.CoADOU = CoADOU;
        this.CoEmpIDx00 = CoEmpIDx00;
        this.CoFirstName = CoFirstName;
        this.OData = OData;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.SubmitDT = SubmitDT;
        this.SubmitterGroup = SubmitterGroup;
        this.SubmitterTechnologyx0020 = SubmitterTechnologyx0020;
        this.Platform = Platform;
        this.Assignee = Assignee;
        this.Type1 = Type1;
        this.SubType = SubType;
        this.ResolvedDuration = ResolvedDuration;
        this.ClosedDuration = ClosedDuration;
        this.ActualDuration = ActualDuration;
        this.ActualDurationHRs = ActualDurationHRs;
        this.BusinessImpactClas = BusinessImpactClas;
        this.OData3rdPartyInvo = OData3rdPartyInvo;
        this.OData4BlockerRequ = OData4BlockerRequ;
        this.MajorProblemReview = MajorProblemReview;
        this.TimelineRequiredx = TimelineRequiredx;
        this.RootCauseAnalysis = RootCauseAnalysis;
        this.Type1GroupId = Type1GroupId;
        this.ExcelDTRepo = ExcelDTRepo;
        this.ExcelDTClos = ExcelDTClos;
        this.ExcelSubmitDx002f = ExcelSubmitDx002f;
        this.ExcelDTReso = ExcelDTReso;
        this.ExcelDailyDate = ExcelDailyDate;
        this.ODataOID = ODataOID;
        this.ClassPK2000 = ClassPK2000;
        this.ID1 = ID1;
        this.Modified = Modified;
        this.Created = Created;
        this.AuthorId = AuthorId;
        this.EditorId = EditorId;
        this.ODataUIVersionString = ODataUIVersionString;
        this.Attachments = Attachments;
        this.GUID = GUID;
        this.MonthYear = MonthYear;
        this.WeekEnding = WeekEnding;
        this.DayMonthYear = DayMonthYear;
    }

    public String getProblemID() {
        return ProblemID;
    }

    public void setProblemID(String ProblemID) {
        this.ProblemID = ProblemID;
    }

    public String getApplication() {
        return Application;
    }

    public void setApplication(String Application) {
        this.Application = Application;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String Severity) {
        this.Severity = Severity;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String Priority) {
        this.Priority = Priority;
    }

    public String getBriefProblemSummar() {
        return BriefProblemSummar;
    }

    public void setBriefProblemSummar(String BriefProblemSummar) {
        this.BriefProblemSummar = BriefProblemSummar;
    }

    public String getTypeReqVSx() {
        return TypeReqVSx;
    }

    public void setTypeReqVSx(String TypeReqVSx) {
        this.TypeReqVSx = TypeReqVSx;
    }

    public String getCauseCode() {
        return CauseCode;
    }

    public void setCauseCode(String CauseCode) {
        this.CauseCode = CauseCode;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getDTReported() {
        return DTReported;
    }

    public void setDTReported(String DTReported) {
        this.DTReported = DTReported;
    }

    public String getDDMonthYr() {
        return DDMonthYr;
    }

    public void setDDMonthYr(String DDMonthYr) {
        this.DDMonthYr = DDMonthYr;
    }

    public String getDTClosed() {
        return DTClosed;
    }

    public void setDTClosed(String DTClosed) {
        this.DTClosed = DTClosed;
    }

    public String getDTResolved() {
        return DTResolved;
    }

    public void setDTResolved(String DTResolved) {
        this.DTResolved = DTResolved;
    }

    public String getEACO() {
        return EACO;
    }

    public void setEACO(String EACO) {
        this.EACO = EACO;
    }

    public String getEACOIssueID() {
        return EACOIssueID;
    }

    public void setEACOIssueID(String EACOIssueID) {
        this.EACOIssueID = EACOIssueID;
    }

    public String getOwnerGroup() {
        return OwnerGroup;
    }

    public void setOwnerGroup(String OwnerGroup) {
        this.OwnerGroup = OwnerGroup;
    }

    public String getResponsibleGroup() {
        return ResponsibleGroup;
    }

    public void setResponsibleGroup(String ResponsibleGroup) {
        this.ResponsibleGroup = ResponsibleGroup;
    }

    public String getClosedBy() {
        return ClosedBy;
    }

    public void setClosedBy(String ClosedBy) {
        this.ClosedBy = ClosedBy;
    }

    public String getClosedByGroupx002() {
        return ClosedByGroupx002;
    }

    public void setClosedByGroupx002(String ClosedByGroupx002) {
        this.ClosedByGroupx002 = ClosedByGroupx002;
    }

    public String getResolutionID() {
        return ResolutionID;
    }

    public void setResolutionID(String ResolutionID) {
        this.ResolutionID = ResolutionID;
    }

    public String getResolvedBy() {
        return ResolvedBy;
    }

    public void setResolvedBy(String ResolvedBy) {
        this.ResolvedBy = ResolvedBy;
    }

    public String getResolvedByGroupx0() {
        return ResolvedByGroupx0;
    }

    public void setResolvedByGroupx0(String ResolvedByGroupx0) {
        this.ResolvedByGroupx0 = ResolvedByGroupx0;
    }

    public String getRCARespTech() {
        return RCARespTech;
    }

    public void setRCARespTech(String RCARespTech) {
        this.RCARespTech = RCARespTech;
    }

    public String getRCAResponsibleGrou() {
        return RCAResponsibleGrou;
    }

    public void setRCAResponsibleGrou(String RCAResponsibleGrou) {
        this.RCAResponsibleGrou = RCAResponsibleGrou;
    }

    public String getRCASearchString() {
        return RCASearchString;
    }

    public void setRCASearchString(String RCASearchString) {
        this.RCASearchString = RCASearchString;
    }

    public String getRCAStatus() {
        return RCAStatus;
    }

    public void setRCAStatus(String RCAStatus) {
        this.RCAStatus = RCAStatus;
    }

    public String getCoADOU() {
        return CoADOU;
    }

    public void setCoADOU(String CoADOU) {
        this.CoADOU = CoADOU;
    }

    public String getCoEmpIDx00() {
        return CoEmpIDx00;
    }

    public void setCoEmpIDx00(String CoEmpIDx00) {
        this.CoEmpIDx00 = CoEmpIDx00;
    }

    public String getCoFirstName() {
        return CoFirstName;
    }

    public void setCoFirstName(String CoFirstName) {
        this.CoFirstName = CoFirstName;
    }

    public String getOData() {
        return OData;
    }

    public void setOData(String OData) {
        this.OData = OData;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getSubmitDT() {
        return SubmitDT;
    }

    public void setSubmitDT(String SubmitDT) {
        this.SubmitDT = SubmitDT;
    }

    public String getSubmitterGroup() {
        return SubmitterGroup;
    }

    public void setSubmitterGroup(String SubmitterGroup) {
        this.SubmitterGroup = SubmitterGroup;
    }

    public String getSubmitterTechnologyx0020() {
        return SubmitterTechnologyx0020;
    }

    public void setSubmitterTechnologyx0020(String SubmitterTechnologyx0020) {
        this.SubmitterTechnologyx0020 = SubmitterTechnologyx0020;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getType1() {
        return Type1;
    }

    public void setType1(String Type1) {
        this.Type1 = Type1;
    }

    public String getSubType() {
        return SubType;
    }

    public void setSubType(String SubType) {
        this.SubType = SubType;
    }

    public String getResolvedDuration() {
        return ResolvedDuration;
    }

    public void setResolvedDuration(String ResolvedDuration) {
        this.ResolvedDuration = ResolvedDuration;
    }

    public String getClosedDuration() {
        return ClosedDuration;
    }

    public void setClosedDuration(String ClosedDuration) {
        this.ClosedDuration = ClosedDuration;
    }

    public String getActualDuration() {
        return ActualDuration;
    }

    public void setActualDuration(String ActualDuration) {
        this.ActualDuration = ActualDuration;
    }

    public String getActualDurationHRs() {
        return ActualDurationHRs;
    }

    public void setActualDurationHRs(String ActualDurationHRs) {
        this.ActualDurationHRs = ActualDurationHRs;
    }

    public String getBusinessImpactClas() {
        return BusinessImpactClas;
    }

    public void setBusinessImpactClas(String BusinessImpactClas) {
        this.BusinessImpactClas = BusinessImpactClas;
    }

    public String getOData3rdPartyInvo() {
        return OData3rdPartyInvo;
    }

    public void setOData3rdPartyInvo(String OData3rdPartyInvo) {
        this.OData3rdPartyInvo = OData3rdPartyInvo;
    }

    public String getOData4BlockerRequ() {
        return OData4BlockerRequ;
    }

    public void setOData4BlockerRequ(String OData4BlockerRequ) {
        this.OData4BlockerRequ = OData4BlockerRequ;
    }

    public String getMajorProblemReview() {
        return MajorProblemReview;
    }

    public void setMajorProblemReview(String MajorProblemReview) {
        this.MajorProblemReview = MajorProblemReview;
    }

    public String getTimelineRequiredx() {
        return TimelineRequiredx;
    }

    public void setTimelineRequiredx(String TimelineRequiredx) {
        this.TimelineRequiredx = TimelineRequiredx;
    }

    public String getRootCauseAnalysis() {
        return RootCauseAnalysis;
    }

    public void setRootCauseAnalysis(String RootCauseAnalysis) {
        this.RootCauseAnalysis = RootCauseAnalysis;
    }

    public String getType1GroupId() {
        return Type1GroupId;
    }

    public void setType1GroupId(String Type1GroupId) {
        this.Type1GroupId = Type1GroupId;
    }

    public String getExcelDTRepo() {
        return ExcelDTRepo;
    }

    public void setExcelDTRepo(String ExcelDTRepo) {
        this.ExcelDTRepo = ExcelDTRepo;
    }

    public String getExcelDTClos() {
        return ExcelDTClos;
    }

    public void setExcelDTClos(String ExcelDTClos) {
        this.ExcelDTClos = ExcelDTClos;
    }

    public String getExcelSubmitDx002f() {
        return ExcelSubmitDx002f;
    }

    public void setExcelSubmitDx002f(String ExcelSubmitDx002f) {
        this.ExcelSubmitDx002f = ExcelSubmitDx002f;
    }

    public String getExcelDTReso() {
        return ExcelDTReso;
    }

    public void setExcelDTReso(String ExcelDTReso) {
        this.ExcelDTReso = ExcelDTReso;
    }

    public String getExcelDailyDate() {
        return ExcelDailyDate;
    }

    public void setExcelDailyDate(String ExcelDailyDate) {
        this.ExcelDailyDate = ExcelDailyDate;
    }

    public String getODataOID() {
        return ODataOID;
    }

    public void setODataOID(String ODataOID) {
        this.ODataOID = ODataOID;
    }

    public String getClassPK2000() {
        return ClassPK2000;
    }

    public void setClassPK2000(String ClassPK2000) {
        this.ClassPK2000 = ClassPK2000;
    }

    public String getID1() {
        return ID1;
    }

    public void setID1(String ID1) {
        this.ID1 = ID1;
    }

    public String getModified() {
        return Modified;
    }

    public void setModified(String Modified) {
        this.Modified = Modified;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String Created) {
        this.Created = Created;
    }

    public String getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(String AuthorId) {
        this.AuthorId = AuthorId;
    }

    public String getEditorId() {
        return EditorId;
    }

    public void setEditorId(String EditorId) {
        this.EditorId = EditorId;
    }

    public String getODataUIVersionString() {
        return ODataUIVersionString;
    }

    public void setODataUIVersionString(String ODataUIVersionString) {
        this.ODataUIVersionString = ODataUIVersionString;
    }

    public String getAttachments() {
        return Attachments;
    }

    public void setAttachments(String Attachments) {
        this.Attachments = Attachments;
    }

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getMonthYear() {
        return MonthYear;
    }

    public void setMonthYear(String MonthYear) {
        this.MonthYear = MonthYear;
    }

    public String getWeekEnding() {
        return WeekEnding;
    }

    public void setWeekEnding(String WeekEnding) {
        this.WeekEnding = WeekEnding;
    }

    public String getDayMonthYear() {
        return DayMonthYear;
    }

    public void setDayMonthYear(String DayMonthYear) {
        this.DayMonthYear = DayMonthYear;
    }

    @Override
    public String toString() {
        return "PK2000Data{" + "ProblemID=" + ProblemID + ", Application=" + 
                Application + ", Severity=" + Severity + ", Priority=" + 
                Priority + ", BriefProblemSummar=" + BriefProblemSummar + 
                ", TypeReqVSx=" + TypeReqVSx + ", CauseCode=" + CauseCode + 
                ", Status=" + Status + ", DTReported=" + DTReported + 
                ", DDMonthYr=" + DDMonthYr + ", DTClosed=" + DTClosed + 
                ", DTResolved=" + DTResolved + ", EACO=" + EACO + 
                ", EACOIssueID=" + EACOIssueID + ", OwnerGroup=" + 
                OwnerGroup + ", ResponsibleGroup=" + ResponsibleGroup + 
                ", ClosedBy=" + ClosedBy + ", ClosedByGroupx002=" + 
                ClosedByGroupx002 + ", ResolutionID=" + ResolutionID + 
                ", ResolvedBy=" + ResolvedBy + ", ResolvedByGroupx0=" + 
                ResolvedByGroupx0 + ", RCARespTech=" + RCARespTech + 
                ", RCAResponsibleGrou=" + RCAResponsibleGrou + 
                ", RCASearchString=" + RCASearchString + ", RCAStatus=" + 
                RCAStatus + ", CoADOU=" + CoADOU + ", CoEmpIDx00=" + 
                CoEmpIDx00 + ", CoFirstName=" + CoFirstName + ", OData=" + 
                OData + ", Address=" + Address + ", City=" + City + 
                ", State=" + State + ", SubmitDT=" + SubmitDT + 
                ", SubmitterGroup=" + SubmitterGroup + 
                ", SubmitterTechnologyx0020=" + SubmitterTechnologyx0020 + 
                ", Platform=" + Platform + ", Assignee=" + Assignee + 
                ", Type1=" + Type1 + ", SubType=" + SubType + 
                ", ResolvedDuration=" + ResolvedDuration + 
                ", ClosedDuration=" + ClosedDuration + 
                ", ActualDuration=" + ActualDuration + 
                ", ActualDurationHRs=" + ActualDurationHRs + 
                ", BusinessImpactClas=" + BusinessImpactClas + 
                ", OData3rdPartyInvo=" + OData3rdPartyInvo + 
                ", OData4BlockerRequ=" + OData4BlockerRequ + 
                ", MajorProblemReview=" + MajorProblemReview + 
                ", TimelineRequiredx=" + TimelineRequiredx + 
                ", RootCauseAnalysis=" + RootCauseAnalysis + 
                ", Type1GroupId=" + Type1GroupId + ", ExcelDTRepo=" + 
                ExcelDTRepo + ", ExcelDTClos=" + ExcelDTClos + 
                ", ExcelSubmitDx002f=" + ExcelSubmitDx002f + 
                ", ExcelDTReso=" + ExcelDTReso + ", ExcelDailyDate=" + 
                ExcelDailyDate + ", ODataOID=" + ODataOID + ", ClassPK2000=" + 
                ClassPK2000 + ", ID1=" + ID1 + ", Modified=" + Modified + 
                ", Created=" + Created + ", AuthorId=" + AuthorId + 
                ", EditorId=" + EditorId + ", ODataUIVersionString=" + 
                ODataUIVersionString + ", Attachments=" + Attachments + 
                ", GUID=" + GUID + ", MonthYear=" + MonthYear + 
                ", WeekEnding=" + WeekEnding + ", DayMonthYear=" + 
                DayMonthYear + '}';
    }

    @Override
    public int compare(PK2000Data t, PK2000Data t1) {
        return t1.getPAC2000ID() - t.getPAC2000ID(); 
    }
    
   




    
}
