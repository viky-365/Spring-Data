package com.spike.msg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mysema.query.Tuple;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.types.MappingProjection;
import com.spike.model.QUser1;
import com.spike.model.User1;

@Service
public class MessageService {

	@Autowired
	private QueryDslJdbcTemplate queryDslJdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getMessage() {
		return "Hw r u?";
	}

	private static final QUser1 qUser1 = QUser1.User1;

	public String getName(int id) {

		SQLQuery sqlQuery = queryDslJdbcTemplate.newSqlQuery().from(qUser1)
				.where(qUser1.id.eq((Integer)id));
		List<User1> list = queryDslJdbcTemplate.query(sqlQuery,
				new User1MappingProjection(qUser1));

		System.out.println(id + " : " + list);

		return jdbcTemplate.queryForObject(
				"select first_name from User1 where id=" + id, String.class);
	}

	private static class User1MappingProjection extends
			MappingProjection<User1> {

		private static final long serialVersionUID = 1L;

		public User1MappingProjection(QUser1 qUser1) {
			super(User1.class, qUser1.id, qUser1.firstName, qUser1.lastName,
					qUser1.email, qUser1.score);
		}

		@Override
		protected User1 map(Tuple row) {
			User1 user1 = new User1();
			user1.setId(row.get(qUser1.id));
			user1.setFirstName(row.get(qUser1.firstName));
			user1.setLastName(row.get(qUser1.lastName));
			user1.setEmail(row.get(qUser1.email));
			user1.setScore(Integer.parseInt(row.get(qUser1.score)));
			return null;
		}

	}
}
