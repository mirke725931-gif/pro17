package sec01.practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeDAO {
	
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public NoticeDAO()
	{
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<NoticeVO> listNotice()
	{
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();
		try 
		{
			conn = dataFactory.getConnection();
			String query = "select * from t_notice order by notice_list_id";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				String id = rs.getString("notice_list_id");
				String title = rs.getString("notice_title");
				String date = rs.getString("notice_date");
				NoticeVO noticeVO = new NoticeVO(id, title, date);
				noticeList.add(noticeVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return noticeList;
	}
}
