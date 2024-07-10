package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Dvd;
import com.study.dvd.util.DBConnectionMgr;

public class DvdDao {
	// �̱��� ����
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static List<Dvd> searchDvdByTitle(String searchText) {
		List<Dvd> dvds = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// db ����
			con = pool.getConnection();
			// �⺻ sql�� ����
			StringBuilder sql = new StringBuilder();
			// ������� �����ؾ� ��.
			sql.append("select * from dvd_view ");
			// ""�� �ְ������ \"value\"�� ������ �� but, �߰��� ?�� "?" �̷��� ���� ������ 
//			sql.append("where title like\"%?%\"");
			// setString���� ? ��ü�� %��%�� �־��ָ� ��
			sql.append("where title like ? ");
			sql.append("limit 0, 50");
			// ������ sql�� pstmt�� �Է�
			pstmt = con.prepareStatement(sql.toString());
			// ?�� �ش��ϴ� �� �Է�
			pstmt.setString(1, "%" + searchText + "%");
			// ���� ���� ��� ����
			rs = pstmt.executeQuery();
			
			// ���������� ������� dvds ������ ����
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
			// db���� ����
			pool.freeConnection(con, pstmt, rs);
		}
		// �Լ� ���� ��� dvds ����Ʈ ����
		return dvds;
	}
}
