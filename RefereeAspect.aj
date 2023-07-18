
public aspect RefereeAspect {
	pointcut checkGame(): call (public boolean TicTacToe.check());	//point cut to check for win
	
	after(): checkGame() {
		//series of IF statements check the condition of the button for all winning possibilities 
		//check all X possibilities 
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[0].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[1].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[2].getText() == "X")) {			
			//call to corresponding method to update board with winner info
			((TicTacToe)thisJoinPoint.getTarget()).xWins(0, 1, 2);		
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[3].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[5].getText() == "X")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).xWins(3, 4, 5);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[6].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[7].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[8].getText() == "X")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).xWins(6, 7, 8);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[0].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[3].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[6].getText() == "X")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).xWins(0, 3, 6);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[1].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[7].getText() == "X")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).xWins(1, 4, 7);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[2].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[5].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[8].getText() == "X")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).xWins(2, 5, 8);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[0].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[8].getText() == "X")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).xWins(0, 4, 8);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[2].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "X") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[6].getText() == "X")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).xWins(2, 4, 6);
			
		}		
		//check all O possibilities 
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[0].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[1].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[2].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(0, 1, 2);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[3].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[5].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(3, 4, 5);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[6].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[7].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[8].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(6, 7, 8);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[0].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[3].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[6].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(0, 3, 6);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[1].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[7].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(1, 4, 7);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[2].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[5].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[8].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(2, 5, 8);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[0].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[8].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(0, 4, 8);
			
		}
		if((((TicTacToe)thisJoinPoint.getTarget()).buttons[2].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[4].getText() == "O") && 
				(((TicTacToe)thisJoinPoint.getTarget()).buttons[6].getText() == "O")) {
			
			((TicTacToe)thisJoinPoint.getTarget()).oWins(2, 4, 6);
			
		}
		((TicTacToe)thisJoinPoint.getTarget()).draw();
	}	
}
