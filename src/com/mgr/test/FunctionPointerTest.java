package com.mgr.test;

/**
 * create :fanghaoyi
 * date: 2020/5/29
 * describe: 描述
 */
public class FunctionPointerTest {

	public static void main(String... args){
		Player[] players = new Player[5];
		for(int i = 0;i<players.length;i++){
			players[i] = new Player();
		}
		pressButton(players,new StopButton());
		pressButton(players,new StartButton());
	}
	public static void pressButton(Player[] players,PlayerButton button){
		for(int i=0;i<players.length;i++){
			button.buttonPressed(players[i]);
		}
	}

	static class Player {
		public void start(){
			System.out.println("start");
		}
		public void stop(){
			System.out.println("stop");
		}
	}
	interface PlayerButton {
		public void buttonPressed(Player player);
	}
	static class StopButton implements PlayerButton{
		@Override
		public void buttonPressed(Player player) {
			player.stop();
		}
	}
	static class StartButton implements PlayerButton{
		@Override
		public void buttonPressed(Player player) {
			player.start();
		}
	}
}
