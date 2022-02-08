package jrJava.memoryCardGame3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import resources.SoundPlayer;

public class CardManager implements MouseListener {

	private Card[][] cards;
	private int row, col;
	private boolean oneSelected, twoSelected, threeSelected;
	private Card firstSelected, secondSelected, thirdSelected;
	private long timeThreeCardsSelected;
	private boolean needToPaint;
	private SoundPlayer tick, chime, buzz;
	private int score;
	private Font font;
	
	
	private String[] imageNames = {
			"apple", "bank", "basketball", "bubble_blue", 
			"bubble_green", "bubble_red", "building", "cat",
			"cheese", "denture", "dog", "hockey_stick", 
			"keys", "phone", "pizza", "santa",
			"soccer_ball", "sock", "toilet_bowl", "toilet_paper",
			"xmas_tree"
	};
	
	
	public CardManager(int numberOfCards, int col){
		
		this.col = col;
		numberOfCards = (numberOfCards+2)/3*3;
		if(numberOfCards>3*imageNames.length ) numberOfCards = 3*imageNames.length;
		
		//row = numberOfCards/col;
		//if(numberOfCards%col!=0) row++;
		row = numberOfCards/col + (numberOfCards%col==0? 0:1);
		
		int i, j;
		Image image;
		int x, y;
		
		// 1. create array of arrays.
		cards = new Card[row][];
		for(i=0; i<cards.length; i++){
			if(i!=row-1) cards[i] = new Card[col];
			else cards[i] = new Card[numberOfCards-(row-1)*col];
		}
		
		// 2. Prepare all the images.
		Image[] images = new Image[numberOfCards];
		for(i=0; i<numberOfCards/3; i++){
			image = new ImageIcon("jrJava/memoryCardGame2/" + imageNames[i] + ".png").getImage();
			images[i] = image;
			images[i + numberOfCards/3] = image;
			images[i + numberOfCards*2/3] = image;
		}
		
		/*
		// Shuffle the images
		Image temp;
		int rand;
		for(i=0; i<images.length; i++){
			rand = (int)(Math.random()*images.length);
			//swap the values in [i] and [rand].
			temp = images[i];
			images[i] = images[rand];
			images[rand] = temp;
		}
		*/
		
		// 3. Create all the card objects.
		for(i=0; i<cards.length; i++){
			// i-th secondary array's reference: cards[i].
			for(j=0; j<cards[i].length; j++){
				image = images[i*col+j];
				x = 50 + j*Card.getSize();
				y = 50 + i*Card.getSize();
				cards[i][j] = new Card(image, x, y);
				//cards[i][j].show();
			}
		}
		
		tick = new SoundPlayer("jrJava/memoryCardGame2/tick.wav");
		chime = new SoundPlayer("jrJava/memoryCardGame2/chime.wav");
		buzz = new SoundPlayer("jrJava/memoryCardGame2/buzz.wav");
		
		font = new Font("Arial", Font.BOLD, 14);
	}
	
	
	public int getRowNumber(){ return row; }
	
	public boolean needToPaint(){ return needToPaint; }
	
	
	public void draw(Graphics g){
		int i, j;
		for(i=0; i<cards.length; i++){
			for(j=0; j<cards[i].length; j++){
				cards[i][j].draw(g); 
			}
		}
		
		g.setColor(Color.darkGray); 
		g.setFont(font); 
		g.drawString("score: " + score, 50, 40);
		
		if(Coordinator.gameOver){
			g.setFont(new Font("Courier", Font.BOLD, 10*col));
			
			g.setColor(Color.orange);
			int yPos = 100;
			g.drawString("Congratulations!", 50, yPos);
			
			g.setColor(Color.cyan);
			yPos += 30*row;
			g.drawString("Good Job!", 50, yPos);
			
			g.setColor(Color.green);
			yPos += 30*row;
			g.drawString("Game Over", 50, yPos);
		}
		
		needToPaint = false;
	}
	
	
	public void showAll(){
		int i, j;
		for(i=0; i<cards.length; i++){
			for(j=0; j<cards[i].length; j++){
				cards[i][j].show();
			}
		}
	}
	
	
	
	public void hideAll(){
		int i, j;
		for(i=0; i<cards.length; i++){
			for(j=0; j<cards[i].length; j++){
				cards[i][j].hide();
			}
		}
	}


	public void applyGameLogic(){
		
		if(!threeSelected || System.currentTimeMillis()<timeThreeCardsSelected+2000) return;
		
		boolean checkGameOver = false;
		
		if(firstSelected.equals(secondSelected) && firstSelected.equals(thirdSelected)){
			firstSelected.setMatched();
			secondSelected.setMatched();
			thirdSelected.setMatched();
			chime.play();
			score += 100;
			checkGameOver = true;
		}
		else {
			firstSelected.hide();
			secondSelected.hide();
			thirdSelected.hide();
			buzz.play();
			score -= 50;
		}
		
		needToPaint = true;
		
		oneSelected = false;
		twoSelected = false;
		threeSelected = false;
		firstSelected = null;
		secondSelected = null;
		thirdSelected = null;
		
		if(!checkGameOver) return;
		// check the game over.
		int i, j;
		for(i=0; i<cards.length; i++){
			for(j=0; j<cards[i].length; j++){
				if(!cards[i][j].isMatched()) return;
			}
		}
		
		Coordinator.gameOver = true;
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		
		if(threeSelected) return;
		
		int mx = e.getX();
		int my = e.getY();
		
		int i, j;
		for(i=0; i<cards.length; i++){
			for(j=0; j<cards[i].length; j++){
				if(cards[i][j].isSelected(mx, my) &&  cards[i][j]!=firstSelected &&  cards[i][j]!=secondSelected &&  !cards[i][j].isMatched()){
					cards[i][j].show();
					tick.play();
					needToPaint = true;
					
					if(!oneSelected && !twoSelected){ // if no card has been selected.
						oneSelected = true;
						firstSelected = cards[i][j];
					}
					else if(oneSelected){
						oneSelected = false;
						twoSelected = true;
						secondSelected = cards[i][j];
					}
					else {
						twoSelected = false;
						threeSelected = true;
						thirdSelected = cards[i][j];
						timeThreeCardsSelected = System.currentTimeMillis();
					}
					
					return;
				}
				
			}
		}
		
		
	}


	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
}
















/*

*/