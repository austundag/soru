package com.supmount.razi;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class ConsentTypeJDBCTemplate implements ConsentTypeDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private PlatformTransactionManager transactionManager;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public Integer create(NewConsentType newConsentType) {
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);

		try {
			String SQL1 = "insert into consent_type (name, type, role) values (?, ?, ?)";
			String name = newConsentType.getName();
			jdbcTemplateObject.update(SQL1, name, newConsentType.getType(), newConsentType.getRole());

			String SQL2 = "select max(id) from consent_type";
			int id = jdbcTemplateObject.queryForObject(SQL2, Integer.class);

			String SQL3 = "insert into consent_type_text (consent_type_id, language_code, title) " + "values (?, ?, ?)";
			jdbcTemplateObject.update(SQL3, id, "en", newConsentType.getTitle());

			System.out.println("Created Name = " + name);
			transactionManager.commit(status);
			return id;
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public ConsentType get(Integer id, String languageCode) {
		String select = "select ct.id as id, ct.name as name, ct.type as type, ct.role as role, ctt.title as title";
		String from = "from consent_type as ct inner join consent_type_text as ctt";
		String on = "on ct.id = ctt.consent_type_id and ctt.language_code = ?";
		String where = "where ct.id = ?";
		String SQL = select + " " + from + " " + on + " " + where;
		Object[] params = new Object[] { languageCode, id };
		ConsentType consentType = jdbcTemplateObject.queryForObject(SQL, params, new ConsentTypeMapper());
		return consentType;
	}

	@Override
	public List<ConsentType> list(String languageCode) {
		String select = "select ct.id as id, ct.name as name, ct.type as type, ct.role as role, ctt.title as title";
		String from = "from consent_type inner join consent_type_text";
		String where = "where consent_type_text.language_code = " + languageCode;
		String SQL = select + " " + from + " " + where;
		List<ConsentType> consentTypes = jdbcTemplateObject.query(SQL, new ConsentTypeMapper());
		return consentTypes;
	}

	@Override
	public void delete(Integer id, String languageCode) {
		String SQL = "delete from language where code = ?";
		jdbcTemplateObject.update(SQL, id, languageCode);
		return;
	}

	@Override
	public void update(Integer id, String languageCode, NewConsentType newConsentType) {
		String SQL = "update language set name = ?, native_name = ? where code = ?";
		// jdbcTemplateObject.update(SQL, code, name, nativeName);
		// System.out.println("Updated Record with code = " + code);
		return;
	}
}
