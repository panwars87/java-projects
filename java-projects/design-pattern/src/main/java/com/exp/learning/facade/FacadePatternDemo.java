package com.exp.learning.facade;

public class FacadePatternDemo {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMakerImpl();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();		
	}
}

interface ShapeMaker{
	void drawCircle();
	void drawRectangle();
	void drawSquare();
}

class ShapeMakerImpl implements ShapeMaker{
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMakerImpl() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle(){
		circle.draw();
	}
	public void drawRectangle(){
		rectangle.draw();
	}
	public void drawSquare(){
		square.draw();
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square::draw()");
	}
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
	}
}

interface Shape {
	void draw();
}