package example.com.prince.tictactoe;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int count = 0;

    public void BuClick(View view) {
        Button buSelected = (Button) view;

        int CellID = 0;
        switch (buSelected.getId()){
            case R.id.button1:
                CellID = 1;
                break;
            case R.id.button2:
                CellID = 2;
                break;
            case R.id.button3:
                CellID = 3;
                break;
            case R.id.button4:
                CellID = 4;
                break;
            case R.id.button5:
                CellID = 5;
                break;
            case R.id.button6:
                CellID = 6;
                break;
            case R.id.button7:
                CellID = 7;
                break;
            case R.id.button8:
                CellID = 8;
                break;
            case R.id.button9:
                CellID = 9;
                break;

        }
        PlayGame(CellID,buSelected);
    }

    int ActivePlayer = 1;

    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();
    void PlayGame(int CellID,Button button){
        button.setBackgroundColor(Color.RED);
        Log.d("Player: ",String.valueOf(CellID));
        if(ActivePlayer == 1){
            button.setText("X");
            button.setBackgroundColor(Color.GREEN);
            Player1.add(CellID);
            ActivePlayer = 2;
            count++;
        }
        else if(ActivePlayer == 2){
            button.setText("O");
            button.setBackgroundColor(Color.YELLOW);
            Player2.add(CellID);
            ActivePlayer = 1;
            count++;
        }
        button.setEnabled(false);
        CheckWinner();
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    void CheckWinner(){
        int Winner = -1;
        //row 1
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            Winner = 1;
        }
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            Winner = 2;
        }
        //row 2
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            Winner = 1;
        }
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            Winner = 2;
        }
        //row 3
        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            Winner = 1;
        }
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            Winner = 2;
        }
        //col 1
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            Winner = 1;
        }
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            Winner = 2;
        }
        //col 2
        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            Winner = 1;
        }
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            Winner = 2;
        }
        //col 3
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            Winner = 1;
        }
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            Winner = 2;
        }
        //Diagonal 1
        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
            Winner = 1;
        }
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            Winner = 2;
        }
        //Diagonal 2
        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
            Winner = 1;
        }
        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            Winner = 2;
        }


        // Decide Winner
        if(Winner!=-1) {
            if (Winner == 1) {
                //Toast.makeText(this,"Player 1 is Winner!",Toast.LENGTH_LONG).show();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Winner");
                alertDialog.setMessage("Player 1 is Winner!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                onDestroy();
            } else {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Winner");
                alertDialog.setMessage("Player 2 is Winner!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                onDestroy();
            }

        }
        // Game Over
        if(count==9){
            Toast.makeText(this,"GAME OVER",Toast.LENGTH_LONG).show();
        }

    }


}
