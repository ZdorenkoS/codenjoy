package com.codenjoy.dojo.sudoku.services;

import com.codenjoy.dojo.services.PlayerScores;
import com.codenjoy.dojo.services.settings.Settings;
import com.codenjoy.dojo.services.settings.SettingsImpl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: sanja
 * Date: 05.06.13
 * Time: 20:35
 */
public class SudokuPlayerScoresTest {
    private PlayerScores scores;

    private Settings settings;
    private Integer loosePenalty;
    private Integer winScore;

    public void loose() {
        scores.event(SudokuEvents.LOOSE);
    }

    public void win() {
        scores.event(SudokuEvents.WIN);
    }

    @Before
    public void setup() {
        settings = new SettingsImpl();
        scores = new SudokuPlayerScores(0, settings);

        loosePenalty = settings.getParameter("Loose penalty").type(Integer.class).getValue();
        winScore = settings.getParameter("Win score").type(Integer.class).getValue();
    }

    @Test
    public void shouldCollectScores() {
        scores = new SudokuPlayerScores(140, settings);

        win();  //+30
        win();  //+30
        win();  //+30
        win();  //+30

        loose(); //-100

        assertEquals(140 + 4* winScore - loosePenalty, scores.getScore());
    }

    @Test
    public void shouldStillZeroAfterDead() {
        loose();    //-100

        assertEquals(0, scores.getScore());
    }

    @Test
    public void shouldClearScore() {
        win();    // +30

        scores.clear();

        assertEquals(0, scores.getScore());
    }


}
