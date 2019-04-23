package br.unifor.si.rosos.fuzhoda;

import br.unifor.si.rosos.GameSimulator;
import br.unifor.si.rosos.RobotBasic;

public class RobotBoy extends RobotBasic {
	private float velocidade;

	public RobotBoy(GameSimulator g) {
		super(g);
		// TODO Auto-generated constructor stub
	}
	
	public void setup(){
		velocidade = 1f;
		/*
			You should use this method to initialize your code,
			setup Sensors and variables.

			It will be runned once.
		*/
	}

	public void loop(){
		caminhar(velocidade);
		System.out.println(this.getRealPosition().x);
		System.out.println(this.getRealPosition().y);
		this.setRotation(30);		System.out.println(this.getOrientation());
		//velocidade+= 0.5f;
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
