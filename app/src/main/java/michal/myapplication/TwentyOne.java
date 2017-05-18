package michal.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwentyOne extends AppCompatActivity {

    Map<Integer, String> cardsValue = new HashMap<>();
    Random Randomizer = new Random();
    int[] deleted = new int[18];
    int takenCardsCounter=0;
    int playerOneScore = 0;
    int playerOneTakenCardCount = 0;
    int playerTwoScore = 0;
    int playerTwoTakenCardCount = 0;

    boolean playerOneFinishGame = false;
    boolean playerTwoFinishGame = false;

    Button playerOneTakeButton, playerTwoTakeButton, playerOneStopButton, playerTwoStopButton;

    ImageView playerOneCard1, playerOneCard2, playerOneCard3, playerOneCard4, playerOneCard5, playerOneCard6, playerOneCard7, playerOneCard8, playerOneCard9,
              playerTwoCard1, playerTwoCard2, playerTwoCard3, playerTwoCard4, playerTwoCard5, playerTwoCard6, playerTwoCard7, playerTwoCard8, playerTwoCard9;

    TextView textViewPlayerOneSum, textViewPlayerTwoSum;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_one);

        playerOneTakeButton = (Button) findViewById(R.id.buttonPlayerOneTake);
        playerTwoTakeButton = (Button) findViewById(R.id.buttonPlayerTwoTake);

        playerOneStopButton = (Button) findViewById(R.id.buttonPlayerOneStop);
        playerTwoStopButton = (Button) findViewById(R.id.buttonPlayerTwoStop);

        textViewPlayerOneSum = (TextView) findViewById(R.id.textViewPlayerOneSum);
        textViewPlayerTwoSum = (TextView) findViewById(R.id.textViewPlayerTwoSum);

        playerOneCard1 = (ImageView) findViewById(R.id.imageViewPlayerOneCard1);
        playerOneCard2 = (ImageView) findViewById(R.id.imageViewPlayerOneCard2);
        playerOneCard3 = (ImageView) findViewById(R.id.imageViewPlayerOneCard3);
        playerOneCard4 = (ImageView) findViewById(R.id.imageViewPlayerOneCard4);
        playerOneCard5 = (ImageView) findViewById(R.id.imageViewPlayerOneCard5);
        playerOneCard6 = (ImageView) findViewById(R.id.imageViewPlayerOneCard6);
        playerOneCard7 = (ImageView) findViewById(R.id.imageViewPlayerOneCard7);
        playerOneCard8 = (ImageView) findViewById(R.id.imageViewPlayerOneCard8);
        playerOneCard9 = (ImageView) findViewById(R.id.imageViewPlayerOneCard9);

        playerTwoCard1 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard1);
        playerTwoCard2 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard2);
        playerTwoCard3 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard3);
        playerTwoCard4 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard4);
        playerTwoCard5 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard5);
        playerTwoCard6 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard6);
        playerTwoCard7 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard7);
        playerTwoCard8 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard8);
        playerTwoCard9 = (ImageView) findViewById(R.id.imageViewPlayerTwoCard9);

        this.createDeck();
    }

    protected void createDeck() {
        String[] symbols = {"pik", "karo", "trefl", "kier"};
        String carts;
        int number = 2;
        int symbolsNumber=0;

        for(int i =0 ; i < 52; i++) {
            if(i > 35 && i < 40) {
                carts = "as" + ((String) symbols[symbolsNumber]);
                cardsValue.put(i, carts);
            } else {
                if(i > 39 && i < 44) {
                    carts = "krol" + ((String) symbols[symbolsNumber]);
                    cardsValue.put(i, carts);
                } else {
                    if(i > 43 && i < 48) {
                        carts = "dama" + ((String) symbols[symbolsNumber]);
                        cardsValue.put(i, carts);
                    } else {
                        if( i > 47 && i <52) {
                            carts = "walet" + ((String) symbols[symbolsNumber]);
                            cardsValue.put(i, carts);
                        } else{
                            carts = number + " " + ((String) symbols[symbolsNumber]);
                            cardsValue.put(i, carts);
                        }
                    }
                }
            }

            if(symbolsNumber == 3){
                symbolsNumber = 0;
                number++;
            } else {
                symbolsNumber++;
            }

        }

    }

    protected int takeCard() {
        int takenCard = Randomizer.nextInt(52);
        return takenCard;
    }

    protected boolean checkIfDeletedCard(int number) {
        Boolean check = true;
        for(int i = 0; i < deleted.length; i++) {
            if(deleted[i] == number) {
                check = false;
                break;
            }
        }
        return check;
    }

    protected  void deleteCard(int number) {
        deleted[takenCardsCounter] = number;
    }

    protected String takenCardSymbol(int number) {
        String takenCard=cardsValue.get(number);

        String[] word = takenCard.split(" ");
        takenCard = word[0];

        return takenCard;
    }

    protected String cardTaken(int number) {
        String takenCard = cardsValue.get(number);
        return  takenCard;
    }

    protected int checkCardValue(String card) {
        int value = 0;

        if(card.equals("as")) {
            value = 11;
        } else {
            if(card.equals("krol")) {
                value = 4;
            } else {
                if(card.equals("dama")) {
                    value = 3;
                } else {
                    if(card.equals("walet")) {
                        value = 2;
                    } else {
                        value  = Integer.parseInt(card);
                    }
                }
            }
        }

        return value;
    }

    protected void setCard(String takenCard, String player) {
        String[] card = takenCard.split(" ");
        String name = card[1] + "_" + card[0];

        Context c = getApplicationContext();
        int id = c.getResources().getIdentifier("drawable/" + name, null, c.getPackageName());

        if(player.equals("Player1")) {
            if(playerOneTakenCardCount == 9) {
                playerOneCard9.setImageResource(id);
            }
            if(playerOneTakenCardCount == 8) {
                playerOneCard8.setImageResource(id);
            }
            if(playerOneTakenCardCount == 7) {
                playerOneCard7.setImageResource(id);
            }
            if(playerOneTakenCardCount == 6) {
                playerOneCard6.setImageResource(id);
            }
            if(playerOneTakenCardCount == 5) {
                playerOneCard5.setImageResource(id);
            }
            if(playerOneTakenCardCount == 4) {
                playerOneCard4.setImageResource(id);
            }
            if(playerOneTakenCardCount == 3) {
                playerOneCard3.setImageResource(id);
            }
            if(playerOneTakenCardCount == 2) {
                playerOneCard2.setImageResource(id);
            }
            if(playerOneTakenCardCount == 1) {
                playerOneCard1.setImageResource(id);
            }
        } else {
            if(playerTwoTakenCardCount == 9) {
                playerTwoCard9.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 8) {
                playerTwoCard8.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 7) {
                playerTwoCard7.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 6) {
                playerTwoCard6.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 5) {
                playerTwoCard5.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 4) {
                playerTwoCard4.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 3) {
                playerTwoCard3.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 2) {
                playerTwoCard2.setImageResource(id);
            }
            if(playerTwoTakenCardCount == 1) {
                playerTwoCard1.setImageResource(id);
            }
        }
    }

    protected void checkIfPlayerOneFinishGame() {
        if(!playerOneFinishGame) {
            playerOneTakeButton.setEnabled(true);
            playerOneStopButton.setEnabled(true);
            playerTwoTakeButton.setEnabled(false);
            playerTwoStopButton.setEnabled(false);
        } else {
            playerTwoTakeButton.setEnabled(true);
            playerTwoStopButton.setEnabled(true);
        }
    }

    protected void checkIfPlayerTwoFinishGame() {
        if(!playerTwoFinishGame) {
            playerOneTakeButton.setEnabled(false);
            playerOneStopButton.setEnabled(false);
            playerTwoTakeButton.setEnabled(true);
            playerTwoStopButton.setEnabled(true);
        } else {
            playerOneTakeButton.setEnabled(true);
            playerOneStopButton.setEnabled(true);
        }
    }

    protected void onClickPlayerOneTakeCard(View v) {

        checkIfPlayerTwoFinishGame();

        int takenCard = takeCard();

        Boolean deletedCard = checkIfDeletedCard(takenCard);

        while(!deletedCard) {
            takenCard = takeCard();
            deletedCard = checkIfDeletedCard(takenCard);
        }

        deleteCard(takenCard);
        takenCardsCounter++;

        String symbol = takenCardSymbol(takenCard);
        String value = cardTaken(takenCard);

        int taken = checkCardValue(symbol);

        playerOneScore = playerOneScore + taken;
        playerOneTakenCardCount++;

        setCard(value, "Player1");

        textViewPlayerOneSum.setText("Sum:" + playerOneScore);

        if(playerOneScore>21) {
            playerOneTakeButton.setEnabled(false);
            playerOneStopButton.setEnabled(false);
            playerTwoTakeButton.setEnabled(false);
            playerTwoStopButton.setEnabled(false);
        }
    }

    protected void onClickPlayerTwoTakeCard(View v) {

        checkIfPlayerOneFinishGame();

        int takenCard = takeCard();

        Boolean deletedCard = checkIfDeletedCard(takenCard);

        while(!deletedCard) {
            takenCard = takeCard();
            deletedCard = checkIfDeletedCard(takenCard);
        }

        deleteCard(takenCard);
        takenCardsCounter++;

        String symbol = takenCardSymbol(takenCard);
        String value = cardTaken(takenCard);

        int taken = checkCardValue(symbol);

        playerTwoScore = playerTwoScore + taken;
        playerTwoTakenCardCount++;

        setCard(value, "Player2");

        textViewPlayerTwoSum.setText("Sum:" + playerTwoScore);

        if(playerTwoScore>21) {
            playerOneTakeButton.setEnabled(false);
            playerOneStopButton.setEnabled(false);
            playerTwoTakeButton.setEnabled(false);
            playerTwoStopButton.setEnabled(false);
        }
    }

    protected void onClickPlayerOneFinishGame(View v) {
        playerOneFinishGame = true;
        if(playerTwoFinishGame) {
            finish();
        } else {
            playerOneTakeButton.setEnabled(false);
            playerOneStopButton.setEnabled(false);
        }
    }

    protected void onClickPlayerTwoFinishGame(View v) {
        playerTwoFinishGame = true;
        if(playerOneFinishGame) {
            finishGame();
        } else {
            playerTwoTakeButton.setEnabled(false);
            playerTwoStopButton.setEnabled(false);
        }

    }

    protected void finishGame() {
        if(playerOneScore>playerTwoScore) {
            //toast wygrał gracz 1
        } else {
            if(playerOneScore<playerTwoScore) {
                //toast wygrał gracz 2
            } else {
                //tosat remis
            }
        }
    }
}
