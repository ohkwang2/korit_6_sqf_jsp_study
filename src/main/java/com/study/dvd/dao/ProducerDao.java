package com.study.dvd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.dvd.entity.Producer;
import com.study.dvd.util.DBConnectionMgr;

public class ProducerDao {
	
	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static List<Producer> seachProducerByProducerName(String searchText) {
		List<Producer> producers = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstms = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from producer_tb ");
			sql.append("where producer_name LIKE ? ");
			sql.append("order by producer_id ");
			sql.append("LIMIT 0, 30");
			pstms = con.prepareStatement(sql.toString());
			pstms.setString(1, "%" + searchText + "%");
			rs = pstms.executeQuery();
			
			while(rs.next()) {
				Producer producer = Producer.builder()
						.producerId(rs.getInt(1))
						.producerName(rs.getString(2))
						.build();
				
				producers.add(producer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstms, rs);
		}
		
		System.out.println(producers);
		return producers;
	}
}