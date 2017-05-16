package us.nauvil.ogame.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import us.nauvil.ogame.Score;

public class ScoreDao extends Dao<Score> {

	public String getInsertSql() {
		return "INSERT INTO planets" + "(playerId,dayId,total,totalRank,economy,economyRank,research,researchRank,military,militaryRank,ships,militaryBuilt,militaryBuiltRank,militaryDestroyed,militaryDestroyedRank,militaryLost,militaryLostRank,honor,honorRank) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected void doInsert(PreparedStatement preparedStatement, Score s) throws SQLException {
		preparedStatement.setInt(1, s.getPlayerId());
		preparedStatement.setInt(2, s.getDayId());
		preparedStatement.setInt(3, s.getTotal());
		preparedStatement.setInt(4, s.getTotalRank());
		preparedStatement.setInt(5, s.getEconomy());
		preparedStatement.setInt(6, s.getEconomyRank());
		preparedStatement.setInt(7, s.getResearch());
		preparedStatement.setInt(8, s.getResearchRank());
		preparedStatement.setInt(9, s.getMilitary());
		preparedStatement.setInt(10, s.getMilitaryRank());
		preparedStatement.setInt(11, s.getShips());
		preparedStatement.setInt(12, s.getMilitaryBuilt());
		preparedStatement.setInt(13, s.getMilitaryBuiltRank());
		preparedStatement.setInt(14, s.getMilitaryDestroyed());
		preparedStatement.setInt(15, s.getMilitaryDestroyedRank());
		preparedStatement.setInt(16, s.getMilitaryLost());
		preparedStatement.setInt(17, s.getMilitaryLostRank());
		preparedStatement.setInt(18, s.getHonor());
		preparedStatement.setInt(19, s.getHonorRank());

		/*
		 * if (t.getAlliance() != null) { preparedStatement.setInt(4,
		 * t.getAlliance()); } else { preparedStatement.setNull(4,
		 * Types.INTEGER); }
		 */
	}
}
