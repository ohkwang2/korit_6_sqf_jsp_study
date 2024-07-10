package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Dvd;
import com.study.dvd.util.DBConnectionMgr;

public class DvdDao {
	// 싱글톤 생성
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static List<Dvd> searchDvdByTitle(String searchText) {
		List<Dvd> dvds = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// db 연결
			con = pool.getConnection();
			// 기본 sql문 생성
			StringBuilder sql = new StringBuilder();
			// 띄워쓰기 조심해야 함.
			sql.append("select * from dvd_view ");
			// ""를 넣고싶으면 \"value\"로 넣으면 됨 but, 중간에 ?는 "?" 이렇게 들어가기 때문에 
//			sql.append("where title like\"%?%\"");
			// setString으로 ? 자체에 %값%을 넣어주면 됨
			sql.append("where title like ? ");
			sql.append("limit 0, 50");
			// 생성한 sql문 pstmt에 입력
			pstmt = con.prepareStatement(sql.toString());
			// ?에 해당하는 값 입력
			pstmt.setString(1, "%" + searchText + "%");
			// 쿼리 실행 결과 대입
			rs = pstmt.executeQuery();
			
			// 순차적으로 결과값을 dvds 변수에 대입
			while(rs.next()) {
				Dvd dvd = Dvd.builder()
						.dvdId(rs.getInt(1))
						.registrationNumber(rs.getString(2))
						.title(rs.getString(3))
						.producerId(rs.getInt(4))
						.producerName(rs.getString(5))
						.publisherId(rs.getInt(6))
						.publisherName(rs.getString(7))
						.publicationYear(rs.getInt(8))
						.databaseDate(rs.getDate(9).toLocalDate())
						.build();
				dvds.add(dvd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// db연결 종료
			pool.freeConnection(con, pstmt, rs);
		}
		// 함수 실행 결과 dvds 리스트 리턴
		return dvds;
	}
}
