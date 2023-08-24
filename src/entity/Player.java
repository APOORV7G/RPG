package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity
{
	GamePanel gp;
	KeyHandler keyH;
	public Player(GamePanel gp,KeyHandler keyH) 
	{
		this.gp=gp;
		this.keyH=keyH;		
		defaultValue();
		getImage();
	}
	public void defaultValue() 
	
	{
		x=100;
		y=100;
		speed=4;
		direction="down";
	}
	public void getImage() 
	{
		try {
			down=ImageIO.read(getClass().getResourceAsStream("/player/player1-front.png"));
			up=ImageIO.read(getClass().getResourceAsStream("/player/player1-back.png"));
			left=ImageIO.read(getClass().getResourceAsStream("/player/player1-left.png"));
			right=ImageIO.read(getClass().getResourceAsStream("/player/player1-right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update() 
	{
		if(keyH.up==true) 
		{
			direction="up";
			y-=speed;
		}
		else if(keyH.down==true) 
		{
			direction="down";
			y+=speed;
		}
		else if(keyH.left==true) 
		{
			direction="left";
			x-=speed;
		}
		else if(keyH.right==true) 
		{
			direction="right";
			x+=speed;
		}
	}
	public void draw(Graphics2D g2d) {
		BufferedImage image=null;
		switch (direction) 
		{
		case "up": 
		{
			
			image=up;
		}
		break;
		case "down": 
		{
			
			image=down;
		}
		break;
		case "left": 
		{
			
			image=left;
		}
		break;
		case "right": 
		{
			
			image=right;
		}
		break;
		
		}
		g2d.drawImage(image, x, y, gp.tileSize,gp.tileSize,	null );
	}
	
		
	

}