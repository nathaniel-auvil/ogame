package us.nauvil.ogame.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public abstract class Dao<T> {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
		c.setAutoCommit(true);
		return c;
	}

	public abstract String getInsertSql();

	protected abstract void doInsert(PreparedStatement preparedStatement, T t) throws SQLException;

	public void insert(T t) throws SQLException {
		try (Connection c = this.getConnection()) {
			try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(this.getInsertSql())) {
				this.doInsert(preparedStatement, t);
				preparedStatement.executeUpdate();
			}
		}
	}

	protected void safeInsert(PreparedStatement preparedStatement, int index, Integer value) throws SQLException {
		if (value != null) {
			preparedStatement.setInt(index, value);
		} else {
			preparedStatement.setNull(index, Types.INTEGER);
		}
	}
}
