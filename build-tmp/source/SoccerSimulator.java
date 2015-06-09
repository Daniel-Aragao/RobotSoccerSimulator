import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SoccerSimulator extends PApplet {

ArrayList<Drawable> uiElements = new ArrayList<Drawable>();

GameController controller;
GameSimulator simulator;

float gameScale = 300f;
public void setup(){

	controller = new GameController(2);
	uiElements.add(controller);
	size((int)controller.getWidth(gameScale) + 200, (int)controller.getHeight(gameScale)+100);
}

public void draw(){
	
	background(255);

	controller.run();

	translate(100, 0);
	for(Drawable d:uiElements)
		d.draw(this, gameScale);

	translate(-100, 0);
}

public void mouseDragged(){
	controller.moveBallToSpot(new PVector((mouseX - 100) / gameScale, (mouseY - 100) / gameScale));
}

public void keyPressed(){

	if(key == ' '){
		if(controller.isRunning()){
			System.out.println("Pausing game...");
			controller.pauseGame();
		}else{
			System.out.println("Starting game...");
			controller.startGame();
		}
	}else if(key == 'i'){
		controller.resetGame();
		controller.startGame();
	}else if(key == 'r'){
		controller.restartPositions();
	}else if(key == 'd'){
		String debug = "DEBUG:";
		debug += "\nisRunning:"+controller.isRunning();
		debug += "\nController Robots:"+controller.robots.size();
		for(Robot r:controller.robots)
			debug += "\n\t"+r+" ["+r.position.x+","+r.position.y+"]";

		debug += "\nSimulatables:"+controller.getSimulator().simulatables.size();
		for(Simulatable r:controller.getSimulator().simulatables)
			debug += "\n\t"+r;

		System.out.println(debug);
	}

}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SoccerSimulator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}