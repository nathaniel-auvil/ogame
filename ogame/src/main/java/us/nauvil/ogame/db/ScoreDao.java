package us.nauvil.ogame.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import us.nauvil.ogame.Player;

public class ScoreDao extends Dao<Player> {

	public String getInsertSql() {
		return "INSERT INTO scores" + "(playerId, dayId, total, economy, research, military, militaryBuilt, militaryDestroyed, militaryLost, militaryShips, honor) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)";

	}

	@Override
	protected void doInsert(PreparedStatement preparedStatement, Player t) throws SQLException {
		preparedStatement.setInt(1, t.getId());
		preparedStatement.setInt(2, t.getDayId());
		preparedStatement.setString(2, t.getName());
		preparedStatement.setString(3, t.getStatus());
		if (t.getAlliance() != null) {
			preparedStatement.setInt(4, t.getAlliance());
		} else {
			preparedStatement.setNull(4, Types.INTEGER);
		}
		
	}
}
