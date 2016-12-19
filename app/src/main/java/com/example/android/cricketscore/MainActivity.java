    package com.example.android.cricketscore;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {
        int fnlScoreA;
        int fnlWktA;
        int fnlWktB;
        int fnlScoreB;
        int ovrA;
        int bllsA;
        int ovrB;
        int bllsB;
        int wktA;
        int wktB;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            fnlScoreA = 0;
            fnlWktA = 0;
            fnlScoreB = 0;
            fnlWktB = 0;
            ovrA = 20;
            ovrB = 20;
            bllsA = 0;
            bllsB = 0;
            wktA = 11;
            wktB = 11;
            displayForTeamA(fnlScoreA);
            displayWktTeamA(fnlWktA);
            displaySumA();
            displaySumB();
            displayForTeamB(fnlScoreB);
            displayWktTeamB(fnlWktB);
        }
        /**  Displays the given score for Team A.  */
        public void displayForTeamA(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score));
        }
        /**  Displays the given score for Team B.  */
        public void displayForTeamB(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_b_score);
            scoreView.setText(String.valueOf(score));
        }
        /**  Displays the lost wicket for Team A.  */
        public void displayWktTeamA(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_wkt);
            scoreView.setText(String.valueOf(score));
        }
        /**  Displays the lost wicket for Team B.  */
        public void displayWktTeamB(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_b_wkt);
            scoreView.setText(String.valueOf(score));
        }
        /**  Displays the Summary for Team A.  */
        public void displaySumA() {
            String gameOvrA = "";
            int valGamePlay = (ovrA + bllsA) * wktA;
            /**  Displays Game over if  wickets or over became zero */
            if (valGamePlay == 0){
                gameOvrA = "Team A Game Over";
            }
            String Smry = "Balls      - " + ovrA + "." + bllsA +
                          "\nWickets - " + wktA + "\n" + gameOvrA;
            TextView summary = (TextView) findViewById(R.id.summaryA);
            summary.setText(String.valueOf(Smry));
        }
        /**  Displays the Summary for Team B.  */
        public void displaySumB() {
            String gameOvrB = "";
            int valGamePlay = (ovrB + bllsB) * wktB;
            /**  Displays Game over if  wickets or over became zero */
            if (valGamePlay == 0){
                gameOvrB = "Team B Game Over";
            }
            String Smry = "Balls      - " + ovrB + "." + bllsB +
                          "\nWickets - " + wktB + "\n" + gameOvrB;
            TextView summary = (TextView) findViewById(R.id.summaryB);
            summary.setText(String.valueOf(Smry));
        }
        /**  Calculate and display Summary for Team A and B  */
        public void calSumry(String modeX) {
            if (modeX == "AB") {
                /**  1 over = 6 balls*/
                if (bllsA == 0) {
                    bllsA = 5;
                    ovrA = ovrA - 1;
                } else if( bllsA > 0){
                bllsA = bllsA - 1;
                }
            }
            if (modeX == "BB") {
                if (bllsB == 0) {
                    bllsB = 5;
                    ovrB = ovrB - 1;
                } else if (bllsB > 0) {
                 bllsB = bllsB - 1;
                }
            }
            if (modeX == "AW") {
                wktA = wktA - 1;
            }
            if (modeX == "BW") {
                wktB = wktB - 1;
            }
            displaySumA();
            displaySumB();
        }
        public void runOneA(View view) {
            int valGamePlay;
            valGamePlay = (ovrA + bllsA) * wktA;
            if (valGamePlay > 0 ) {
                fnlScoreA = fnlScoreA + 1;
                displayForTeamA(fnlScoreA);
                calSumry("AB");
            }
        }
        public void noBallA(View view) {
            int valGamePlay;
            valGamePlay = (ovrA + bllsA) * wktA;
            if (valGamePlay > 0 ) {
                fnlScoreA = fnlScoreA + 1;
                displayForTeamA(fnlScoreA);
                calSumry("AX");
            }
        }
        public void runSixA(View view) {
            int valGamePlay;
            valGamePlay = (ovrA + bllsA) * wktA;
            if (valGamePlay > 0 ) {
                fnlScoreA = fnlScoreA + 6;
                displayForTeamA(fnlScoreA);
                calSumry("AB");
            }
        }
        public void runFourA(View view) {
            int valGamePlay;
            valGamePlay = (ovrA + bllsA) * wktA;
            if (valGamePlay > 0 ) {
                fnlScoreA = fnlScoreA + 4;
                displayForTeamA(fnlScoreA);
                calSumry("AB");
            }
        }
        public void wicketA(View view) {
            int valGamePlay;
            valGamePlay = (ovrA + bllsA) * wktA;
            if (valGamePlay > 0 ) {
                fnlWktA = fnlWktA + 1;
                displayWktTeamA(fnlWktA);
                calSumry("AW");
            }
        }
        public void runOneB(View view) {
            int valGamePlay;
            valGamePlay = (ovrB + bllsB) * wktB;
            if (valGamePlay > 0 ) {
                fnlScoreB = fnlScoreB + 1;
                displayForTeamB(fnlScoreB);
                calSumry("BB");
            }
        }
        public void noBallB(View view) {
            int valGamePlay;
            valGamePlay = (ovrB + bllsB) * wktB;
            if (valGamePlay > 0 ) {
                fnlScoreB = fnlScoreB + 1;
                displayForTeamB(fnlScoreB);
                calSumry("BX");
            }
        }
        public void runSixB(View view) {
            int valGamePlay;
            valGamePlay = (ovrB + bllsB) * wktB;
            if (valGamePlay > 0 ) {
                fnlScoreB = fnlScoreB + 6;
                displayForTeamB(fnlScoreB);
                calSumry("BB");
            }
        }
        public void runFourB(View view) {
            int valGamePlay;
            valGamePlay = (ovrB + bllsB) * wktB;
            if (valGamePlay > 0 ) {
                fnlScoreB = fnlScoreB + 4;
                displayForTeamB(fnlScoreB);
                calSumry("BB");
            }
        }
        public void wicketB(View view) {
            int valGamePlay;
            valGamePlay = (ovrB + bllsB) * wktB;
            if (valGamePlay > 0 ) {
                fnlWktB = fnlWktB + 1;
                displayWktTeamB(fnlWktB);
                calSumry("BW");
            }
        }
        public void Reset(View view) {
            fnlScoreB = 0;
            fnlWktA=0;
            fnlWktB=0;
            fnlScoreA = 0;
            fnlScoreB = 0;
            ovrA = 20;
            ovrB = 20;
            bllsA = 0;
            bllsB = 0;
            wktA = 11;
            wktB = 11;
            displayForTeamA(fnlScoreA);
            displayForTeamB(fnlScoreB);
            displayWktTeamA(fnlWktA);
            displayWktTeamB(fnlWktB);
            displaySumA();
            displaySumB();
        }
    }
