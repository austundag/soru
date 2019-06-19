package com.supmount.razi;

import java.util.List;

import javax.sql.DataSource;

public interface ConsentTypeDAO {
	public void setDataSource(DataSource ds);

	public Integer create(NewConsentType newConsentType);

	public ConsentType get(Integer id, String languageCode);

	public List<ConsentType> list(String languageCode);

	public void delete(Integer id, String languageCode);

	public void update(Integer id, String languageCode, NewConsentType newConsentType);
}
