
package se.johan.oh.containers;

/**
 * @author johan
 */
public class Chapter {
    
    /*columns in table*/
    public static final String CHAPTER_ID = "CHAPTER_ID";
    public static final String CHAPTER_NAME = "CHAPTER_NAME";
    public static final String PRIORITY = "PRIORITY";
    public static final String HTML_CONTENT ="HTML_CONTENT";
    
    /*SQL queries*/
    public static final String INSERT_CHAPTER_SQL = 
            "INSERT INTO CHAPTER (CHAPTER_NAME, PRIORITY, HTML_CONTENT) VALUES (?,?,?)";
    public static final String INSERT_SUBJECT_HAS_CHAPTERS_SQL =
            "INSERT INTO SUBJECT_HAS_CHAPTER (SUBJECT_ID, CHAPTER_ID) VALUES(?,?)";
    public static final String  DELETE_CHAPTER_SQL = 
            "DELETE FROM CHAPTER WHERE CHAPTER_ID = ? ";
    public static final String UPDATE_CHAPTER_SQL = 
            "UPDATE CHAPTER SET CHAPTER_NAME = ?, PRIORITY = ?, HTML_CONTENT = ?"+
            "WHERE CHAPTER_ID = ?";  
    public static final String SELECT_CHAPTER_SQL = 
            "SELECT CHAPTER_ID, CHAPTER_NAME, PRIORITY, HTML_CONTENT FROM CHAPTER WHERE CHAPTER_ID = ?";
    public static final String SELECT_ALL_CHAPTERS_SQL = 
            "SELECT CHAPTER_ID, CHAPTER_NAME, PRIORITY, HTML_CONTENT FROM CHAPTER";
   
    
    private Integer chapterID;
    private Integer subjectID;
    private String chapterName;
    private Integer priority;
    private String contentHTML;

    public Chapter(Integer chapterID, String chapterName, Integer priority, String contentHTML) {
        this.chapterID = chapterID;
        this.chapterName = chapterName;
        this.priority = priority;
        this.contentHTML = contentHTML;
    }
    
    public Chapter(String chapterName, Integer priority, String contentHTML) {
        this.chapterID = 0;
        this.chapterName = chapterName;
        this.priority = priority;
        this.contentHTML = contentHTML;
    }

    /**
     * @return the chapterID
     */
    public Integer getChapterID() {
        return chapterID;
    }

    /**
     * @param chapterID the chapterID to set
     */
    public void setChapterID(Integer chapterID) {
        this.chapterID = chapterID;
    }

    /**
     * @return the chapterName
     */
    public String getChapterName() {
        return chapterName;
    }

    /**
     * @param chapterName the chapterName to set
     */
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    /**
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return the contentHTML
     */
    public String getContentHTML() {
        return contentHTML;
    }

    /**
     * @param contentHTML the contentHTML to set
     */
    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }
   
    public String toString(){
        return CHAPTER_ID +" : "+ chapterID +", "+
               CHAPTER_NAME+" : "+ chapterName+", "+
               PRIORITY + " : "+ priority+", "+
               HTML_CONTENT+" : "+ contentHTML;                  
    }
}
