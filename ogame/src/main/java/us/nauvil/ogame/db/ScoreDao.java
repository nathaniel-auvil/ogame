package us.nauvil.ogame.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import us.nauvil.ogame.Score;

public class ScoreDao extends Dao<Score> {

	public String getInsertSql() {
		return "INSERT INTO scores" + "(playerId,dayId,total,totalRank,economy,economyRank,research,researchRank,military,militaryRank,ships,militaryBuilt,militaryBuiltRank,militaryDestroyed,militaryDestroyedRank,militaryLost,militaryLostRank,honor,honorRank) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	protected void doInsert(PreparedStatement preparedStatement, Score s) throws SQLException {
		preparedStatement.setInt(1, s.getPlayerId());
		preparedStatement.setInt(2, s.getDayId());
		super.safeInsert(preparedStatement, 3, s.getTotal());
		super.safeInsert(preparedStatement, 4, s.getTotalRank());
		super.safeInsert(preparedStatement, 5, s.getEconomy());
		super.safeInsert(preparedStatement, 6, s.getEconomyRank());
		super.safeInsert(preparedStatement, 7, s.getResearch());
		super.safeInsert(preparedStatement, 8, s.getResearchRank());
		super.safeInsert(preparedStatement, 9, s.getMilitary());
		super.safeInsert(preparedStatement, 10, s.getMilitaryRank());
		super.safeInsert(preparedStatement, 11, s.getShips());
		super.safeInsert(preparedStatement, 12, s.getMilitaryBuilt());
		super.safeInsert(preparedStatement, 13, s.getMilitaryBuiltRank());
		super.safeInsert(preparedStatement, 14, s.getMilitaryDestroyed());
		super.safeInsert(preparedStatement, 15, s.getMilitaryDestroyedRank());
		super.safeInsert(preparedStatement, 16, s.getMilitaryLost());
		super.safeInsert(preparedStatement, 17, s.getMilitaryLostRank());
		super.safeInsert(preparedStatement, 18, s.getHonor());
		super.safeInsert(preparedStatement, 19, s.getHonorRank());
	}

}
