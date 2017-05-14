package us.nauvil.ogame.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import us.nauvil.ogame.Player;

public class PlayerDao extends Dao<Player> {

	public String getInsertSql() {
		return "INSERT INTO players" + "(ID, NAME, STATUS, ALLIANCE, DAYID) VALUES" + "(?,?,?,?,?)";
	}

	@Override
	protected void doInsert(PreparedStatement preparedStatement, Player t) throws SQLException {
		preparedStatement.setInt(1, t.getId());
		preparedStatement.setString(2, t.getName());
		preparedStatement.setString(3, t.getStatus());
		if (t.getAlliance() != null) {
			preparedStatement.setInt(4, t.getAlliance());
		} else {
			preparedStatement.setNull(4, Types.INTEGER);
		}
		preparedStatement.setInt(5, t.getDayId());
	}
}
