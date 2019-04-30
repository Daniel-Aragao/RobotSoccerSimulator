package br.unifor.si.rosos.fuzhoda;

import br.unifor.si.rosos.TeamSide;
import net.sourceforge.jFuzzyLogic.FIS;

public class RobotConfig {
	private TeamSide teamSide;
	private FIS fis;
	
	public RobotConfig(TeamSide teamSide) {
		this.teamSide = teamSide;
		
		String fileName = "daniel_arthur_fuzzy.fcl";
		
		fis = FIS.load(fileName);
		
		if(fis  == null) {
			try {
				throw new Exception(".fcl não encontrado");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public FIS getFis() {
		return fis;
	}

	public TeamSide getTeamSide() {
		return teamSide;
	}	
}
