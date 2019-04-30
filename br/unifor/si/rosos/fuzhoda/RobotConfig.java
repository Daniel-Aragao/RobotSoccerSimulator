package br.unifor.si.rosos.fuzhoda;

import br.unifor.si.rosos.TeamSide;

public class RobotConfig {
	private TeamSide teamSide;
	
	public RobotConfig(TeamSide teamSide) {
		this.teamSide = teamSide;
	}

	public TeamSide getTeamSide() {
		return teamSide;
	}	
}
