package com.supmount.razi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ConsentTypeMapper implements RowMapper<ConsentType> {
	@Override
	public ConsentType mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConsentType consentType = new ConsentType();

		consentType.setId(rs.getInt("id"));
		consentType.setName(rs.getString("name"));
		consentType.setType(rs.getString("type"));
		consentType.setRole(rs.getString("role"));
		consentType.setTitle(rs.getString("title"));

		return consentType;
	}
}