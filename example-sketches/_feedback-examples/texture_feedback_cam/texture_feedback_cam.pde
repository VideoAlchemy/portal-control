
import processing.opengl.*;
import processing.video.*;
//import codeanticode.glgraphics.*;


Capture cam;



float frameSize=10;
PImage img;
PImage patternLang;
PImage tex;

void setup() {
  noCursor();

  size(1024, 768, P3D);///P3D
  
//get list of available cameras
 //String[] devices = Capture.list();
  //println(devices);

  // If no device is specified, will just use the default.
  cam = new Capture(this, 320, 240);
  cam.start();
  
  img = loadImage("000.png"); //start with an initial image
  patternLang = loadImage ("004.png");
  stroke(255);
}

void draw() {
  strokeWeight(frameSize);
  lights();
  stroke(255,0,0);
  background(0);
  pushMatrix();
  translate(width/2,height/2,-250);
  translate(mouseX-width/2,mouseY-width/2,500);
  beginShape();
  texture(img);
  sphere(50);
  endShape();
  popMatrix(); 
  ellipse (mouseX,mouseY,50,50);

  translate(width / 2, height / 2);

  // use 2 full rotations in both directions with 2*PI
  rotateY(map(mouseX, 0, width, -2*PI, 2*PI));
  rotateX(map(mouseY, 0, width, -2*PI, 2*PI));

  
  image(cam, -50, -50, 200, 200);

  //begin mesh shape and place the grabbed texture from get()
  beginShape();
  texture(img);
  vertex(-200, -200, 0, 0, 0);
  vertex(200, -200, 0, 400, 0);
  vertex(200, 200, 0, 400, 400);
  vertex(-200, 200, 0, 0, 400);
  endShape(CLOSE);

  //place a png from previous generative art piece
  image(patternLang, -200, -200, 200, 200);

  // acquire pixels within these dimensions and store in PImage varible 'img'
  img=get(200, 200, 400, 400);
}

void keyPressed() {
  if (keyCode == 38) { //arrow up
    frameSize++;
  }
  else if (keyCode==40) { //arrow down
    frameSize--;
  }
}


void captureEvent(Capture cam){
  cam.read();
}


