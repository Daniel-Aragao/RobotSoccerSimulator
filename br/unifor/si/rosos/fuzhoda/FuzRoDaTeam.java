package br.unifor.si.rosos.fuzhoda;

import br.unifor.si.rosos.GameSimulator;
import br.unifor.si.rosos.Robot;
import br.unifor.si.rosos.Team;
import br.unifor.si.rosos.TeamSide;

public class FuzRoDaTeam implements Team{
	private TeamSide teamSide;

	@Override
	public String getTeamName() {
		return "Fuz Ro Da";
	}	
	
	@Override
	public void setTeamSide(TeamSide side){
		teamSide = side;
	}

	@Override
	public Robot buildRobot(GameSimulator simulator, int index) {
		RobotConfig robotconfig = new RobotConfig(this.teamSide);
		return new RobotBoy(simulator, robotconfig);
	}

}
