package us.nauvil.ogame.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import us.nauvil.ogame.Planet;

public class PlanetDao extends BatchDao<Planet> {

	public String getInsertSql() {
		return "INSERT INTO planets" + "(id,playerId,dayId,name,coords,galaxy,solarsystem,planet) VALUES" + "(?,?,?,?,?,?,?,?)";
	}

	@Override
	protected void doInsert(PreparedStatement preparedStatement, List<Planet> planets) throws SQLException {
		for (Planet p : planets) {
			preparedStatement.setInt(1, p.getPlanetId());
			preparedStatement.setInt(2, p.getPlayerId());
			preparedStatement.setInt(3, p.getDayId());
			preparedStatement.setString(4, p.getName());
			preparedStatement.setString(5, p.getCoords());
			preparedStatement.setInt(6, p.getGalaxy());
			preparedStatement.setInt(7, p.getSystem());
			preparedStatement.setInt(8, p.getPlanet());
			preparedStatement.addBatch();
		}
	}

}
