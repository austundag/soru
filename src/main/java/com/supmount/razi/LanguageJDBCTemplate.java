package com.supmount.razi;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class LanguageJDBCTemplate implements LanguageDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String code, String name, String nativeName) {
		String SQL = "insert into language (code, name, native_name) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, code, name, nativeName);
		System.out.println("Created Record Name = " + name + " Native name = " + nativeName);
		return;
	}

	@Override
	public Language get(String code) {
		String SQL = "select * from language where code = ?";
		Language language = jdbcTemplateObject.queryForObject(SQL, new Object[] { code }, new LanguageMapper());
		return language;
	}

	@Override
	public List<Language> list() {
		String SQL = "select * from language";
		List<Language> languages = jdbcTemplateObject.query(SQL, new LanguageMapper());
		return languages;
	}

	@Override
	public void delete(String code) {
		String SQL = "delete from language where code = ?";
		jdbcTemplateObject.update(SQL, code);
		System.out.println("Deleted Record with code = " + code);
		return;
	}

	@Override
	public void update(String code, String name, String nativeName) {
		String SQL = "update language set name = ?, native_name = ? where code = ?";
		jdbcTemplateObject.update(SQL, code, name, nativeName);
		System.out.println("Updated Record with code = " + code);
		return;
	}
}
