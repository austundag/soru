package com.supmount.razi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LanguageMapper implements RowMapper<Language> {
	@Override
	public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
		Language language = new Language();

		language.setCode(rs.getString("code"));
		language.setName(rs.getString("name"));
		language.setNativeName(rs.getString("native_name"));

		return language;
	}
}