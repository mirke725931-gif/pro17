package sec01.practice;

import java.sql.Date;

public class NoticeVO {
	
	private String id;
    private String title;
    private String date;
    
    public NoticeVO()
    {
    	System.out.println("NoticeVO 생성자 호출");
    }
    
    public NoticeVO(String id, String title, String date)
    {
    	this.id = id;
    	this.title = title;
    	this.date = date;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
   
}
