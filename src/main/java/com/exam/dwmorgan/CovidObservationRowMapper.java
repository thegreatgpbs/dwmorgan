package com.exam.dwmorgan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.exam.domain.CovidObservation;

public class CovidObservationRowMapper implements RowMapper<CovidObservation>{

	@Override
    public CovidObservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		CovidObservation co = new CovidObservation();

		co.setCountry(rs.getString("country"));
		co.setConfirmed(Math.round(rs.getDouble("confirmed")));
		co.setDeaths(Math.round(rs.getDouble("deaths")));
		co.setRecovered(Math.round(rs.getDouble("recovered")));
		co.setConfirmedDouble(null);
		co.setDeathsDouble(null);
		co.setRecoveredDouble(null);
		
        return co;
    }
}