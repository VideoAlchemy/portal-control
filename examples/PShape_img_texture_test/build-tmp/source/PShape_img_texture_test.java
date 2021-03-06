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

public class PShape_img_texture_test extends PApplet {

PShape star;

PImage testImg;
PImage buffer;

PGraphics pg;
PGraphics bufferGraphics;

int screenScale = 3;

public void setup() {
  size(400*screenScale, 400*screenScale, P2D);
  pg = createGraphics(40*screenScale, 40*screenScale);
  buffer = createImage(width, height, ARGB);
  testImg = loadImage("../../images/angels/angel000.png");
  bufferGraphics = createGraphics(width,height);

  // First create the shape
  star = createShape();

  star.beginShape();
  star.textureMode(NORMAL);
  star.texture(testImg);
  // You can set fill and stroke
  //star.fill(102);
  //star.stroke(255);
  star.strokeWeight(2);
  // Here, we are hardcoding a series of vertices
  star.vertex(0, 0,0,0);
  star.vertex(200, 100,1,0);
  star.vertex(200, 200,1,1);
  star.vertex(0,700,0,1);

  /*
  star.vertex(29, 40);
  star.vertex(0, 25);
  star.vertex(-29, 40);
  star.vertex(-23, 7);
  star.vertex(-47, -15);
  star.vertex(-14, -20);
  */

  star.endShape(CLOSE);
}

public void draw() {
  background(51);
  
  translate(mouseX, mouseY);
  bufferGraphics.beginDraw();
  
  bufferGraphics.shape(star);

  bufferGraphics.endDraw();

  image(bufferGraphics, 0,0, width,height);


}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PShape_img_texture_test" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
