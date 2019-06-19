package com.supmount.razi;

import java.util.List;

import javax.sql.DataSource;

public interface LanguageDAO {
	public void setDataSource(DataSource ds);

	public void create(String code, String name, String nativeName);

	public Language get(String code);

	public List<Language> list();

	public void delete(String code);

	public void update(String code, String name, String nativeName);
}
