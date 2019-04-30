package br.unifor.si.rosos.fuzhoda;

import br.unifor.si.rosos.GameSimulator;
import br.unifor.si.rosos.MathUtil;
import br.unifor.si.rosos.RobotBasic;
import br.unifor.si.rosos.Sensor;
import br.unifor.si.rosos.TeamSide;

public class RobotBoy extends RobotBasic {
	private float velocidade;
	private RobotConfig robotConfig;
	
	private Sensor locator;
	private Sensor compass;
	private Sensor front, right, back, left;
	private float goalDir;

	public RobotBoy(GameSimulator g, RobotConfig robotConfig) {
		super(g);
		this.robotConfig = robotConfig;
	}
	
	public void setup(){
		velocidade = 1f;
		/*
			You should use this method to initialize your code,
			setup Sensors and variables.

			It will be runned once.
		*/
		
		System.out.println("Running!");

		locator = getSensor("BALL");
		compass = getSensor("COMPASS");

		front = getSensor("ULTRASONIC_FRONT");
		left = getSensor("ULTRASONIC_LEFT");
		back = getSensor("ULTRASONIC_BACK");
		right = getSensor("ULTRASONIC_RIGHT");

		goalDir = 0f;
		// Find Goal Direction
		if(this.robotConfig.getTeamSide() == TeamSide.RIGHT)
			goalDir = 180f;
	}

	public void loop(){
		float ballAngle = locator.readValue(0);
		float ballDist = locator.readValue(1);
		
		
		lookToTheBall();
		
		System.out.print(this.getRealPosition().x + " ");
		System.out.print(this.getRealPosition().y + " ");
		System.out.println(this.getOrientation());
		
		caminhar(velocidade);
	}
	
	private void lookToTheBall() {
		float comp = compass.readValue(0);

		setRotation(MathUtil.relativeAngle(goalDir - comp) * 1f);
	}
	
	void caminhar(float distancia) {
		setSpeed(distancia);
		delay(1000);
		stopMotors();
		//setRotation(-360);
		//delay(1000);
		//stopMotors();
		/*setSpeed(-distancia);
		delay(1000);
		stopMotors();*/
	}
}
